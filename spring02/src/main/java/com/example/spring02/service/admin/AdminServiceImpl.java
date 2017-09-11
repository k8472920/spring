package com.example.spring02.service.admin;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.example.spring02.model.admin.dao.AdminDAO;
import com.example.spring02.model.member.vo.MemberVO;

@Service
public class AdminServiceImpl implements AdminService {

	@Inject
	AdminDAO adminDao;

	@Override
	public String loginCheck(MemberVO vo) {
		return adminDao.loginCheck(vo);
	}

	@Override
	public void logout(HttpSession session) {
		session.invalidate();		
	}
	
}
