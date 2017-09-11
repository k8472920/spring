package com.example.spring02.controller.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring02.model.board.vo.BoardVO;
import com.example.spring02.service.board.BoardService;
import com.example.spring02.service.board.Pager;

@Controller
@RequestMapping("/board/")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	BoardService boardService;
	
	@RequestMapping("list.do")
	public ModelAndView list(@RequestParam(defaultValue="1") int curPage,
			@RequestParam(defaultValue="all") String search_option, @RequestParam(defaultValue="") String keyword ) throws Exception{
		  
		  int count = boardService.countArticle(search_option, keyword);
		  
		  Pager pager = new Pager(count, curPage);
		  int start=pager.getPageBegin();
		  int end=pager.getPageEnd();
		  
		  List<BoardVO> list = boardService.listAll(start, end, search_option, keyword);
		  ModelAndView mav = new ModelAndView("board/list");
		  Map<String, Object> map = new HashMap<>();
		  map.put("list", list);
		  map.put("count", list.size());
		  map.put("keyword", keyword);
		  map.put("pager", pager);
		  map.put("search_option", search_option);
		  
		  mav.addObject("map", map);
		  return mav;
	}
	
	@RequestMapping("write.do")
	public String write(){
		return "board/write";
	}
	
	@RequestMapping("insert.do")
	public String insert(@ModelAttribute BoardVO vo, HttpSession session) throws Exception{
    String writer = (String) session.getAttribute("userid");
    vo.setWriter(writer);
    boardService.create(vo);
    return "redirect:/board/list.do";
	}

	@RequestMapping("view.do")
	public ModelAndView view(@RequestParam int bno,HttpSession session) throws Exception { 
		//조회수 증가처리
		boardService.increaseViewcnt(bno, session);
		//레코드를 리턴받음
		ModelAndView mav=new ModelAndView();
		mav.setViewName("board/view");
		mav.addObject("vo", boardService.read(bno));
		return mav;
	}
	
	@RequestMapping("update.do")
	public String update(@ModelAttribute BoardVO vo) throws Exception{
		boardService.update(vo);
		return "redirect:/board/list.do";
	}

	@RequestMapping("delete.do")
    public String delete(@RequestParam int bno) throws Exception{
		 boardService.delete(bno);
		 return "redirect:/board/list.do";
		
	}
	
	@RequestMapping("getAttach/{bno}")
	@ResponseBody
	public List <String> getAttach(@PathVariable("bno") int bno){
		return boardService.getAttach(bno);
		
	}
	
	
}
