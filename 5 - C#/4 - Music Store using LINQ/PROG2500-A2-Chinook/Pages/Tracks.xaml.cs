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
    /// Interaction logic for Tracks.xaml
    /// </summary>
    public partial class Tracks : Page
    {
        //database context object
        ChinookContext _chinookContext = new ChinookContext();
        //will hold the data that we get from our db context object
        CollectionViewSource trackViewSource = new CollectionViewSource();
        public Tracks()
        {
            InitializeComponent();

            //link xaml collection view source to code
            trackViewSource = (CollectionViewSource)FindResource(nameof(trackViewSource));
            //load the correct table
            _chinookContext.Tracks.Load();
            //fill the view with data
            trackViewSource.Source = _chinookContext.Tracks.Local.ToObservableCollection();
        }

        private void trackSearchButton_Click(object sender, RoutedEventArgs e)
        {
            string searchText = trackSearchBox.Text;

            var searchQuery = from track in _chinookContext.Tracks
                              where track.Name.ToLower().Contains(searchText.ToLower())
                              select track;

            trackViewSource.Source = searchQuery.ToList();
        }
    }
}
