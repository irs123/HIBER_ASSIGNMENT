package com.hiber_assignment;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hiber_assignment.Author;
import com.hiber_assignment.Book;

public class Application {
	   public static void main(String args[]) throws Exception{
		
		   	  Configuration conf = new Configuration().configure().addAnnotatedClass(Book.class).addAnnotatedClass(Author.class);
		   	  SessionFactory sf = conf.buildSessionFactory();
		   	  Session ss = sf.openSession();
		   	  Transaction t =	ss.beginTransaction();
		
		   	  Scanner sc = new Scanner(System.in);
		   	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		   	  int batchsize = 5;
		  
		   	  System.out.println("Enter the no of entities which you want to enter");
		   	  int n = sc.nextInt();
		   	  

		   System.out.println("\nENTER THE DETAILS OF AUTHOR \n\n");
		   	for(int i=0;i<n;i++) {
			   	Author author = new Author();

		   		System.out.println("enter author id");
		   		int a_id = sc.nextInt();
		 			   
		 	      	   
		   		System.out.println("enter author name");
		   		String a_name = br.readLine();
		   		
		   		author.setAuthor_id(a_id);
		   		author.setAuthor_name(a_name);
		   		
		   		ss.save(author);

		   		if(i>0 && i% batchsize == 0) {  
		   			ss.flush();
		   			ss.clear();
		 	    }
		 	       }
		
		   System.out.println("Enter the details of  book");
		   for(int i=0;i<n;i++)
		   {
		   		Book book = new Book();

		 		System.out.println("enter book id");
		 	    int b_id = sc.nextInt();
		 	       
		 	    System.out.println("enter book name");
		 	    String b_name = br.readLine();    
		 	      
		 	    System.out.println("enter book price");
		 	    int b_price = sc.nextInt();
		 	       
		 	    book.setBook_id(b_id);
		 	    book.setBook_name(b_name);
		 	    book.setBook_price(b_price);
		 	       
		 	    ss.save(book);
		 	       
		 	    if(i>0 && i% batchsize == 0) { 
		 	    	ss.flush();
		 	    	ss.clear();
		       	 }
		 	       	      
		 	  }
		 			
		    	  t.commit();
			      ss.close();
			      sc.close();
			      
			      System.out.println("COMPLETED");
	
		}
	

	
}

