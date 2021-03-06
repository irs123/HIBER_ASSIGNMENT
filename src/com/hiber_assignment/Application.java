package com.hiber_assignment;

import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Application {
	
			/*-----Here session is created so that it can be accessible by all method ----*/
				Configuration conf = new Configuration().configure().addAnnotatedClass(Book.class).addAnnotatedClass(Author.class);
		  		SessionFactory sf = conf.buildSessionFactory();
		  		Session ss = sf.openSession();
		  		Transaction t =	ss.beginTransaction();
		  	
	   /*------ create method---*/		
			public void create() throws Exception {
				
					Author author = new Author();
					Author author1 = new Author();
					
					Book book = new Book();
					
					author.setAuthor_id(119);
				   	author.setAuthor_name("JAMES");
				   	
				 	book.setBook_id(116);
					book.setBook_name("JAVAA");
					book.setBook_price(760);
					
					AuthorAddress auth_add = new AuthorAddress();
					auth_add.setAuthor_id(112);
					auth_add.setAuthor_address("34c lajpat IV");
					auth_add.setAuthor(author);

					       
					ss.save(book);
					ss.save(author);  
					
					ss.save(auth_add);
				 			
					t.commit();
					ss.close();
					
								
			}
				   
			 /*------ update method---*/		
				public void update() {
						try{
						Book book= (Book) ss.get(Book.class,115); //here 102 is the Primary Key of the Entity which we want to delete
						book.setBook_name("JAVA");
					
						ss.update(book);
						ss.save(book);
						t.commit();
						ss.close();
						}
						catch(Exception e) {
						}
				
				}
			
			
			/*------ delete method---*/		
				public void delete() {
					
					try{
					Book book = (Book)ss.get(Book.class, 115); //here 102 is the Primary Key of the Entity which we want to delete
					ss.delete(book);
					ss.save(book);
					ss.close();
					t.commit();
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
						
						
				}
   
//	main method starts here		
			public static void main(String args[]) throws Exception {
					Application obj = new Application();
				
					System.out.println("Please enter you choice");
					System.out.println("1.Create");
					System.out.println("2.update");
					System.out.println("3.Delete");
					
					Scanner sc = new Scanner(System.in);
					int i = sc.nextInt();
					
					switch(i)
					{  case 1 : obj.create();
									break;
					
					   case 2 : obj.update();
					   				break;	
					
					   case 3 : obj.delete();
					   				break;
					   
					   default :System.out.println("Enter correct choice");
						   
					}
					
					
				
					System.out.println("COMPLETED");
	
	  }
}
