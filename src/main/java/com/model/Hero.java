package com.model;

import javax.persistence.*;


@Entity
//@PrimaryKeyJoinColumn(name="id")
@Table(name="hero")
public class Hero extends Model{
	
	@Column(name = "name")
	private String name;
	
	public Hero () {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
