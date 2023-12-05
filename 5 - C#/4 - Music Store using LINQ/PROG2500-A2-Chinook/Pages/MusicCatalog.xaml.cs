using Microsoft.EntityFrameworkCore;
using PROG2500_A2_Chinook.Data;
using PROG2500_A2_Chinook.Models.Generated;
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

namespace PROG2500_A2_Chinook.Pages
{
    /// <summary>
    /// Interaction logic for MusicCatalog.xaml
    /// </summary>
    public partial class MusicCatalog : Page
    {
        //db and viewsource objects
        private ChinookContext context = new ChinookContext();
        private CollectionViewSource catalogViewSource;
        public MusicCatalog()
        {
            InitializeComponent();
            //connect xml viewsource to code
            catalogViewSource = (CollectionViewSource)FindResource(nameof(catalogViewSource));

            //load db data
            context.Artists.Load();
            context.Albums.Load();
            context.Tracks.Load();
        }

        private void catalogSearchButton_Click(object sender, RoutedEventArgs e)
        {
            //query for each artist and group them by the first letter of their name
            var query =
                from artist in context.Artists
                where artist.Name.ToLower().Contains(catalogSearchBox.Text.ToLower())
                group artist by artist.Name.ToUpper().Substring(0, 1) into artistGroup
                select new
                {
                    //index is the first letter of their name
                    index = artistGroup.Key,
                    //count of artists in this group
                    count = "(" + artistGroup.Count().ToString() + ")",
                    //the group of artists as a dataset
                    artist = artistGroup.ToList<Artist>()
                };

            //send data to our listview
            catalogListView.ItemsSource = query.ToList();
        }
    }
}
