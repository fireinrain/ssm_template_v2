package com.sunrise.dao;

import com.sunrise.entity.Book;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

public class BookDaoTest extends BaseTest{
    @Resource
    private BookDao bookDao;

    @Test
    public void queryById() {
        Long id = 1000L;
        Book book = bookDao.queryById(id);
        Assert.assertNotNull(book);
    }

    @Test
    public void queryAll() {
        List<Book> books = bookDao.queryAll(0, 100);
        Assert.assertEquals(4,books.size());

    }

    @Test
    public void reduceNumber() {
        Long bookId = 1000L;
        int i = this.bookDao.reduceNumber(bookId);
        Assert.assertEquals(1,i);
    }
}