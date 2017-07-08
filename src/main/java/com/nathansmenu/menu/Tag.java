package com.nathansmenu.menu;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tag {

	@Id
	@GeneratedValue
	private Long id;

	private String tag;
	private String name;

	@ManyToMany(mappedBy = "tags")
	private Set<MenuItem> menuItemTag;

	public Long getId() {
		return id;
	}

	public String getTag() {
		return tag;
	}

	public String getName() {
		return name;
	}

	public Tag(String tag) {
		this.tag = tag;
	}

	public Set<MenuItem> getMenuItemTag() {
		return menuItemTag;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public void setName() {
		this.name = name;
	}

	@Override
	public String toString() {
		return tag;
	}

	public Tag() {
	}

}
