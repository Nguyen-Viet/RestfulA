package model;

public class Airport {

	private String name;
	private String city;
	private boolean active;
	
	public Airport() {
		
	}
	
	public Airport( String name, String city, boolean active ) {
		this.name = name;
		this.city = city;
		this.active = active;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	
}
