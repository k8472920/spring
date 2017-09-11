package com.example.spring02.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component // 스프링에서 관리하는 bean 객체
@Aspect // 횡단관심(공통업무)을 지원하는 클래스
public class LogAdvice {
	private static final Logger logger = LoggerFactory.getLogger(LogAdvice.class);

	// JoinPoint : method가 호출되는 시점
	// @Before(전처리), @After(후처리), @Around(전후처리)
	@Around("execution(* com.example.spring02.controller..*Controller.*(..))"
			+ " or execution(* com.example.spring02.service..*Impl.*(..))"
			+ " or execution(* com.example.spring02.model..dao.*Impl.*(..))")

	public Object logPrint(ProceedingJoinPoint joinPoint) throws Throwable {
		// 요청 전에 처리할 코드
		long start = System.currentTimeMillis();
		// 메인 코드(핵심업무, 종단관심)
		Object result = joinPoint.proceed();
		// 메인 코드가 끝난 후에 처리할 코드
		// 핵심업무를 실행한 클래스와 method의 정보 확인
		String type = joinPoint.getSignature().getDeclaringTypeName();
		String name = "";
		if (type.indexOf("Controller") > -1) {
			name = "컨트롤러 :";
		} else if (type.indexOf("Service") > -1) {
			name = "서비스 :";
		} else if (type.indexOf("DAO") > -1) {
			name = "모델 :";
	 	}
		long end = System.currentTimeMillis();
		long time = end - start;
		logger.info(name+type+":실행시간:"+time);
		// method name
		// logger.info(
		// name + type + "."
		// + joinPoint.getSignature().getName()
		// + "()");
		// 매개변수
		// logger.info(Arrays.toString(joinPoint.getArgs()));
		// logger.info("실행시간:"+time);
		// 후처리
		return result;
	}
}
