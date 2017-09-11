package com.example.spring02.model.shop.dao;

import java.util.List;

import com.example.spring02.model.shop.vo.ProductVO;

public interface ProductDAO {
	
	List<ProductVO> listProduct();
	ProductVO detailProduct(int product_id);
	void updateProduct(ProductVO vo);
	void deleteProduct(int product_id );
	void insertProduct(ProductVO vo);
	String fileInfo(int Product_id);
	
	

}
