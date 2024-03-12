//
// Thread-per-client architecture using the "is a thread" model.
//

import java.net.*;
import java.io.*;
import java.util.*;

public class DailyAdviceClientHandler extends Thread {

    private Socket clientSocket = null;
    private PrintWriter writer = null;

    // Constructor. Store the Socket object that we will use to deal with this client.
    public DailyAdviceClientHandler( Socket socket )
    {
		clientSocket = socket;
    }

    // Feel free to add any 'hilarious' one-line advice strings here.
    private String[] adviceList = {
        "Take smaller bites",
        "Go for the tight jeans. No they do NOT make you look fat",
        "One word: inappropriate",
        "Just for today, be honest. Tell your boss what you *really* think",
        "You might want to rethink that haircut"
    };

    // The advice sent to the client is just randomly selected from the above list.
    private String getAdvice()
    {
        int random = (int) (Math.random() * adviceList.length);
        return adviceList[random];
    }

    // This is the method that gets called when the OS scheduler gives out thread some CPU time.
    public void run()
    {
        // A few Socket methods used below need to be checked for an IOException, so put this all in one try-catch clause.
        try
        {
            // Get the address of the client. Also get the date. This information could be
            // added to a log file, for instance, but for this demo it is printed to stdout.
            InetAddress inet = clientSocket.getInetAddress();
            Date date = new Date();
            System.out.println("\nDate " + date.toString() );
            System.out.println("Connection made from " + inet.getHostName() );

            // Open up an output stream to the client.
            writer = new PrintWriter( clientSocket.getOutputStream() ); 
    
            // Get a random line of text and send to the client.
            String advice = getAdvice();
            writer.println(advice);
    
            // Local server echo (for demonstration purposes).
            System.out.println(advice);

            // Flush the buffer, then pause for 5 seconds. As explained in the worksheet question, this is to
            // give enough time to launch a second client to confirm this really is a multi-threaded server.
            writer.flush();
            try
            {
                Thread.sleep(5000);
            }
            catch( InterruptedException err )
            {
                // Report the error but carry on.
                System.err.println( "Interrupted exception." );
            }

            // Close up the output stream and the client connection.
            System.out.println( "Closing connection with client: " + inet.getHostName() );      // This is to help confirm concurrent clients.
            writer.close();
            clientSocket.close();
        }
        catch( IOException err )
        {
            System.err.println( "Error: Could not open up an output stream with the client." );
            System.exit(-1);
        }
    }
}