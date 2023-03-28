package cn.wj.ssm.mapper;

import cn.wj.ssm.pojo.SysLog;

import java.util.List;

/**
 * @Auther: wangjing
 * @Date: 2022/11/9 20:06
 * @Desc:
 */
public interface SysLogMapper {

    /**
     * 记录日志操作
     */
    void save(SysLog sysLog);


    /**
     * 查询所有日志
     */
    List<SysLog> findAll();
}
