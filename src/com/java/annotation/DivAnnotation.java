package com.java.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * �Զ���ע��
 */

//Ԫע��
@Target(value = {ElementType.TYPE}) //ָ����ע�����÷�Χ���࣬���ԣ�����...
@Retention(value = RetentionPolicy.RUNTIME) //����ע�������: SOURCE,CLASS,RUNTIME
//ע�� @interface+ע����( ע���� ) 1.��ע����ֻ��һ��ʱ��ע������ʹ��value 2��Defulte��ʾĬ�ϲ���
public @interface DivAnnotation {

	String value();//ע����
}
