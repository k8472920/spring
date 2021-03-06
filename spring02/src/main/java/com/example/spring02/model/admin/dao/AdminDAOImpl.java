package com.example.spring02.model.admin.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.spring02.model.member.vo.MemberVO;

@Repository
public class AdminDAOImpl implements AdminDAO{

	@Inject
	SqlSession session;
	
	@Override
	public String loginCheck(MemberVO vo) { 
		return session.selectOne("admin.login_check",vo);
	}

}
