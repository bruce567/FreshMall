package com.freshmall.util;

import org.apache.http.util.TextUtils;

/**
 * 验证是否符合手机号码格式
 * @author Administrator
 *
 */
public class CheckIphoneUtil {
	/**
	 * 验证是否是手机号码
	 * @param mobiles
	 * @return
	 */
	public static boolean isMobileNO(String mobiles) {
        String telRegex = "[1][3456789]\\d{9}";
        // "[1]"代表第1位为数字1，"[3456789]"代表第二位可以为3456789中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(mobiles)) {
            return false;
        } else {
        	return mobiles.matches(telRegex);
        }
    }
	
	/**
	 * 验证是否是QQ号码
	 * @param qq
	 * @return
	 */
	public static boolean isQQNO(String qq) {
		return qq.matches("[1-9][0-9]{4,11}");
	}
}
