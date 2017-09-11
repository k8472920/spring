package com.example.spring02.service.shop;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.spring02.model.shop.dao.ProductDAO;
import com.example.spring02.model.shop.vo.ProductVO;

@Service
public class ProductServiceImpl implements ProductService{

	@Inject
	ProductDAO projectDao;
	
	@Override
	public List<ProductVO> listProduct() {
		return projectDao.listProduct();
	}

	@Override
	public ProductVO detailProduct(int product_id) {
		return projectDao.detailProduct(product_id);
	}

	@Override
	public void updateProduct(ProductVO vo) {
      projectDao.updateProduct(vo);		
	}

	@Override
	public void deleteProduct(int product_id) {
      projectDao.deleteProduct(product_id);		
	}

	@Override
	public void insertProduct(ProductVO vo) {
       projectDao.insertProduct(vo);		
	}

	@Override
	public String fileInfo(int Product_id) {
		return projectDao.fileInfo(Product_id);
	}

}
