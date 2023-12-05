namespace ChatClient;

public class Server : Chat
{
    
    public override void close()
    {
        Console.Out.WriteLine("Application has been disconnected.");
        messageReader.Close();
        client.Close();
        listener.Stop();
        writer.Close();
        chatStream.Close();
        //Beep on close   
        Console.Beep();
    }
}