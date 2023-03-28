package cn.wj.ssm.service;

import cn.wj.ssm.pojo.Product;

import java.util.List;

/**
 * @Auther: wangjing
 * @Date: 2022/10/31 19:36
 * @Desc:
 */
public interface ProductService {

    /**
     * 查询所有产品
     * @return
     */
    List<Product> findAll();

    /**
     * 新增产品
     * @param product
     */
    void save(Product product);


    /**
     * 指定删除
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 修改前数据回写
     * @param id
     * @return
     */
    Product editById(Integer id);


    /**
     * 修改
     * @param product
     */
    void edit(Product product);
}
