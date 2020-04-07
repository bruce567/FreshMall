package com.freshmall.model;

import java.util.List;

/**
 * 商品类型表实体类
 * @author gongwei
 *
 */
public class Goodstype {
	private int goodstype_id;//商品类型表id
	private String goodstype_name;//商品类型名称
	private List<Goods> goodslist;//商品列表
	public int getGoodstype_id() {
		return goodstype_id;
	}
	public void setGoodstype_id(int goodstype_id) {
		this.goodstype_id = goodstype_id;
	}
	public String getGoodstype_name() {
		return goodstype_name;
	}
	public void setGoodstype_name(String goodstype_name) {
		this.goodstype_name = goodstype_name;
	}
	public List<Goods> getGoodslist() {
		return goodslist;
	}
	public void setGoodslist(List<Goods> goodslist) {
		this.goodslist = goodslist;
	}
	
}
