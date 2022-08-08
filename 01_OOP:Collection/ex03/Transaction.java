import java.util.UUID;

public class Transaction {
	private UUID id;

	private User recipient;

	private User sender;

	private enum TransferCategory{
		INCOME, OUTCOME;
	}

	private TransferCategory category;

	private Integer transferAmount;
	
	public Transaction (User recipient, User sender, Integer transferAmount) {
		this.id = UUID.randomUUID();
		this.recipient = recipient;
		this.sender = sender;
		this.transferAmount = transferAmount;

		if (transferAmount > 0) {
			this.category = TransferCategory.INCOME;
		}
		else {
			this.category = TransferCategory.OUTCOME;
		}

		if (transferAmount > 0 && sender.getBalance() < transferAmount) {
			System.err.println("Not enough money");
		}
		else if (transferAmount < 0 && recipient.getBalance() < (-1) * transferAmount) {
			System.err.println("Not enough money");
		}
		else if (this.category == TransferCategory.INCOME) {
			recipient.setBalance(recipient.getBalance() + transferAmount);
		}
		else if (this.category == TransferCategory.OUTCOME) {
			recipient.setBalance(recipient.getBalance() + transferAmount);
		}

	}	

	public UUID getUUID() {
		return this.id;
	}

	public void setUUID (UUID id) {
		this.id = id;
	}

	public User getSender() {
		return this.sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public User getRecipient() {
		return this.recipient;
	}

	public void setRecipient(User recipient) {
		this.recipient = recipient;
	}

	public Integer getTransferAmount() {
		return this.transferAmount;
	}

	public void setTransferAmount (Integer transferAmount) {
		this.transferAmount = transferAmount;
	}

	public TransferCategory getCategory() {
		return this.category;
	}

	public void setCategory(TransferCategory category) {
		this.category = category;
	}

}