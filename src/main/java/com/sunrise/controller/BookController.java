package com.sunrise.controller;


import com.sunrise.dto.AppointmentDto;
import com.sunrise.dto.ResultBean;
import com.sunrise.entity.Book;
import com.sunrise.enums.AppointmentStateEnum;
import com.sunrise.exception.NoStockException;
import com.sunrise.exception.ReAppointException;
import com.sunrise.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RestController  若开启，这代表所有返回的都是json格式的数据
@RequestMapping("/book")  // url:/模块/资源/{id}/细分 /seckill/list
public class BookController {
    @Autowired
    private BookService bookService;


    /**
     * 传统模式 即后端渲染模式
     *
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getAllBooks(Model model) {
        List<Book> allBooks = bookService.getAllBooks();
        model.addAttribute("books", allBooks);
        return "listbooks"; //it will find /WEB-INF/jsp/list.jsp and you can get and write you data in list.jsp
        //return new ResultBean<List<Book>>(true,allBooks);

    }

    /**
     * restful 风格 前后端分离模式 返回json格式数据
     *
     * @param bookId
     * @param model
     * @return
     */
    @RequestMapping(value = "/{bookId}/detail", method = RequestMethod.GET)
    @ResponseBody //该注解可以是返回的对象序列化为json格式
    public ResultBean<Book> getBookById(@PathVariable("bookId") Long bookId, Model model) {
        Book book = bookService.getById(bookId);
        return new ResultBean<Book>(true, book);
    }

    /**
     * 预约
     * @param bookId
     * @param studentId
     * @return
     */
    @RequestMapping(value = "/{bookId}/appoint", method = RequestMethod.POST, produces = {
            "application/json; charset=utf-8"})
    @ResponseBody
    private ResultBean<AppointmentDto> appoint(@PathVariable("bookId") Long bookId, @RequestParam("studentId") Long studentId) {
        if (studentId == null || studentId.equals("")) {
            return new ResultBean<>(false, "学号不能为空");
        }
        //AppointmentDto execution = bookService.appoint(bookId, studentId);//错误写法，不能统一返回，要处理异常（失败）情况
        AppointmentDto appointmentDto = null;
        try {
            appointmentDto = bookService.makeAppoint(bookId, studentId);
        } catch (NoStockException e1) {
            appointmentDto = new AppointmentDto(bookId, AppointmentStateEnum.NO_NUMBER);
        } catch (ReAppointException e2) {
            appointmentDto = new AppointmentDto(bookId, AppointmentStateEnum.RE_APPOINT);
        } catch (Exception e) {
            appointmentDto = new AppointmentDto(bookId, AppointmentStateEnum.SYSTEM_ERROR);
        }
        return new ResultBean<AppointmentDto>(true, appointmentDto);
    }
/**
 *
 *  @RequestMapping(value = "/list", method = RequestMethod.GET)
 *     private String list(Model model) {
 *         List<Book> list = bookService.getList();
 *         model.addAttribute("list", list);
 *         // list.jsp + model = ModelAndView
 *         return "list";// WEB-INF/jsp/"list".jsp
 *     }
 *
 *     @RequestMapping(value = "/{bookId}/detail", method = RequestMethod.GET)
 *     private String detail(@PathVariable("bookId") Long bookId, Model model) {
 *         if (bookId == null) {
 *             return "redirect:/book/list";
 *         }
 *         Book book = bookService.getById(bookId);
 *         if (book == null) {
 *             return "forward:/book/list";
 *         }
 *         model.addAttribute("book", book);
 *         return "detail";
 *     }
 *
 *     //ajax json
 *     @RequestMapping(value = "/{bookId}/appoint", method = RequestMethod.POST, produces = {
 *             "application/json; charset=utf-8" })
 *     @ResponseBody
 *     private Result<AppointmentDto> appoint(@PathVariable("bookId") Long bookId, @RequestParam("studentId") Long studentId) {
 *         if (studentId == null || studentId.equals("")) {
 *             return new Result<>(false, "学号不能为空");
 *         }
 *         //AppointmentDto execution = bookService.appoint(bookId, studentId);//错误写法，不能统一返回，要处理异常（失败）情况
 *         AppointmentDto execution = null;
 *         try {
 *             execution = bookService.appoint(bookId, studentId);
 *         } catch (NoNumberException e1) {
 *             execution = new AppointmentDto(bookId, AppointmentStateEnum.NO_NUMBER);
 *         } catch (RepeatAppointException e2) {
 *             execution = new AppointmentDto(bookId, AppointmentStateEnum.REPEAT_APPOINT);
 *         } catch (Exception e) {
 *             execution = new AppointmentDto(bookId, AppointmentStateEnum.INNER_ERROR);
 *         }
 *         return new Result<AppointmentDto>(true, execution);
 *     }
 *
 *
 * */


}
