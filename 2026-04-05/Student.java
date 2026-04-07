public class Student {
	private int id;
	private String name;
	private float gpa;

	private Object idLock = new Object();
	private Object nameLock = new Object();
	private Object gpaLock = new Object();

	public int getId() {
		synchronized (idLock) {
			return id;
		}
	}

	public String getName() {
		synchronized (nameLock) {
			return name;
		}
	}

	public float getGpa() {
		synchronized (gpaLock) {
			return gpa;
		}
	}

	public void setId(int id) {
		synchronized (idLock) {
			this.id = id;
		}
	}

	public void setName(String name) {
		synchronized (nameLock) {
			this.name = name;
		}
	}

	public void setGpa(float gpa) {
		synchronized (gpaLock) {
			this.gpa = gpa;
		}
	}
}
