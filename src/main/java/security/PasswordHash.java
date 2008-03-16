package security;

public class PasswordHash {

	private int passwordHash;

	public PasswordHash(String password) {
		passwordHash = password.hashCode();
	}

	public boolean equals(Object o) {
		if (o instanceof PasswordHash) {
			return passwordHash == ((PasswordHash) o).passwordHash;
		}
		return false;
	}
	
	public int hashCode() {
		return passwordHash;
	}
}
