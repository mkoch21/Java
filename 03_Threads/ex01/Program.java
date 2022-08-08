public class Program {
	public static void main(String[] args) {

		Integer count = checkInput(args);
		
		Handling handling = new Handling();

		Hen hen = new Hen(count, handling);

        Egg egg = new Egg(count, handling);

		egg.start();
		hen.start();
		try {
			egg.join();
			hen.join();
		} catch (InterruptedException ie) {
			System.err.println("Interrupted Exception");
			System.exit(-1);
		}
	}

	public static int checkInput(String[] args) {
		Integer count = 0;

		if (args.length == 1 && args[0].startsWith("--count=")) {
			try {
				count = Integer.parseInt(args[0].substring(8));
			} catch (NumberFormatException nfe) {
				System.err.println("Input Error");
				System.exit(-1);
			}
		} else {
			System.err.println("Input Error");
			System.exit(-1);
		}

		if (count < 0) {
			System.err.println("Input Error");
			System.exit(-1);
		}

		return count;
	}

} 