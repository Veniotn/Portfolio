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

namespace PROG2500_A2_Chinook
{
    /// <summary>
    /// Interaction logic for CustomerControl.xaml
    /// </summary>
    public partial class CustomerControl : UserControl
    {
        //db and viewsource objects
        ChinookContext context = new ChinookContext();
        CollectionViewSource customerViewSource;
        public CustomerControl()
        {
            InitializeComponent();
            //connect viewsource from xml to code
            customerViewSource = (CollectionViewSource)FindResource(nameof(customerViewSource));

            //load db tables
            context.Customers.Load();
            context.Invoices.Load();
        }
    }
}
