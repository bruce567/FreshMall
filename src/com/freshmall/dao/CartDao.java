package com.freshmall.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.freshmall.model.Cart;
import com.freshmall.model.Cart;
import com.freshmall.model.PageBean;

/**
 * 购物车实现类
 * @author gongwei
 *
 */
public class CartDao {
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return namedParameterJdbcTemplate;
	}

	public void setNamedParameterJdbcTemplate(
			NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public int addCart(Cart cart) {
		String sql = "INSERT INTO freshmall_cart(adminuser_id,goods_id,cart_addnum,cart_addtime,cart_price) " +
				"VALUES(:adminuser_id,:goods_id,:cart_addnum,:cart_addtime,:cart_price)";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("adminuser_id", cart.getAdminuser_id());
		sps.addValue("goods_id", cart.getGoods_id());
		sps.addValue("cart_addnum", cart.getCart_addnum());
		sps.addValue("cart_addtime", cart.getCart_addtime());
		sps.addValue("cart_price", cart.getCart_price());
		KeyHolder keyholder = new GeneratedKeyHolder();
		namedParameterJdbcTemplate.update(sql, sps, keyholder);
		// 加上KeyHolder这个参数可以得到添加后主键的值
		int m = keyholder.getKey().intValue();
		return m;
	}

	public int updateCart(Cart cart) {
		String sql = "update freshmall_cart set adminuser_id=:adminuser_id,goods_id=:goods_id,"
				+ "cart_addnum=:cart_addnum where cart_id=:cart_id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("adminuser_id", cart.getAdminuser_id());
		sps.addValue("goods_id", cart.getGoods_id());
		sps.addValue("cart_addnum", cart.getCart_addnum());
		sps.addValue("cart_id", cart.getCart_id());
		return namedParameterJdbcTemplate.update(sql, sps);
	}
	
	public int deleteCart(int cart_id) {
		String sql = "delete from freshmall_cart where cart_id=:cart_id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("cart_id", cart_id);
		return namedParameterJdbcTemplate.update(sql, sps);
	}
	
	public List<Cart> findCartByPage(Cart cart, PageBean pageBean) {
		String sql = "select c.*,a.adminuser_username as adminuser_username,f.goods_name as goods_name,f.goods_images as goods_images,"
				+ "f.goods_price as goods_price from freshmall_cart c,freshmall_adminuser a,freshmall_goods f "
				+ "where c.adminuser_id=a.adminuser_id and c.goods_id=f.goods_id limit " + pageBean.getStart()
		+ "," + pageBean.getPageSize() + "";
		List<Cart> CartList = namedParameterJdbcTemplate.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Cart>(Cart.class));
		return CartList;
	}

	public int CartCount(Cart cart) {
		String sql = "select count(*) total from freshmall_cart";
		int totals = 0;
		MapSqlParameterSource sps = new MapSqlParameterSource();
		totals = (int) namedParameterJdbcTemplate.queryForLong(sql, sps);
		return totals;
	}
	
	/**
	 * 根据条件查询购物车信息
	 * @param searchType
	 * @param searchvalue
	 * @param pageBean
	 * @return
	 */
	public List<Cart> findCartBySearchPage(String searchType, String searchvalue, PageBean pageBean) {
		String sql = null;
		if (searchType.equals("adminusername")) {//如果搜索类型为按用户名称搜索
			sql = "select c.*,a.adminuser_username as adminuser_username,f.goods_name as goods_name,f.goods_images as goods_images,"
				+ "f.goods_price as goods_price from freshmall_cart c,freshmall_adminuser a,freshmall_goods f "
				+ "where c.adminuser_id=a.adminuser_id and c.goods_id=f.goods_id and a.adminuser_username like '%"+searchvalue+"%' limit " + pageBean.getStart()
					+ "," + pageBean.getPageSize() + "";
		}
		List<Cart> CartList = namedParameterJdbcTemplate.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Cart>(Cart.class));
		return CartList;
	}

	/**
	 * 根据条件查询购物车数量
	 * @param searchType
	 * @param searchvalue
	 * @return
	 */
	public int CartCountBySearch(String searchType, String searchvalue) {
		MapSqlParameterSource sps = new MapSqlParameterSource();
		String sql = null;
		if (searchType.equals("adminusername")) {
			sql = "select count(*) total from freshmall_cart c,freshmall_adminuser a "
					+ "where c.adminuser_id=a.adminuser_id and a.adminuser_username like '%"+searchvalue+"%'";
		}
		int totals = 0;
		totals = (int) namedParameterJdbcTemplate.queryForLong(sql, sps);
		return totals;
	}

	public List<Cart> findCarts(Cart cart) {
		String sql = "select c.*,a.adminuser_username as adminuser_username,f.goods_name as goods_name,f.goods_images as goods_images,"
				+ "f.goods_price as goods_price from freshmall_cart c,freshmall_adminuser a,freshmall_goods f "
				+ "where c.adminuser_id=a.adminuser_id and c.goods_id=f.goods_id ";
		List<Cart> CartList = namedParameterJdbcTemplate.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Cart>(Cart.class));
		return CartList;
	}

	/**
	 * 通过购物车id查询购物车
	 * 
	 * @param cart_id
	 *            购物车id
	 * @return
	 */
	public Cart getCartById(int cart_id) {
		String sql = "select c.*,a.adminuser_username as adminuser_username,f.goods_name as goods_name,f.goods_images as goods_images,"
				+ "f.goods_price as goods_price from freshmall_cart c,freshmall_adminuser a,freshmall_goods f "
				+ "where c.adminuser_id=a.adminuser_id and c.goods_id=f.goods_id and c.cart_id=:cart_id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("cart_id", cart_id);
		return (Cart) namedParameterJdbcTemplate.queryForObject(sql, sps,
				new BeanPropertyRowMapper<Cart>(Cart.class));
	}
	
	public List<Cart> findCartsByAdminUserId(int adminuser_id) {
		String sql = "select c.*,a.adminuser_username as adminuser_username,f.goods_name as goods_name,f.goods_images as goods_images"
				+ ",f.goods_price as goods_price from freshmall_cart c,freshmall_adminuser a,freshmall_goods f "
				+ "where c.adminuser_id=a.adminuser_id and c.goods_id=f.goods_id and c.adminuser_id=:adminuser_id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("adminuser_id", adminuser_id);
		List<Cart> CartList = namedParameterJdbcTemplate.query(sql,sps,new BeanPropertyRowMapper<Cart>(Cart.class));
		return CartList;
	}
	
	public List<Cart> findCartsById(int cart_id) {
		String sql = "select c.*,a.adminuser_username as adminuser_username,f.goods_name as goods_name,f.goods_images as goods_images"
				+ ",f.goods_price as goods_price from freshmall_cart c,freshmall_adminuser a,freshmall_goods f "
				+ "where c.adminuser_id=a.adminuser_id and c.goods_id=f.goods_id and c.cart_id=:cart_id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("cart_id", cart_id);
		List<Cart> CartList = namedParameterJdbcTemplate.query(sql,sps,new BeanPropertyRowMapper<Cart>(Cart.class));
		return CartList;
	}
	
	public int CartSumByAdminUser(int adminuser_id) {
		String sql = "select sum(cart_price) as sumprice from freshmall_cart where adminuser_id=:adminuser_id";
		int totals = 0;
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("adminuser_id", adminuser_id);
		totals = (int) namedParameterJdbcTemplate.queryForLong(sql, sps);
		return totals;
	}
	
	public int deleteCartByAdminuserId(int adminuser_id) {
		String sql = "delete from freshmall_cart where adminuser_id=:adminuser_id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("adminuser_id", adminuser_id);
		return namedParameterJdbcTemplate.update(sql, sps);
	}
	
	public List<Cart> findCartsByAdminUserIdAndGoodsId(int adminuser_id, int goods_id) {
		String sql = "select * from freshmall_cart where adminuser_id=:adminuser_id and goods_id=:goods_id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("adminuser_id", adminuser_id);
		sps.addValue("goods_id", goods_id);
		List<Cart> CartList = namedParameterJdbcTemplate.query(sql,sps,new BeanPropertyRowMapper<Cart>(Cart.class));
		return CartList;
	}
	
	public int updateCartByAdminUserIdAndGoodsId(int adminuser_id, int goods_id) {
		String sql = "update freshmall_cart set cart_addnum=cart_addnum+1 where adminuser_id=:adminuser_id and goods_id=:goods_id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("adminuser_id", adminuser_id);
		sps.addValue("goods_id", goods_id);
		return namedParameterJdbcTemplate.update(sql, sps);
	}
	
	public int updateCartByIdToUpdateNum(int cart_id, String cart_price, int cart_addnum) {
		String sql = "update freshmall_cart set cart_price=:cart_price,cart_addnum=:cart_addnum "
				+ "where cart_id=:cart_id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("cart_id", cart_id);
		sps.addValue("cart_price", cart_price);
		sps.addValue("cart_addnum", cart_addnum);
		return namedParameterJdbcTemplate.update(sql, sps);
	}
}
