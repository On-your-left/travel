package cn.wj.ssm.mapper;

import cn.wj.ssm.pojo.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: wangjing
 * @Date: 2022/11/7 22:27
 * @Desc:
 */
@Repository
public interface PermissionMapper {


    /**
     * 查询所有资源权限
     * @return
     */
    List<Permission> findAll();


    /**
     * 添加资源权限
     * @param permission
     */
    void save(Permission permission);
}
