//
// Simple Java code intended as a refresher for students who need to 'brush up' on their Java.
// There are no network featires in this example.
//
// Compile with: javac ParseCmdLineArgs.java
// Execute with: java ParseCmdLineArgs arg1 arg2 arg3 ...
//

public class ParseCmdLineArgs {

	private String[] input;

	// The sole constructor, which expects the command line arguments to be provided as a String array.
	public ParseCmdLineArgs( String[] args ) {
		if (args.length == 0) {
			System.out.println("No command line given.");
			return;
		}

		input = args;

		for (int i=0; i<input.length; i++) {
			System.out.print("Argument" + i + ": " + input[i]);

			// if there's any dots
			if (input[i].contains(".")) {
				System.out.print("(may be a hostname)");
			}

			// (iii) if contains exactly 3 dots
			if (countDots(input[i]) == 3) {
				System.out.print("(may be an IPv4 address)");
			}

			// end line
			System.out.println();
		}
		
	}

    // main(): This is the function that is called after executing with 'java ParseCmdLineArgs'.
	// Any command line arguments are passed as the string array 'String[] args', i.e. if you execute the code with
	//   java ParseCmdLineArgs arg1 arg2 arg3
	// then String[] args will be an array of length 3, containing the strings 'arg1', arg2', and arg3.'
    public static void main( String[] args ) {
		ParseCmdLineArgs parser = new ParseCmdLineArgs(args);
	}
	
	// Count the number of dots in a string
	private int countDots(String s) {
		int count = 0;
		for (char c : s.toCharArray()) {
			if (c == '.') {
				count++;
			}
		}
		return count;
	}
}