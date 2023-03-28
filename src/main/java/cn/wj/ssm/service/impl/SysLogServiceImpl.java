package cn.wj.ssm.service.impl;

import cn.wj.ssm.mapper.SysLogMapper;
import cn.wj.ssm.pojo.SysLog;
import cn.wj.ssm.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: wangjing
 * @Date: 2022/11/9 19:24
 * @Desc:
 */
@Service
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private SysLogMapper sysLogMapper;

    /**
     * 记录日志操作
     */
    @Override
    public void save(SysLog sysLog) {
        this.sysLogMapper.save(sysLog);
    }

    /**
     * 查询所有日志
     */
    @Override
    public List<SysLog> findAll() {
        return this.sysLogMapper.findAll();
    }
}
