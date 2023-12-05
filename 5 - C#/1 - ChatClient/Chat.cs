using System.Net;
using System.Net.Sockets;

namespace ChatClient;

public class Chat
{
    //Global variables.
    private const int PORT = 8888;
    protected TcpClient client;
    protected TcpListener listener;
    protected NetworkStream chatStream;
    protected StreamReader messageReader;
    protected StreamWriter writer;
    private const string EXIT_TERM = "exit";
    private bool exit;

    public bool Exit
    {
        get => exit;
    }


    public Chat() { listener = new TcpListener(IPAddress.Any, PORT);}

    public void waitForConnection()
    {
        //begin waiting for a response.
        listener.Start();
        Console.Out.WriteLine("Waiting for any Client connection :}");
            
        //Accept incoming signal
        client = listener.AcceptTcpClient();
        
        setupReaderWriter();
    }
    
    
    public void connectToServer()
    {
        bool connected = false;
        int attempts = 0;
        while (!connected)
        {
            try
            {
                //Create client and attempt to connect
                client = new TcpClient();
                client.Connect("localhost", PORT);
            
                //Setup reader and writer for chat
                setupReaderWriter();
                connected = true;
            }
            catch (Exception e)
            {
                //If connection ever times out, prompt the user and search again.
                attempts++;
                Console.Out.WriteLine("Searching for server... Attempts: " + attempts);
            }
        }
        
        
    }

    private void setupReaderWriter()
    {
        //Create properties needed to read and write and to check for incoming input.
        chatStream = client.GetStream();
        messageReader = new StreamReader(client.GetStream());
        writer        = new StreamWriter(client.GetStream());
    }

    public void chooseMode()
    {
        //This method is the main mode of the chat, it will check for input from the user as well as
        //messages from the second user.

        //if a key is pressed check it
        if (Console.KeyAvailable)
        {
            //Using intercept will allow you to read the key without pressing enter
            var keyInput = Console.ReadKey(true);
            
            //Convert key to string, if the key is 'i' switch to input mode, else do nothing.
            string modeSelection = keyInput.KeyChar.ToString();
            if (modeSelection[0] == 'i')
            {
                inputMode();
            }
        }
        //the loop will constantly be checking if the stream has received any new messages, if there is a message
        //available, check it and display it to the user.
        if (chatStream.DataAvailable)
        {
            recieveMessages();
        }

    }
    
    private void inputMode()
    {
        //Prompt for a message
        Console.Out.Write("Insertion Mode>> ");
        var outgoingMessage = Console.ReadLine();
        
        //Check if the message is exit
        if (outgoingMessage.Equals(EXIT_TERM, StringComparison.OrdinalIgnoreCase))
        {
            Console.Out.WriteLine("You typed escape to exit.");
            exit = true;
        }
        
        //Write that message to the client
        writer.WriteLine(outgoingMessage);
        writer.Flush();
    }

    private void recieveMessages()
    {
        
        var incomingMessage = messageReader.ReadLine();
        if (incomingMessage.Equals(EXIT_TERM, StringComparison.OrdinalIgnoreCase))
        {
            
            exit = true;
            return;
        }
        
        Console.Out.WriteLine("INCOMING MESSAGE: " + incomingMessage);
    }
    
    public virtual void close()
    {
        Console.Out.WriteLine("Disconnected\nGood Bye!");
        messageReader.Close();
        client.Close();
        listener.Stop();
        
        //Beep on close   
        Console.Beep();
    }
}