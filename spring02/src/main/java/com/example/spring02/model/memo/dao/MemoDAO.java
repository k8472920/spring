package com.example.spring02.model.memo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.spring02.model.memo.vo.MemoVO;

public interface MemoDAO {
	
	String list_memo = "select * from memo order by idx desc";
	String insert_memo ="insert into memo ( idx,writer,memo) values ( (select nvl(max(idx)+1,1) from memo), #{writer}, #{memo})";
	String view_memo = "select * from memo where idx=#{idx}";
	String update_memo = "update memo set writer=#{writer}, memo=#{memo} where idx=#{idx}";
	String delete_memo = "delete from memo where idx=#{idx}";
	
	@Select(list_memo)
	public List<MemoVO> list();
	
	@Insert(insert_memo)
	public void insert(@Param("writer") String writer, @Param("memo") String memo);
	
	@Select(view_memo)
	public MemoVO memo_view(@Param("idx") int idx);
	
	@Update(update_memo)
	public void update(MemoVO vo);
	
	@Delete(delete_memo)
	public void delete(@Param("idx") int idx);


	

}
