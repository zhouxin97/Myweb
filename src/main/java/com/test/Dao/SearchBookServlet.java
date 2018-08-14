package com.test.Dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.test.Service.Book;

public class SearchBookServlet implements SearchBookDao {
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	public List<Book> SearchBookMessages(String bookid) {
		String Sql ="select bookid,bookname,author,publisher,year,isbn,borrow_date,return_date,status from book where bookid = '"+bookid+"'";
		List<Book> book = jdbcTemplateObject.query(Sql, new BookMapper());
		System.out.println("1");
		
		return book ;
	}

}
