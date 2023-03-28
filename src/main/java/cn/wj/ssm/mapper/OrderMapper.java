package cn.wj.ssm.mapper;

import cn.wj.ssm.pojo.Orders;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: wangjing
 * @Date: 2022/11/1 19:08
 * @Desc:
 */
@Repository
public interface OrderMapper {




    /**
     * 查询所有订单
     */
    List<Orders> findAll();

    /**
     * 查看详情
     * @param id
     * @return
     */
    Orders findById(Integer id);

    /**
     *  添加订单
     * @param orders
     */
    void save(Orders orders);
}