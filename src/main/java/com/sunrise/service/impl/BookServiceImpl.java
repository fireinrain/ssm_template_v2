package com.sunrise.service.impl;

import com.sunrise.dao.AppointmentDao;
import com.sunrise.dao.BookDao;
import com.sunrise.dto.AppointmentDto;
import com.sunrise.entity.Appointment;
import com.sunrise.entity.Book;
import com.sunrise.enums.AppointmentStateEnum;
import com.sunrise.exception.AppointException;
import com.sunrise.exception.NoStockException;
import com.sunrise.exception.ReAppointException;
import com.sunrise.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("bookService")
public class BookServiceImpl implements BookService {
    //日志
    Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
    @Resource
    private BookDao bookDao;

    @Resource
    private AppointmentDao appointmentDao;

    public Book getById(Long bookId) {
        return bookDao.queryById(bookId);
    }

    public List<Book> getAllBooks() {
        return bookDao.queryAll(0,Integer.MAX_VALUE);
    }

    @Transactional
    public AppointmentDto makeAppoint(long bookId, Long studentId) {
        try{
            Book book = bookDao.queryById(bookId);
            if (book.getNumber()<=0){
                //return new AppointmentDto(bookId,AppointmentStateEnum.NO_NUMBER); //错误写法
                throw new NoStockException("no stock");
            }else{
                Appointment appointment = appointmentDao.queryByKeyWithBook(bookId, studentId);
                if (appointment!=null){
                    //return new AppointmentDto(bookId,AppointmentStateEnum.RE_APPOINT); //错误写法
                    throw new ReAppointException("you have appoint this book");

                }else {
                    appointmentDao.insertAppointRecord(bookId,studentId);
                    bookDao.reduceNumber(bookId);
                    //只有成功才返回该对象
                    AppointmentDto appointmentDto = new AppointmentDto(bookId,AppointmentStateEnum.SUCCESS);
                    return appointmentDto;
                }
            }

        }catch (NoStockException e1){
            throw  e1;
        }catch (ReAppointException e2){
            throw  e2;
        }catch (Exception e){
            logger.error(e.getMessage(),e);

            //错误写法
            //return new AppointExecution(bookId, AppointStateEnum.INNER_ERROR);
            throw  new AppointException("appoint inner error"+e.getMessage());
        }


    }
}
