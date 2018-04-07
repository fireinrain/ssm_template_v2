package com.sunrise.dao;

import com.sunrise.entity.Appointment;
import org.apache.ibatis.annotations.Param;

public interface AppointmentDao {
    /**
     * 插入预约记录
     * @param bookId
     * @param studenId
     * @return 插入点行数
     */
    int insertAppointRecord(@Param("bookId") long bookId,@Param("studentId") Long studenId);

    /**
     * 通过主键查询预约图书记录，并且携带图书实体
     *
     * @param bookId
     * @param studentId
     * @return
     */
    Appointment queryByKeyWithBook(@Param("bookId") long bookId, @Param("studentId") long studentId);
}
