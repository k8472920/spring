package com.example.spring02.model.member.dao;

import com.example.spring02.model.member.vo.MemberVO;

public interface MemberDAO {

	public boolean loginCheck(MemberVO vo); 
	public MemberVO viewMember(String userid);
	public void insert(MemberVO vo);
	public boolean checkId(MemberVO vo);
	
	
}
