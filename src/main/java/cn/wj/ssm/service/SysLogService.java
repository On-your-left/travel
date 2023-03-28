package cn.wj.ssm.service;

import cn.wj.ssm.pojo.SysLog;

import java.util.List;

/**
 * @Auther: wangjing
 * @Date: 2022/11/9 19:23
 * @Desc:
 */
public interface SysLogService {

    /**
     * 记录日志操作
     */
    void save(SysLog sysLog);

    /**
     * 查询所有日志
     */
    List<SysLog> findAll();

}
