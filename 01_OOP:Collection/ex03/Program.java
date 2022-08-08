// import java.util.UUID;

public class Program {
	public static void main(String[] args) {

		User John = new User("John", 100);
		User Alex = new User("Alex", 200);
		User Tom = new User("Tom", 300);

		Transaction transaction1 = new Transaction(John, Alex, 100);
		Transaction transaction2 = new Transaction(Alex, John, -100);
		Transaction transaction3 = new Transaction(Alex, Tom, 200);
		Transaction transaction4 = new Transaction(Tom, Alex, -200);

        John.addTransaction(transaction1);
        Alex.addTransaction(transaction2);
        Alex.addTransaction(transaction3);
        Tom.addTransaction(transaction4);
		// Alex.getTransactionList().removeTransactionById(UUID.randomUUID());

		Transaction[] transactions = John.getTransactionsArray();
		for (int i = 0; i < transactions.length; i++) {
			System.out.println(transactions[i].getSender().getName() + "->" + transactions[i].getRecipient().getName() + " " + transactions[i].getTransferAmount());
		}

		//System.out.println(transactions[5].getSender().getName() + "->" + transactions[5].getRecipient().getName() + " " + transactions[5].getTransferAmount());

		transactions = Alex.getTransactionsArray();
		for (int i = 0; i < transactions.length; i++) {
			System.out.println(transactions[i].getSender().getName() + "->" + transactions[i].getRecipient().getName() + " " + transactions[i].getTransferAmount());
		}

		transactions = Tom.getTransactionsArray();
		for (int i = 0; i < transactions.length; i++) {
			System.out.println(transactions[i].getSender().getName() + "->" + transactions[i].getRecipient().getName() + " " + transactions[i].getTransferAmount());
		}
	}

}
