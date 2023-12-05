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

namespace PROG2500_A2_Chinook
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        Page homePage;
        Page artistPage;
        Page albumPage;
        Page trackPage;
        Page orderPage;
        Page catalogPage;
        public MainWindow()
        {
            InitializeComponent();
            //create all of our pages when starting so we dont have to make a new one everytime we switch pages
            homePage    = new Pages.Home();
            artistPage  = new Pages.Artists();
            albumPage   = new Pages.Albums();
            trackPage   = new Pages.Tracks();
            catalogPage = new Pages.MusicCatalog();
            orderPage   = new Pages.CustomerOrders();
        }

        //page navigation options
        private void Window_Loaded(object sender, RoutedEventArgs e)
        {
            mainFrame.NavigationService.Navigate(homePage);
        }
        private void home_Click(object sender, RoutedEventArgs e)
        {
            mainFrame.NavigationService.Navigate(homePage);
        }

        private void artists_Click(object sender, RoutedEventArgs e)
        {
            mainFrame.NavigationService.Navigate(artistPage);
        }

        private void albums_Click(object sender, RoutedEventArgs e)
        {
            mainFrame.NavigationService.Navigate(albumPage);
        }

        private void tracks_Click(object sender, RoutedEventArgs e)
        {
            mainFrame.NavigationService.Navigate(trackPage);
        }

   

        private void catalog_Click(object sender, RoutedEventArgs e)
        {
            mainFrame.NavigationService.Navigate(catalogPage);
        }

        private void orders_Click(object sender, RoutedEventArgs e)
        {
            mainFrame.NavigationService.Navigate(orderPage);
        }

        private void exit_bar_Click(object sender, RoutedEventArgs e)
        {
            Application.Current.Shutdown();
        }
    }
}
