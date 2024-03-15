//
// Simple client that tries to connect to a PortReporterServer running on localhost,
// and reports all ports to screen, then closes.
//

import java.io.*;
import java.net.*;

public class PortReporterClient
{
    public void connect() {
        try {
            // Try to open up a connection with this host ('localhost'), port number 5555.
            // You must first run the server 'PortReporterServer' on the same host, e.g. in another shell.
            Socket s = new Socket( "localhost", 5555 );

            // Output both the local and 'remote' port.
            System.out.println( "CLIENT: Connected to server with local port " + s.getLocalPort() + " connected to remote port " + s.getPort() + "." );

            // Close immediately.
            s.close();
        }
        catch( IOException e )
        {
            System.out.println( e );
        }
    }

    // Called with command line arguments, which are not used in this simple example.
    public static void main( String[] args )
    {
        PortReporterClient client = new PortReporterClient();
        client.connect();
    }
}
