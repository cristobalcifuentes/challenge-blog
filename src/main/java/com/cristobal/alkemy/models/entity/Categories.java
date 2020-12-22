package com.cristobal.alkemy.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class Categories {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,  generator = "seq_categories")
	@SequenceGenerator(name = "seq_categories", sequenceName = "seq_categories", allocationSize = 1, initialValue= 5)
	@Column(name = "categories_id")
	private int id;
	
	@Column(name = "categories")
	private String categories;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		return "Categories [id=" + id + ", categories=" + categories + "]";
	}
	
	
	
	

}
