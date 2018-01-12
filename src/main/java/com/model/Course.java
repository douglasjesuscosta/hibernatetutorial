package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.FetchMode; 

@Entity
@Table(name="course")
public class Course extends Model{
	
	@Column(name = "name")
	private String name;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_category",
	 insertable=true, updatable=true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Category category;
	
	@Column(name = "money_back")
	private boolean moneyBack;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category cat) {
		this.category = cat;
	}

	public boolean isMoneyBack() {
		return moneyBack;
	}

	public void setMoneyBack(boolean moneyBack) {
		this.moneyBack = moneyBack;
	}
	
	
}
