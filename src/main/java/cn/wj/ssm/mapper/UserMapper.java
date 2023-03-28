package cn.wj.ssm.mapper;

import cn.wj.ssm.pojo.Role;
import cn.wj.ssm.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: wangjing
 * @Date: 2022/11/2 21:03
 * @Desc:
 */
public interface UserMapper {

    /**
     * 认证--通过用户名查询用户所拥有的角色
     */
    UserInfo findUserByUserName(String s);


    /**
     * 查询所有用户
     * @return
     */
    List<UserInfo> findAll();


    /**
     * 新增用户
     * @param userInfo
     */
    void save(UserInfo userInfo);

    /**
     * 用户详情
     */
    UserInfo findById(int id);

    /**
     * 删除用户
     * @param id
     */
    void deleteUser(Integer id);


    /**
     * 用户查询可添加角色---添加角色前,查询有哪些角色可以添加
     */
    List<Role> findUserByIdAndAllRole(Integer id);


    /**
     * 添加角色
     * @param userId
     * @param roleId
     */
    void addRoleToUser(@Param("userId") Integer userId, @Param("roleId")Integer roleId);
}
