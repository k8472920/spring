package com.example.spring02.service.admin;

import javax.servlet.http.HttpSession;

import com.example.spring02.model.member.vo.MemberVO;

public interface AdminService {

	public String loginCheck(MemberVO vo);

	public void logout(HttpSession session);
	
}
