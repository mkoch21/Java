public class User {
	private String name;

	private Integer balance;

	private Integer id;
	
	private TransactionsLinkedList transactions;

	public User (String name, Integer balance) {
		this.id = UserIdsGenerator.getInstance().generateId();
		this.name = name;
		if (balance >= 0) {
			this.balance = balance;
		}
		else {
			System.err.println("Balance of user " + this.name + " is negative, set to 0");
			this.balance = 0;
		}
		this.transactions = new TransactionsLinkedList();
	}

    public TransactionsLinkedList getTransactionList() {
        return this.transactions;
    }

    public void addTransaction(Transaction transaction) {
        transactions.addTransaction(transaction);
    }

    public Transaction[] getTransactionsArray() {
		return transactions.transformIntoArray();
    }

	public Integer getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBalance() {
		return this.balance;
	}

	public void setBalance (Integer balance) {
		if (balance >= 0) {
			this.balance = balance;
		}
		else {
			System.err.println("Balance of user " + this.name + " is negative, set to 0");
			this.balance = 0;
		}
	}



}