package com.java.annotation;

/**
 * java�е�����ע��/Ԫע��
 *
 */
public class Annotation {

	//���η�����ע�⣬��д���෽��
	@Override 
	public String toString() {
		return super.toString();
	}
	
	//���η�����ע�⣬��ʾ�÷���������ʹ��(������)
	@Deprecated 
	public void toInt(){
		
	}
	
	//���η�����ע�⣬��ʾǿ��ѹ�Ʊ���ľ�����Ϣ��value�������ֵ
	@SuppressWarnings(value = { }) 
	public void toSuper(){
		
	}

}

