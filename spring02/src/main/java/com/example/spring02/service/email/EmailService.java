package com.example.spring02.service.email;

import com.example.spring02.model.email.vo.EmailVO;

public interface EmailService {

	public void sendMail(EmailVO vo);
}
