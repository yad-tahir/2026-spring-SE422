public class Student {

	private String firstName;
	private int fnLength;
	private Object fnLock = new Object();

	private String lastName;
	private int lnLength;
	private Object lnLock = new Object();

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String name) {
		synchronized (fnLock) {
			this.firstName = name;
			this.fnLength = this.firstName.length();
		}
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String name) {
		synchronized (lnLock) {
			this.lastName = name;
			this.lnLength = this.lastName.length();
		}
	}

}
