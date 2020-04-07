package com.freshmall.model;

/**
 * 订单表实体类
 * @author gongwei
 *
 */
public class Buy {
	private int buy_id;//订单表id
	private int adminuser_id;//用户id
	private String buy_sn;//订单编号
	private String buy_price;//订单价格
	private String buy_addtime;//下单时间
	private int buy_status;//订单状态 1、未支付 2、已支付（等待发货） 3、已发货（等待确认收货）4、已确认收货（待评价）5、已评价（完成）
	private String adminuser_username;//用户名称
	private String adminuser_iphone;//用户手机号码
	private String buy_content;//订单内容
	private String buy_message;//订单留言
	private String buy_address;//订单地址
	private int payment_id;//支付方式1、支付宝 2、微信
	private int goods_id;//商品id
	public int getBuy_id() {
		return buy_id;
	}
	public void setBuy_id(int buy_id) {
		this.buy_id = buy_id;
	}
	public int getAdminuser_id() {
		return adminuser_id;
	}
	public void setAdminuser_id(int adminuser_id) {
		this.adminuser_id = adminuser_id;
	}
	public String getBuy_sn() {
		return buy_sn;
	}
	public void setBuy_sn(String buy_sn) {
		this.buy_sn = buy_sn;
	}
	public String getBuy_price() {
		return buy_price;
	}
	public void setBuy_price(String buy_price) {
		this.buy_price = buy_price;
	}
	public String getBuy_addtime() {
		return buy_addtime;
	}
	public void setBuy_addtime(String buy_addtime) {
		this.buy_addtime = buy_addtime;
	}
	public int getBuy_status() {
		return buy_status;
	}
	public void setBuy_status(int buy_status) {
		this.buy_status = buy_status;
	}
	public String getAdminuser_username() {
		return adminuser_username;
	}
	public void setAdminuser_username(String adminuser_username) {
		this.adminuser_username = adminuser_username;
	}
	public String getAdminuser_iphone() {
		return adminuser_iphone;
	}
	public void setAdminuser_iphone(String adminuser_iphone) {
		this.adminuser_iphone = adminuser_iphone;
	}
	public String getBuy_content() {
		return buy_content;
	}
	public void setBuy_content(String buy_content) {
		this.buy_content = buy_content;
	}
	public String getBuy_message() {
		return buy_message;
	}
	public void setBuy_message(String buy_message) {
		this.buy_message = buy_message;
	}
	public String getBuy_address() {
		return buy_address;
	}
	public void setBuy_address(String buy_address) {
		this.buy_address = buy_address;
	}
	public int getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
}
