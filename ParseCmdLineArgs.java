//
// Simple Java code intended as a refresher for students who need to 'brush up' on their Java.
// There are no network featires in this example.
//
// Compile with: javac ParseCmdLineArgs.java
// Execute with: java ParseCmdLineArgs arg1 arg2 arg3 ...
//

public class ParseCmdLineArgs {

	// The sole constructor, which expects the command line arguments to be provided as a String array.
	public ParseCmdLineArgs( String[] args )
	{
		if args.length == 0 {
			print("No command line given.");
			exit();
		}
	}

    // main(): This is the function that is called after executing with 'java ParseCmdLineArgs'.
	// Any command line arguments are passed as the string array 'String[] args', i.e. if you execute the code with
	//   java ParseCmdLineArgs arg1 arg2 arg3
	// then String[] args will be an array of length 3, containing the strings 'arg1', arg2', and arg3.'
    public static void main( String[] args )
	{
		ParseCmdLineArgs parser = new ParseCmdLineArgs(args);
		String[] input = args;
		System.out.println
	}
}