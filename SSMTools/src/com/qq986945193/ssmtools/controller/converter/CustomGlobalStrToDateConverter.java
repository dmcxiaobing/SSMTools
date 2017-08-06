package com.qq986945193.ssmtools.controller.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
/**
 * 这是一个字符串转换为时间的converter
 * @author DAVID
 *S, source 源
 *T target 目标
 */
public class CustomGlobalStrToDateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		try {
			Date date = new SimpleDateFormat("yyyy:MM:dd hh:mm:ss").parse(source);
			return date;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
