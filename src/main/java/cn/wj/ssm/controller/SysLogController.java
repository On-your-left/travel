package cn.wj.ssm.controller;

import cn.wj.ssm.pojo.Orders;
import cn.wj.ssm.pojo.SysLog;
import cn.wj.ssm.service.SysLogService;
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
 * @Date: 2022/11/9 20:13
 * @Desc:
 */
@Controller
@RequestMapping("sysLog")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    /**
     * 查询所有日志
     */
    @RequestMapping("findAll")
    public ModelAndView findAll(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                @RequestParam(value = "size",defaultValue = "5") Integer size){

        PageHelper.startPage(page,size);
        List<SysLog> list =  this.sysLogService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        ModelAndView mv = new ModelAndView("syslog-list");

        mv.addObject("pageInfo",pageInfo);
        return mv;
    }

}
