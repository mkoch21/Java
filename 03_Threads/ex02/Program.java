import java.util.ArrayList;
import java.util.List;

public class Program {
	public static void main(String[] args) {
		Integer arraySize = 0;

		Integer threadsCount = 0;

		Integer sunInMain = 0;

		if (args.length == 2 && args[0].startsWith("--arraySize=")
		 	&& args[1].startsWith("--threadsCount=")) {
			try {
				arraySize = Integer.parseInt(args[0].substring(12));
				threadsCount = Integer.parseInt(args[1].substring(15));
			} catch (NumberFormatException nfe) {
				System.err.println("Input Error");
				System.exit(-1);
			}
		} else {
			System.err.println("Input Error");
			System.exit(-1);
		}

		if (arraySize <= 0 || threadsCount <= 0 || threadsCount > arraySize || 
			arraySize > 2000000) {
			System.err.println("Input Error");
			System.exit(-1);
		}

		int delta = (int)(arraySize / threadsCount);

		int begin = 0;

		int end = 0;

		List<Integer> array = new ArrayList<>(arraySize);
        for (int i = 0; i < arraySize; i++) {
			array.add((int)(Math.random() * 2 * 1000 - 1000));
			sunInMain += array.get(i);
		}

		List<Sum> threads = new ArrayList<>(threadsCount);

		List<Integer> currentArray = new ArrayList<>(delta);

		for (int i = 0; i < threadsCount; i++) {
			begin = i * delta;
			end = i * delta + delta - 1;
			if (i == threadsCount - 1) {
				end = arraySize - 1;
			}
			currentArray = array.subList(begin, end + 1);
			Sum thread = new Sum(currentArray, i + 1, begin, end);
			threads.add(thread);
		}

		for (Sum sum : threads) {
			sum.start();
		}
		for (Sum sum : threads) {
			try {
				sum.join();
			} catch (InterruptedException ie) {
				System.err.println("Interrupted Exception");
				System.exit(-1);
			}
		}

		System.out.println("Sum: " + sunInMain);

		for (Sum sum : threads) {
			sum.printInfo();
		}

		System.out.println("Sum by threads: " + Sum.getTotalSum());
	}

	public static class Sum extends Thread {
		private static int totalSum = 0;

		private List<Integer> currentArray;

		private int numberOfThread;

		private int begin;

		private int end;

		private int sumInThread = 0;

		public Sum (List<Integer> currentArray, int numberOfThread, int begin, int end) {
			this.currentArray = currentArray;
			this.numberOfThread = numberOfThread;
			this.begin = begin;
			this.end = end;
		}
	
		@Override
		public void run() {
			for (Integer integer : currentArray) {
				sumInThread += integer;
			}
			try {
				Sum.sleep((int) (Math.random() * 100));
			}
			catch (InterruptedException ie) {
				System.out.println("ie");
			}
		}

		public synchronized void printInfo() {
			System.out.println("Thread " + numberOfThread + ": from " + begin + " to " + end + " sum is " + sumInThread);
			totalSum += sumInThread;
		} 

		public static int getTotalSum () {
			return totalSum;
		}
	}

} 