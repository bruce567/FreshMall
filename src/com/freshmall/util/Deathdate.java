package com.freshmall.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Deathdate {

	public static void main(String[] args) throws ParseException {
		int day = caculateTotalTime("2019-11-20", "2019-11-20");
		System.out.println("day:"+day);
	}


	/**
	 * 指定日期加上天数后的日期
	 * @param num 为增加的天数
	 * @param newDate 创建时间
	 * @return
	 * @throws ParseException 
	 */
	public static String plusDay(int day, String newDate) throws Exception{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(newDate);
		long time = date.getTime(); // 得到指定日期的毫秒数
		day = day * 24 * 60 * 60 * 1000; // 要加上的天数转换成毫秒数
		time += day; // 相加得到新的毫秒数
		
		Date date1 = new Date(time);// 将毫秒数转换成日期
		String enddate = format.format(date1);
		return enddate;
	}

	/**
	 * 指定日期加上天数后的日期
	 * @param num 为增加的天数
	 * @param newDate 创建时间
	 * @return
	 * @throws ParseException 
	 */
	//	public static String plusDay(int num,String newDate) throws Exception {
	//		System.out.println("num:"+num);
	//		System.out.println("newDate:"+newDate);
	//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	//		Date d = format.parse(newDate);
	//		String currdate = format.format(d);
	//		System.out.println("现在的日期是：" + currdate);
	//
	//		Calendar ca = Calendar.getInstance();
	//		ca.add(Calendar.DATE, num);// num为增加的天数，可以改变的
	//		d = ca.getTime();
	//		String enddate = format.format(d);
	//		System.out.println("增加天数以后的日期：" + enddate);
	//		return enddate;
	//	}


	//当前日期加上天数：


	/**
	 * 当前日期加上天数后的日期
	 * @param num 为增加的天数
	 * @return
	 */
	public static String plusDay2(int num){
		Date d = new Date();
		//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String currdate = format.format(d);
		System.out.println("现在的日期是：" + currdate);

		Calendar ca = Calendar.getInstance();
		ca.add(Calendar.DATE, num);// num为增加的天数，可以改变的
		d = ca.getTime();
		String enddate = format.format(d);
		System.out.println("增加天数以后的日期：" + enddate);
		return enddate;
	}

	//给定开始时间和结束时间计算之间的天数
	public static int caculateTotalTime(String startTime,String endTime) throws ParseException{
		SimpleDateFormat formatter =   new SimpleDateFormat( "yyyy-MM-dd" );
		Date date1=null;
		Date date = formatter.parse(startTime);
		long ts = date.getTime();
		date1 =  formatter.parse(endTime);
		long ts1 = date1.getTime();
		long ts2=ts1-ts;
		int totalTime = 0;
		totalTime=(int) (ts2/(24*3600*1000)+1);		
		return totalTime;	
	}



}