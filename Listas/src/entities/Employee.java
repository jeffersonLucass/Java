package entities;

public class Employee {
	private Integer id;
	private String name;
	private Double salary;
	
	public Employee() {
	}
	
	
	
	public Employee(Integer id, String name, Double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void increaseSalary(double percentage) {
		this.salary += this.salary * percentage / 100.0;
	}

	public String toString() {
		return id + ", " + name + ", " + String.format("%.2f", salary);
	}

}
