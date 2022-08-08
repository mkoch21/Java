import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

		String line = null;

        int weeksCount = 1;

        long gradeStorage = 0;

		line = checkLine(scanner);

		while (weeksCount <= 18) {
            if (line.equals("42")) {
                break;
            }
            if (!line.equals("Week " + weeksCount)) {
                System.err.println("Illegal Argument");
                System.exit(-1);
            }
			gradeStorage = gradeStorage * 10 + findMin(scanner);
			line = checkLine(scanner);
			line = checkLine(scanner);
			weeksCount++;
        }

		for (int i = 1; i < weeksCount; i++) {
			draw(gradeStorage, i, weeksCount);
		}

		scanner.close();
    }


	public static void draw(long gradeStorage, int week, int weeksCount) {
		
		for (int i = weeksCount - 1; i > week; i--) {
			gradeStorage /= 10;
		}

		gradeStorage = gradeStorage % 10;
		System.out.print("Week " + week + " ");
		for (int i = 0; i < gradeStorage; i++) {
			System.out.print("=");
		}

		System.out.println(">");
	}

	public static int findMin(Scanner scanner) {
		int min = 10;

		int currentGrade = 0;

		for (int i = 0; i < 5; i++) {
			if (scanner.hasNextInt()){
				currentGrade = scanner.nextInt();
			}
			else {
				System.err.println("Illegal Argument");
				System.exit(-1);
			}

			if (currentGrade < 1 || currentGrade > 9) {
				System.err.println("Illegal Argument");
				System.exit(-1);
			}

			if (currentGrade < min) {
				min = currentGrade;
			}
		}

		return min;
	}

	public static String checkLine(Scanner scanner) {

		if (scanner.hasNextLine()) {
			return scanner.nextLine();
		}
		
		System.err.println("Illegal Argument");
		System.exit(-1);
		return null;
	}
}
