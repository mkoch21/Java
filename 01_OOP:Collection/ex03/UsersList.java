public interface UsersList {
	public void addUser(User user);

	public User retrieveUserById(Integer id);

	public User retrieveUserByIndex(Integer index);

	public Integer retrieveNumberOfUsers();

}
