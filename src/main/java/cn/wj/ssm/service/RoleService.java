package cn.wj.ssm.service;

import cn.wj.ssm.pojo.Permission;
import cn.wj.ssm.pojo.Role;

import java.util.List;

/**
 * @Auther: wangjing
 * @Date: 2022/11/6 17:57
 * @Desc:
 */
public interface RoleService {
    /**
     * 查询所有角色
     */
    List<Role> findAll();


    /**
     * 新增角色
     * @param role
     */
    void save(Role role);

    /**
     * 角色详情
     * @param id
     * @return
     */
    Role findById(Integer id);


    /**
     * 添加权限前查询角色已经拥有哪些权限
     */
    List<Permission> findRoleByIdAndAllPermission(Integer id);


    /**
     * 添加权限
     * @param roleId
     * @param ids
     */
    void addPermissionToRole(Integer roleId, Integer[] ids);

    /**
     * 删除角色
     * @param id
     */
    void deleteRole(Integer id);
}
