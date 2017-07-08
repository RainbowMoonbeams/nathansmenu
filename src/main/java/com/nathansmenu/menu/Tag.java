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
	
	private String tagWord;
	
	@ManyToMany(mappedBy = "tagSet")
	private Set<MenuItem> menuItemTag;

	public Long getId() {
		return id;
	}

	public String getTagWord() {
		return tagWord;
	}
	
	public Tag(String tagSet) {
	}
	
	public Set<MenuItem> getMenuItemTag() {
		return menuItemTag;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTagWord(String tagWord) {
		this.tagWord = tagWord;
	}

	@Override
	public String toString() {
		return tagWord;
	}

	public Tag(Long id, String tagWord) {
		this.tagWord = tagWord;
	}

	public Tag() {
	}

	
}
