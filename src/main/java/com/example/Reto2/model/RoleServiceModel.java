package com.example.Reto2.model;

public class RoleServiceModel {

    private Integer id;
    private String name;
    
    public RoleServiceModel() {
    	
    }
	public RoleServiceModel(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "RoleServiceModel [id=" + id + ", name=" + name + "]";
	}
}
