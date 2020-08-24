package com.oksoft.utils;

import org.springframework.stereotype.Component;

@Component
public class PwdUtils {

   private static final String ALPHA_NUMERIC_STR="ABCDEFGHIJKLMNOPQRSTTUVWXYZ0123456789";
	
	public static String generateTempPwd(Integer count) {
		StringBuilder builder=new StringBuilder();
		
		while(count--!=0) {
			Integer character= (int) (Math.random()*ALPHA_NUMERIC_STR.length());
			 builder.append(ALPHA_NUMERIC_STR.charAt(character));
		}
		return builder.toString();
	}
}
