package cn.wj.ssm.service.impl;

import cn.wj.ssm.mapper.RoleMapper;
import cn.wj.ssm.pojo.Permission;
import cn.wj.ssm.pojo.Role;
import cn.wj.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: wangjing
 * @Date: 2022/11/6 18:03
 * @Desc:
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 查询所有角色
     */
    @Override
    public List<Role> findAll() {
        return this.roleMapper.findAll();
    }


    /**
     * 新增角色
     * @param role
     */
    @Override
    public void save(Role role) {
        this.roleMapper.save(role);
    }

    /**
     * 角色详情
     * @param id
     * @return
     */
    @Override
    public Role findById(Integer id) {
        return this.roleMapper.findById(id);
    }

    /**
     * 添加权限前查询角色已经拥有哪些权限
     */
    @Override
    public List<Permission> findRoleByIdAndAllPermission(Integer id) {
        return this.roleMapper.findRoleByIdAndAllPermission(id);
    }


    /**
     * 添加权限
     * @param roleId
     * @param ids
     */
    @Override
    public void addPermissionToRole(Integer roleId, Integer[] ids) {
        for (Integer permissionId : ids) {
            this.roleMapper.addPermissionToRole(roleId,permissionId);
        }
    }

    /**
     * 删除角色
     * @param id
     */
    @Override
    public void deleteRole(Integer id) {
        //删除role表中的角色
        this.roleMapper.deleteRole(id);
        //删除role_permission表中的关系
        this.roleMapper.delete_role_permission(id);
        //删除users_role表中的关系
        this.roleMapper.delete_users_role(id);
    }
}
