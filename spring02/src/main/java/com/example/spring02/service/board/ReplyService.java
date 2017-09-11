package com.example.spring02.service.board;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.spring02.model.board.vo.ReplyVO;

public interface ReplyService {
	// 댓글 목록
	public List<ReplyVO> list(int bno, int start, int end, HttpSession session);

	public int count(int bno); // 댓글 갯수

	public void create(ReplyVO vo); // 댓글 쓰기

	public void update(ReplyVO vo); // 댓글 수정

	public void delete(int rno); // 댓글 삭제

	public ReplyVO detail(int rno); // 댓글 상세
}
