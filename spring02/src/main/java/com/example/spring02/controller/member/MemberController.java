package com.example.spring02.controller.member;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring02.model.member.dao.MemberDAO;
import com.example.spring02.model.member.vo.MemberVO;
import com.example.spring02.service.member.MemberService;

@Controller
@RequestMapping("/member/")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Inject
	MemberService memberService;

	@Inject
	MemberDAO memberDao;

	@RequestMapping("join.do")
	public String address() {
		return "member/join";
	}

	@RequestMapping("login.do")
	public String login() {
		return "member/login";
	}

	@RequestMapping("register.do")
	public String register() {
		return "member/register";
	}

	@RequestMapping("login_check.do")
	public ModelAndView login_check(@ModelAttribute MemberVO vo, HttpSession session) {

		boolean result = memberService.loginCheck(vo, session);

		ModelAndView mav = new ModelAndView();
		if (result) {
			mav.setViewName("home");
			mav.addObject("message", "success");
		} else {
			mav.setViewName("member/login");
			mav.addObject("message", "error");
		}
		return mav;
	}

	@RequestMapping("logout.do")
	public ModelAndView logout(HttpSession session, ModelAndView mav) {
		memberService.logout(session);
		mav.setViewName("member/login");
		mav.addObject("message", "logout");
		return mav;
	}

	@RequestMapping("insert.do")
	public String insert(@ModelAttribute MemberVO vo) {
		memberService.insert(vo);
		return "redirect:/member/login.do";
	}

	@ResponseBody
	@RequestMapping("chechId.do")
	public boolean checkId(@ModelAttribute MemberVO vo) {

		System.out.println(vo.getUserid());
		boolean result = memberService.checkId(vo);

		return result;

	}
	
	@ResponseBody
	@RequestMapping("forgot.do")
	public void forgot(){
		
		
		
	}
	

}