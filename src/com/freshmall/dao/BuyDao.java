package com.freshmall.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.freshmall.model.Buy;
import com.freshmall.model.PageBean;

/**
 * 订单实现类
 * @author gongwei
 *
 */
public class BuyDao {
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return namedParameterJdbcTemplate;
	}

	public void setNamedParameterJdbcTemplate(
			NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public int addBuy(Buy buy) {
		String sql = "INSERT INTO freshmall_buy(adminuser_id,buy_sn,buy_price,buy_addtime,buy_status,adminuser_username,"
				+ "adminuser_iphone,buy_content,buy_message,buy_address,payment_id,goods_id) " +
				"VALUES(:adminuser_id,:buy_sn,:buy_price,:buy_addtime,:buy_status,:adminuser_username,"
				+ ":adminuser_iphone,:buy_content,:buy_message,:buy_address,:payment_id,:goods_id)";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("adminuser_id", buy.getAdminuser_id());
		sps.addValue("buy_sn", buy.getBuy_sn());
		sps.addValue("buy_price", buy.getBuy_price());
		sps.addValue("buy_addtime", buy.getBuy_addtime());
		sps.addValue("buy_status", buy.getBuy_status());
		sps.addValue("adminuser_username", buy.getAdminuser_username());
		sps.addValue("adminuser_iphone", buy.getAdminuser_iphone());
		sps.addValue("buy_content", buy.getBuy_content());
		sps.addValue("buy_message", buy.getBuy_message());
		sps.addValue("buy_address", buy.getBuy_address());
		sps.addValue("payment_id", buy.getPayment_id());
		sps.addValue("goods_id", buy.getGoods_id());
		KeyHolder keyholder = new GeneratedKeyHolder();
		namedParameterJdbcTemplate.update(sql, sps, keyholder);
		// 加上KeyHolder这个参数可以得到添加后主键的值
		int m = keyholder.getKey().intValue();
		return m;
	}

	public int updateBuy(Buy buy) {
		String sql = "update freshmall_buy set adminuser_id=:adminuser_id,buy_sn=:buy_sn,"
				+ "buy_price=:buy_price,adminuser_username=:adminuser_username,"
				+ "adminuser_iphone=:adminuser_iphone,buy_content=:buy_content,"
				+ "buy_message=:buy_message,buy_address=:buy_address where buy_id=:buy_id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("adminuser_id", buy.getAdminuser_id());
		sps.addValue("buy_sn", buy.getBuy_sn());
		sps.addValue("buy_price", buy.getBuy_price());
		sps.addValue("adminuser_username", buy.getAdminuser_username());
		sps.addValue("adminuser_iphone", buy.getAdminuser_iphone());
		sps.addValue("buy_content", buy.getBuy_content());
		sps.addValue("buy_message", buy.getBuy_message());
		sps.addValue("buy_address", buy.getBuy_address());
		sps.addValue("buy_id", buy.getBuy_id());
		return namedParameterJdbcTemplate.update(sql, sps);
	}
	
	public int deleteBuy(int buy_id) {
		String sql = "delete from freshmall_buy where buy_id=:buy_id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("buy_id", buy_id);
		return namedParameterJdbcTemplate.update(sql, sps);
	}
	
	public List<Buy> findBuyByPage(Buy buy, PageBean pageBean) {
		String sql = "select * from freshmall_buy limit " + pageBean.getStart()
		+ "," + pageBean.getPageSize() + "";
		List<Buy> BuyList = namedParameterJdbcTemplate.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Buy>(Buy.class));
		return BuyList;
	}

	public int BuyCount(Buy buy) {
		String sql = "select count(*) total from freshmall_buy";
		int totals = 0;
		MapSqlParameterSource sps = new MapSqlParameterSource();
		totals = (int) namedParameterJdbcTemplate.queryForLong(sql, sps);
		return totals;
	}
	
	/**
	 * 根据条件查询订单信息
	 * @param searchType
	 * @param searchvalue
	 * @param pageBean
	 * @return
	 */
	public List<Buy> findBuyBySearchPage(String searchType, String searchvalue, PageBean pageBean) {
		String sql = null;
		if (searchType.equals("adminusername")) {//如果搜索类型为按用户名称搜索
			sql = "select * from freshmall_buy where adminuser_username like '%"+searchvalue+"%' limit " + pageBean.getStart()
					+ "," + pageBean.getPageSize() + "";
		}
		List<Buy> BuyList = namedParameterJdbcTemplate.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Buy>(Buy.class));
		return BuyList;
	}

	/**
	 * 根据条件查询订单数量
	 * @param searchType
	 * @param searchvalue
	 * @return
	 */
	public int BuyCountBySearch(String searchType, String searchvalue) {
		MapSqlParameterSource sps = new MapSqlParameterSource();
		String sql = null;
		if (searchType.equals("adminusername")) {
			sql = "select count(*) total from freshmall_buy where adminuser_username like '%"+searchvalue+"%'";
		}
		int totals = 0;
		totals = (int) namedParameterJdbcTemplate.queryForLong(sql, sps);
		return totals;
	}

	public List<Buy> findBuys(Buy Buy) {
		String sql = "select * from freshmall_buy ";
		List<Buy> BuyList = namedParameterJdbcTemplate.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Buy>(Buy.class));
		return BuyList;
	}

	/**
	 * 通过订单id查询订单
	 * 
	 * @param buy_id
	 *            订单id
	 * @return
	 */
	public Buy getBuyById(int Buy_id) {
		String sql = "select * from freshmall_buy where buy_id=:buy_id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("buy_id", Buy_id);
		return (Buy) namedParameterJdbcTemplate.queryForObject(sql, sps,
				new BeanPropertyRowMapper<Buy>(Buy.class));
	}
	
	/**
	 * 通过订单id将订单的状态改为已发货状态
	 * @param buy_id
	 * @return
	 */
	public int updateBuyByIdToYfh(int buy_id) {
		String sql = "update freshmall_buy set buy_status=3 where buy_id=:buy_id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("buy_id", buy_id);
		return namedParameterJdbcTemplate.update(sql, sps);
	}
	
	public List<Buy> findBuysByAdminUserId(int adminuser_id) {
		String sql = "select * from freshmall_buy where adminuser_id=:adminuser_id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("adminuser_id", adminuser_id);
		List<Buy> BuyList = namedParameterJdbcTemplate.query(sql,sps,new BeanPropertyRowMapper<Buy>(Buy.class));
		return BuyList;
	}
	
	/**
	 * 待发货订单
	 * @param adminuser_id
	 * @return
	 */
	public List<Buy> findBuysByAdminUserIdToWait(int adminuser_id) {
		String sql = "select * from freshmall_buy where buy_status=2 and adminuser_id=:adminuser_id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("adminuser_id", adminuser_id);
		List<Buy> BuyList = namedParameterJdbcTemplate.query(sql,sps,new BeanPropertyRowMapper<Buy>(Buy.class));
		return BuyList;
	}
	
	/**
	 * 待收货订单
	 * @param adminuser_id
	 * @return
	 */
	public List<Buy> findBuysByAdminUserIdToShouhuo(int adminuser_id) {
		String sql = "select * from freshmall_buy where buy_status=3 and adminuser_id=:adminuser_id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("adminuser_id", adminuser_id);
		List<Buy> BuyList = namedParameterJdbcTemplate.query(sql,sps,new BeanPropertyRowMapper<Buy>(Buy.class));
		return BuyList;
	}
	
	/**
	 * 待评价订单
	 * @param adminuser_id
	 * @return
	 */
	public List<Buy> findBuysByAdminUserIdToPingjia(int adminuser_id) {
		String sql = "select * from freshmall_buy where buy_status=4 and adminuser_id=:adminuser_id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("adminuser_id", adminuser_id);
		List<Buy> BuyList = namedParameterJdbcTemplate.query(sql,sps,new BeanPropertyRowMapper<Buy>(Buy.class));
		return BuyList;
	}
	
	public List<Buy> findBuyByUserIdPage(int adminuser_id, PageBean pageBean) {
		String sql = "select * from freshmall_buy where adminuser_id=:adminuser_id limit " + pageBean.getStart()
		+ "," + pageBean.getPageSize() + "";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("adminuser_id", adminuser_id);
		List<Buy> BuyList = namedParameterJdbcTemplate.query(sql,sps,new BeanPropertyRowMapper<Buy>(Buy.class));
		return BuyList;
	}

	public int BuyCountByUserId(int adminuser_id) {
		String sql = "select count(*) total from freshmall_buy where adminuser_id=:adminuser_id";
		int totals = 0;
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("adminuser_id", adminuser_id);
		totals = (int) namedParameterJdbcTemplate.queryForLong(sql, sps);
		return totals;
	}
	
	/**
	 * 确认收货
	 * @param buy_id
	 * @return
	 */
	public int updateBuyByIdToShouhuo(int buy_id) {
		String sql = "update freshmall_buy set buy_status=4 where buy_id=:buy_id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("buy_id", buy_id);
		return namedParameterJdbcTemplate.update(sql, sps);
	}
	
	/**
	 * 评价订单状态
	 * @param buy_id
	 * @return
	 */
	public int updateBuyByIdToYpj(int buy_id) {
		String sql = "update freshmall_buy set buy_status=5 where buy_id=:buy_id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("buy_id", buy_id);
		return namedParameterJdbcTemplate.update(sql, sps);
	}
	
	public List<Buy> findBuysById(int buy_id) {
		String sql = "select * from freshmall_buy where buy_id=:buy_id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("buy_id", buy_id);
		List<Buy> BuyList = namedParameterJdbcTemplate.query(sql,sps,new BeanPropertyRowMapper<Buy>(Buy.class));
		return BuyList;
	}
}
