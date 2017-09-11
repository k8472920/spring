package com.example.spring02.controller.upload;

import java.io.File;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring02.controller.memo.MemoController;

@Controller
public class UploadController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemoController.class);

	@Resource(name="uploadPath")
	String uploadPath;
	
	@RequestMapping(value="/upload/uploadForm", method=RequestMethod.GET)
	public void uploadForm(){
		
	}
	
	@RequestMapping(value="/upload/uploadForm",method=RequestMethod.POST) //post방식
	public ModelAndView uploadForm(MultipartFile file, ModelAndView mav)throws Exception {
		logger.info("파일이름:"+file.getOriginalFilename());
		
		//업로드한 파일 이름
		String savedName=file.getOriginalFilename();
		//업로드 디렉토리로 이동, 파일이름중복 방지 처리
		savedName=uploadFile(savedName, file.getBytes());
		
		logger.info("파일크기:"+file.getSize());
		logger.info("컨텐트 타입:"+file.getContentType());
		mav.setViewName("upload/uploadResult");//뷰의 이름
		mav.addObject("savedName", savedName);//변수
		return mav;
	}
	
	String uploadFile(String originalName, byte[] fileData)throws Exception {
		//uuid(Universal Unique IDentifier,범용고유식별자)
		UUID uid=UUID.randomUUID();
        //파일 이름 앞에 uuid를 붙여서 중복 방지		
		String savedName=uid.toString()+"_"+originalName;
		File target=new File(uploadPath, savedName);
        //임시 디렉토리에 저장된 파일을 파일업로드 디렉토리로 복사		
		FileCopyUtils.copy(fileData, target);
		return savedName;
	}
	
	
}
