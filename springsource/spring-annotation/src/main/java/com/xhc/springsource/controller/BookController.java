package com.xhc.springsource.controller;

import com.xhc.springsource.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;

	@Override
	public String toString() {
		return "bookService =[" + bookService.toString() + "]";
	}

}
