package com.example.spring02.controller.chart;

import java.io.FileOutputStream;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring02.service.chart.JFreeChartService;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

@Controller
@RequestMapping("/jchart/")
public class JFreeChartController {
	
	@Inject
	JFreeChartService chartService;
	
	@RequestMapping("chart1.do")
	public void createChart(HttpServletResponse response){
		try { //차트 생성 후 png 이미지로 출력
			JFreeChart chart=chartService.createChart();
             // writeChartAsPNG( 스트림, 차트, 가로, 세로 ) 			
			ChartUtilities.writeChartAsPNG(response.getOutputStream(),chart,900,550);
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}
	}
	
	
	@RequestMapping("chart2")
	public ModelAndView createChart2(HttpServletResponse response){
		 
		String message="";
		try{  
			JFreeChart chart = chartService.createChart();
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream("d:/test.pdf")); 
			document.open();
			Image png= Image.getInstance(ChartUtilities.encodeAsPNG(chart.createBufferedImage(500, 500)));
			document.add(png);
			document.close();
			message="PDF 파일이 생성되었습니다";
			
		}catch(Exception e){
			e.printStackTrace();
			message="PDF 파일이 생성 실패..";
		}
		
		return new ModelAndView("chart/jchart2","message",message); 
		
	}

}
