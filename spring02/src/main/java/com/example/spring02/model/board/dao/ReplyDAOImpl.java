package com.example.spring02.model.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.spring02.model.board.vo.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {

	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<ReplyVO> list(int bno,int start,int end){
		Map<String,Object> map=new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		map.put("bno", bno);
		return sqlSession.selectList("reply.listReply",map);
	}

	@Override
	public int count(int bno) {
		return sqlSession.selectOne("reply.count", bno);
	}

	@Override
	public void create(ReplyVO vo) {
		sqlSession.insert("reply.insertReply", vo);
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
