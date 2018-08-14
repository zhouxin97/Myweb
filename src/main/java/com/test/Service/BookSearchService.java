package com.test.Service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.Dao.BookSearchDao;
import com.test.Dao.SearchBookDao;
import com.test.Dao.SearchBookServlet;
import javax.annotation.Resource;
public class BookSearchService implements BookSearchDao{


	public BookSearchService() {
		// TODO 自动生成的构造函数存根
	}
@Resource 
private SearchBookDao searchBookDao;
@Resource 
private SearchBookServlet searchBookServerJDBCTemplate;
	public Book SearchBook(String bookid) {		
		System.out.println("传入后端所要查找书本的BOOKID为:"+bookid);
		List<Book> book = searchBookServerJDBCTemplate.SearchBookMessages(bookid);
		System.out.println("2");
		//String booklist = "";
		Book bookList = new Book();
	     for (Book record : book) {    	 
//	         System.out.print("bookid : " +record.getBookid());
//	         System.out.print(", bookname : " + record.getBookname());
//	         System.out.println(",Author : " + record.getAuthoer());
//	         System.out.println(", publisher : " + record.getPublisher());
//	         System.out.print(",year : " + record.getDate());
//	         System.out.print(", borrow_date : " + record.getBorrow_Date());
//	         System.out.println(", return_date : " + record.getReturn_Date());
//	         System.out.print(",Isbn : " + record.getIsbn());
//	         System.out.print(", status : " + record.getStatus());   
	        String booklist  = "bookid : " + record.getBookid() + ", bookname : " + record.getBookname() + ",Author : " 
	        		 + record.getAuthoer() + ", publisher : " + record.getPublisher() + ",year : " + record.getDate()
	        		 + ", borrow_date : " + record.getBorrow_Date() + ", return_date : " + record.getReturn_Date()
	        		 + ",Isbn : " + record.getIsbn() + ", status : " + record.getStatus();
	    	 bookList.setBookid(record.getBookid());
	    	 bookList.setBookname(record.getBookname());
	    	 bookList.setAuthor(record.getAuthoer());
	    	 bookList.setPublish(record.getPublisher());
	    	 bookList.setDate(record.getDate());
	    	 bookList.setIsbn(record.getIsbn());
	    	 bookList.setBorrow_Date(record.getBorrow_Date());
	    	 bookList.setStatus(record.getStatus());
	    	 bookList.setReturn_Date(record.getReturn_Date());
	    	 System.out.println(booklist);
	    	 
	     }	
	     return bookList;
	   
	}
}
