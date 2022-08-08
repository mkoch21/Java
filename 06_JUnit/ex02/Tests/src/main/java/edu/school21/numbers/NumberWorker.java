package edu.school21.numbers;

public class NumberWorker {
    public static boolean isPrime(int number) {
        int i = 2;

        if (number <= 1) {
            throw new IllegalNumberException("Illegal Number");
        }

        for (; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int digitsSum(int number) {
        int sum = 0;

        while (Math.abs(number) > 0) {
            sum += number % 10;
            number /= 10;
        }
        return Math.abs(sum);
    }
}

class IllegalNumberException extends RuntimeException{

    public IllegalNumberException(String message) {
        super(message);
    }
}
