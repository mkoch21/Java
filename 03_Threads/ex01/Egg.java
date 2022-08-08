public class Egg extends Thread {

	public Integer count;
	
	public Handling handling; 

	public Egg (int count, Handling handling) {
		this.count = count;
		this.handling = handling;
	}

	@Override
	public void run() {
		for (int i = 0; i < this.count; i++) {
			this.handling.printEgg();
		}
	}
	
}
