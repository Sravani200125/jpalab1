package com.cg.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.cg.config.JPAConfig;
import com.cg.pojo.Author;

public class AuthorDaoImpl implements AuthorDao {
	EntityManager eManager=JPAConfig.getEntityManager();

	@Override
	public String saveEmployee(Author au) {
		EntityTransaction tx=eManager.getTransaction();
		tx.begin();
		eManager.persist(au);
		tx.commit();
		return "Author saved...";
		
	}

	@Override
	public String deleteEmployee(int id) {
		EntityTransaction tx=eManager.getTransaction();
		tx.begin();
		Author e=eManager.find(Author.class,id);
		if(e==null)
			return "Author with the given id is not available...";
		else {
		    eManager.remove(e);
		    tx.commit();
		    return "Author deleted...";
		}
	}

	@Override
	public Author findAuthor(int id) {
		Author aut=eManager.find(Author.class,id);
		if(aut==null)
			return null;
		else
			return aut;
	}

}
