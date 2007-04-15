package security;

import junit.framework.TestCase;

public class UsersTest extends TestCase {

	private Users users;

	public void setUp() throws Exception {
		users = UsersFactory.makeSimpleUsers();
	}

	public void tearDown() throws Exception {
	}

	public void testAdminLogin() {
		checkValidLogin(UserFactory.adminUserName(), UserFactory.adminPassword());
	}
	
	public void testInvalidLoginAfterRemove() {
		User vendorUser = users.get(UserFactory.vendorUserName());
		users.remove(vendorUser);
		checkInvalidLogin(UserFactory.vendorUserName(), UserFactory.vendorPassword());
	}
	
	public void testVendorLogin() {
		checkValidLogin(UserFactory.vendorUserName(), UserFactory.vendorPassword());
	}
	
	public void testInvalidNameLogin() {
		checkInvalidLogin(UserFactory.adminUserName() + "Invalid", UserFactory.adminPassword());
	}

	public void testInvalidPasswordLogin() {
		checkInvalidLogin(UserFactory.adminUserName(), UserFactory.adminPassword() + "0");
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
