using Microsoft.EntityFrameworkCore;
using PROG2500_A2_Chinook.Data;
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
    /// Interaction logic for Albums.xaml
    /// </summary>
    public partial class Albums : Page
    {
        //database context object
        ChinookContext _chinookContext = new ChinookContext();
        //will hold the data that we get from our db context object
        CollectionViewSource albumViewSource = new CollectionViewSource();
        public Albums()
        {
            InitializeComponent();

            //link xaml collection view source to code
            albumViewSource = (CollectionViewSource)FindResource(nameof(albumViewSource));
            //load the correct table
            _chinookContext.Albums.Load();
            //fill the view with data
            albumViewSource.Source = _chinookContext.Albums.Local.ToObservableCollection(); 
        }

        private void albumSearchButton_Click(object sender, RoutedEventArgs e)
        {
            //grab text out of the search box
            string searchText = albumSearchBox.Text;
            //create query
            var searchQuery = from album in _chinookContext.Albums
                              where album.Title.ToLower().Contains(searchText.ToLower())
                              select album;

            //clear the view
            albumViewSource.Source = searchQuery.ToList();

            
        }
    }
}
