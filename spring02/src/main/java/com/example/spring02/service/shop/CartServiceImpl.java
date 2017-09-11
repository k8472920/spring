package com.example.spring02.service.shop;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.spring02.model.shop.dao.CartDAO;
import com.example.spring02.model.shop.vo.CartVO;

@Service
public class CartServiceImpl implements CartService {

	@Inject
	CartDAO cartDao;
	
	@Override
	public List<CartVO> cartMoney() {
		return cartDao.cartMoney();
	}

	@Override
	public void insert(CartVO vo) {
		cartDao.insert(vo);
		
	}

	@Override
	public List<CartVO> listCart(String userid) {
		return cartDao.listCart(userid);
	}

	@Override
	public void delete(int cart_id) {
       	cartDao.delete(cart_id);	
	}

	@Override
	public void deleteAll(String userid) {
		cartDao.deleteAll(userid);
	}

	@Override
	public void update(int cart_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int sumMoney(String userid) {
		return cartDao.sumMoney(userid);
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
		cartDao.modifyCart(vo);
		
	}

}
