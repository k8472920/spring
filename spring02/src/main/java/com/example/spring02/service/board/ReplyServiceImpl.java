package com.example.spring02.service.board;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.example.spring02.model.board.dao.ReplyDAO;
import com.example.spring02.model.board.vo.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Inject
	ReplyDAO replyDao;
	
	@Override
	public List<ReplyVO> list(int bno, int start, int end, HttpSession session) {
		List<ReplyVO> items=replyDao.list(bno, start, end);
		return items;
	}

	@Override
	public int count(int bno) {
		return replyDao.count(bno);
	}

	@Override
	public void create(ReplyVO vo) {
		replyDao.create(vo); 
	}

	@Override
	public void update(ReplyVO vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int rno) {
		// TODO Auto-generated method stub

	}

	@Override
	public ReplyVO detail(int rno) {
		// TODO Auto-generated method stub
		return null;
	}

}
