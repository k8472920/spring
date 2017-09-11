package com.example.spring02.service.member;

import javax.servlet.http.HttpSession;

import com.example.spring02.model.member.vo.MemberVO;
import com.example.spring02.model.memo.vo.MemoVO;

public interface MemberService {
	public boolean loginCheck(MemberVO vo, HttpSession session); 
	public MemberVO viewMember(String userid);
	public void logout(HttpSession session); 
	public void insert(MemberVO vo);
	public boolean checkId(MemberVO vo);
}
