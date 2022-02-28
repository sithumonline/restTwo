package com.example.resttwo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Category", schema = "productDB", catalog = "")
public class Category {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id")
	private int id;
	@Basic
	@Column(name = "name")
	private String name;
	@Basic
	@Column(name = "description")
	private String description;

	public Category(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public Category() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Category that = (Category) o;

		if (id != that.getId()) return false;
		if (name != null ? !name.equals(that.getName()) : that.getName() != null) return false;
		if (description != null ? !description.equals(that.getDescription()) : that.getDescription() != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (description != null ? description.hashCode() : 0);
		return result;
	}
}
