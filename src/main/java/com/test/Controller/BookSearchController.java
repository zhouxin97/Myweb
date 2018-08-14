package com.test.Controller;

import java.io.IOException;


import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.test.Dao.BookSearchDao;

import com.test.Service.Book;



@Controller
public class BookSearchController {
		
	@RequestMapping(value = "/Book_Show")
	public ModelAndView Book () {
		System.out.println("3");
		return new ModelAndView("Book_Show","command",new Book());
	}
	@Resource
	private BookSearchDao bookSearchService;
	@RequestMapping(value="/BookSearch")
	@ResponseBody
	public Book SearchBook(HttpServletRequest request,HttpServletResponse response) throws IOException {
		Book book = bookSearchService.SearchBook(request.getParameter("bookid"));		
		return book;
	}
	@RequestMapping(value="/ReturnBook")
	public void ReturnBook() {
		
	}
}
