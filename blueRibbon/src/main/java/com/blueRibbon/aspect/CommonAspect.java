package com.blueRibbon.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Component
@Aspect
public class CommonAspect {
	
	@Value("${page.size}")
	private int pageSize;
	
	@Value("${multimediaPage.size}")
	private int multimediaPageSize;
	
	@Around("execution(* com.blueRibbon.*.controller..*.*(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		Object[] args = joinPoint.getArgs();
		
		for(Object obj : args) {
            if(obj instanceof Model) {
            	((Model) obj).addAttribute("pageSize", pageSize);
            }
        }
		
		return joinPoint.proceed(args);
	}
	
	@Around("execution(* com.blueRibbon.multimedia.controller..*.*(..))")
	public Object multimediaAround(ProceedingJoinPoint joinPoint) throws Throwable {
		Object[] args = joinPoint.getArgs();
		
		for(Object obj : args) {
			if(obj instanceof Model) {
				((Model) obj).addAttribute("pageSize", multimediaPageSize);
			}
		}
		
		return joinPoint.proceed(args);
	}
	
}
