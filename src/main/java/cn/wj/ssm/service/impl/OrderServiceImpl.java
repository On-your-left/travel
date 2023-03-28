package cn.wj.ssm.service.impl;

import cn.wj.ssm.mapper.OrderMapper;
import cn.wj.ssm.pojo.Orders;
import cn.wj.ssm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: wangjing
 * @Date: 2022/11/1 19:06
 * @Desc:
 */
@Service
public class OrderServiceImpl implements OrderService {

    //注入Mapper层
    @Autowired
    private OrderMapper orderMapper;

    /**
     * 查询所有订单
     */
    public List<Orders> findAll() {
        return this.orderMapper.findAll();
    }


    /**
     * 查看详情
     * @param id
     * @return
     */
    @Override
    public Orders findById(Integer id) {
        return this.orderMapper.findById(id);
    }


    /**
     * 添加订单
     * @param orders
     */
    @Override
    public void save(Orders orders) {
        this.orderMapper.save(orders);
    }
}
