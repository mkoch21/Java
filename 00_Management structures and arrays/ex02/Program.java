import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		final int end = 42;

		long number = 0;

		int countCoffee = 0;

		number = checkInt(scanner);
		if (number <= 1) {
			System.err.println("Illegal Argument");
			System.exit(-1);
		}

		while (number != end) {
			if (isPrime(findSum(number)))
				countCoffee++;
			number = checkInt(scanner);
			if (number <= 1) {
				System.err.println("Illegal Argument");
				System.exit(-1);
			}
		}
		
		scanner.close();
		System.out.println("Count of coffee-request - " + countCoffee);
	}

	public static int checkInt(Scanner scanner) {
		if (scanner.hasNextInt()) {
			return scanner.nextInt();
		}
		System.err.println("Illegal Argument");
		System.exit(-1);
		return 0;
	}

	public static int findSum (long number) {
		int sum = 0;
		while (number > 0) {
			sum += number % 10;
			number /= 10;
		}
		return sum;
	}

	public static boolean isPrime (int sum) {
        for (int i = 2; i * i <= sum; i++) {
            if (sum % i == 0) {
                return false;
            }
        }
		return true;
	}
}