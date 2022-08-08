public class UserIdsGenerator {
    private static final UserIdsGenerator userIdsGenerator = new UserIdsGenerator();

	private static int id = 0;

    private UserIdsGenerator() {
    }

    public static UserIdsGenerator getInstance() {
        return userIdsGenerator;
    }

	public static int generateId() {
		return ++id;
	}
}