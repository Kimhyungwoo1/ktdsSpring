package com.naver.cafe.common;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(METHOD)
public @interface Auth {

	String value() default "";
	//String[] value() default "";		//권한을 여러개 주고싶으면 배열로 만들어야 한다.
	
}
