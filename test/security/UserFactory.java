package security;

public class UserFactory {

	public static User makeAdminUser() {
		return new User(adminUserName(), new PasswordHash(adminPassword()), Profile.adminProfile());
	}

	public static User makeVendorUser() {
		return new User(vendorUserName(), new PasswordHash(vendorPassword()), Profile.vendorProfile());
	}

	public static String adminUserName() {
		return "admin";
	}

	public static String adminPassword() {
		return "123456";
	}

	public static String vendorUserName() {
		return "vendor";
	}

	public static String vendorPassword() {
		return "147147";
	}
	
}
