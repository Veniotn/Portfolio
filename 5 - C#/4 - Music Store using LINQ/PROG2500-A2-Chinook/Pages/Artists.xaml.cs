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
    /// Interaction logic for Artists.xaml
    /// </summary>
    public partial class Artists : Page
    {
        //database context object
        ChinookContext _chinookContext = new ChinookContext();
        //will hold the data that we get from our db context object
        CollectionViewSource artistViewSource = new CollectionViewSource();
        public Artists()
        {
            InitializeComponent();

            //link xaml collection view source to code
            artistViewSource = (CollectionViewSource)FindResource(nameof(artistViewSource));
            //load the correct table
            _chinookContext.Artists.Load();
            //fill the view with data
            artistViewSource.Source = _chinookContext.Artists.Local.ToObservableCollection();


        }

        private void artistSearchButton_Click(object sender, RoutedEventArgs e)
        {
            string searchText = artistSearchBox.Text;

            var searchQuery = from artist in _chinookContext.Artists
                              where artist.Name.ToLower().Contains(searchText.ToLower())
                              select artist;

            artistViewSource.Source = searchQuery.ToList();
        }
    }
}
