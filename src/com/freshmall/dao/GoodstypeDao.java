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

import com.freshmall.model.PageBean;
import com.freshmall.model.Goods;
import com.freshmall.model.Goodstype;

/**
 * 商品类型实现类
 * @author gongwei
 *
 */
public class GoodstypeDao {
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return namedParameterJdbcTemplate;
	}

	public void setNamedParameterJdbcTemplate(
			NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	public int addGoodstype(Goodstype goodstype) {
		String sql = "INSERT INTO freshmall_goodstype(goodstype_name) " +
				"VALUES(:goodstype_name)";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("goodstype_name", goodstype.getGoodstype_name());
		KeyHolder keyholder = new GeneratedKeyHolder();
		namedParameterJdbcTemplate.update(sql, sps, keyholder);
		// 加上KeyHolder这个参数可以得到添加后主键的值
		int m = keyholder.getKey().intValue();
		return m;
	}

	public int updateGoodstype(Goodstype goodstype) {
		String sql = "update freshmall_goodstype set goodstype_name=:goodstype_name where goodstype_id=:goodstype_id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("goodstype_name", goodstype.getGoodstype_name());
		sps.addValue("goodstype_id", goodstype.getGoodstype_id());
		return namedParameterJdbcTemplate.update(sql, sps);
	}

	public int deleteGoodstype(int goodstype_id) {
		String sql = "delete from freshmall_goodstype where goodstype_id=:goodstype_id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("goodstype_id", goodstype_id);
		return namedParameterJdbcTemplate.update(sql, sps);
	}
	
	public List<Goodstype> findGoodstypeByPage(Goodstype goodstype, PageBean pageBean) {
		String sql = "select * from freshmall_goodstype limit " + pageBean.getStart()
		+ "," + pageBean.getPageSize() + "";
		List<Goodstype> GoodstypeList = namedParameterJdbcTemplate.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Goodstype>(Goodstype.class));
		return GoodstypeList;
	}

	public int GoodstypeCount(Goodstype goodstype) {
		String sql = "select count(*) total from freshmall_goodstype";
		int totals = 0;
		MapSqlParameterSource sps = new MapSqlParameterSource();
		totals = (int) namedParameterJdbcTemplate.queryForLong(sql, sps);
		return totals;
	}
	
	public List<Goodstype> findGoodstype(Goodstype goodstype) {
		String sql = "select * from freshmall_goodstype";
		List<Goodstype> GoodstypeList = namedParameterJdbcTemplate.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Goodstype>(Goodstype.class));
		return GoodstypeList;
	}
	
	public List<Goodstype> findGoodstypeById(int goodstype_id) {
		String sql = "select * from freshmall_goodstype where goodstype_id=:goodstype_id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("goodstype_id", goodstype_id);
		List<Goodstype> GoodstypeList = namedParameterJdbcTemplate.query(sql,sps,new BeanPropertyRowMapper<Goodstype>(Goodstype.class));
		return GoodstypeList;
	}

	/**
	 * 通过商品类型id查询商品类型
	 * 
	 * @param goodstype_id
	 *            商品类型id
	 * @return
	 */
	public Goodstype getGoodstypeById(int goodstype_id) {
		String sql = "select * from freshmall_goodstype where goodstype_id=:goodstype_id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("goodstype_id", goodstype_id);
		return (Goodstype) namedParameterJdbcTemplate.queryForObject(sql, sps,
				new BeanPropertyRowMapper<Goodstype>(Goodstype.class));
	}
	
	/**
	 * 查询一级分类的列表
	 * @return
	 */
	public List<Goodstype> getgoodstype() {
		final List<Goodstype> goodstype_arr = new ArrayList<Goodstype>();
		//查询顶级分类
        String sql = "select goodstype_id,goodstype_name from freshmall_goodstype";
        namedParameterJdbcTemplate.query(sql, new RowCallbackHandler() {
			public void processRow(ResultSet rs) throws SQLException {
				Goodstype goodstype = new Goodstype();
				goodstype.setGoodstype_id(rs.getInt("goodstype_id"));
				goodstype.setGoodstype_name(rs.getString("goodstype_name"));
				goodstype_arr.add(goodstype);
				if (goodstype_arr.size() > 0) {
					goodstype.setGoodslist(getgoods(rs.getInt("goodstype_id")));
				}
			}
		});
        return goodstype_arr;
	}
	
	/**
	 * 根据一级分类id查询分类的商品列表
	 * @param goodstype_id
	 * @return
	 */
	public List<Goods> getgoods(int goodstype_id) {
		final List<Goods> goods_arr = new ArrayList<Goods>();
		String child_sql = "select goods_id,goodstype_id,goods_name,goods_images,goods_price "
				+ "from freshmall_goods where goodstype_id="+goodstype_id+"";
		namedParameterJdbcTemplate.query(child_sql, new RowCallbackHandler() {
			public void processRow(ResultSet rs) throws SQLException {
				Goods goods = new Goods();
				goods.setGoods_id(rs.getInt("goods_id"));
				goods.setGoodstype_id(rs.getInt("goodstype_id"));
				goods.setGoods_name(rs.getString("goods_name"));
				goods.setGoods_images(rs.getString("goods_images"));
				goods.setGoods_price(rs.getString("goods_price"));
				goods_arr.add(goods);
			}
		});
		return goods_arr;
	}
}
