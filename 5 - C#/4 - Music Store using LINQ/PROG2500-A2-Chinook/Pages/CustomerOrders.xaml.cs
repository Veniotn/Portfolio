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
    /// Interaction logic for CustomerOrders.xaml
    /// </summary>
    public partial class CustomerOrders : Page
    {
        //db and viewsource objects
        private ChinookContext context = new ChinookContext();
        private CollectionViewSource customerViewSource;
        public CustomerOrders()
        {
            InitializeComponent();
            //connect viewsource from xml to code
            customerViewSource = (CollectionViewSource)FindResource(nameof(customerViewSource));

            //load db tables
            context.Customers.Load();
            context.Invoices.Load();  
            context.InvoiceItems.Load();
        }

        private void customerSearchButton_Click(object sender, RoutedEventArgs e)
        {
            //grab search term from the searchbox
            string searchText = customerSearchBox.Text.ToLower();

            //create the db query to select each customers information
            var query =
                from customer in context.Customers
                where customer.LastName.ToLower().Contains(searchText)
                select customer;

            //update the view source to display the customers information
            customerViewSource.Source = query.ToList();        
        }
    }
}
