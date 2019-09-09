package com.jzy.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMapping;

public class Utils {

	@RequestMapping("toTest.do")
	public String toTest() {
		return "test";
	}
	
	@Test
	@RequestMapping("test.do")
	public void toHtml(String str) {
		
		//创建一个StringBuffer
		StringBuffer stringBuffer = null;
		
		//如果有\n\r
		if (str.contains("(\n\r)")) {
			stringBuffer.append("<p>");
			//如果有\r
			stringBuffer.append(str);
			if (str.contains("(\r)")) {
				stringBuffer.append("<br/>");
			}
			stringBuffer.append("</p>");
		}
		
		System.out.println("---"+stringBuffer+"---");
		
	}
	
	@RequestMapping("isPhone")
	public Object isPhone(String phone) {
		//正则表达式
		Pattern pattern = Pattern.compile("1[3|5|7|8|9][0-9]{9}");
		Matcher matcher = pattern.matcher(phone);
		
		//验证 正则是正确
		if (matcher.matches()) {
			return true;
		} else {
			return false;
		}
		
	}
	
	@RequestMapping("isEmail")
	public Object isEmail(String email) {

		//正则表达式
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]+@[a-zA-Z0-9]{2,3}\\.[a-zA-Z]{2,}");
		Matcher matcher = pattern.matcher(email);

		//验证 正则是正确
		if (matcher.matches()) {
			return true;
		} else {
			return false;
		}
		
	}
	
}
