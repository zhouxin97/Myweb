package com.test.Dao;

import java.util.List;

import javax.sql.DataSource;

import com.test.Service.Book;

public interface SearchBookDao {
	 void setDataSource(DataSource dataSource);
	 List<Book> SearchBookMessages(String bookid);
}
