package security;

public class UsersFixture {

	public static Users simpleUsers() {
		Users users = new Users();
		users.add(UserFactory.makeAdminUser());
		users.add(UserFactory.makeVendorUser());
		return users;
	}
}
