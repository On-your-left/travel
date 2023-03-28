package cn.wj.ssm.service.impl;

import cn.wj.ssm.mapper.PermissionMapper;
import cn.wj.ssm.pojo.Permission;
import cn.wj.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: wangjing
 * @Date: 2022/11/7 22:25
 * @Desc:
 */
@Service
public class permissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;



    /**
     * 查询所有资源权限
     * @return
     */
    @Override
    public List<Permission> findAll() {
        return this.permissionMapper.findAll();
    }

    /**
     * 添加资源权限
     */
    @Override
    public void save(Permission permission) {
        this.permissionMapper.save(permission);
    }
}
