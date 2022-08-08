package edu.school21.numbers;

import java.util.Scanner;

public class NumberWorker {
    public boolean isPrime(int number) {
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

    public int digitsSum(int number) {
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
