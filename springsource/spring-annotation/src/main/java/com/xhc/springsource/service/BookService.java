package com.xhc.springsource.service;


import com.xhc.springsource.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class BookService {

    //@Qualifier("bookDao")
    //@Resource(name="bookDao2")
    //@Inject
    //@Autowired(required = false)
    //@Qualifier("bookDao2")
    //@Autowired(required = false)

    @Qualifier("bookDao2")
    @Autowired(required = false)
    private BookDao bookDao;

    public void print() {
        System.out.println(bookDao);
    }

    @Override
    public String toString() {
        return "BookService=[bookDao="+bookDao.toString()+ "]";
    }
}
