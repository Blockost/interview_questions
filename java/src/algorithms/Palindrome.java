package algorithms;

public class Palindrome implements Algorithm {
    static final String WORD = "KAYYAK";

    @Override
    public void execute() {
        System.out.println("Executing Palindrome");
        System.out.println(String.format("Is %s a palindrome: %b", WORD, this.isPalindrome(WORD)));
    }

    @SuppressWarnings("SameParameterValue")
    private boolean isPalindrome(String word) {
        for (int i = 0; i < word.length() / 2; i++) {
            char c1 = word.charAt(i);
            char c2 = word.charAt(word.length() - 1 - i);
            System.out.println(String.format("Checking that '%c' is the same as '%c' ", c1, c2));
            if (c1 != c2) {
                return false;
            }
        }
        return true;
    }
}
