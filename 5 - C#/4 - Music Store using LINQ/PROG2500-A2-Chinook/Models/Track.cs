using System;
using System.Collections.Generic;
using System.Linq;
using System.Security;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Data;

namespace PROG2500_A2_Chinook.Models.Generated
{
    public partial class Track
    {
        readonly string composerBase = "Composer: ", composerNotFound = "not found";
        //if no composer info exists append not found to the composer textbox, otherwise grab the composer info
       public string? ComposerInfo { get { return composerBase + (string.IsNullOrEmpty(this.Composer) ? composerNotFound : this.Composer); } }
    }
}
