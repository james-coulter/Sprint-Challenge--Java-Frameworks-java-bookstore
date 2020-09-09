package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.models.Book;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.Null;

import static org.junit.Assert.*;


public class BookServiceImplTest {

    @Autowired
    private BookService bookService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test(expected = NullPointerException.class)
    public void findBookById() {
        Book book = bookService.findBookById(78);
        assertEquals("Digital Fortess", book.getBooktitle());
    }

    @Test
    public void save() {
    }

    @Test(expected = NullPointerException.class)
    public void findAllBooks() {

        assertEquals(6, bookService.findAllBooks().size());
    }

    @Test
    public void deleteBookById() {
    }
}