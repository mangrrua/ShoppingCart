package com.oguzhanmangir.shoppingcart.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


//@Aspect
//@Component
public class LoggingAspect {
	
	@Pointcut ("execution (* com.oguzhanmangir.shoppingcart.dao.impl.*.*(..))")
	public void daoLayer() {}
	
	@Pointcut("execution (* com.oguzhanmangir.shoppingcart.service.impl.*.*(..))")
	public void serviceLayer() {}
	
	@Pointcut("execution (* com.oguzhanmangir.shoppingcart.controller.*.*(..))")
	public void controllerLayer() {}
	
}
