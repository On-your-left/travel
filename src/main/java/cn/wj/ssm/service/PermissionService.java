package cn.wj.ssm.service;

import cn.wj.ssm.pojo.Permission;

import java.util.List;

/**
 * @Auther: wangjing
 * @Date: 2022/11/7 22:24
 * @Desc:
 */
public interface PermissionService {


    /**
     * 查询所有资源权限
     * @return
     */
    List<Permission> findAll();

    /**
     * 添加资源权限
     */
    void save(Permission permission);
}
