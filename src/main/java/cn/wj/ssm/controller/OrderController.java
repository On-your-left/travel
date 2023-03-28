package cn.wj.ssm.controller;

import cn.wj.ssm.pojo.Member;
import cn.wj.ssm.pojo.Orders;
import cn.wj.ssm.pojo.Product;
import cn.wj.ssm.service.MemberService;
import cn.wj.ssm.service.OrderService;
import cn.wj.ssm.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Auther: wangjing
 * @Date: 2022/11/1 18:55
 * @Desc:
 */
@RequestMapping("order")
@Controller
public class OrderController {

    //注入Service层
    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Autowired
    private MemberService memberService;

    /**
     * 添加订单
     */
    @RequestMapping("save")
    public String save(Orders orders){
        this.orderService.save(orders);
        return "redirect:findAll.do";
    }


    /**
     * 新增订单前查询所有产品和管理员
     */
    @RequestMapping("add")
    public ModelAndView add(){
        //查询所有产品
        List<Product> productList = this.productService.findAll();

        //查询所有管理员
        List<Member> memberList =  this.memberService.findAll();

        ModelAndView mv = new ModelAndView("order-add");
        mv.addObject("productList",productList);
        mv.addObject("memberList",memberList);

        return mv;
    }



    /**
     * 查看详情
     */
    @RequestMapping("findById")
    public ModelAndView findById(@RequestParam("id") Integer id){
        Orders orders =  this.orderService.findById(id);

        ModelAndView mv = new ModelAndView("order-show");

        mv.addObject("order",orders);
        return mv;
    }


    /**
     * 查询所有订单
     */
    @RequestMapping("findAll")
    public ModelAndView findAll(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                @RequestParam(value = "size",defaultValue = "5") Integer size){

        PageHelper.startPage(page,size);
        List<Orders> list =  this.orderService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        ModelAndView mv = new ModelAndView("order-list");

        mv.addObject("pageInfo",pageInfo);
        return mv;
    }
}
