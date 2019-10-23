package poo.dao.beans;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Set;

public class Employee {
	private long id;
	private String firstName;
	private String lastName;
	private LocalDate birthDate;
	private Set<Language> languages;
	
	public Set<Language> getLanguages() {
		return languages;
	}
	
	public void setLanguages(Set<Language> languages) {
		this.languages = languages;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public LocalDate getBirthDate() {
		return birthDate;
	}
	
/*
	public Date getBithDate() {
		return Date.from()
	}
*/
	
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
}
