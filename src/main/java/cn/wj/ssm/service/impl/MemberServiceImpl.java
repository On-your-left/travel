package cn.wj.ssm.service.impl;

import cn.wj.ssm.mapper.MemberMapper;
import cn.wj.ssm.pojo.Member;
import cn.wj.ssm.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: wangjing
 * @Date: 2022/11/2 17:44
 * @Desc:
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;


    /**
     * 新增订单前查询所有产品和管理员
     */
    @Override
    public List<Member> findAll() {
        return this.memberMapper.findAll();
    }
}
