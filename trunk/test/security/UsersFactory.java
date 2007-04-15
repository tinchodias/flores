package security;

public class UsersFactory {

	public static Users makeSimpleUsers() {
		Users users = new Users();
		users.add(UserFactory.makeAdminUser());
		users.add(UserFactory.makeVendorUser());
		return users;
	}
}
