package com.blueRibbon.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.blueRibbon.common.service.CommonService;

@Component
@Aspect
public class CommonAspect {
	
	@Autowired
	private CommonService commonService;
	
	@Value("${page.size}")
	private int pageSize;
	
	@Value("${multimediaPage.size}")
	private int multimediaPageSize;
	
	@Around("execution(* com.blueRibbon.*.controller..*.*(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		Object user = request.getSession().getAttribute("user");
		
		Object[] args = joinPoint.getArgs();		
		for(Object obj : args) {
            if(obj instanceof Model) {
            	((Model) obj).addAttribute("pageSize", pageSize);
            	
            	if(user != null) {
            		((Model) obj).addAttribute("user", commonService.getUser(user));
            	}
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
