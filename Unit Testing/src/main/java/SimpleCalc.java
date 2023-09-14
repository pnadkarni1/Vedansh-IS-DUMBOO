//various functions for a simple calculator
//start with only taking positive numbers
public class SimpleCalc {

    /**
     * Add two non-negative numbers together.  A negative is treated as a 0.
     *
     * @param numOne first non-negative number to be added, must fit into the range of a positive integer
     * @param numTwo second non-negative number to be added, must fit into the range of a positive integer
     * @return the sum of two non-negative numbers.  Negatives are treated as 0.
     */
    public int add (int numOne, int numTwo) {
        if (numOne < 0) {
            numOne = 0;
        } else if (numTwo < 0) {
            numTwo = 0;
        }

        return numOne + numTwo;
    }

    /**
     * Subtract two non-negative numbers to only produce a non-negative number.  Negative numbers are treated as 0.
     *
     * @param numOne first non-negative number to be subtracted, must fit into the range of a positive integer
     * @param numTwo first non-negative number to be subtracted, must fit into the range of a positive integer
     * @return difference between numOne and numTwo where they produce only a positive number.  Negative numbers are treated as 0
     */
    public int subtract (int numOne, int numTwo) {
        if (numOne < 0) {
            numOne = 0;
        } else if (numTwo < 0) {
            numTwo = 0;
        }

        //if the result of numOne - numTwo is a negative number we want to return 0 instead
        //we are taking the max of either the subtraction or 0
        return Math.max(numOne - numTwo, 0);
    }

    /**
     * Multiply two non-negative integers together.  Any negative integer is treated as a 0
     *
     * @param numOne first non-negative number to be multiplied.  Negative treated as 0
     * @param numTwo second non-negative number to be multiplied.  Negative treated as 0
     * @return product fo two integer numbers multiplied together.  Negative number treated as 0
     */
    public int multiply (int numOne, int numTwo) {
        //ternary operator in java
        //evaluates as compare numOne < 0 OR numTwo < 0
        //since we are an OR if either is true return 0 else return numOne * numTwo
        //could also be done with if-else if statements
        return numOne < 0 || numTwo < 0 ? 0 : numOne * numTwo;
    }

    /**
     * Divide two non-negative zero numbers to get a quotient.  Divisor cannot be 0.
     *
     * @param divisor A non zero positive number. Throws IllegalArgument if 0 or less
     * @param dividend A non-negative integer.  Negative treated as 0
     * @return the quotient after dividing.  Divisor cannot be 0 or less throws IllegalArgument
     */
    public int division (int divisor, int dividend) throws IllegalArgumentException {
        //the reason we want to throw this exception here
        //and not with any of the other methods is because
        //those limitations do not have to exist and we could change them if we wanted
        //this limitation can never be changed
        //
        if (divisor <= 0) {
            throw new IllegalArgumentException("Cannot / by 0 and divisor cannot be negative");
        }

        if (dividend < 0) {
            dividend = 0;
        }

        return dividend/divisor;
    }

    /**
     * Calculate the remainder of division from two positive integers.  Divisor cannot be 0 or negative.
     *
     * @param divisor A non zero positive number. IllegalArgument if 0 or less
     * @param dividend A non-negative integer.  Negative treated as 0
     * @return remainder from division of two positive integers.  Divisor not negative
     */
    public int remainder (int divisor, int dividend) {
        int remainder = 0;
        try {
            if (dividend < 0) {
                dividend = 0;
            }

            if (divisor < 0) {
                divisor = 0;
            }

            remainder = dividend % divisor;
        } catch (ArithmeticException badDivisor) {
            System.out.println("Cannot divide by 0");
            return -1;
        }

        return remainder;
    }

    public boolean isOddNumber (int number) {
        return number % 2 != 0;
    }

}
