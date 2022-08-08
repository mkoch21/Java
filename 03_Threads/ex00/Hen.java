public class Hen extends Thread {

	public Integer count;

	public Hen (int count) {
		this.count = count;
	}

	@Override
	public void run() {
		for (int i = 0; i < this.count; i++) {
			System.out.println("Hen");
			try {
				Thread.sleep((long) (Math.random() * 10));
			} catch (InterruptedException ie) {
				System.err.println("Interrupted Exception");
				System.exit(-1);
			}
		}
	}
	
}
