package cn.wj.ssm.service.impl;

import cn.wj.ssm.mapper.BookMapper;
import cn.wj.ssm.pojo.Book;
import cn.wj.ssm.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: wangjing
 * @Date: 2022/10/31 17:35
 * @Desc:
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    /**
     * 查询所有book
     * @return
     */
    @Override
    public List<Book> FindAllBooks() {
        return this.bookMapper.FindAllBooks();
    }
}
