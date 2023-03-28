package cn.wj.ssm.service;

import cn.wj.ssm.pojo.Role;
import cn.wj.ssm.pojo.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @Auther: wangjing
 * @Date: 2022/11/2 20:53
 * @Desc:
 */
public interface UserService extends UserDetailsService {
    /**
     * 查询所有用户
     */
    List<UserInfo> findAll();

    /**
     * 新增用户
     */
    void save(UserInfo userInfo);

    /**
     * 用户详情
     */
    UserInfo findById(int id);

    /**
     * 删除用户
     */
    void deleteUser(Integer id);


    /**
     * 用户查询可添加角色---添加角色前,查询有哪些角色可以添加
     */
    List<Role> findUserByIdAndAllRole(Integer id);

    /**
     * 添加角色
     */
    void addRoleToUser(Integer userId, Integer[] ids);
}
