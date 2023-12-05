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
    /// Interaction logic for CatalogControl.xaml
    /// </summary>
    public partial class CatalogControl : UserControl
    {
        //db and viewsource objects
        private ChinookContext context = new ChinookContext();
        private CollectionViewSource catalogViewSource;
        public CatalogControl()
        {
            InitializeComponent();
            //connect xml to code
            catalogViewSource = (CollectionViewSource)FindResource(nameof(catalogViewSource));

            //load db into this context
            context.Artists.Load();
            context.Albums.Load(); 
        }
    }
}
