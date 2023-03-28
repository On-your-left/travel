package cn.wj.ssm.mapper;

import cn.wj.ssm.pojo.Permission;
import cn.wj.ssm.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: wangjing
 * @Date: 2022/11/6 18:04
 * @Desc:
 */
public interface RoleMapper {


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
     * @param permissionId
     */
    void addPermissionToRole(@Param("roleId") Integer roleId, @Param("permissionId")Integer permissionId);





    /**
     * 删除role表中的角色
     * @param id
     */
    void deleteRole(Integer id);
    /**
     * 删除role_permission表中的关系
     * @param id
     */
    void delete_role_permission(Integer id);
    /**
     * 删除users_role表中的关系
     * @param id
     */
    void delete_users_role(Integer id);
}
