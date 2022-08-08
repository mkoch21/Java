package edu.school21.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberWorkerTest {
    NumberWorker numberWorker;

    @ParameterizedTest
    @ValueSource (ints = {2, 3, 11, 199, 131071})
    void isPrimeForPrimes(int number) {
        Assertions.assertTrue((new NumberWorker()).isPrime(number));
    }

    @ParameterizedTest
    @ValueSource (ints = {4, 169, 97512, 42, 481516234})
    void isPrimeForNotPrimes(int number) {
        Assertions.assertFalse((new NumberWorker()).isPrime(number));
    }

    @ParameterizedTest
    @ValueSource (ints = {0, 1, -1, -42, -777})
    void isPrimeForIncorrectNumbers(int number) {
        Assertions.assertThrows(IllegalNumberException.class, () -> (new NumberWorker()).isPrime(number));
    }

    @ParameterizedTest
    @CsvFileSource(resources = {"/data.csv"}, delimiter = ',')
    void digitsSum(int x, int y) {
        Assertions.assertEquals((new NumberWorker()).digitsSum(x), y);

    }
}
