public class Handling {
	public static boolean isEgg = true;

	public synchronized void printEgg() {
        if (!isEgg) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Egg");
        isEgg = !isEgg;
        notify();
    }

	public synchronized void printHen() {
        if (isEgg) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Hen");
        isEgg = !isEgg;
        notify();
    }
}
