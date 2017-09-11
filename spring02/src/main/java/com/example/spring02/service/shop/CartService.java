package com.example.spring02.service.shop;

import java.util.List;

import com.example.spring02.model.shop.vo.CartVO;

public interface CartService {
	
	public List<CartVO> cartMoney();
	public void insert(CartVO vo);
	public List<CartVO> listCart(String userid);
	public void delete(int cart_id);
	public void deleteAll(String userid);
	public void update(int cart_id);
	public int sumMoney(String userid);
	public int countCart(String userid,int product_id);
	public void updateCart(CartVO vo);
	public void modifyCart(CartVO vo);

}
