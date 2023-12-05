// See https://aka.ms/new-console-template for more information

using System.Net;
using System.Net.Sockets;

namespace ChatClient;

public class Program
{

    public static void Main(string[] args)
    {
        if (args.Length > 3)
        {
            Console.Out.WriteLine("Invalid number of arguments.");
            
            return;
        }
        
        //start of the Program.
        Chat chat = new Chat();
        
         if (args.Length > 0 && args[0].Equals("-server", StringComparison.OrdinalIgnoreCase))
         {
             //Begin server mode and wait for a client
             Server server = new Server();
             server.waitForConnection();
             Console.Out.WriteLine("Connection established with client");

             //begin the chat
             while (server.Exit == false)
             {
                 server.chooseMode();
             }
             
             //Once the user types exit, break the loop and close the program.
             server.close();
         }
        //End server mode.
         
        //Begin client mode
         else
         {   
            //Attempt to connect to server
            chat.connectToServer();
            Console.Out.WriteLine("Client is connected to Server!");
            
            while (chat.Exit == false)
            {
                //prompt for mode
                chat.chooseMode();
            }
            
            //Close everything
            chat.close();
         }
    }//End main.
}