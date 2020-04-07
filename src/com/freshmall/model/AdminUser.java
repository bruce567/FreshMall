package com.freshmall.model;

/**
 * 用户表实体类
 * @author Administrator
 *
 */
public class AdminUser {
	private int adminuser_id;//用户表id
	private String adminuser_sn;//用户编号
	private String adminuser_username;//用户姓名
	private String adminuser_password;//用户登录密码
	private int adminuser_sex;//用户性别 1、男 0、女
	private int adminuser_age;//用户年龄
	private String adminuser_iphone;//用户手机号码
	private String adminuser_email;//用户邮箱地址
	private String adminuser_lastertime;//用户最近登录时间
	private String adminuser_lasterip;//用户最近登录所使用的ip
	private String adminuser_registertime;//用户注册时间
	private int adminuser_status;//用户状态 1、正常 2、锁定
	private int role_id;//用户角色 1、管理员 2、用户  3、店长
	private String adminuser_image;//用户照片
	public int getAdminuser_id() {
		return adminuser_id;
	}
	public void setAdminuser_id(int adminuser_id) {
		this.adminuser_id = adminuser_id;
	}
	public String getAdminuser_sn() {
		return adminuser_sn;
	}
	public void setAdminuser_sn(String adminuser_sn) {
		this.adminuser_sn = adminuser_sn;
	}
	public String getAdminuser_username() {
		return adminuser_username;
	}
	public void setAdminuser_username(String adminuser_username) {
		this.adminuser_username = adminuser_username;
	}
	public String getAdminuser_password() {
		return adminuser_password;
	}
	public void setAdminuser_password(String adminuser_password) {
		this.adminuser_password = adminuser_password;
	}
	public int getAdminuser_sex() {
		return adminuser_sex;
	}
	public void setAdminuser_sex(int adminuser_sex) {
		this.adminuser_sex = adminuser_sex;
	}
	public int getAdminuser_age() {
		return adminuser_age;
	}
	public void setAdminuser_age(int adminuser_age) {
		this.adminuser_age = adminuser_age;
	}
	public String getAdminuser_iphone() {
		return adminuser_iphone;
	}
	public void setAdminuser_iphone(String adminuser_iphone) {
		this.adminuser_iphone = adminuser_iphone;
	}
	public String getAdminuser_email() {
		return adminuser_email;
	}
	public void setAdminuser_email(String adminuser_email) {
		this.adminuser_email = adminuser_email;
	}
	public String getAdminuser_lastertime() {
		return adminuser_lastertime;
	}
	public void setAdminuser_lastertime(String adminuser_lastertime) {
		this.adminuser_lastertime = adminuser_lastertime;
	}
	public String getAdminuser_lasterip() {
		return adminuser_lasterip;
	}
	public void setAdminuser_lasterip(String adminuser_lasterip) {
		this.adminuser_lasterip = adminuser_lasterip;
	}
	public String getAdminuser_registertime() {
		return adminuser_registertime;
	}
	public void setAdminuser_registertime(String adminuser_registertime) {
		this.adminuser_registertime = adminuser_registertime;
	}
	public int getAdminuser_status() {
		return adminuser_status;
	}
	public void setAdminuser_status(int adminuser_status) {
		this.adminuser_status = adminuser_status;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getAdminuser_image() {
		return adminuser_image;
	}
	public void setAdminuser_image(String adminuser_image) {
		this.adminuser_image = adminuser_image;
	}
}
