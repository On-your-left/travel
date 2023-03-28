package cn.wj.ssm.controller;

import cn.wj.ssm.pojo.Permission;
import cn.wj.ssm.pojo.Role;
import cn.wj.ssm.service.RoleService;
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
 * @Date: 2022/11/6 17:55
 * @Desc:
 */
@Controller
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 删除角色
     */
    @RequestMapping("deleteRole")
    public String deleteRole(@RequestParam("id") Integer id){
        this.roleService.deleteRole(id);
        return "redirect:findAll.do";
    }




    /**
     * 新增权限
     */
    @RequestMapping("addPermissionToRole")
    public String addPermissionToRole(@RequestParam("roleId") Integer roleId ,
                                      @RequestParam("ids") Integer[] ids){
        this.roleService.addPermissionToRole(roleId,ids);
        return "redirect:findAll.do";
    }


    /**
     * 添加权限前查询角色已经拥有哪些权限
     */
    @RequestMapping("findRoleByIdAndAllPermission")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam("id") Integer id){
        //查询角色详情(获取当前角色的id,传给页面)
        Role role = this.roleService.findById(id);

        //添加权限前查询角色已经拥有哪些权限
        List<Permission> permissionList = this.roleService.findRoleByIdAndAllPermission(id);

        ModelAndView mv = new ModelAndView("role-permission-add");
        mv.addObject("role",role);
        mv.addObject("permissionList",permissionList);
        return mv;
    }



    /**
     * 角色详情
     */
    @RequestMapping("findById")
    public ModelAndView findById(@RequestParam("id") Integer id){
        Role role = this.roleService.findById(id);
        ModelAndView mv = new ModelAndView("role-show");
        mv.addObject("role",role);
        return mv;
    }




    /**
     * 新增角色
     */
    @RequestMapping("save")
    public String save(Role role){
        this.roleService.save(role);
        return "redirect:findAll.do";
    }



    /**
     * 查询所有角色
     */
    @RequestMapping("findAll")
    public ModelAndView findAll(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                @RequestParam(value = "size",defaultValue = "5") Integer size){

        PageHelper.startPage(page,size);

        List<Role> productList =  this.roleService.findAll();
        PageInfo pageInfo = new PageInfo(productList);

        ModelAndView mv = new ModelAndView("role-list");
        mv.addObject("pageInfo",pageInfo);
        return mv;
    }
}
