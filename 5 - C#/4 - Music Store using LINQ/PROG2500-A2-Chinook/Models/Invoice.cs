using PROG2500_A2_Chinook.Models.Generated;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PROG2500_A2_Chinook.Models.Generated
{
    public partial class Invoice
    {
        public string? InvoiceDateString
        {
            get
            {
                //format datetime object to string
                return this.InvoiceDate.ToString("yyyy-mm-dd");
            }
        }

        public int Quantity
        {
            get
            {
                //grab a count of items attactched to this invoice
                return this.InvoiceItems.Count;
            }
        }
    }
}
