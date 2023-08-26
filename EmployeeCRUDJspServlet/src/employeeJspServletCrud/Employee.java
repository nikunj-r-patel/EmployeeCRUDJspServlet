package employeeJspServletCrud;
public class Employee {
	private int id;
	private String name;
	private String skills;
	private int age;
	private long salary;
	private String joinDate;
	Employee(int id, String name, String skills, int age, long salary, String joinDate) {
		super();
		this.id = id;
		this.name = name;
		this.skills = skills;
		this.age = age;
		this.salary = salary;
		this.joinDate = joinDate;
	}
	Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", skills=" + skills + ", age=" + age + ", salary=" + salary
				+ ", joinDate=" + joinDate + "]";
	}
}
