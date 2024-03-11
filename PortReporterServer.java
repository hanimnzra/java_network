//
// The server that pairs with the PortReportetClient.' Essentially just reports all ports
// during the connection to the client.
//

import java.io.*;
import java.net.*;
import java.util.*;

public class PortReporterServer
{
    public void runServer() {
        try
        {
            // Port 5555 is known to the client as well.
            ServerSocket serverSock = new ServerSocket(5555);

            // Send message to stdout giving the listening port.
            System.out.println( "SERVER: Listening on port " + serverSock.getLocalPort() + "." );

            // Infinite loop.
            while( true )
            {
                // Accept; blocking; will not return until a client has made contact.
                Socket sock = serverSock.accept();

                // Output the ports for the socket being used to communicate with this client.
                System.out.println( "SERVER: Communicating with client using local port " + sock.getLocalPort() + " and remote port " + sock.getPort() + "." );

                // Close straight away.
                sock.close();
            }
        }
        catch (IOException ex) {
            System.out.println( ex );
        }
    }

    // Command line arguments are given by String[] args, but are unused in this example.
    public static void main( String[] args ) {
        PortReporterServer server = new PortReporterServer();
        server.runServer();
    }
}
