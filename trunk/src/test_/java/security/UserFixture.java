package security;

import model.Vendor;

public class UserFixture {

	public static User makeAdminUser() {
		return new User(adminUserName(), new PasswordHash(adminPassword()), new VendorProfile(new Vendor("AdminVendor")));
	}

	public static User makeVendorUser() {
		return new User(vendorUserName(), new PasswordHash(vendorPassword()), new VendorProfile(new Vendor("Vendor")));
	}

	public static String adminUserName() {
		return "admin";
	}

	public static String adminPassword() {
		return "123";
	}

	public static String vendorUserName() {
		return "vendor";
	}

	public static String vendorPassword() {
		return "147";
	}
	
}
