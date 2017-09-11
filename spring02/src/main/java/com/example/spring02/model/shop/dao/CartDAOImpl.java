package com.example.spring02.model.shop.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.spring02.model.shop.vo.CartVO;

@Repository
public class CartDAOImpl implements CartDAO{

	@Inject
	SqlSession session;
	
	@Override
	public List<CartVO> cartMoney() {
		return session.selectList("cart.cart_money");
	}

	@Override
	public void insert(CartVO vo) {
		session.insert("cart.insert",vo);
		
	}

	@Override
	public List<CartVO> listCart(String userid) {
		return session.selectList("cart.listCart",userid);
	}

	@Override
	public void delete(int cart_id) {
		session.delete("cart.delete",cart_id);
		
	}

	@Override
	public void deleteAll(String userid) {
       session.delete("cart.deleteAll",userid);		
	}

	@Override
	public void update(int cart_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int sumMoney(String userid) {
		return session.selectOne("cart.sumMoney", userid);
	}

	@Override
	public int countCart(String userid, int product_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateCart(CartVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyCart(CartVO vo) {
		session.update("cart.modifyCart",vo);
		
	}

}
