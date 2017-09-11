package com.example.spring02.controller.email;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring02.model.email.vo.EmailVO;
import com.example.spring02.model.member.vo.MemberVO;
import com.example.spring02.service.email.EmailService;

@Controller
@RequestMapping("/email/")
public class EmailController {

	
	
	@Inject
	EmailService emailService;
	
	@RequestMapping("write.do")
	public String write(){
		return "/email/write";
	}
	
	@RequestMapping("send.do")
    public String send(@ModelAttribute EmailVO vo, Model model) throws Exception{

		try {
			emailService.sendMail(vo);
			model.addAttribute("message","메일이 발송되었습니다");
			
		} catch (Exception e) {
          e.printStackTrace();
          model.addAttribute("message","메세지 전송을 실패하였습니다");
		}
		
		return "email/write";
	}
	
	
	
}
