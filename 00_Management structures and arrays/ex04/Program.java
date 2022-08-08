import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String line = null;

		short[] frequency = new short[65535];

		int index = 0;

		int[] mostCommon = new int[10];

		if (scanner.hasNextLine()) {
			line = scanner.nextLine();
		}
		else {
			System.err.println("Illegal Argument");
			System.exit(-1);
		}

		scanner.close();

		if (line.equals("")) {
			System.err.println("Illegal Argument");
			System.exit(-1);
		}

		for (int i = 0; i < line.length(); i++) {
			index = (int) line.charAt(i);
			frequency[index]++;
		}

		findMostCommon(frequency, mostCommon);
		mostCommon = rearrangeArray(frequency, mostCommon);
		drawGraph(frequency, mostCommon);
	}

	public static int[] findMostCommon (short[] frequency, int[] mostCommon) {
		int minMostCommon = 0;

		for (int i = 0; i < mostCommon.length; i++) {
			mostCommon[i] = i;
		}

		minMostCommon = findMinMostCommon(frequency, mostCommon);

		for (int i = mostCommon.length; i < frequency.length; i++) {
			if (frequency[i] > frequency[mostCommon[minMostCommon]]) {
				mostCommon[minMostCommon] = i;
				minMostCommon = findMinMostCommon(frequency, mostCommon);
			}
			else if (frequency[i] == frequency[minMostCommon] && i < mostCommon[minMostCommon]) {
				mostCommon[minMostCommon] = i;
				minMostCommon = findMinMostCommon(frequency, mostCommon);
			}
		}

		return mostCommon;
	}

	public static int findMinMostCommon(short[] frequency, int[] mostCommon) {
		int minFreq = frequency[mostCommon[0]];

		int min = 0;

		for (int i = 0; i < mostCommon.length; i++) {
			if (minFreq > frequency[mostCommon[i]]) {
				min = i;
				minFreq = frequency[mostCommon[i]];
			}
			else if (minFreq == frequency[mostCommon[i]] && i > mostCommon[min]) {
				min = i;
				minFreq = frequency[mostCommon[i]];
			}
		}

		return min;
	}

	public static int[] rearrangeArray (short[] frequency, int[] mostCommon) {
		int tmp = 0;

		while (!isIncrease(frequency, mostCommon)) {
			for (int i = 0; i < mostCommon.length - 1; i++) {
				if (frequency[mostCommon[i]] < frequency[mostCommon[i + 1]]) {
					tmp = mostCommon[i];
					mostCommon[i] = mostCommon[i + 1];
					mostCommon[i + 1] = tmp;
				}
				if (frequency[mostCommon[i]] == frequency[mostCommon[i + 1]] && mostCommon[i] > mostCommon[i + 1]) {
					tmp = mostCommon[i];
					mostCommon[i] =  mostCommon[i + 1];
					mostCommon[i + 1] = tmp;
				}
			}
		}
		return mostCommon;
	}

	public static boolean isIncrease (short[] frequency, int[] mostCommon) {
		
		for (int i = 0; i < mostCommon.length - 1; i++) {
			if (frequency[mostCommon[i]] < frequency[mostCommon[i + 1]]) {
				return false;
			}

			if (frequency[mostCommon[i]] == frequency[mostCommon[i + 1]] && mostCommon[i] > mostCommon[i + 1]) {
				return false;
			}
		}

		return true;
	}	

	public static void drawGraph(short[] frequency, int[] mostCommon) {
		int[] height = new int[10];

		char[][] graph = new char[12][10];

		height[0] = 10;

		for (int i = 1; i < mostCommon.length; i++) {
			height[i] = (int) (10 * frequency[mostCommon[i]] / frequency[mostCommon[0]]);
		}

		for (int j = 0; j < 10; j++) {
			graph[11][j] = (char) mostCommon[j];
		}

		for (int j = 0; j < 10; j++) {
			for (int i = 10; i > (10 - height[j]); i--) {
				graph[i][j] = '#';
			}
			if (frequency[mostCommon[j]] != 0)
				graph[10 - height[j]][j] = '*';
		}
		
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 10; j++) {
				if (graph[i][j] == '*' && i != 11) {
					System.out.printf("%3d", frequency[mostCommon[j]]);
				}
				else {
					System.out.printf("%3c", graph[i][j]);
				}
			}
			System.out.println();
		}
	}
}