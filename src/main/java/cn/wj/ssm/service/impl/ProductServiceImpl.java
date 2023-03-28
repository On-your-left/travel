package cn.wj.ssm.service.impl;

import cn.wj.ssm.mapper.ProductMapper;
import cn.wj.ssm.pojo.Product;
import cn.wj.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: wangjing
 * @Date: 2022/10/31 19:44
 * @Desc:
 */
@Service
public class ProductServiceImpl implements ProductService {

    //注入Mapper层
    @Autowired
    private ProductMapper productMapper;


    /**
     * 查询所有产品
     * @return
     */
    @Override
    public List<Product> findAll() {
        return this.productMapper.findAll();
    }

    /**
     * 新增产品
     * @param product
     */
    @Override
    public void save(Product product) {
        this.productMapper.save(product);
    }

    /**
     * 指定删除
     * @param id
     */
    @Override
    public void deleteById(Integer id) {

        //删除时,把产品在订单表中的外键设置为null
        this.productMapper.updateById(id);

        this.productMapper.deleteById(id);
    }


    /**
     * 修改前数据回写
     * @param id
     * @return
     */
    @Override
    public Product editById(Integer id) {
        return this.productMapper.editById(id);
    }


    /**
     * 修改
     * @param product
     */
    @Override
    public void edit(Product product) {
        this.productMapper.edit(product);
    }


}
