package cn.wj.ssm.mapper;

import cn.wj.ssm.pojo.Product;

import java.util.List;

/**
 * @Auther: wangjing
 * @Date: 2022/10/31 19:46
 * @Desc:
 */
public interface ProductMapper {

    /**
     * 查询所有产品
     * @return
     */
    List<Product> findAll();

    /**
     * 新增产品
     */
    void save(Product product);


    /**
     * 指定删除
     * @param id
     */
    void deleteById(Integer id);
    /**
     * 删除时,把产品在订单表中的外键设置为null
     * @param id
     */
    void updateById(Integer id);


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
