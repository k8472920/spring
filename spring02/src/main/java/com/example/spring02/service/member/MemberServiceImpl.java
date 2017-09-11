package com.example.spring02.service.member;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.example.spring02.model.member.dao.MemberDAO;
import com.example.spring02.model.member.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject
	MemberDAO memberDao;

	@Override
	public boolean loginCheck(MemberVO vo, HttpSession session) {

		boolean result = memberDao.loginCheck(vo);
		if(result){
			MemberVO vo2= viewMember(vo.getUserid());
			session.setAttribute("userid", vo2.getUserid());
			session.setAttribute("name", vo2.getName());
		}
		return result;
	}

	@Override
	public void logout(HttpSession session) {
		session.invalidate();
		
	}

	@Override
	public MemberVO viewMember(String userid) {
		return memberDao.viewMember(userid);
	}

	@Override
	public void insert(MemberVO vo) {
      memberDao.insert(vo);		
	}

	@Override
	public boolean checkId(MemberVO vo) {
		
		boolean result = memberDao.checkId(vo);
		return result;
	}

}
