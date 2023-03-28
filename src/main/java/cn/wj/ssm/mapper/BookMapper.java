package cn.wj.ssm.mapper;

import cn.wj.ssm.pojo.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: wangjing
 * @Date: 2022/10/31 17:18
 * @Desc:
 */
@Repository
public interface BookMapper {

    /**
     * 查询所有book
     * @return
     */
    public List<Book> FindAllBooks();

}
