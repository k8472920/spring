package com.example.spring02.controller.chart;

import javax.inject.Inject;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring02.service.chart.GoogleChartService;

@RestController
//@Controller
@RequestMapping("/chart/")
public class GoogleChartController {

	@Inject
	GoogleChartService googleChartService;
	
	
	@RequestMapping("chart1.do")
	public ModelAndView chart1(){
		
		return new ModelAndView("chart/chart1");
	}
	
	@RequestMapping("chart2.do")
	public ModelAndView chart2(){
		
		return new ModelAndView("chart/chart2");
	}
	
	@RequestMapping("cart_money_list.do")
	//@ResponseBody
	public JSONObject cart_money_list(){
		
		return googleChartService.getChartData();
	}
	
}
