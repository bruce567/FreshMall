package com.freshmall.model;

/**
 * 店铺表实体类
 * @author gongwei
 *
 */
public class Shop {
	private int shop_id;//店铺表id
	private String shop_name;//店铺名称
	private String shop_images;//店铺封面
	private String shop_content;//店铺介绍
	private String shop_addtime;//店铺添加时间
	private String shop_opentime;//店铺营业时间
	private String shop_address;//店铺地址
	private String shop_iphone;//店铺电话
	public int getShop_id() {
		return shop_id;
	}
	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}
	public String getShop_name() {
		return shop_name;
	}
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
	public String getShop_images() {
		return shop_images;
	}
	public void setShop_images(String shop_images) {
		this.shop_images = shop_images;
	}
	public String getShop_content() {
		return shop_content;
	}
	public void setShop_content(String shop_content) {
		this.shop_content = shop_content;
	}
	public String getShop_addtime() {
		return shop_addtime;
	}
	public void setShop_addtime(String shop_addtime) {
		this.shop_addtime = shop_addtime;
	}
	public String getShop_opentime() {
		return shop_opentime;
	}
	public void setShop_opentime(String shop_opentime) {
		this.shop_opentime = shop_opentime;
	}
	public String getShop_address() {
		return shop_address;
	}
	public void setShop_address(String shop_address) {
		this.shop_address = shop_address;
	}
	public String getShop_iphone() {
		return shop_iphone;
	}
	public void setShop_iphone(String shop_iphone) {
		this.shop_iphone = shop_iphone;
	}
}
