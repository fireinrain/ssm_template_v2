package com.sunrise.dao;

import com.sunrise.entity.Appointment;
import com.sunrise.entity.Book;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Date;

import static org.junit.Assert.*;

public class AppointmentDaoTest extends BaseTest {

    @Resource
    private BookDao bookDao;

    @Resource
    private AppointmentDao appointmentDao;

    @Test
    public void insertAppointRecord() {
        Book book = this.bookDao.queryById(1000L);
        int i = this.appointmentDao.insertAppointRecord(1000L, 92112L);
        Assert.assertNotNull(i);
    }

    @Test
    public void queryByKeyWithBook() {
        Long studenId = 92112L;
        Long bookId = 1000L;
        Appointment appointment = this.appointmentDao.queryByKeyWithBook(bookId, studenId);
        Assert.assertNotNull(appointment);

    }
}