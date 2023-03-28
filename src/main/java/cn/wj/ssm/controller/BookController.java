package cn.wj.ssm.controller;

import cn.wj.ssm.pojo.Book;
import cn.wj.ssm.service.BookService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Auther: wangjing
 * @Date: 2022/10/31 17:30
 * @Desc:
 */
@Controller
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * 页面显示
     */
    @RequestMapping("findAllBook2")
    public String findAllBook2(Model model){

        List<Book> list = this.bookService.FindAllBooks();
        model.addAttribute("books",list);

        return "books";

    }



    /**
     * 响应Json
     * @return
     */
    @RequestMapping("findAllBook")
    @ResponseBody
    public List<Book> findAllBook(){
        return this.bookService.FindAllBooks();
    }
}
