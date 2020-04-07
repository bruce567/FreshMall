package com.freshmall.model;

/**
 * 优惠券表实体类
 * @author gongwei
 *
 */
public class Coupon {
	private int coupon_id;//优惠券表id
	private int coupon_type;//优惠券类型 1、平台优惠券 2、店铺优惠券
	private int shop_id;//店铺id
	private String coupon_name;//优惠券名称
	private int coupon_num;//优惠券数量
	private String coupon_price;//优惠券价值
	private String coupon_endtime;//优惠券截止日期
	private String shop_name;//店铺名称
	public int getCoupon_id() {
		return coupon_id;
	}
	public void setCoupon_id(int coupon_id) {
		this.coupon_id = coupon_id;
	}
	public int getCoupon_type() {
		return coupon_type;
	}
	public void setCoupon_type(int coupon_type) {
		this.coupon_type = coupon_type;
	}
	public int getShop_id() {
		return shop_id;
	}
	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}
	public String getCoupon_name() {
		return coupon_name;
	}
	public void setCoupon_name(String coupon_name) {
		this.coupon_name = coupon_name;
	}
	public int getCoupon_num() {
		return coupon_num;
	}
	public void setCoupon_num(int coupon_num) {
		this.coupon_num = coupon_num;
	}
	public String getCoupon_price() {
		return coupon_price;
	}
	public void setCoupon_price(String coupon_price) {
		this.coupon_price = coupon_price;
	}
	public String getCoupon_endtime() {
		return coupon_endtime;
	}
	public void setCoupon_endtime(String coupon_endtime) {
		this.coupon_endtime = coupon_endtime;
	}
	public String getShop_name() {
		return shop_name;
	}
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
}
