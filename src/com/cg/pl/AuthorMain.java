package com.cg.pl;

import com.cg.service.AuthorServiceImpl;

import java.util.Scanner;

import com.cg.pojo.Author;
import com.cg.service.AuthorService;

public class AuthorMain {
	
   public static void main(String[] args) {
	   
	   AuthorService as=new AuthorServiceImpl();
	   Scanner sc=new Scanner(System.in);
	   
	   System.out.println("============================");
	   System.out.println("Enter 1: TO add an author");
	   System.out.println("Enter 2: TO delete an author");
	   System.out.println("Enter 3: TO find an author");
	   System.out.println("============================");
	   
	   int i=sc.nextInt();
	   String repeat="yes";
	   
	  
	   while(repeat.equalsIgnoreCase("yes")) {
	   switch(i) {
	   
	   case 1:
		   String aut=as.createAuthor(new Author("Denise","Robins","George",22776641));
		   System.out.println(aut);
		   break;
	   case 2:
		   System.out.println("Enter the id whose details are to be deleted..");
		   int id=sc.nextInt();
		   String result=as.removeAuthor( id);
		   System.out.println(result);
		   break;
	   case 3:
		   System.out.println("Enter the id whose details are to be displayed..");
		   int aid=sc.nextInt();
		   Author a=as.getAuthor(aid);
		   System.out.println(a.getAuthorId()+"\t"+a.getFirstName()+"\t"+a.getLastName()+"\t"+a.getPhoneNo());
		   break;
	   
	    
		   
	   
	   
	   }
	   
	   System.out.println("Do u want to continue...Yes/No");
	   repeat=sc.next();
		
	   }
	}

}
