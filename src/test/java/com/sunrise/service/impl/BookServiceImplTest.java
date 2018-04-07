package com.sunrise.service.impl;

import com.sunrise.dao.BaseTest;
import com.sunrise.dto.AppointmentDto;
import com.sunrise.service.BookService;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.junit.Assert.*;

public class BookServiceImplTest extends BaseTest {
    @Autowired
    private BookService bookService;

    @Test
    public void getById() {
    }

    @Test
    public void getAllBooks() {
    }

    @Test
    @Transactional
    @Rollback
    public void makeAppoint() {
        Long bookId = 1002L;
        Long studentId  = 91233L;

        AppointmentDto appointmentDto = bookService.makeAppoint(bookId, studentId);
        Assert.assertNotNull(appointmentDto);
        //System.out.println(appointmentDto);
    }
}