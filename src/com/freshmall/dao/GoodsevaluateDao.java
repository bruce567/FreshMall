package com.freshmall.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.freshmall.model.PageBean;
import com.freshmall.model.Goodsevaluate;

/**
 * 商品评价实现类
 * @author gongwei
 *
 */
public class GoodsevaluateDao {
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return namedParameterJdbcTemplate;
	}

	public void setNamedParameterJdbcTemplate(
			NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	public int addGoodsevaluate(Goodsevaluate goodsevaluate) {
		String sql = "INSERT INTO freshmall_goodsevaluate(adminuser_id,goods_id,goodsevaluate_star,goodsevaluate_content,goodsevaluate_addtime) " +
				"VALUES(:adminuser_id,:goods_id,:goodsevaluate_star,:goodsevaluate_content,:goodsevaluate_addtime)";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("adminuser_id", goodsevaluate.getAdminuser_id());
		sps.addValue("goods_id", goodsevaluate.getGoods_id());
		sps.addValue("goodsevaluate_star", goodsevaluate.getGoodsevaluate_star());
		sps.addValue("goodsevaluate_content", goodsevaluate.getGoodsevaluate_content());
		sps.addValue("goodsevaluate_addtime", goodsevaluate.getGoodsevaluate_addtime());
		KeyHolder keyholder = new GeneratedKeyHolder();
		namedParameterJdbcTemplate.update(sql, sps, keyholder);
		// 加上KeyHolder这个参数可以得到添加后主键的值
		int m = keyholder.getKey().intValue();
		return m;
	}

	public int updateGoodsevaluate(Goodsevaluate goodsevaluate) {
		String sql = "update freshmall_goodsevaluate set adminuser_id=:adminuser_id,goods_id=:goods_id,"
				+ "goodsevaluate_star=:goodsevaluate_star,goodsevaluate_content=:goodsevaluate_content "
				+ "where goodsevaluate_id=:goodsevaluate_id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("adminuser_id", goodsevaluate.getAdminuser_id());
		sps.addValue("goods_id", goodsevaluate.getGoods_id());
		sps.addValue("goodsevaluate_star", goodsevaluate.getGoodsevaluate_star());
		sps.addValue("goodsevaluate_content", goodsevaluate.getGoodsevaluate_content());
		sps.addValue("goodsevaluate_id", goodsevaluate.getGoodsevaluate_id());
		return namedParameterJdbcTemplate.update(sql, sps);
	}

	public int deleteGoodsevaluate(int goodsevaluate_id) {
		String sql = "delete from freshmall_goodsevaluate where goodsevaluate_id=:goodsevaluate_id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("goodsevaluate_id", goodsevaluate_id);
		return namedParameterJdbcTemplate.update(sql, sps);
	}
	
	public List<Goodsevaluate> findGoodsevaluateByPage(Goodsevaluate goodsevaluate, PageBean pageBean) {
		String sql = "select gs.*,a.adminuser_username as adminuser_username,g.goods_name as goods_name "
				+ "from freshmall_goodsevaluate gs,freshmall_adminuser a,freshmall_goods g "
				+ "where gs.adminuser_id=a.adminuser_id and gs.goods_id=g.goods_id order by goodsevaluate_addtime asc limit " + pageBean.getStart()
		+ "," + pageBean.getPageSize() + "";
		List<Goodsevaluate> GoodsevaluateList = namedParameterJdbcTemplate.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Goodsevaluate>(Goodsevaluate.class));
		return GoodsevaluateList;
	}

	public int GoodsevaluateCount(Goodsevaluate goodsevaluate) {
		String sql = "select count(*) total from freshmall_goodsevaluate";
		int totals = 0;
		MapSqlParameterSource sps = new MapSqlParameterSource();
		totals = (int) namedParameterJdbcTemplate.queryForLong(sql, sps);
		return totals;
	}
	
	public List<Goodsevaluate> findGoodsevaluate(Goodsevaluate goodsevaluate) {
		String sql = "select gs.*,a.adminuser_username as adminuser_username,g.goods_name as goods_name "
				+ "from freshmall_goodsevaluate gs,freshmall_adminuser a,freshmall_goods g "
				+ "where gs.adminuser_id=a.adminuser_id and gs.goods_id=g.goods_id order by goodsevaluate_addtime asc";
		List<Goodsevaluate> GoodsevaluateList = namedParameterJdbcTemplate.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Goodsevaluate>(Goodsevaluate.class));
		return GoodsevaluateList;
	}

	/**
	 * 通过商品评价id查询商品评价
	 * 
	 * @param goodsevaluate_id
	 *            商品评价id
	 * @return
	 */
	public Goodsevaluate getGoodsevaluateById(int goodsevaluate_id) {
		String sql = "select gs.*,a.adminuser_username as adminuser_username,g.goods_name as goods_name "
				+ "from freshmall_goodsevaluate gs,freshmall_adminuser a,freshmall_goods g "
				+ "where gs.adminuser_id=a.adminuser_id and gs.goods_id=g.goods_id and gs.goodsevaluate_id=:goodsevaluate_id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("goodsevaluate_id", goodsevaluate_id);
		return (Goodsevaluate) namedParameterJdbcTemplate.queryForObject(sql, sps,
				new BeanPropertyRowMapper<Goodsevaluate>(Goodsevaluate.class));
	}
	
	public List<Goodsevaluate> findGoodsevaluateByGoodId(int goods_id) {
		String sql = "select gs.*,a.adminuser_username as adminuser_username,g.goods_name as goods_name "
				+ "from freshmall_goodsevaluate gs,freshmall_adminuser a,freshmall_goods g "
				+ "where gs.adminuser_id=a.adminuser_id and gs.goods_id=g.goods_id and gs.goods_id=:goods_id order by goodsevaluate_addtime asc";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("goods_id", goods_id);
		List<Goodsevaluate> GoodsevaluateList = namedParameterJdbcTemplate.query(sql,sps,new BeanPropertyRowMapper<Goodsevaluate>(Goodsevaluate.class));
		return GoodsevaluateList;
	}
}
