package security;

import junit.framework.TestCase;

public class UsersTest extends TestCase {

	private Users users;

	public void setUp() throws Exception {
		users = UsersFixture.simpleUsers();
	}

	public void tearDown() throws Exception {
	}

	public void testAdminLogin() {
		checkValidLogin(UserFixture.adminUserName(), UserFixture.adminPassword());
	}
	
	public void testInvalidLoginAfterRemove() {
		User vendorUser = users.get(UserFixture.vendorUserName());
		users.remove(vendorUser);
		checkInvalidLogin(UserFixture.vendorUserName(), UserFixture.vendorPassword());
	}
	
	public void testVendorLogin() {
		checkValidLogin(UserFixture.vendorUserName(), UserFixture.vendorPassword());
	}
	
	public void testInvalidNameLogin() {
		checkInvalidLogin(UserFixture.adminUserName() + "Invalid", UserFixture.adminPassword());
	}

	public void testInvalidPasswordLogin() {
		checkInvalidLogin(UserFixture.adminUserName(), UserFixture.adminPassword() + "0");
	}

	private void checkValidLogin(String name, String password) {
		assertTrue(users.isValid(name, password));
		
		User adminUser = users.get(name);
		assertNotNull(adminUser);
		assertEquals(name, adminUser.getName());
	}
	
	private void checkInvalidLogin(String name, String password) {
		assertFalse(users.isValid(name, password));
	}

}
