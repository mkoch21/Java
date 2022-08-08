public class Hen extends Thread {
	
	public Integer count;

	public Handling handling; 

	public Hen (int count, Handling handling) {
		this.count = count;
		this.handling = handling;
	}

	@Override
	public void run() {
		for (int i = 0; i < this.count; i++) {
			this.handling.printHen();
		}
	}
}
