package com.cg.service;

import com.cg.pojo.Author;
import com.cg.dao.AuthorDao;
import com.cg.dao.AuthorDaoImpl;

public class AuthorServiceImpl implements AuthorService {
	
	AuthorDao adao=new AuthorDaoImpl();

	@Override
	public String createAuthor(Author au) {
		return adao.saveEmployee(au);
	}

	@Override
	public String removeAuthor(int id) {
		return adao.deleteEmployee(id);
		
	}

	@Override
	public Author getAuthor(int id) {
		// TODO Auto-generated method stub
		return adao.findAuthor(id);
	}
	

}