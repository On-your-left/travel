package cn.wj.ssm.service.impl;

import cn.wj.ssm.mapper.UserMapper;
import cn.wj.ssm.pojo.Role;
import cn.wj.ssm.pojo.UserInfo;
import cn.wj.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: wangjing
 * @Date: 2022/11/2 20:54
 * @Desc:   UserService继承了UserDetailsService , 会重写UserDetailsService的loadUserByUsername方法
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    /**
     * 认证--通过用户输入的用户名查询用户所拥有的角色
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        UserInfo userInfo =  this.userMapper.findUserByUserName(s);

        User user = new User(userInfo.getUsername(),
                userInfo.getPassword(),
                userInfo.getStatus() == 0 ? false:true, //校验用户是否开启
                true,                   //账号是否过期,不过期
                true,               //证书是否过期,不过期
                true,               //账号是否锁定,不锁定
                getAuthority(userInfo.getRoles()));
        return user;
    }



    /**
     * 认证--查询用户对应的角色
     */
    private List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {

        List<SimpleGrantedAuthority> list = new ArrayList<>();

        for (Role r : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + r.getRoleName()));
        }
        return list;
    }


    /**
     * 查询所有用户
     * @return
     */
    @Override
    public List<UserInfo> findAll() {
        return this.userMapper.findAll();
    }


    /**
     * 新增用户
     */
    @Override
    public void save(UserInfo userInfo) {

        userInfo.setPassword(this.bCryptPasswordEncoder.encode(userInfo.getPassword()));
        this.userMapper.save(userInfo);
    }

    /**
     * 用户详情
     */
    @Override
    public UserInfo findById(int id) {
        return this.userMapper.findById(id);
    }


    /**
     * 删除用户
     * @param id
     */
    @Override
    public void deleteUser(Integer id) {
        this.userMapper.deleteUser(id);
    }


    /**
     * 用户查询可添加角色---添加角色前,查询有哪些角色可以添加
     */
    @Override
    public List<Role> findUserByIdAndAllRole(Integer id) {
        return this.userMapper.findUserByIdAndAllRole(id);
    }


    /**
     * 添加角色
     */
    @Override
    public void addRoleToUser(Integer userId, Integer[] ids) {
        for (Integer roleId : ids) {
            this.userMapper.addRoleToUser(userId,roleId);
        }
    }


}
