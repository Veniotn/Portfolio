using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
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
    /// Interaction logic for TagEditor.xaml
    /// </summary>
    public partial class TagEditor : UserControl
    {
        private TagLib.File currentFile;

        public event EventHandler SongUpdated;

        public TagLib.File? CurrentFile
        {
            get { return currentFile; }
            set {
                if (value != null)
                {
                    currentFile = value;
                }
            }
        }

        public TagEditor()
        {
            InitializeComponent();          
        }

        public void displayTags(SongInfo songInfo)
        {
            //update UI elements based off of songinfo data
            titleTag.Text  = songInfo.Title;
            artistTag.Text = songInfo.Artist;
            albumTag.Text  = songInfo.Album;
            yearTag.Text   = songInfo.Year;
        }

        private void Save_Click(object sender, RoutedEventArgs e)
        {

            if (currentFile != null) 
            {
                //free up the file so the tags can be saved
                currentFile.Tag.Title = titleTag.Text;
                currentFile.Tag.Performers = new String[]{ artistTag.Text };
                currentFile.Tag.Album = albumTag.Text;
                int year;
                if(Int32.TryParse(yearTag.Text, out year))
                {
                    currentFile.Tag.Year = (uint)year;
                }   
                //save changes to the files metadata
                currentFile.Save();

                //fire the song updated event
                this.SongUpdated(this, e);
            }            
        }
    }
}
