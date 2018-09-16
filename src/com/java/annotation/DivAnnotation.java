package com.java.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 */

//元注解
@Target(value = {ElementType.TYPE}) //指定该注解作用范围：类，属性，方法...
@Retention(value = RetentionPolicy.RUNTIME) //描述注解的周期: SOURCE,CLASS,RUNTIME
//注解 @interface+注解名( 注解体 ) 1.当注解体只有一个时，注解体名使用value 2，Defulte表示默认参数
public @interface DivAnnotation {

	String value();//注解体
}
