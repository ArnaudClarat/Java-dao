package poo.dao.beans;

public class Language {
	private long id;
	private String name;
	
	public Language(String name) {
		this.name = name;
	}
	
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
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		
		Language language = (Language) o;
		
		return id == language.id;
	}
	
	@Override
	public int hashCode() {
		return (int) (id ^ (id >>> 32));
	}
	
	@Override
	public String toString() {
		return id + " : " + name;
	}
}
