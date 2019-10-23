package poo.dao.beans;

import java.util.List;

public class Society {
	long id;
	String name;
	List<Employee> employees;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Employee> getEmployees() {
		return employees;
	}
	
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder
				.append("**********")
				.append(id)
				.append(" : ")
				.append(name)
				.append(" ")
				.append("**********\n");
		employees.forEach((employee -> builder.append(employees).append("\n")));
		return builder.toString();
	}
}
