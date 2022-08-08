public class Program {
	public static void main(String[] args) {
		User John = new User("John", 100);
		User Alex = new User("Alex", 200);
		User Tom = new User("Tom", 300);
		User Mike = new User("Mike", 400);
		
		System.out.println("John.getId() = " + John.getId());
		System.out.println("John.getName() = " + John.getName());
		System.out.println("John.getBalance() = " + John.getBalance());
		System.out.println();

		System.out.println("Alex.getId() = " + Alex.getId());
		System.out.println("Alex.getName() = " + Alex.getName());
		System.out.println("Alex.getBalance() = " + Alex.getBalance());
		System.out.println();

		System.out.println("Tom.getId() = " + Tom.getId());
		System.out.println("Tom.getName() = " + Tom.getName());
		System.out.println("Tom.getBalance() = " + Tom.getBalance());
		System.out.println();

		System.out.println("Mike.getId() = " + Mike.getId());
		System.out.println("Mike.getName() = " + Mike.getName());
		System.out.println("Mike.getBalance() = " + Mike.getBalance());
		System.out.println();
	}

}
