import java.io.*;
import java.util.*;

/**
 * This class uses DoubleStacks to reverse .dat sound clips.
 * @author Jessica Miller (minor modifications by Benson Limketkai)
 *
 */
public class SoundBlaster {
    public static final boolean DEBUG = true;
	
    /**
     * Pprompts the user for an input file (.dat), an output file (.dat),
     * and the type of DoubleStack implementation that should be 
     * used.  Given this information, a reversed sound clip is produced.
     * @param args not used
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
	long startTime, endTime, elapsedTime;
	Scanner console = new Scanner(System.in);
		
	System.out.println("Welcome to SoundBlaster!!");
		
	Scanner input = getInputFile(console);
	PrintStream output = getOutputFile(console);
	boolean useArrayStack = usingArrayStack(console);

	DoubleStack stack;
	if (useArrayStack) {
	    stack = new ArrayStack();
	} else {
	    stack = new LinkedStack();
	}
		
	if (DEBUG) {
	    startTime = System.currentTimeMillis();
	}
		
	int sampleRate = readInput(input, stack);
		
	if (DEBUG) {
	    endTime = System.currentTimeMillis();
	    elapsedTime = endTime - startTime;
	    System.out.printf("Time it took to push samples onto stack: %d ms\n", elapsedTime);

	    startTime = System.currentTimeMillis();
	}
		
	writeOutput(output, stack, sampleRate);
		
	if (DEBUG) {
	    endTime = System.currentTimeMillis();
	    elapsedTime = endTime - startTime;
	    System.out.printf("Time it took to pop samples from stack: %d ms\n", elapsedTime);	
	}
    }
	
    /**
     * Returns a Scanner to the input file.
     * @param console
     * @return Scanner to the input file
     * @throws FileNotFoundException
     */
    private static Scanner getInputFile(Scanner console) throws FileNotFoundException {
	System.out.print("Input file (.dat) to reverse: ");
	return new Scanner(new File(console.nextLine().trim()));
    }
	
    /**
     * Returns a PrintStream to the output file.
     * @param console
     * @return PrintStream to the output file
     * @throws FileNotFoundException
     */	
    private static PrintStream getOutputFile(Scanner console) throws FileNotFoundException {
	System.out.print("Output file (.dat) to write backmask to: ");
	return new PrintStream(new File(console.nextLine().trim()));		
    }
	
    /**
     * Gets the sample rate of the source sound clip and returns it.
     * @param input
     * @return sample rate
     */
    private static int getSampleRate(Scanner input) {
        String line = input.nextLine();
        Scanner lineScanner = new Scanner(line);

	// The fourth token is the sample rate (ignore the rest).
        lineScanner.next(); 		 // read semicolon
        lineScanner.next(); 		 // read "Sample"
        lineScanner.next(); 		 // read "Rate"
        return lineScanner.nextInt();	 // read in sample rate
    }
	
    /**
     * Reads the source .dat file and stores its contents reversed into the given
     * stack.  The sample rate found in the source .dat file is returned from this 
     * method.
     * @param input
     * @return sample rate
     */	
    private static int readInput(Scanner input, DoubleStack stack) {
        // Read the first line of the .dat file to get the sample rate.
        int sampleRate = getSampleRate(input);

        // Read in the file and place values from the second column 
        // in the stack. The first column values are thrown away. 
        // We stop reading when we reach the end of the file.
        int count = 0;
        
        while (input.hasNextLine()) {
	    String line = input.nextLine();

	    // ignore lines that start with semi-colons
            if (line.startsWith(";")) {
                continue;
            }
            
            Scanner lineScanner = new Scanner(line);
            lineScanner.next(); // throw away first value
            double data = lineScanner.nextDouble();
            stack.push(data);
            count++;
        }

        System.out.println(count + " samples in file");	
        return sampleRate;
    }
	
    /**
     * Writes the reversed sound clip to the output file using the stack that 
     * was created from reading the input.
     * @param output output stream
     * @param stack stack containing input
     * @param sampleRate sample rate
     */
    private static void writeOutput(PrintStream output, DoubleStack stack, int sampleRate) {
        // Now we are ready to output the data values to output file.
        // But first, we need to output the header line
        // "; Sample Rate <sample rate>"
        output.println("; Sample Rate " + sampleRate);

        // Since the first column consists of numbers which start
        // at 0 and increase by 1/sampleRate every time slice, we'll
        // just use numSteps to recalculate these numbers.
        int numSteps = 0;

        // Finally, we print the values in reverse order (by popping
        // them off the stack). The first column consists of numbers
        // which start at 0 and increase by 1/sampleRate per row, so
        // we'll use numSteps/sampleRate to recalculate the appropriate
        // values. Uniform spacing will be accomplished by printing a tab.
        while (!stack.isEmpty()) {
            output.println((double)numSteps / sampleRate + "\t" + stack.pop());
            numSteps++;
        }	
    }
	
    /**
     * Prompts the user for which DoubleStack implementation to use 
     * to create the reversed sound file.
     * @param console
     * @return whether to use an array DoubleStack implementation
     */
    private static boolean usingArrayStack(Scanner console) {
	String prompt = "ArrayStack or LinkedStack (enter 'a' or 'l'): ";
	System.out.print(prompt);
	String answer = console.nextLine().trim().toLowerCase();
		
	while (!answer.equals("a") && !answer.equals("l")) {
	    System.out.print(prompt);
	    answer = console.nextLine().trim().toLowerCase();
	}
		
	return answer.equals("a");		
    }
}
