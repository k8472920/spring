package com.example.spring02.controller.product;

import java.io.File;

import javax.inject.Inject;
import javax.swing.plaf.metal.MetalIconFactory.FileIcon16;

import org.apache.tomcat.jni.FileInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring02.model.shop.vo.ProductVO;
import com.example.spring02.service.shop.ProductService;

@Controller
@RequestMapping("/shop/product/")
public class ProductController {

	@Inject
	ProductService productService;

	@RequestMapping("boot.do")
	public String boot() {
		return "shop/boot";
	}
	
	
	@RequestMapping("list.do")
	public ModelAndView list(ModelAndView mav) {

		mav.setViewName("/shop/product_list");
		mav.addObject("list", productService.listProduct());

		return mav;
	}

	@RequestMapping("detail/{product_id}")
	public ModelAndView detail(@PathVariable int product_id, ModelAndView mav) {
		mav.setViewName("/shop/product_detail");
		mav.addObject("vo", productService.detailProduct(product_id));
		return mav;

	}

	@RequestMapping("write.do")
	public String write() {
		return "shop/product_write";
	}

	@RequestMapping("insert.do")
	public String insert(@ModelAttribute ProductVO vo) {
		String filename = "-";
		if (!vo.getFile1().isEmpty()) {
			filename = vo.getFile1().getOriginalFilename();

			try {
				//String path = "C:/Users/kh/Desktop/workspace/spring02/src/main/webapp/WEB-INF/views/images/";
				String path="C:\\Users\\kh\\Desktop\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\spring02\\WEB-INF\\views\\images\\";
				new File(path).mkdir();
				vo.getFile1().transferTo(new File(path + filename));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		vo.setPicture_url(filename);
		productService.insertProduct(vo);
		return "redirect:/shop/product/list.do";
	}
	
	@RequestMapping("edit/{product_id}")
	public ModelAndView edit(@PathVariable("product_id") int product_id, ModelAndView mav ){
		
		mav.setViewName("shop/product_edit");
		mav.addObject("vo",productService.detailProduct(product_id));
		return mav;
		
		
	}

	
	@RequestMapping("update.do")
	public String update(@ModelAttribute ProductVO vo) {
		String filename = "-";
		if (!vo.getFile1().isEmpty()) {
			filename = vo.getFile1().getOriginalFilename();

			try {
				//String path = "C:/Users/kh/Desktop/workspace/spring02/src/main/webapp/WEB-INF/views/images/";
				String path="C:\\Users\\kh\\Desktop\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\spring02\\WEB-INF\\views\\images\\";
				new File(path).mkdir();
				vo.getFile1().transferTo(new File(path + filename));
			} catch (Exception e) {
				e.printStackTrace();
			}
			vo.setPicture_url(filename);
		}else {
			ProductVO vo2 = productService.detailProduct(vo.getProduct_id());
			vo.setPicture_url(vo2.getPicture_url());
		}
  
		productService.updateProduct(vo);
		return "redirect:/shop/product/list.do";
	}

	@RequestMapping("delete.do")
	public String delete(@RequestParam int product_id){
		
		String filename = productService.fileInfo(product_id);
		if(filename!=null && !filename.equals("-") ){
			String path="C:\\Users\\kh\\Desktop\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\spring02\\WEB-INF\\views\\images\\";
			File file=new File(path+filename);
			
			if(file.exists()){
				file.delete();
			}
		}
         productService.deleteProduct(product_id);
         return "redirect:/shop/product/list.do";
		
		
	}
	
	

}
