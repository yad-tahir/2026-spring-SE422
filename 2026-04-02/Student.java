public class Student {
	private int id;
	private String name;
	private float gpa;

	// Constructor
	public Student(int id, String name, float gpa) {
		this.id = id;
		this.name = name;
		this.gpa = gpa;
	}

	public Student(Student another) {
		this.id = another.id;
		this.name = another.name;
		this.gpa = another.gpa;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public float getGpa() {
		return gpa;
	}

	public Student setId(int id) {
		Student result = new Student(this);
		result.id = id;
		return result;
	}

	public Student setName(String name) {
		Student result = new Student(this);
		result.name = name;
		return result;
	}

	public Student setGPA(float gpa) {
		Student result = new Student(this);
		result.gpa = gpa;
		return result;
	}
}

// main
Student s1 = new Student(1, "Sara", 3.2f);s1=s1.setGPA(3f).setId(5)
;
