package com.example.spring02.service.board;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring02.model.board.dao.BoardDAO;
import com.example.spring02.model.board.vo.BoardVO;
import com.mysql.cj.api.Session;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	BoardDAO boardDao;
	
	@Override
	public void deleteFile(String fullName) {
		boardDao.deleteFile(fullName);
		
	}

	@Override
	public List<String> getAttach(int bno) {
		return boardDao.getAttach(bno);
	}

	@Override
	public void addAttach(String fullName) {
       boardDao.addAttach(fullName);		
	}

	@Override
	public void updateAttach(String fullName, int bno) {
		boardDao.updateAttach(fullName, bno);
				
	}

	@Transactional
	@Override
	public void create(BoardVO vo) throws Exception {
		boardDao.create(vo);
		String[] files=vo.getFiles();
		if(files==null) return;
			
		for(String name :files){
			boardDao.addAttach(name);
		}
	}

	@Override
	public BoardVO read(int bno) throws Exception {
		return boardDao.read(bno);
	}

	@Transactional
	@Override
	public void update(BoardVO vo) throws Exception {
       boardDao.update(vo);
       String[] files=vo.getFiles();
		if(files==null) return;
			
		for(String name :files){
			boardDao.updateAttach(name,vo.getBno());
		}
	}

	@Override
	public void delete(int bno) throws Exception {
       boardDao.delete(bno);		
	}

	@Override
	public List<BoardVO> listAll(int start, int end, String search_option, String keyword) throws Exception {
		return boardDao.listAll(start, end, search_option, keyword);
	}

	@Override
	public void increaseViewcnt(int bno, HttpSession session) {
		long update_time = 0;
		//세션에 저장된 게시물의 조회시간 검색
		if(session.getAttribute("update_time_"+bno)!=null){
			update_time=(long)session.getAttribute("update_time_"+bno);
		}
		//현재 시간
		long current_time=System.currentTimeMillis();
		//일정 시간이 경과된 후 조회수 증가 처리
		if(current_time - update_time > 5*1000 ) {
			boardDao.increaseViewcnt(bno);
			session.setAttribute("update_time_"+bno,current_time);
		}
	}

	@Override
	public int countArticle(String search_option, String keyword) throws Exception {
		return boardDao.countArticle(search_option, keyword);
	}

}
