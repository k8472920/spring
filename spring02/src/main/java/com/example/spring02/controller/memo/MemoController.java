package com.example.spring02.controller.memo;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring02.model.memo.vo.MemoVO;
import com.example.spring02.service.memo.MemoService;

@Controller
@RequestMapping("/memo/")
public class MemoController {
	
      private static final Logger logger = LoggerFactory.getLogger(MemoController.class);	
	
	  @Inject
	  MemoService memoService;
	  
	  @RequestMapping("list.do")
		public ModelAndView list(ModelAndView mav){
			List<MemoVO> items = memoService.list();
			logger.info("items:"+items);
			mav.setViewName("memo/memo_list");//뷰의 이름
			mav.addObject("list",items);//데이터 저장
			return mav; //뷰로 포워딩
		}
	  
	    @RequestMapping("insert.do")  
	    public String insert(@ModelAttribute MemoVO vo){
	    	memoService.insert(vo);
	    	return "redirect:/memo/list.do";
	    }

	    @RequestMapping("view/{idx}") 
	    public ModelAndView view(@PathVariable int idx,ModelAndView mav){
	        logger.info("view:"+idx); 
	    	mav.setViewName("memo/view");
	    	mav.addObject("vo",memoService.memo_view(idx));
	        return mav;
	    	
	    }
	    
	    @RequestMapping("update/{idx}")
		public String update(@PathVariable int idx, MemoVO vo){
			memoService.update(vo);
			return "redirect:/memo/list.do";
		}
		@RequestMapping("delete/{idx}")
		public String delete(@PathVariable int idx){
			memoService.delete(idx);
			return "redirect:/memo/list.do";
		}
}
