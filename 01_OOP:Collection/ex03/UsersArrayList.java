public class UsersArrayList implements UsersList{
	public static Integer size = 10;

	public static User[] userArray = new User[size];

	public void addUser(User user) {
		if (this.retrieveNumberOfUsers() == size) {
			size = (int) (size * 1.5);
			User[] newUserArray = new User[size];
			for (int i = 0; i < userArray.length; i++) {
				newUserArray[i] = userArray[i];
			}
			newUserArray[userArray.length] = user;
			userArray = newUserArray;
		}
		else {
			for (int i = 0; i < userArray.length; i++) {
				if (userArray[i] == null) {
					userArray[i] = user;
					break;
				}
			}
		}

	}

	public User retrieveUserById(Integer id) {
		for (int i = 0; i < userArray.length; i++) {
			if (userArray[i] != null && userArray[i].getId().equals(id)) {
				return userArray[i];
			}
		}
		throw new UserNotFoundException("User Not Found");
	}

	public User retrieveUserByIndex(Integer index) {
		if (index < userArray.length && userArray[index] != null) {
			return userArray[index];
		}
		throw new UserNotFoundException("User Not Found");
	}

	public Integer retrieveNumberOfUsers() {
		int count = 0;
		for (int i = 0; i < userArray.length; i++) {
			if (userArray[i] != null) {
				count++;
			}
		}
		return count;
	}
}
