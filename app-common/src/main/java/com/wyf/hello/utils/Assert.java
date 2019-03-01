/**
 * 
 */
package com.wyf.hello.utils;

import java.util.*;

/**
 *
 */
public abstract class Assert {

	public static void isTrue(boolean expression, String message) {
		if (!expression) {
			throw new IllegalArgumentException(message);
		}
	}
	

	public static void notNull(Object object, String message) {
		if (object == null) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void noLessZero(Long[] text,String message){
		boolean flag = false;
		for(Long one:text){
			if(one<=0)
				flag=true;
		}
		if(flag){
			throw new IllegalArgumentException(message);
		}
	}
	
	public static void noLessZero(Long... text){
		noLessZero(text, "Illegal parameters");
	}
	
	
	public static void hasLength(String... text) {
		hasLength(text, "Illegal parameters;it cannot be null,empty,or blank");
	}
	
	public static void hasLength(String[] text,String message) {
		if (!StringUtil.isAnyBlank(text)) {
			throw new IllegalArgumentException(message);
		}
	}


	public static void notEmpty(Object[] array, String message) {
		if (array == null || array.length == 0) {
			throw new IllegalArgumentException(message);
		}
	}

	
	public static void notEmpty(Collection collection, String message) {
		if (collection == null || collection.isEmpty()) {
			throw new IllegalArgumentException(message);
		}
	}
	

	public static void notEmpty(Map map, String message) {
		if (map == null || map.isEmpty()) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void main(String[] args) {
		Map aa  = new HashMap();
		List bb = new ArrayList<>();
	}

}
