package com.example.spring02.model.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.spring02.model.board.vo.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO{

	@Inject
	SqlSession session;
	
	@Override
	public void deleteFile(String fullName) {
		session.delete("board.deleteAttach",fullName);
		
	}

	@Override
	public List<String> getAttach(int bno) {
		return session.selectList("board.getAttach", bno);
	}

	@Override
	public void addAttach(String fullName) {
      session.insert("board.addAttach",fullName);		
	}

	@Override
	public void updateAttach(String fullName, int bno) {
		Map<String,Object> map = new HashMap<>();
		map.put("fullName", fullName);
		map.put("bno", bno);
		session.insert("board.updateAttach",map);
		
	}

	@Override
	public void create(BoardVO vo) throws Exception {
        session.insert("board.insert",vo);		
	}

	@Override
	public BoardVO read(int bno) throws Exception {
		return session.selectOne("board.view",bno);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
       session.update("board.updateArticle",vo);		
	}

	@Override
	public void delete(int bno) throws Exception {
		session.delete("board.deleteArticle",bno);
		
	}

	@Override
	public List<BoardVO> listAll(int start, int end, String search_option, String keyword) throws Exception {
		Map<String,Object> map = new HashMap<>();
		map.put("keyword", keyword);
		map.put("search_option", search_option);
		map.put("start", start);
		map.put("end", end);
		
		return session.selectList("board.listAll",map);
	}

	@Override
	public void increaseViewcnt(int bno) {
           
	    /*Map<String, Object> map= new HashMap<>();
	    map.put("bno", bno);
	    map.put("session", session);*/
	    
		session.update("board.increaseViewcnt",bno);		
	}

	@Override
	public int countArticle(String search_option, String keyword) throws Exception {
		Map<String, Object> map= new HashMap<>();
	    map.put("search_option", search_option);
	    map.put("keyword", keyword);
		
		return session.selectOne("board.countArticle",map);
	}

	

	
}
