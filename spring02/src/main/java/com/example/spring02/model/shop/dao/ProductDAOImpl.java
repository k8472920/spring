package com.example.spring02.model.shop.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.spring02.model.shop.vo.ProductVO;

@Repository
public class ProductDAOImpl implements ProductDAO {
    
	@Inject
	SqlSession session;
	
	@Override
	public List<ProductVO> listProduct() {
		return session.selectList("product.list_product");
	}

	@Override
	public ProductVO detailProduct(int product_id) {
		return session.selectOne("product.detail_product",product_id);
	}

	@Override
	public void updateProduct(ProductVO vo) {
		session.update("product.update_product",vo);
		
	}

	@Override
	public void deleteProduct(int product_id) {
       session.delete("product.delete",product_id);		
	}

	@Override
	public void insertProduct(ProductVO vo) {
       session.insert("product.insert",vo);		
	}

	@Override
	public String fileInfo(int Product_id) {
		return session.selectOne("product.file_info",Product_id);
	}

}
