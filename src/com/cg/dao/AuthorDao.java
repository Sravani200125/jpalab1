package com.cg.dao;

import com.cg.pojo.Author;
public interface AuthorDao {
	public String saveEmployee(Author au);
	public String deleteEmployee(int id);
	public Author findAuthor(int id);

}
