package algorithms;

public class Fibonacci implements Algorithm {
    private static final int FIBONACCI_NUMBER = 6;

    @Override
    public void execute() {
        System.out.println("Executing Fibonacci algorithm");
        System.out.println(String.format("%sth Fibonacci (with recursion) number: %d",
                FIBONACCI_NUMBER, fibo(FIBONACCI_NUMBER)));
        System.out.println(String.format("%sth Fibonacci (without recursion) number: %d",
                FIBONACCI_NUMBER, fiboNotRecursive(FIBONACCI_NUMBER)));
    }

    private int fibo(int number) {
        if (number == 0) {
            return 0;
        }

        if (number == 1) {
            return 1;
        }

        return fibo(number - 1) + fibo(number - 2);
    }

    private int fiboNotRecursive(int number) {
        if (number <= 1) {
            return number;
        }

        int current = 1;
        int previousValue = 1;
        for (int i = 2; i < number; i++) {
            int temp = current;
            current += previousValue;
            previousValue = temp;
        }

        return current;
    }
}
