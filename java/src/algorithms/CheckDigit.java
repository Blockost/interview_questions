package algorithms;

/**
 * See https://en.wikipedia.org/wiki/Check_digit
 */
public class CheckDigit implements Algorithm {
    final static String UPC_NUMBER = "036000241457";
    final static String ISBN10_NUMBER = "0-201-53082-1";

    @Override
    public void execute() {
        System.out.println("Executing CheckDigit algorithm");
        System.out.println(String.format("Check UPC: %b", this.checkUPC(UPC_NUMBER)));
        System.out.println(String.format("Check ISBN: %b", this.checkISBN10(ISBN10_NUMBER)));
    }

    /**
     * The final digit of a Universal Product Code is a check digit computed as follows:
     * <p>
     * 1 - Add the digits in the odd-numbered positions (first, third, fifth, etc.) together and multiply by three.
     * <p>
     * 2- Add the digits (up to but not including the check digit) in the even-numbered positions
     * (second, fourth, sixth, etc.) to the result.
     * <p>
     * 3 - Take the remainder of the result divided by 10 (modulo operation). If the remainder is equal to 0
     * then use 0 as the check digit, and if not 0 subtract the remainder from 10 to derive the check digit.
     */
    @SuppressWarnings("SameParameterValue")
    private boolean checkUPC(String numberAsString) {
        int checkDigit = Character.getNumericValue(numberAsString.charAt(numberAsString.length() - 1));
        int sumOfOddNumbers = 0;
        int sumOfEvenNumbers = 0;

        for (int i = 0; i < numberAsString.length(); i = i + 2) {
            sumOfOddNumbers += Character.getNumericValue(numberAsString.charAt(i));
        }

        for (int i = 0; i < numberAsString.length() - 2; i = i + 2) {
            sumOfEvenNumbers += Character.getNumericValue(numberAsString.charAt(i + 1));
        }

        int total = (sumOfOddNumbers * 3 + sumOfEvenNumbers) % 10;

        if (total == 0) {
            return checkDigit == 0;
        }

        return checkDigit == 10 - total;
    }

    /**
     * The final character of a ten-digit International Standard Book Number is a
     * check digit computed so that multiplying each digit by its position in the number
     * (counting from the right) and taking the sum of these products modulo 11 is 0.
     * The digit the farthest to the right (which is multiplied by 1) is the check digit,
     * chosen to make the sum correct
     */
    @SuppressWarnings("SameParameterValue")
    private boolean checkISBN10(String numberAsString) {
        int position = 0;
        int computation = 0;
        for (int i = 0; i < numberAsString.length(); i++) {
            if (numberAsString.charAt(i) != '-') {
                position++;
                computation += Character.getNumericValue(numberAsString.charAt(i)) * position;
            }
        }
        return computation % 11 == 0;
    }
}
