public class User {
	private static Integer id = 0;

	private String name;

	private Integer balance;

	private Integer userId;

	public User (String name, Integer balance) {
		id++;
		this.userId = id;
		this.name = name;
		if (balance >= 0) {
			this.balance = balance;
		}
		else {
			System.err.println("Balance of user " + this.name + " is negative, set to 0");
			this.balance = 0;
		}
	}

	public Integer getUserId() {
		return this.userId;
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