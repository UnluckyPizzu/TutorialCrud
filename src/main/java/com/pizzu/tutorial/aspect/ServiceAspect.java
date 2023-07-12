package com.pizzu.tutorial.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {
	
	@Pointcut("execution(* com.pizzu.tutorial.service.*(..))")
	public void forServicePointcuts() {}
	
	@Before("forServicePointcuts()")
	public void beforeLogging( ) {
		System.out.println("prova");
	}

}
