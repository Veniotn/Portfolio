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
using static System.Net.Mime.MediaTypeNames;

namespace assignment_1
{
    /// <summary>
    /// Interaction logic for SongInfo.xaml
    /// </summary>
    public partial class SongInfo : UserControl
    {

        const string DEFAULT_META_DATA = "No metadata found";
         
        public string Title
        {

            get { return titleLabel.Text; }
            set { titleLabel.Text = value ?? DEFAULT_META_DATA;}
   
        }

        public string Artist
        {
            get { return artistLabel.Text; }
            set { artistLabel.Text = value ?? DEFAULT_META_DATA;}
        }


        public string Album
        {
            get { return albumLabel.Text; }
            init { albumLabel.Text = value ?? DEFAULT_META_DATA; }          
        }

        public string Year
        {

            get { return yearLabel.Text; }
            init { yearLabel.Text = value ?? DEFAULT_META_DATA; }   
        }
        public SongInfo()
        {
            InitializeComponent();
        }


        public void setSongInfo(TagLib.File currentFile)
        {
            updateLabel(currentFile.Tag.Title, titleLabel);
            updateLabel(currentFile.Tag.FirstPerformer, artistLabel);
            updateLabel(currentFile.Tag.Album, albumLabel);
            updateLabel(currentFile.Tag.Year.ToString(), yearLabel);
        }

        private void updateLabel(String tag, TextBlock textBlock)
        {
            textBlock.Text = tag != null ? tag.ToString() : DEFAULT_META_DATA;
        }
    }
}
