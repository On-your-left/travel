package cn.wj.ssm.controller;

import cn.wj.ssm.pojo.Role;
import cn.wj.ssm.pojo.UserInfo;
import cn.wj.ssm.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * @Auther: wangjing
 * @Date: 2022/11/5 19:18
 * @Desc:
 */
@Controller
@RequestMapping("user")
public class UserController {

    //注入UserService层
    @Autowired
    private UserService userService;

    /**
     * 添加角色
     */
    @RequestMapping("addRoleToUser")
    public String addRoleToUser(@RequestParam("userId") Integer userId ,
                                      @RequestParam("ids") Integer[] ids){

        this.userService.addRoleToUser(userId,ids);
        return "redirect:findAll.do";
    }



    /**
     * 用户查询可添加角色---添加角色前,查询有哪些角色可以添加
     */
    @RequestMapping("findUserByIdAndAllRole")
    public ModelAndView findUserByIdAndAllRole(@RequestParam("id") Integer id){
        //查询用户详情,返回给页面,让页面获取此ID
        UserInfo userInfo = this.userService.findById(id);
        //查询用户还可以添加哪些角色
        List<Role> roleList = this.userService.findUserByIdAndAllRole(id);

        ModelAndView mv = new ModelAndView("user-role-add");
        mv.addObject("user",userInfo);
        mv.addObject("roleList",roleList);
        return mv;
    }




    /**
     * 删除用户
     */
    @RequestMapping("deleteUser")
    public String deleteUser(@RequestParam("id") Integer id){
        this.userService.deleteUser(id);
        return "redirect:findAll.do";
    }


    /**
     * 用户详情
     */
    @RequestMapping("findById")
    public ModelAndView findById(@RequestParam("id") Integer id){
        UserInfo userInfo = this.userService.findById(id);

        ModelAndView mv = new ModelAndView("user-show");
        mv.addObject("user",userInfo);
        return mv;
    }



    /**
     * 新增用户
     */
    @RequestMapping("save")
    public String save(UserInfo userInfo){
        this.userService.save(userInfo);
        return "redirect:findAll.do";
    }



    /**
     * 查询所有用户
     */
    // @RolesAllowed("ADMIN")      //jsr250
    // @Secured("ROLE_ADMIN")          //Secured
    // @PreAuthorize("authentication.principal.username == 'jack'")     //pre-post,只有jack才可以访问
    @RequestMapping("findAll")
    public ModelAndView findAll(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                @RequestParam(value = "size" , defaultValue = "5") Integer size){

        PageHelper.startPage(page,size);

        List<UserInfo> userInfoList =  this.userService.findAll();
        PageInfo pageInfo = new PageInfo(userInfoList);

        ModelAndView mv = new ModelAndView("user-list");
        mv.addObject("pageInfo",pageInfo);
        return mv;
    }
}
