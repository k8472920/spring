package com.example.spring02.model.member.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.spring02.model.member.vo.MemberVO;

@Repository
public class MemberDAOImple implements MemberDAO{

	@Inject
	SqlSession sqlSession;
	
	@Override
	public boolean loginCheck(MemberVO vo) {
	 	String name = sqlSession.selectOne("member.login_check",vo);
		return (name==null) ?  false : true ;
	}


	@Override
	public MemberVO viewMember(String userid) {
		return sqlSession.selectOne("member.viewMember",userid);
	}


	@Override
	public void insert(MemberVO vo) {
		sqlSession.insert("member.insert",vo);
		
	}
    
	@Override
	public boolean checkId(MemberVO vo) {
	 	String name = sqlSession.selectOne("member.checkId",vo);
		return (name==null) ?  false : true ;
	}
		
}
