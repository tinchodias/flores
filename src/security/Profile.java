package security;

public class Profile {

	private enum ProfileType {
		Admin, Vendor
	}

	private static Profile adminProfile;
	private static Profile vendorProfile;
	
	private Profile(ProfileType admin) {
	}

	public static Profile adminProfile() {
		if (adminProfile == null) {
			adminProfile = new Profile(ProfileType.Admin);
		}
		return adminProfile;
	}

	public static Profile vendorProfile() {
		if (vendorProfile == null) {
			vendorProfile = new Profile(ProfileType.Vendor);
		}
		return vendorProfile;
	}
}
