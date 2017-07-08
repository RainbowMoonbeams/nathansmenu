package com.nathansmenu.menu;

import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends CrudRepository<Tag, Long> {

	Tag findByName(String name);

	Tag findByNameContains(String substring);

}
