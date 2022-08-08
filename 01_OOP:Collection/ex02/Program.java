public class Program {
	public static void main(String[] args) {
		User John = new User("John", 100);
		User Alex = new User("Alex", 200);
		User Tom = new User("Tom", 300);
		User Mike = new User("Mike", 400);
		// User John1 = new User("John", 100);
		// User Alex1 = new User("Alex", 200);
		// User Tom1 = new User("Tom", 300);
		// User Mike1 = new User("Mike", 400);
		// User John2 = new User("John", 100);
		// User Alex2 = new User("Alex", 200);
		// User Tom2 = new User("Tom", 300);
		// User Mike2 = new User("Mike", 400);

		UsersArrayList userArray = new UsersArrayList();
		userArray.addUser(John);
		userArray.addUser(Alex);
		userArray.addUser(Tom);
		userArray.addUser(Mike);
		// userArray.addUser(John1);
		// userArray.addUser(Alex1);
		// userArray.addUser(Tom1);
		// userArray.addUser(Mike1);
		// userArray.addUser(John2);
		// userArray.addUser(Alex2);
		// userArray.addUser(Tom2);
		// userArray.addUser(Mike2);

		System.out.println("userArray.retrieveNumberOfUsers() = " + userArray.retrieveNumberOfUsers());

		System.out.println("userArray.retrieveUserByIndex(0).getName() = " + userArray.retrieveUserByIndex(0).getName());
		System.out.println("userArray.retrieveUserByIndex(1).getName() = " + userArray.retrieveUserByIndex(1).getName());
		System.out.println("userArray.retrieveUserByIndex(2).getName() = " + userArray.retrieveUserByIndex(2).getName());
		System.out.println("userArray.retrieveUserByIndex(3).getName() = " + userArray.retrieveUserByIndex(3).getName());
		// System.out.println("userArray.retrieveUserByIndex(4).getName() = " + userArray.retrieveUserByIndex(4).getName());
		
		System.out.println("userArray.retrieveUserById(0).getName() = " + userArray.retrieveUserById(1).getName());
		System.out.println("userArray.retrieveUserById(1).getName() = " + userArray.retrieveUserById(2).getName());
		System.out.println("userArray.retrieveUserById(2).getName() = " + userArray.retrieveUserById(3).getName());
		System.out.println("userArray.retrieveUserById(3).getName() = " + userArray.retrieveUserById(4).getName());
		// System.out.println("userArray.retrieveUserById(3).getName() = " + userArray.retrieveUserById(5).getName());
		
	}

}
