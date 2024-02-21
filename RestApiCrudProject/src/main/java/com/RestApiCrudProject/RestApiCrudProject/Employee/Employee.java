package com.RestApiCrudProject.RestApiCrudProject.Employee;

public class Employee {
	private int id;
	private String Name;
	private String Adddress;
	public Employee(int id, String Name, String Adddress) {
		
		this.id = id;
		this.Name = Name;
		this.Adddress = Adddress;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAdddress() {
		return Adddress;
	}

	public void setAdddress(String adddress) {
		Adddress = adddress;
	}
	
	
	
	

}
