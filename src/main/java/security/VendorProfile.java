package security;

import model.Vendor;

public class VendorProfile extends Profile {

	private final Vendor vendor;

	public VendorProfile(Vendor vendor) {
		this.vendor = vendor;
	}

	public Vendor getVendor() {
		return vendor;
	}
	
}
