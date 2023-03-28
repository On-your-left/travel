package cn.wj.ssm.controller;

import cn.wj.ssm.pojo.Product;
import cn.wj.ssm.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Auther: wangjing
 * @Date: 2022/10/31 19:30
 * @Desc:
 */
@Controller
@RequestMapping("product")
public class ProductController {


    //注入service层
    @Autowired
    private ProductService productService;


    /**
     * 查看详情
     */
    @RequestMapping("findById")
    public ModelAndView findById(@RequestParam("id") Integer id ){
        Product product = this.productService.editById(id);
        ModelAndView mv = new ModelAndView("product-show");
        mv.addObject("product",product);
        return mv;
    }


    /**
     * 修改
     */
    @RequestMapping("edit")
    public String edit(Product product){
        this.productService.edit(product);
        return "redirect:findAll.do";
    }

    /**
     * 修改前数据回写
     */
    @RequestMapping("editById")
    public ModelAndView editById(@RequestParam("id") Integer id){

        Product product = this.productService.editById(id);

        ModelAndView mv = new ModelAndView("product-edit");
        mv.addObject("product",product);
        return mv;
    }



    /**
     * 批量删除
     */
    @RequestMapping("selectDelete")
    public String selectDelete(HttpServletRequest request){
        String arr = request.getParameter("arr");
        String[] split = arr.split(",");
        for (String s : split) {
            int i = Integer.parseInt(s);
            this.productService.deleteById(i);
        }
        return "redirect:findAll.do";
    }




    /**
     * 指定删除
     */
    @RequestMapping("deleteById")
    public String deleteById(@RequestParam("id") Integer id){
        this.productService.deleteById(id);
        return "redirect:findAll.do";
    }



    /**
     * 新增产品
     */
    @RequestMapping("save")
    public String save(Product product){
        this.productService.save(product);
        return "redirect:findAll.do";
    }


    /**
     * 查询所有产品
     * @return
     */
    @RequestMapping("findAll")
    public ModelAndView findAll(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                @RequestParam(value = "size",defaultValue = "5") Integer size){

        PageHelper.startPage(page,size);

        List<Product> productList =  this.productService.findAll();
        PageInfo pageInfo = new PageInfo(productList);

        ModelAndView mv = new ModelAndView("product-list");
        mv.addObject("pageInfo",pageInfo);
        return mv;
    }
}
