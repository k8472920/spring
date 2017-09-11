package com.example.spring02.service.email;

import javax.inject.Inject;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.spring02.model.email.vo.EmailVO;

@Service
public class EmailServiceImpl implements EmailService{

	
	@Inject
	JavaMailSender mailSender;
	
	@Override 
	public void sendMail(EmailVO vo) {
        try {
        	MimeMessage msg=mailSender.createMimeMessage();
			//메일 수신자 추가
			msg.addRecipient(RecipientType.TO, new InternetAddress(vo.getReceiveMail()));
			//메일 발신자
			//msg.addFrom(new InternetAddress[] {new InternetAddress(vo.getSenderMail(),vo.getSenderName())});
			//메일 제목
			msg.setSubject(vo.getSubject(),"utf-8");
			//메일 본문
			msg.setText(vo.getMessage(),"utf-8");
			//이메일 전송
			mailSender.send(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
