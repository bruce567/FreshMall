package com.freshmall.model;

/**
 * 商品表实体类
 * @author gongwei
 *
 */
public class Goods {
	private int goods_id;//商品表id
	private int shop_id;//店铺表id
	private int goodstype_id;//商品类型表id
	private String goods_name;//商品名称
	private String goods_images;//商品图片
	private String goods_price;//商品价格
	private String goods_content;//商品内容
	private int goods_num;//商品数量
	private String goods_addtime;//商品添加数量
	
	private int goods_promote;//促销类型 1、正常 2、限时抢购
	private String goods_starttime;//抢购开始时间
	private String goods_endtime;//抢购结束时间
	
	private String shop_name;//店铺名称(模型类字段)
	private String goodstype_name;//商品类型名称(模型类字段)
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public int getShop_id() {
		return shop_id;
	}
	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}
	public int getGoodstype_id() {
		return goodstype_id;
	}
	public void setGoodstype_id(int goodstype_id) {
		this.goodstype_id = goodstype_id;
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
	public String getGoods_content() {
		return goods_content;
	}
	public void setGoods_content(String goods_content) {
		this.goods_content = goods_content;
	}
	public int getGoods_num() {
		return goods_num;
	}
	public void setGoods_num(int goods_num) {
		this.goods_num = goods_num;
	}
	public String getGoods_addtime() {
		return goods_addtime;
	}
	public void setGoods_addtime(String goods_addtime) {
		this.goods_addtime = goods_addtime;
	}
	public String getShop_name() {
		return shop_name;
	}
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
	public String getGoodstype_name() {
		return goodstype_name;
	}
	public void setGoodstype_name(String goodstype_name) {
		this.goodstype_name = goodstype_name;
	}
	public int getGoods_promote() {
		return goods_promote;
	}
	public void setGoods_promote(int goods_promote) {
		this.goods_promote = goods_promote;
	}
	public String getGoods_starttime() {
		return goods_starttime;
	}
	public void setGoods_starttime(String goods_starttime) {
		this.goods_starttime = goods_starttime;
	}
	public String getGoods_endtime() {
		return goods_endtime;
	}
	public void setGoods_endtime(String goods_endtime) {
		this.goods_endtime = goods_endtime;
	}
}
