package com.example.spring02.service.memo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.spring02.model.memo.vo.MemoVO;

@Service
public interface MemoService {

	public List<MemoVO> list();
	public void insert(MemoVO vo);
	public MemoVO memo_view(int idx);
	public void update(MemoVO vo);
	public void delete(int idx);
	
}
