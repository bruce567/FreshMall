package com.freshmall.model;

/**
 * 购物车表实体类
 * @author gongwei
 *
 */
public class Cart {
	private int cart_id;//购物车表id
	private int adminuser_id;//用户id
	private int goods_id;//商品id
	private int cart_addnum;//加入数量
	private String cart_addtime;//加入购物车时间
	private String cart_price;//加入价格
	
	private String adminuser_username;//用户名称
	private String goods_name;//商品名称
	private String goods_images;//商品图片
	private String goods_price;//商品价格
	
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public int getAdminuser_id() {
		return adminuser_id;
	}
	public void setAdminuser_id(int adminuser_id) {
		this.adminuser_id = adminuser_id;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public int getCart_addnum() {
		return cart_addnum;
	}
	public void setCart_addnum(int cart_addnum) {
		this.cart_addnum = cart_addnum;
	}
	public String getCart_addtime() {
		return cart_addtime;
	}
	public void setCart_addtime(String cart_addtime) {
		this.cart_addtime = cart_addtime;
	}
	public String getAdminuser_username() {
		return adminuser_username;
	}
	public void setAdminuser_username(String adminuser_username) {
		this.adminuser_username = adminuser_username;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public String getGoods_images() {
		return goods_images;
	}
	public void setGoods_images(String goods_images) {
		this.goods_images = goods_images;
	}
	public String getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(String goods_price) {
		this.goods_price = goods_price;
	}
	public String getCart_price() {
		return cart_price;
	}
	public void setCart_price(String cart_price) {
		this.cart_price = cart_price;
	}
}
