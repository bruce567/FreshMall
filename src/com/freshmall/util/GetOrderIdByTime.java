package com.freshmall.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 生成唯一订单号
 * @author Administrator
 *
 */
public class GetOrderIdByTime {
	
	//高并发性下，确保订单的唯一性，可以把用户id加进去
	
	public static String getOrderIdByTime(String user_id) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		String newDate=sdf.format(new Date());
		String result="";
		Random random=new Random();
		for(int i=0;i<3;i++){
			result+=random.nextInt(10);
			}
		return newDate+user_id+result;
	}
}
