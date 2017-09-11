package com.example.spring02.service.chart;

import java.util.List;

import javax.inject.Inject;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.spring02.model.shop.vo.CartVO;
import com.example.spring02.service.shop.CartService;

@Service
public class GoogleChartServiceImpl implements GoogleChartService {

	private static final Logger logger = LoggerFactory.getLogger(GoogleChartServiceImpl.class);
	
	@Inject
	CartService cartService;
	
	@Override
	public JSONObject getChartData() {
		List<CartVO> items=cartService.cartMoney();
		logger.info("items:"+items);
		//리턴할 json 객체
		JSONObject data=new JSONObject();
		//컬럼 구성
		JSONObject col1=new JSONObject();
		JSONObject col2=new JSONObject();
		JSONArray title=new JSONArray();
		col1.put("label", "상품명"); //key,value
		col1.put("type", "string");
		col2.put("label", "금액"); //컬럼이름
		col2.put("type", "number"); //컬럼 자료형
		title.add(col1); 
		title.add(col2);
		data.put("cols", title); //컬럼 객체 추가
		
		JSONArray body=new JSONArray(); //실제 데이터
		for(CartVO vo : items){
			JSONObject name=new JSONObject();
			name.put("v", vo.getProduct_name());
			JSONObject money=new JSONObject();
			money.put("v", vo.getMoney());
			JSONArray row=new JSONArray();
			row.add(name); 
			row.add(money);
			JSONObject cell=new JSONObject();
			cell.put("c", row); //셀 추가
			body.add(cell); //row(레코드) 1개 추가
		}
		data.put("rows", body);
		return data;
	}

}
