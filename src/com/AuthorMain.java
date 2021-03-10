package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AuthorMain {
	
	

	public static void main(String[] args) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("day3");
		EntityManager em=factory.createEntityManager();
		EntityTransaction tx=em.getTransaction();
		Scanner sc=new Scanner(System.in);
		System.out.println("=====================================================");
		System.out.println("Enter 1:To get List of All the Books Available");
		System.out.println("Enter 2:To get books witten by an author in DataBase");
		System.out.println("Enter 3:To obtain books whose price>=500 and <=1000");
		System.out.println("Enter 4:To display author by book id");
		System.out.println("=====================================================");
		int c=sc.nextInt();
		
		
		//tx.begin();
		
		/*
		 * Author au=new Author(103,"Harry"); List<Book> b=new ArrayList<Book>();
		 * b.add(new Book(206,"Motivation",1200,au)); b.add(new
		 * Book(207,"Education",600,au)); b.add(new
		 * Book(208,"Moral Values and Ethics",800,au)); au.setBook(b); em.persist(au);
		 */
		
		//tx.commit();
		
		switch(c) {
		case 1:
		     Query q=em.createQuery("select b.title from Book b");
		     List<String> books=q.getResultList();
		     System.out.println("=================List of Books================");
		     System.out.println(books);
		     System.out.println("=================List of Books================");
		     break;
		     
		case 2:
		     System.out.println("Enter the name of the Author to dispay books written by him..");
		     String authName=sc.next();
		     Query qu=em.createQuery("select a.id from Author a where name=?1");
		     qu.setParameter(1,authName);
		     int i=(int) qu.getSingleResult();
		     Query Q=em.createQuery("select b.title from Book b where authorID=:n");
	         Q.setParameter("n",i);
	         List<String> booksByAuth=Q.getResultList();
	         System.out.println("===========Books by"+"\t"+authName+"============");
	         System.out.println(booksByAuth);
	         System.out.println("===========Books by"+"\t"+authName+"============");
	         break;
	         
		case 3:
			 Query que=em.createQuery("select b.title from Book b where b.price between 500 and 1000");
			 List<String> re=que.getResultList();
			 System.out.println("==========List of books whose price is between 500 and 1000=========");
			 System.out.println(re);
			 System.out.println("==========List of books whose price is between 500 and 1000=========");
			 break;
			 
		case 4:
			 System.out.println("Enter the id of book to display author");
			 int auid=sc.nextInt();
			 
			 Query Qu=em.createQuery("select b from Book b where isbn=?1");
			 Qu.setParameter(1,auid);
			 Book a=(Book) Qu.getSingleResult();
			 String s=a.getAuthor().getName();
			 System.out.println("=====================================================================");
			 System.out.println("Name of the Author with BookId"+"\t"+auid+"\t"+"is"+"\t"+s);
			 System.out.println("=====================================================================");
		}
	}

}
