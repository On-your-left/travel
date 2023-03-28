package cn.wj.ssm.controller;

import cn.wj.ssm.pojo.Permission;
import cn.wj.ssm.service.PermissionService;
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
 * @Date: 2022/11/7 22:21
 * @Desc:
 */
@RequestMapping("permission")
@Controller
public class PermissionController {

    @Autowired
    private PermissionService permissionService;


    /**
     * 添加资源权限
     */
    @RequestMapping("save")
    public String save(Permission permission){
        this.permissionService.save(permission);
        return "redirect:findAll.do";
    }



    /**
     * 查询所有资源权限
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("findAll")
    public ModelAndView findAll(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                @RequestParam(value = "size",defaultValue = "5") Integer size){

        PageHelper.startPage(page,size);

        List<Permission> permissionList =  this.permissionService.findAll();
        PageInfo pageInfo = new PageInfo(permissionList);

        ModelAndView mv = new ModelAndView("permission-list");
        mv.addObject("pageInfo",pageInfo);
        return mv;
    }
}
