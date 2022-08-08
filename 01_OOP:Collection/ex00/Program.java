public class Program {
	public static void main(String[] args) {
		User John = new User("John", 100);
		User Alex = new User("Alex", 200);
		User Tom = new User("Tom", 300);

		System.out.println("John.getUserId() = " + John.getUserId());
		System.out.println("John.getName() = " + John.getName());
		System.out.println("John.getBalance() = " + John.getBalance());
		System.out.println();

		System.out.println("Alex.getUserId() = " + Alex.getUserId());
		System.out.println("Alex.getName() = " + Alex.getName());
		System.out.println("Alex.getBalance() = " + Alex.getBalance());
		System.out.println();

		System.out.println("Tom.getUserId() = " + Tom.getUserId());
		System.out.println("Tom.getName() = " + Tom.getName());
		System.out.println("Tom.getBalance() = " + Tom.getBalance());
		System.out.println();

		Transaction transaction1 = new Transaction(John, Alex, 100);
		Transaction transaction2 = new Transaction(Alex, John, -100);
		
		System.out.println("transaction1.getUUID() = " + transaction1.getUUID());
		System.out.println("transaction1.getRecipient() = " + transaction1.getRecipient().getName());
		System.out.println("transaction1.getSender() = " + transaction1.getSender().getName());
		System.out.println("transaction1.getTransferAmount() = " + transaction1.getTransferAmount());
		System.out.println("transaction1.getCategory() = " + transaction1.getCategory());
		System.out.println();

		System.out.println("transaction2.getUUID() = " + transaction2.getUUID());
		System.out.println("transaction2.getRecipient() = " + transaction2.getRecipient().getName());
		System.out.println("transaction2.getSender() = " + transaction2.getSender().getName());
		System.out.println("transaction2.getTransferAmount() = " + transaction2.getTransferAmount());
		System.out.println("transaction2.getCategory() = " + transaction2.getCategory());
		System.out.println();

		System.out.println("John.getUserId() = " + John.getUserId());
		System.out.println("John.getName() = " + John.getName());
		System.out.println("John.getBalance() = " + John.getBalance());
		System.out.println();

		System.out.println("Alex.getUserId() = " + Alex.getUserId());
		System.out.println("Alex.getName() = " + Alex.getName());
		System.out.println("Alex.getBalance() = " + Alex.getBalance());
		System.out.println();

		System.out.println("Tom.getUserId() = " + Tom.getUserId());
		System.out.println("Tom.getName() = " + Tom.getName());
		System.out.println("Tom.getBalance() = " + Tom.getBalance());
		System.out.println();

		Transaction transaction3 = new Transaction(Alex, Tom, 200);
		Transaction transaction4 = new Transaction(Tom, Alex, -200);

		System.out.println("transaction3.getUUID() = " + transaction3.getUUID());
		System.out.println("transaction3.getRecipient() = " + transaction3.getRecipient().getName());
		System.out.println("transaction3.getSender() = " + transaction3.getSender().getName());
		System.out.println("transaction3.getTransferAmount() = " + transaction3.getTransferAmount());
		System.out.println("transaction3.getCategory() = " + transaction3.getCategory());
		System.out.println();

		System.out.println("transaction4.getUUID() = " + transaction4.getUUID());
		System.out.println("transaction4.getRecipient() = " + transaction4.getRecipient().getName());
		System.out.println("transaction4.getSender() = " + transaction4.getSender().getName());
		System.out.println("transaction4.getTransferAmount() = " + transaction4.getTransferAmount());
		System.out.println("transaction4.getCategory() = " + transaction4.getCategory());
		System.out.println();

		System.out.println("John.getUserId() = " + John.getUserId());
		System.out.println("John.getName() = " + John.getName());
		System.out.println("John.getBalance() = " + John.getBalance());
		System.out.println();

		System.out.println("Alex.getUserId() = " + Alex.getUserId());
		System.out.println("Alex.getName() = " + Alex.getName());
		System.out.println("Alex.getBalance() = " + Alex.getBalance());
		System.out.println();
		
		System.out.println("Tom.getUserId() = " + Tom.getUserId());
		System.out.println("Tom.getName() = " + Tom.getName());
		System.out.println("Tom.getBalance() = " + Tom.getBalance());
	}
}