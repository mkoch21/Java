import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList {
	private Node first = null;

	private Node last = null;

    private int listSize;

    private class Node {
        private Node prev;
        private Transaction transaction;
        private Node next;

        public Node(Node prev, Transaction transaction, Node next) {
            this.prev = prev;
            this.transaction = transaction;
            this.next = next;
        }
    }

	public void addTransaction (Transaction transaction) {
        if (listSize == 0) {
            first = new Node(null, transaction, null);
			last = first;
        } else {
            Node newNode = new Node(last, transaction, null);
			last.next = newNode;
            last = newNode;
		}
        listSize++;
	}

	public void removeTransactionById (UUID id) {

        Integer flag = 0;

        if (listSize == 0) {
            throw new TransactionNotFoundException("Transaction Not Found");
        } else {
            Node tmp = first;

			while (tmp.next != null) {
				if (tmp.transaction.getUUID() == id) { // transaction == null?
					tmp.prev.next = tmp.next;
					tmp.next.prev = tmp.prev;
					tmp.transaction = null;
					tmp.next = null;
					tmp.prev = null;
					listSize--;
                    flag = 1;
				}
				tmp = tmp.next;
			}
            if (flag == 0) {
                throw new TransactionNotFoundException("Transaction Not Found");
            }
        }
	}

	public Transaction[] transformIntoArray () {
        Transaction[] transactions = new Transaction[listSize];

        Node tmp;
        
		if (first == null) {
			return null;
		}

		tmp = first;
        if (tmp.next == null) {
            transactions[0] = tmp.transaction;
        }
        else if (tmp.next != null) {
            for (int i = 0; i < transactions.length; i++) {
                transactions[i] = tmp.transaction;
                tmp = tmp.next;
            }
        }
        return transactions;
	}
}
