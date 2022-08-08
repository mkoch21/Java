import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int number = 0;

		boolean isPrime = true;

		if (scanner.hasNextInt()) {
			number = scanner.nextInt();
		}
		else {
			System.err.println("Illegal Argument");
			System.exit(-1);
		}
		
		scanner.close();

		if (number <= 1) {
			System.err.println("Illegal Argument");
			System.exit(-1);
		}

		int i = 2;

        for (; i * i <= number; i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }

		System.out.println(isPrime + " " + (i - 1));
	}
}
