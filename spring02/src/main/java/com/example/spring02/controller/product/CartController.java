package com.example.spring02.controller.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring02.model.shop.vo.CartVO;
import com.example.spring02.service.shop.CartService;

@Controller
@RequestMapping("/shop/cart/")
public class CartController {

	private static final Logger logger = LoggerFactory.getLogger(CartController.class);
	
	@Inject
	CartService cartService;
	
	@RequestMapping("insert.do")
	public String insert(@ModelAttribute CartVO vo, HttpSession session){
		
		String userid = (String) session.getAttribute("userid");
		
		/*if(userid==null){
			return "redirect:/member/login.do ";
		}*/
		vo.setUserid(userid);
		cartService.insert(vo);
		return "redirect:/shop/cart/list.do";
		
	}
	
	@RequestMapping("list.do")
	public ModelAndView list(HttpSession session, ModelAndView mav){
		 Map<String, Object> map = new HashMap<>();
		 String userid= (String) session.getAttribute("userid");
		 
		 if( userid != null){
		 List<CartVO> list =cartService.listCart(userid);
		 int sumMoney=cartService.sumMoney(userid);
		 int fee=sumMoney>=30000 ? 0 : 2500;
		 map.put("sumMoney", sumMoney);
		 map.put("fee", fee);
		 map.put("sum", sumMoney+fee);
		 
		 map.put("list", list);
		 map.put("count", list.size());
		 mav.setViewName("/shop/cart_list");
		 mav.addObject("map",map);
		 return mav;
		 }else{
			 return new ModelAndView("member/login","",null);
		 }
	}
	
	@RequestMapping("delete.do")
	public String delete(@RequestParam int cart_id){
		
		cartService.delete(cart_id);
        return "redirect:/shop/cart/list.do";
		
		
	}
	
	@RequestMapping("deleteAll.do")
	public String deleteAll(HttpSession session){
		
		String userid= (String) session.getAttribute("userid");
		
		if(userid!=null){
			cartService.deleteAll(userid);
		}
		return "redirect:/shop/cart/list.do";
		
		
	}
	
	@RequestMapping("update.do")
	public String update(@RequestParam int[] amount,@RequestParam int[] product_id,HttpSession session ){

		String userid= (String) session.getAttribute("userid");
		for(int i=0; i<product_id.length; i++){
			 CartVO vo=new CartVO();
			 vo.setUserid(userid);
			 vo.setAmount(amount[i]);
			 vo.setProduct_id(product_id[i]);
             cartService.modifyCart(vo);
		}
         		
		return "redirect:/shop/cart/list.do";
	}
	

	
	
	
	
	
	
	
}
