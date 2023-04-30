// Importing
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This program will calculate the power of a number.
 *
 * @author  Adrijan Vranjkovic
 * @version 1.0
 * @since   2023-04-29
 */
public final class RecPow {

    /**
     * For the style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private RecPow() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main function.
     *
     * @param args Unused
     */
    public static void main(final String[] args) {

        try {

            // Create and read the input file
            final File inputFile = new File("input.txt");
            final Scanner scanner = new Scanner(inputFile);

            // Create the output file
            final File outputFile = new File("output.txt");
            final PrintWriter output = new PrintWriter(outputFile);

            // Loop through each line in the input
            while (scanner.hasNextLine()) {

                // Get the numbers from each line.
                final String[] numbers = scanner.nextLine().split(" ");
                final int base = Integer.parseInt(numbers[0]);
                final int exp = Integer.parseInt(numbers[1]);

                // Call the power function and send
                // the result to the output file.
                final int result = power(base, exp);
                output.println(result);
            }

            // Close the scanner
            scanner.close();

            // Close the output file
            output.close();

        } catch (final FileNotFoundException fnfex) {
            // Display error message.
            System.out.println("Error: " + fnfex.getMessage());
        }
    }

    /**
     * This function gets the power of a number.
     *
     * @param base base
     * @param exp exponent
     * @return base raised to the exp
     */
    public static int power(final int base, final int exp) {

        // Base case
        if (exp == 0) {
            return 1;
        } else {

            // Call this function recursively.
            return base * power(base, exp - 1);
        }
    }
}
