package com.sunrise.service;

import com.sunrise.dto.AppointmentDto;
import com.sunrise.entity.Book;

import java.util.List;

/**
 * 图书接口
 */
public interface BookService {
    /**
     * 根据id查询一本书
     * @param bookId
     * @return Book
     */
    Book getById(Long bookId);

    /**
     * 获取所有书籍
     * @return
     */
    List<Book> getAllBooks();

    /**
     * 预约书籍
     * @param bookId
     * @param studentId
     * @return  AppointmentDto
     */
    AppointmentDto makeAppoint(long bookId,Long studentId);
}
