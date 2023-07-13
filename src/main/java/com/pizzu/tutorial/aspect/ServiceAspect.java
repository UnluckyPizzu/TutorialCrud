package com.pizzu.tutorial.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.pizzu.tutorial.model.Tutorial;

@Aspect
@Component
public class ServiceAspect {
	
	
	@Pointcut("execution(* com.pizzu.tutorial.service.*.findAll*(..))")
	public void forFindAllServicePointcuts() {}
	
	
	@Pointcut("execution(* com.pizzu.tutorial.service.*.*(..))")
	public void forServicePointcuts() {}
	
	@Before("forServicePointcuts()")
	public void beforeLogging(JoinPoint jointPoint) {
		
		MethodSignature signature = (MethodSignature) jointPoint.getSignature();
		Object[] args = jointPoint.getArgs();
		System.out.println("Method: " + signature);
		
		if(args.length != 0)
			System.out.println("Parametri: ");
		
		for (Object object : args) {
			System.out.println(object.toString());
		}
	}
	
	@AfterReturning(pointcut = "forFindAllServicePointcuts()", returning = "tutorials")
	public void afterLogging(JoinPoint jointPoint, List<Tutorial> tutorials) {
		
		MethodSignature signature = (MethodSignature) jointPoint.getSignature();
		
		if(!tutorials.isEmpty())
			System.out.println("Return: ");
		
		for (Tutorial tutorial : tutorials) {
			System.out.println(tutorial.toString());
		}
	}

}
