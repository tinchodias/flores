package security;

public class User {

	private final String name;
	private PasswordHash passwordHash;
	private Profile profile;

	public User(String name, PasswordHash hash, Profile profile) {
		this.name = name;
		this.passwordHash = hash;
		this.profile = profile;
	}

	public String getName() {
		return name;
	}

	public PasswordHash getPasswordHash() {
		return passwordHash;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setPasswordHash(PasswordHash passwordHash) {
		this.passwordHash = passwordHash;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

}
