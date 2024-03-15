//
// A thread-per-client version of the serial DailyAdviceServer.
//

import java.io.*;
import java.net.*;

public class DailyAdviceMultiServer
{
    private static int listeningPort = 4242;
    private ServerSocket serverSocket = null;
    private boolean listening = true;

    public void runServer() {

        // Try to bind to the listening port. Use a separate try-catch clause for a more localised error message.
        try
        {
            serverSocket = new ServerSocket(listeningPort);
        }
        catch( IOException err )
        {
            System.err.println( "Could not bind to the listening port " + listeningPort + "." );
            System.exit(-1);
        }

        // In an infinite loop, create new client handler threads for each client that requests a connection.
        try{
            while( listening )
                new DailyAdviceClientHandler( serverSocket.accept() ).start();

           // Although it's not possible to reach here in this simple example, we would normally close the server socket before quitting.
           serverSocket.close();
       }
        catch( IOException err )
        {
            System.err.println( "Could not accept a Socket connection from a new client." );
            System.exit(-1);
        }
    }

    // The main() method has not changed from the serial version.
    public static void main( String[] args )
    {
        DailyAdviceMultiServer server = new DailyAdviceMultiServer();
        server.runServer();
    }
}
