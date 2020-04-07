package com.freshmall.model;

/**
 * 商品评价表
 * @author gongwei
 *
 */
public class Goodsevaluate {
	private int goodsevaluate_id;//评价表id
	private int adminuser_id;//用户id
	private int goods_id;//商品id
	private int goodsevaluate_star;//评价星级
	private String goodsevaluate_content;//评价内容
	private String goodsevaluate_addtime;//评价时间
	
	private String adminuser_username;//用户名称(模型类字段)
	private String goods_name;//商品名称(模型类字段)
	public int getGoodsevaluate_id() {
		return goodsevaluate_id;
	}
	public void setGoodsevaluate_id(int goodsevaluate_id) {
		this.goodsevaluate_id = goodsevaluate_id;
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
	public int getGoodsevaluate_star() {
		return goodsevaluate_star;
	}
	public void setGoodsevaluate_star(int goodsevaluate_star) {
		this.goodsevaluate_star = goodsevaluate_star;
	}
	public String getGoodsevaluate_content() {
		return goodsevaluate_content;
	}
	public void setGoodsevaluate_content(String goodsevaluate_content) {
		this.goodsevaluate_content = goodsevaluate_content;
	}
	public String getGoodsevaluate_addtime() {
		return goodsevaluate_addtime;
	}
	public void setGoodsevaluate_addtime(String goodsevaluate_addtime) {
		this.goodsevaluate_addtime = goodsevaluate_addtime;
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
}
