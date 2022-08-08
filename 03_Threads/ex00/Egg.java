public class Egg extends Thread {

	public Integer count;

	public Egg (int count) {
		this.count = count;
	}

	@Override
	public void run() {
		for (int i = 0; i < this.count; i++) {
			System.out.println("Egg");
			try {
				Thread.sleep((long) (Math.random() * 10));
			} catch (InterruptedException ie) {
				System.err.println("Interrupted Exception");
				System.exit(-1);
			}
		}
	}
	
}
