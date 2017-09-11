package com.example.spring02.controller.admin;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring02.model.member.vo.MemberVO;
import com.example.spring02.service.admin.AdminService;

@Controller
@RequestMapping("/admin/")
public class AdminController {

	@Inject
	AdminService adminService;
	
	@RequestMapping("login.do")
	public String login(){
		return "admin/login";
	}
	
	
	@RequestMapping("login_check.do")
	public ModelAndView login_check(MemberVO vo, HttpSession session, ModelAndView mav){
		
		String name = adminService.loginCheck(vo);
		
		if( name != null){
			session.setAttribute("admin_userid",vo.getUserid());
			session.setAttribute("admin_name",name);
			session.setAttribute("userid",vo.getUserid());
			session.setAttribute("name",name);
            mav.setViewName("admin/admin");
            mav.addObject("message","success");
		}else {
			mav.setViewName("admin/login");
			mav.addObject("message","error");
		}
		
		return mav;
		
	}
	
	@RequestMapping("logout.do")
	public ModelAndView logout(HttpSession session, ModelAndView mav){
		adminService.logout(session);
		mav.setViewName("admin/login");
		mav.addObject("message", "logout");
		return mav;
	}
	
}
