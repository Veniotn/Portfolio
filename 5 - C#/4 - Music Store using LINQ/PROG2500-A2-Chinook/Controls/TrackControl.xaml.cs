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
    /// Interaction logic for TrackControl.xaml
    /// </summary>
    public partial class TrackControl : UserControl
    {
        //db and viewsource objects
        ChinookContext context = new ChinookContext();
        CollectionViewSource trackViewSource = new CollectionViewSource();
        public TrackControl()
        {
            InitializeComponent();
            //connect xml to code
            trackViewSource = (CollectionViewSource)FindResource(nameof(trackViewSource));
            //load table
            context.Tracks.Load();
            //send to xml viewsource
            trackViewSource.Source = context.Tracks.Local.ToObservableCollection();
        }
    }
}
