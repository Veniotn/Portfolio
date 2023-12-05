using Microsoft.Win32;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace assignment_1
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// source for slider logic: https://learn.microsoft.com/en-us/dotnet/desktop/wpf/graphics-multimedia/how-to-control-a-mediaelement-play-pause-stop-volume-and-speed?view=netframeworkdesktop-4.8
    /// source for custom CommandBindings: https://learn.microsoft.com/en-us/dotnet/desktop/wpf/advanced/how-to-create-a-routedcommand?view=netframeworkdesktop-4.8
    /// </summary>
    public partial class MainWindow : Window
    {
        OpenFileDialog? fileDialog;
        TagLib.File? currentFile;

        public static RoutedCommand EditTagsCommand = new RoutedCommand();
        public static RoutedCommand SongInfoCommand = new RoutedCommand();

        public MainWindow()
        {
            InitializeComponent();
            //create the custom command bindings and subscribe to the songUpdated event
            CommandBindings.Add(new CommandBinding(EditTagsCommand, EditTags_Executed, EditTags_CanExecute));
            CommandBindings.Add(new CommandBinding(SongInfoCommand, SongInfo_Executed, SongInfo_CanExecute));

            tagEditor.SongUpdated += new EventHandler(Song_Updated);
        }

        
   

        private void Open_CanExecute(object sender, CanExecuteRoutedEventArgs e)
        {
            e.CanExecute = true;
        }


        private void Open_Executed(object sender, ExecutedRoutedEventArgs e)
        {
            //create the file dialog object, set up the properties and regex for .mp3
            fileDialog = new OpenFileDialog();
            fileDialog.Filter = "MP3 files (*.mp3)|*.mp3 | All files (*.*)|*.*";
            Regex mp3Regex = new Regex("^.*\\.mp3$");
            fileDialog.Multiselect = false;

            //if true user has selected a file
            if (fileDialog.ShowDialog() == true)
            {

                //check they chose an mp3 file
                if (mp3Regex.IsMatch(fileDialog.FileName))
                {
                    //attempt to open the file
                    try
                    {
                        mediaPlayer.Source = new Uri(fileDialog.FileName);
                        currentFile = TagLib.File.Create(fileDialog.FileName);
                    }
                    catch (IOException ex) { MessageBox.Show($"An error occurred: {ex.Message}"); }
                    catch (Exception ex) { MessageBox.Show(ex.Message); }

                    //get the metadata from the file and place it into song info and tag editor controls
                    if(currentFile !=  null) 
                    {
                        tagEditor.CurrentFile = currentFile;
                        songInfo.setSongInfo(currentFile);
                        tagEditor.displayTags(songInfo);

                        //play the media
                        mediaPlayer.Play();
                    }                   
                }
                else
                {
                    MessageBox.Show("MP3 files only.");
                }
            }
        }

        //set the maxium value for the slider and total time label as soon as the file is opened
        private void mediaPlayer_MediaOpened(object sender, RoutedEventArgs e)
        {
            mediaSlider.Maximum = mediaPlayer.NaturalDuration.TimeSpan.TotalMilliseconds;
        }

        //alows the mp3 to be played again once its ended
        private void mediaPlayer_MediaEnded(object sender, RoutedEventArgs e)
        {
            mediaPlayer.Stop();
        }

        //if a file is loaded, and the tag editor isnt up activate play pause and stop
        private void Play_CanExecute(object sender, CanExecuteRoutedEventArgs e)
        {
            e.CanExecute = currentFile != null && !tagEditor.IsVisible;
        }

        private void Play_Executed(object sender, ExecutedRoutedEventArgs e)
        {
            mediaPlayer.Play();
        }

        private void Pause_CanExecute(object sender, CanExecuteRoutedEventArgs e)
        {
            e.CanExecute = currentFile != null && !tagEditor.IsVisible;
        }

        private void Pause_Executed(object sender, ExecutedRoutedEventArgs e)
        {
            mediaPlayer.Pause();
        }

        private void Stop_CanExecute(object sender, CanExecuteRoutedEventArgs e)
        {
            e.CanExecute = currentFile != null && !tagEditor.IsVisible;
        }

        private void Stop_Executed(object sender, ExecutedRoutedEventArgs e)
        {
            mediaPlayer.Stop();
        }
        private void mediaSlider_ValueChanged(object sender, RoutedPropertyChangedEventArgs<double> e)
        {
            int sliderValue = (int)mediaSlider.Value;

            //create new timespan with milliseconds equal to slider value
            TimeSpan timeSpan = new TimeSpan(0, 0, 0, 0, sliderValue);
            mediaPlayer.Position = timeSpan;
        }

        private void EditTags_CanExecute(object sender, CanExecuteRoutedEventArgs e)
        {
            //if theres's a file to edit and the tag editor isnt already on the screen activate the button
            e.CanExecute = currentFile != null && !tagEditor.IsVisible;
        }

        private void EditTags_Executed(object sender, ExecutedRoutedEventArgs e)
        {
            //swap to the tag editor ui and set source to null to allow meta tag writing
            songInfo.Visibility = Visibility.Collapsed;
            tagEditor.Visibility = Visibility.Visible;

            tagEditor.displayTags(songInfo);
            mediaPlayer.Source = null;
        }

        private void SongInfo_CanExecute(object sender, CanExecuteRoutedEventArgs e)
        {
            //if the song info panel is invisible, execute song info
            e.CanExecute = !songInfo.IsVisible;
        }

        private void SongInfo_Executed(object sender, ExecutedRoutedEventArgs e)
        {
            tagEditor.Visibility = Visibility.Collapsed;
            songInfo.Visibility = Visibility.Visible;

            //if switching back to song info without saving tag changes reload the file and play it
            Update_Song(); 
        }

        private void Song_Updated(object sender, System.EventArgs e)
        {
            //fires when save button is clicked on tag editor
            //swap back to song info ui
            tagEditor.Visibility = Visibility.Collapsed;
            songInfo.Visibility = Visibility.Visible;
            //update song file and reload it
            Update_Song();            
        }

        private void Update_Song()
        {
            if (currentFile != null)
            {
                //update the song info elements
                songInfo.setSongInfo(currentFile);

                //reopen the file 
                try
                {
                    mediaPlayer.Source = new Uri(fileDialog.FileName);
                }
                catch (IOException ex) { MessageBox.Show($"An error occurred: {ex.Message}"); }
                catch (Exception ex) { MessageBox.Show(ex.Message); }

                //play the file
                mediaPlayer.Play();
            }
        }


    }
}

