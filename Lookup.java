//
// Modified version of 'Lookup.java' from Lecture 6 to include the extra functionality
// requested in the worksheet question.
//

import java.net.*;								// For InetAddress and UnknownHostException.
import java.io.*;								// (ii) for IOException.

public class Lookup {

	private InetAddress[] inetAddrs = null;		// Note this is now an array of InetAddress objects.
	private static int pingTimeOut  = 2000;		// (ii) Timeout for 'ping' in milliseconds.

	public void resolve(String host) {
		try {
			// (i) Rather than use getByName() as in the originalversion, use getAllByName(),
			// which returns an array of InetAddress objects.
			inetAddrs = InetAddress.getAllByName( host );

			// Print the results as per the original version, for each returned InetAddress.
			System.out.println( "InetAddress.getAllByName() returned " + inetAddrs.length + " object(s)." );
			for( int i=0; i<inetAddrs.length; i++ )
			{
				System.out.println( "For InetAddress object " + i + ":" );
				System.out.println( " - hostname : "  + inetAddrs[i].getHostName   () );
				System.out.println( " - IP address: " + inetAddrs[i].getHostAddress() );

				// (ii) Something like the functionality of 'ping' can be implemented by using the isReachable() method,
				// which takes a timeout (in milliseconds) as a sole argument. Given possible delays by dropped packets etc.,
				// a reasonably timeout should be a few seconds.
				try {
					System.out.println( (inetAddrs[i].isReachable(pingTimeOut)?" - is reachable":" - is not reachable") );
				} catch( IOException e ) {
					System.out.println( " - could not determine reachability; IOException thrown." );
				}
			}
		}
		catch( UnknownHostException e ){ 		// If an exception was thrown, echo to stdout.
			e.printStackTrace();
		}
	}

	public static void main( String[] args ) {
		Lookup lookup = new Lookup();

		// Added some basic error handling for the correct number of command line arguments; not requested in the question, but a good thing to do.
		if( args.length != 1 )
		{
			System.out.println( "Must enter a single hostname or IP address." );
			return;
		}

		// Now know args has only a single entry.
		lookup.resolve( args[0] );
	}
}


