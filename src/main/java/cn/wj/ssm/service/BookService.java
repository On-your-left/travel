package cn.wj.ssm.service;

import cn.wj.ssm.pojo.Book;

import java.util.List;

/**
 * @Auther: wangjing
 * @Date: 2022/10/31 17:35
 * @Desc:
 */
public interface BookService {
    /**
     * 查询所有book
     * @return
     */
    public List<Book> FindAllBooks();
}
