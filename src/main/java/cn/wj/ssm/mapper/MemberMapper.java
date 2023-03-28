package cn.wj.ssm.mapper;

import cn.wj.ssm.pojo.Member;

import java.util.List;

/**
 * @Auther: wangjing
 * @Date: 2022/11/2 17:47
 * @Desc:
 */
public interface MemberMapper {

    /**
     * 新增订单前查询所有产品和管理员
     */
    List<Member> findAll();

}
