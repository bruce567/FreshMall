package com.freshmall.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.freshmall.model.Coupon;
import com.freshmall.model.PageBean;

/**
 * 优惠券实现类
 * @author gongwei
 *
 */
public class CouponDao {
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return namedParameterJdbcTemplate;
	}

	public void setNamedParameterJdbcTemplate(
			NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public int addCoupon(Coupon coupon) {
		String sql = "INSERT INTO freshmall_coupon(coupon_type,shop_id,coupon_name,coupon_num,"
				+ "coupon_price,coupon_endtime,shop_name) " +
				"VALUES(:coupon_type,:shop_id,:coupon_name,:coupon_num,"
				+ ":coupon_price,:coupon_endtime,:shop_name)";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("coupon_type", coupon.getCoupon_type());
		sps.addValue("shop_id", coupon.getShop_id());
		sps.addValue("coupon_name", coupon.getCoupon_name());
		sps.addValue("coupon_num", coupon.getCoupon_num());
		sps.addValue("coupon_price", coupon.getCoupon_price());
		sps.addValue("coupon_endtime", coupon.getCoupon_endtime());
		sps.addValue("shop_name", coupon.getShop_name());
		KeyHolder keyholder = new GeneratedKeyHolder();
		namedParameterJdbcTemplate.update(sql, sps, keyholder);
		// 加上KeyHolder这个参数可以得到添加后主键的值
		int m = keyholder.getKey().intValue();
		return m;
	}

	public int updateCoupon(Coupon coupon) {
		String sql = "update freshmall_coupon set coupon_type=:coupon_type,shop_id=:shop_id,"
				+ "coupon_name=:coupon_name,coupon_num=:coupon_num,coupon_price=:coupon_price,"
				+ "coupon_endtime=:coupon_endtime,shop_name=:shop_name where coupon_id=:coupon_id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("coupon_type", coupon.getCoupon_type());
		sps.addValue("shop_id", coupon.getShop_id());
		sps.addValue("coupon_name", coupon.getCoupon_name());
		sps.addValue("coupon_num", coupon.getCoupon_num());
		sps.addValue("coupon_price", coupon.getCoupon_price());
		sps.addValue("coupon_endtime", coupon.getCoupon_endtime());
		sps.addValue("shop_name", coupon.getShop_name());
		sps.addValue("coupon_id", coupon.getCoupon_id());
		return namedParameterJdbcTemplate.update(sql, sps);
	}
	
	public int deleteCoupon(int coupon_id) {
		String sql = "delete from freshmall_coupon where coupon_id=:coupon_id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("coupon_id", coupon_id);
		return namedParameterJdbcTemplate.update(sql, sps);
	}
	
	public List<Coupon> findCouponByPage(Coupon coupon, PageBean pageBean) {
		String sql = "select * from freshmall_coupon limit " + pageBean.getStart()
		+ "," + pageBean.getPageSize() + "";
		List<Coupon> CouponList = namedParameterJdbcTemplate.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Coupon>(Coupon.class));
		return CouponList;
	}

	public int CouponCount(Coupon coupon) {
		String sql = "select count(*) total from freshmall_coupon";
		int totals = 0;
		MapSqlParameterSource sps = new MapSqlParameterSource();
		totals = (int) namedParameterJdbcTemplate.queryForLong(sql, sps);
		return totals;
	}
	
	/**
	 * 根据条件查询商品信息
	 * @param searchType
	 * @param searchvalue
	 * @param pageBean
	 * @return
	 */
	public List<Coupon> findCouponBySearchPage(String searchType, String searchvalue, PageBean pageBean) {
		String sql = null;
		if (searchType.equals("couponname")) {//如果搜索类型为按商品名称搜索
			sql = "select * from freshmall_coupon where coupon_name like '%"+searchvalue+"%' limit " + pageBean.getStart()
					+ "," + pageBean.getPageSize() + "";
		}
		List<Coupon> CouponList = namedParameterJdbcTemplate.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Coupon>(Coupon.class));
		return CouponList;
	}

	/**
	 * 根据条件查询商品数量
	 * @param searchType
	 * @param searchvalue
	 * @return
	 */
	public int CouponCountBySearch(String searchType, String searchvalue) {
		MapSqlParameterSource sps = new MapSqlParameterSource();
		String sql = null;
		if (searchType.equals("couponname")) {
			sql = "select count(*) total from freshmall_coupon where coupon_name like '%"+searchvalue+"%'";
		}
		int totals = 0;
		totals = (int) namedParameterJdbcTemplate.queryForLong(sql, sps);
		return totals;
	}

	public List<Coupon> findCoupons(Coupon Coupon) {
		String sql = "select * from freshmall_coupon ";
		List<Coupon> CouponList = namedParameterJdbcTemplate.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Coupon>(Coupon.class));
		return CouponList;
	}

	/**
	 * 通过商品id查询商品
	 * 
	 * @param coupon_id
	 *            商品id
	 * @return
	 */
	public Coupon getCouponById(int coupon_id) {
		String sql = "select * from freshmall_coupon where coupon_id=:coupon_id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("coupon_id", coupon_id);
		return (Coupon) namedParameterJdbcTemplate.queryForObject(sql, sps,
				new BeanPropertyRowMapper<Coupon>(Coupon.class));
	}
	
	public List<Coupon> findCouponById(int coupon_id) {
		String sql = "select * from freshmall_coupon where coupon_id=:coupon_id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("coupon_id", coupon_id);
		List<Coupon> CouponList = namedParameterJdbcTemplate.query(sql,sps,new BeanPropertyRowMapper<Coupon>(Coupon.class));
		return CouponList;
	}
	
	public List<Coupon> findCouponsLimit(int limit) {
		String sql = "select * from freshmall_coupon limit :limit ";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("limit", limit);
		List<Coupon> CouponList = namedParameterJdbcTemplate.query(sql,sps,new BeanPropertyRowMapper<Coupon>(Coupon.class));
		return CouponList;
	}
	
	/**
	 * 根据条件查询商品信息
	 * @param searchType
	 * @param searchvalue
	 * @param pageBean
	 * @return
	 */
	public List<Coupon> findCouponBySearchPageValue(String searchvalue, PageBean pageBean) {
		String sql = "select * from freshmall_coupon where coupon_name like '%"+searchvalue+"%' limit " + pageBean.getStart()
					+ "," + pageBean.getPageSize() + "";
		List<Coupon> CouponList = namedParameterJdbcTemplate.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Coupon>(Coupon.class));
		return CouponList;
	}

	/**
	 * 根据条件查询商品数量
	 * @param searchType
	 * @param searchvalue
	 * @return
	 */
	public int CouponCountBySearchValue(String searchvalue) {
		MapSqlParameterSource sps = new MapSqlParameterSource();
		String sql = "select count(*) total from freshmall_coupon where coupon_name like '%"+searchvalue+"%'";
		int totals = 0;
		totals = (int) namedParameterJdbcTemplate.queryForLong(sql, sps);
		return totals;
	}
	
	/**
	 * 查询平台优惠券
	 * @param Coupon
	 * @return
	 */
	public List<Coupon> findCouponsForManager() {
		String sql = "select * from freshmall_coupon where coupon_type=1";
		List<Coupon> CouponList = namedParameterJdbcTemplate.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Coupon>(Coupon.class));
		return CouponList;
	}
	
	/**
	 * 查询商家优惠券
	 * @param Coupon
	 * @return
	 */
	public List<Coupon> findCouponsForShop() {
		String sql = "select * from freshmall_coupon where coupon_type=2";
		List<Coupon> CouponList = namedParameterJdbcTemplate.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Coupon>(Coupon.class));
		return CouponList;
	}
	

}
