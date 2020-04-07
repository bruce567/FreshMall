package com.freshmall.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.freshmall.model.Shop;
import com.freshmall.model.PageBean;

/**
 * 店铺实现类
 * @author gongwei
 *
 */
public class ShopDao {
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return namedParameterJdbcTemplate;
	}

	public void setNamedParameterJdbcTemplate(
			NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	public int addShop(Shop shop) {
		String sql = "INSERT INTO freshmall_shop(shop_name,shop_images,shop_content,shop_addtime,shop_opentime,shop_address,shop_iphone) " +
				"VALUES(:shop_name,:shop_images,:shop_content,:shop_addtime,:shop_opentime,:shop_address,:shop_iphone)";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("shop_name", shop.getShop_name());
		sps.addValue("shop_images", shop.getShop_images());
		sps.addValue("shop_content", shop.getShop_content());
		sps.addValue("shop_addtime", shop.getShop_addtime());
		sps.addValue("shop_opentime", shop.getShop_opentime());
		sps.addValue("shop_address", shop.getShop_address());
		sps.addValue("shop_iphone", shop.getShop_iphone());
		KeyHolder keyholder = new GeneratedKeyHolder();
		namedParameterJdbcTemplate.update(sql, sps, keyholder);
		// 加上KeyHolder这个参数可以得到添加后主键的值
		int m = keyholder.getKey().intValue();
		return m;
	}

	public int updateShop(Shop shop) {
		String sql = "update freshmall_shop set shop_name=:shop_name,shop_images=:shop_images,"
				+ "shop_content=:shop_content,shop_opentime=:shop_opentime,"
				+ "shop_address=:shop_address,shop_iphone=:shop_iphone where shop_id=:shop_id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("shop_name", shop.getShop_name());
		sps.addValue("shop_images", shop.getShop_images());
		sps.addValue("shop_content", shop.getShop_content());
		sps.addValue("shop_opentime", shop.getShop_opentime());
		sps.addValue("shop_address", shop.getShop_address());
		sps.addValue("shop_iphone", shop.getShop_iphone());
		sps.addValue("shop_id", shop.getShop_id());
		return namedParameterJdbcTemplate.update(sql, sps);
	}

	public int deleteShop(int shop_id) {
		String sql = "delete from freshmall_shop where shop_id=:shop_id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("shop_id", shop_id);
		return namedParameterJdbcTemplate.update(sql, sps);
	}
	
	public List<Shop> findShopByPage(Shop shop, PageBean pageBean) {
		String sql = "select * from freshmall_shop order by shop_addtime asc limit " + pageBean.getStart()
		+ "," + pageBean.getPageSize() + "";
		List<Shop> ShopList = namedParameterJdbcTemplate.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Shop>(Shop.class));
		return ShopList;
	}

	public int ShopCount(Shop shop) {
		String sql = "select count(*) total from freshmall_shop";
		int totals = 0;
		MapSqlParameterSource sps = new MapSqlParameterSource();
		totals = (int) namedParameterJdbcTemplate.queryForLong(sql, sps);
		return totals;
	}
	
	public List<Shop> findShop(Shop shop) {
		String sql = "select * from freshmall_shop order by shop_addtime asc";
		List<Shop> ShopList = namedParameterJdbcTemplate.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Shop>(Shop.class));
		return ShopList;
	}

	/**
	 * 通过店铺id查询店铺
	 * 
	 * @param shop_id
	 *            店铺id
	 * @return
	 */
	public Shop getShopById(int shop_id) {
		String sql = "select * from freshmall_shop where shop_id=:shop_id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("shop_id", shop_id);
		return (Shop) namedParameterJdbcTemplate.queryForObject(sql, sps,
				new BeanPropertyRowMapper<Shop>(Shop.class));
	}
	
	public List<Shop> findShopById(int shop_id) {
		String sql = "select * from freshmall_shop where shop_id=:shop_id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("shop_id", shop_id);
		List<Shop> ShopList = namedParameterJdbcTemplate.query(sql,sps,new BeanPropertyRowMapper<Shop>(Shop.class));
		return ShopList;
	}
	
	
}
