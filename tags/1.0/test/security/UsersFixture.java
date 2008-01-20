package security;

public class UsersFixture {

	public static Users simpleUsers() {
		Users users = new Users();
		users.add(UserFixture.makeAdminUser());
		users.add(UserFixture.makeVendorUser());
		return users;
	}
}
