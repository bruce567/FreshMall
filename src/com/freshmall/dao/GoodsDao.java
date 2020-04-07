package com.freshmall.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.freshmall.model.Goods;
import com.freshmall.model.PageBean;

/**
 * 商品实现类
 * @author gongwei
 *
 */
public class GoodsDao {
	@Autowired
	private static NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return namedParameterJdbcTemplate;
	}

	public void setNamedParameterJdbcTemplate(
			NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public int addGoods(Goods goods) {
		String sql = "INSERT INTO freshmall_goods(shop_id,goodstype_id,goods_name,goods_images,"
				+ "goods_price,goods_content,goods_num,goods_addtime,goods_promote,goods_starttime,goods_endtime) " +
				"VALUES(:shop_id,:goodstype_id,:goods_name,:goods_images,"
				+ ":goods_price,:goods_content,:goods_num,:goods_addtime,:goods_promote,:goods_starttime,:goods_endtime)";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("shop_id", goods.getShop_id());
		sps.addValue("goodstype_id", goods.getGoodstype_id());
		sps.addValue("goods_name", goods.getGoods_name());
		sps.addValue("goods_images", goods.getGoods_images());
		sps.addValue("goods_price", goods.getGoods_price());
		sps.addValue("goods_content", goods.getGoods_content());
		sps.addValue("goods_num", goods.getGoods_num());
		sps.addValue("goods_addtime", goods.getGoods_addtime());
		sps.addValue("goods_promote", goods.getGoods_promote());
		sps.addValue("goods_starttime", goods.getGoods_starttime());
		sps.addValue("goods_endtime", goods.getGoods_endtime());
		KeyHolder keyholder = new GeneratedKeyHolder();
		namedParameterJdbcTemplate.update(sql, sps, keyholder);
		// 加上KeyHolder这个参数可以得到添加后主键的值
		int m = keyholder.getKey().intValue();
		return m;
	}

	public int updateGoods(Goods goods) {
		String sql = "update freshmall_goods set shop_id=:shop_id,goodstype_id=:goodstype_id,"
				+ "goods_name=:goods_name,goods_images=:goods_images,goods_price=:goods_price,"
				+ "goods_content=:goods_content,goods_num=:goods_num,goods_promote=:goods_promote,"
				+ "goods_starttime=:goods_starttime,goods_endtime=:goods_endtime "
				+ "where goods_id=:goods_id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("shop_id", goods.getShop_id());
		sps.addValue("goodstype_id", goods.getGoodstype_id());
		sps.addValue("goods_name", goods.getGoods_name());
		sps.addValue("goods_images", goods.getGoods_images());
		sps.addValue("goods_price", goods.getGoods_price());
		sps.addValue("goods_content", goods.getGoods_content());
		sps.addValue("goods_num", goods.getGoods_num());
		sps.addValue("goods_promote", goods.getGoods_promote());
		sps.addValue("goods_starttime", goods.getGoods_starttime());
		sps.addValue("goods_endtime", goods.getGoods_endtime());
		sps.addValue("goods_id", goods.getGoods_id());
		return namedParameterJdbcTemplate.update(sql, sps);
	}
	
	public int deleteGoods(int goods_id) {
		String sql = "delete from freshmall_goods where goods_id=:goods_id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("goods_id", goods_id);
		return namedParameterJdbcTemplate.update(sql, sps);
	}
	
	public List<Goods> findGoodsByPage(Goods goods, PageBean pageBean) {
		String sql = "select g.*,s.shop_name as shop_name,gt.goodstype_name as goodstype_name "
				+ "from freshmall_goods g,freshmall_shop s,freshmall_goodstype gt "
				+ "where g.shop_id=s.shop_id and g.goodstype_id=gt.goodstype_id and g.goods_promote=1 limit " + pageBean.getStart()
		+ "," + pageBean.getPageSize() + "";
		List<Goods> GoodsList = namedParameterJdbcTemplate.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Goods>(Goods.class));
		return GoodsList;
	}

	public int GoodsCount(Goods goods) {
		String sql = "select count(*) total from freshmall_goods where goods_promote=1";
		int totals = 0;
		MapSqlParameterSource sps = new MapSqlParameterSource();
		totals = (int) namedParameterJdbcTemplate.queryForLong(sql, sps);
		return totals;
	}
	


	public List<Goods> findGoodss(Goods Goods) {
		String sql = "select g.*,s.shop_name as shop_name,gt.goodstype_name as goodstype_name "
				+ "from freshmall_goods g,freshmall_shop s,freshmall_goodstype gt "
				+ "where g.shop_id=s.shop_id and g.goodstype_id=gt.goodstype_id ";
		List<Goods> GoodsList = namedParameterJdbcTemplate.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Goods>(Goods.class));
		return GoodsList;
	}

	
	/**
	 * 通过商品id查询商品
	 * 
	 * @param goods_id
	 *            商品id
	 * @return
	 */
	public Goods getGoodsById(int goods_id) {
		String sql = "select g.*,s.shop_name as shop_name,gt.goodstype_name as goodstype_name "
				+ "from freshmall_goods g,freshmall_shop s,freshmall_goodstype gt "
				+ "where g.shop_id=s.shop_id and g.goodstype_id=gt.goodstype_id and g.goods_id=:goods_id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("goods_id", goods_id);
		return (Goods) namedParameterJdbcTemplate.queryForObject(sql, sps,
				new BeanPropertyRowMapper<Goods>(Goods.class));
	}
	
	public List<Goods> findGoodsById(int goods_id) {
		String sql = "select g.*,s.shop_name as shop_name,gt.goodstype_name as goodstype_name "
				+ "from freshmall_goods g,freshmall_shop s,freshmall_goodstype gt "
				+ "where g.shop_id=s.shop_id and g.goodstype_id=gt.goodstype_id and g.goods_id=:goods_id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("goods_id", goods_id);
		List<Goods> GoodsList = namedParameterJdbcTemplate.query(sql,sps,new BeanPropertyRowMapper<Goods>(Goods.class));
		return GoodsList;
	}
	
	public List<Goods> findGoodssLimit(int limit) {
		String sql = "select g.*,s.shop_name as shop_name,gt.goodstype_name as goodstype_name "
				+ "from freshmall_goods g,freshmall_shop s,freshmall_goodstype gt "
				+ "where g.shop_id=s.shop_id and g.goodstype_id=gt.goodstype_id and g.goods_promote=1 limit :limit ";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("limit", limit);
		List<Goods> GoodsList = namedParameterJdbcTemplate.query(sql,sps,new BeanPropertyRowMapper<Goods>(Goods.class));
		return GoodsList;
	}
	
	public List<Goods> findGoodssLimittime(int limit) {
		String sql = "select g.*,s.shop_name as shop_name,gt.goodstype_name as goodstype_name "
				+ "from freshmall_goods g,freshmall_shop s,freshmall_goodstype gt "
				+ "where g.shop_id=s.shop_id and g.goodstype_id=gt.goodstype_id and g.goods_promote=2 limit :limit ";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("limit", limit);
		List<Goods> GoodsList = namedParameterJdbcTemplate.query(sql,sps,new BeanPropertyRowMapper<Goods>(Goods.class));
		return GoodsList;
	}
	
	
	public List<Goods> findGoodsByMeautypeIdPage(int meautype_id, PageBean pageBean) {
		String sql = "select g.*,s.shop_name as shop_name,gt.goodstype_name as goodstype_name "
				+ "from freshmall_goods g,freshmall_shop s,freshmall_goodstype gt "
				+ "where g.shop_id=s.shop_id and g.goodstype_id=gt.goodstype_id and g.meautype_id=:meautype_id limit " + pageBean.getStart()
		+ "," + pageBean.getPageSize() + "";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("meautype_id", meautype_id);
		List<Goods> GoodsList = namedParameterJdbcTemplate.query(sql,sps,new BeanPropertyRowMapper<Goods>(Goods.class));
		return GoodsList;
	}

	public int GoodsCountByMeautypeId(int meautype_id) {
		String sql = "select count(*) total from freshmall_goods where meautype_id=:meautype_id";
		int totals = 0;
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("meautype_id", meautype_id);
		totals = (int) namedParameterJdbcTemplate.queryForLong(sql, sps);
		return totals;
	}
	
	public List<Goods> findGoodsByGoodstypeId(int goodstype_id) {
		String sql = "select g.*,s.shop_name as shop_name,gt.goodstype_name as goodstype_name "
				+ "from freshmall_goods g,freshmall_shop s,freshmall_goodstype gt "
				+ "where g.shop_id=s.shop_id and g.goodstype_id=gt.goodstype_id and g.goods_promote=1 and g.goodstype_id=:goodstype_id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("goodstype_id", goodstype_id);
		List<Goods> GoodsList = namedParameterJdbcTemplate.query(sql,sps,new BeanPropertyRowMapper<Goods>(Goods.class));
		return GoodsList;
	}
	
	public List<Goods> findGoodsByShopId(int shop_id) {
		String sql = "select * from freshmall_goods  where shop_id=:shop_id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("shop_id", shop_id);
		List<Goods> GoodsList = namedParameterJdbcTemplate.query(sql,sps,new BeanPropertyRowMapper<Goods>(Goods.class));
		return GoodsList;
	}
	
	public List<Goods> findGoodsByGoodsTypeId(int goodstype_id) {
		String sql = "select * from freshmall_goods where goodstype_id=:goodstype_id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("goodstype_id", goodstype_id);
		List<Goods> GoodsList = namedParameterJdbcTemplate.query(sql,sps,new BeanPropertyRowMapper<Goods>(Goods.class));
		return GoodsList;
	}
	
	/**
	 * 根据条件查询商品信息
	 * @param searchType
	 * @param searchvalue
	 * @param pageBean
	 * @return
	 */
	public List<Goods> findGoodsLimittimeBySearchPage(String searchType, String searchvalue, PageBean pageBean) {
		String sql = null;
		if (searchType.equals("goodsname")) {//如果搜索类型为按商品名称搜索
			sql = "select g.*,s.shop_name as shop_name,gt.goodstype_name as goodstype_name "
				+ "from freshmall_goods g,freshmall_shop s,freshmall_goodstype gt "
				+ "where g.shop_id=s.shop_id and g.goodstype_id=gt.goodstype_id and g.goods_promote=2 and g.goods_name like '%"+searchvalue+"%' limit " + pageBean.getStart()
					+ "," + pageBean.getPageSize() + "";
		}
		List<Goods> GoodsList = namedParameterJdbcTemplate.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Goods>(Goods.class));
		return GoodsList;
	}

	/**
	 * 根据条件查询商品数量
	 * @param searchType
	 * @param searchvalue
	 * @return
	 */
	public int GoodsCountLimittimeBySearch(String searchType, String searchvalue) {
		MapSqlParameterSource sps = new MapSqlParameterSource();
		String sql = null;
		if (searchType.equals("goodsname")) {
			sql = "select count(*) total from freshmall_goods where goods_promote=2 and goods_name like '%"+searchvalue+"%'";
		}
		int totals = 0;
		totals = (int) namedParameterJdbcTemplate.queryForLong(sql, sps);
		return totals;
	}
	
	public List<Goods> findGoodsLimittimeByPage(Goods goods, PageBean pageBean) {
		String sql = "select g.*,s.shop_name as shop_name,gt.goodstype_name as goodstype_name "
				+ "from freshmall_goods g,freshmall_shop s,freshmall_goodstype gt "
				+ "where g.shop_id=s.shop_id and g.goodstype_id=gt.goodstype_id and g.goods_promote=2 limit " + pageBean.getStart()
		+ "," + pageBean.getPageSize() + "";
		List<Goods> GoodsList = namedParameterJdbcTemplate.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Goods>(Goods.class));
		return GoodsList;
	}

	public int GoodsCountLimittime(Goods goods) {
		String sql = "select count(*) total from freshmall_goods where goods_promote=2";
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
	    public List<Goods> findGoodsBySearchPage(String searchType, String searchvalue, PageBean pageBean) {
		String sql = null;
		if (searchType.equals("goodsname")) {//如果搜索类型为按商品名称搜索
			sql = "select g.*,s.shop_name as shop_name,gt.goodstype_name as goodstype_name "
				+ "from freshmall_goods g,freshmall_shop s,freshmall_goodstype gt "
				+ "where g.shop_id=s.shop_id and g.goodstype_id=gt.goodstype_id and g.goods_promote=1 and g.goods_name like '%"+searchvalue+"%' limit " + pageBean.getStart()
					+ "," + pageBean.getPageSize() + "";
		}
		List<Goods> GoodsList = namedParameterJdbcTemplate.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Goods>(Goods.class));
		return GoodsList;
	}
	
/*	public static List<Goods> findGoodsBySearchPage(String searchType, String searchvalue, PageBean pageBean) {
		String sql = null;
		if (searchType.equals("goodsname")) {//如果搜索类型为按商品名称搜索
			sql = "select * from interest_course where course_name like '%"+searchvalue+"%' limit " + pageBean.getStart()
			+ "," + pageBean.getPageSize() + "";
		}
		List<Goods> GoodsList = namedParameterJdbcTemplate.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Goods>(Goods.class));
		return GoodsList;
	}*/
	

	/**
	 * 根据条件查询商品数量
	 * @param searchType
	 * @param searchvalue
	 * @return
	 */
	    public int GoodsCountBySearch(String searchType, String searchvalue) {
		MapSqlParameterSource sps = new MapSqlParameterSource();
		String sql = null;
		if (searchType.equals("goodsname")) {
			sql = "select count(*) total from freshmall_goods where goods_promote=1 and goods_name like '%"+searchvalue+"%'";
		}
		int totals = 0;
		totals = (int) namedParameterJdbcTemplate.queryForLong(sql, sps);
		return totals;
	}	
	
	/*  public static int GoodsCountBySearch(String searchType, String searchvalue) {
		MapSqlParameterSource sps = new MapSqlParameterSource();
		String sql = null;
		if (searchType.equals("goodsname")) {
			sql = "select count(*) total from freshmall_goods where goods_promote=1 and goods_name like '%"+searchvalue+"%'";
		}
		int totals = 0;
		totals = (int) namedParameterJdbcTemplate.queryForLong(sql, sps);
		return totals;
	}*/
	
	
	/**
	 * 根据条件查询商品信息（value）
	 * @param searchType
	 * @param searchvalue
	 * @param pageBean
	 * @return
	 */
    	public static List<Goods> findGoodsBySearchPageValue(String searchvalue, PageBean pageBean) {
		String sql = "select g.*,s.shop_name as shop_name,gt.goodstype_name as goodstype_name "
				+ "from freshmall_goods g,freshmall_shop s,freshmall_goodstype gt "
				+ "where g.shop_id=s.shop_id and g.goodstype_id=gt.goodstype_id and g.goods_name like '%"+searchvalue+"%' limit " + pageBean.getStart()
					+ "," + pageBean.getPageSize() + "";
		List<Goods> GoodsList = namedParameterJdbcTemplate.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Goods>(Goods.class));
		return GoodsList;
	}
	
/*	public static List<Goods> findGoodsBySearchPageValue(String searchvalue, PageBean pageBean) {
		// TODO Auto-generated method stub
		String sql = "select * from interest_course where course_name like '%"+searchvalue+"%' limit " + pageBean.getStart()
					+ "," + pageBean.getPageSize() + "";
		String sql = "select * from freshmall_goods where goods_name like '%"+searchvalue+"%' limit " + pageBean.getStart()
		             + "," + pageBean.getPageSize() + "";
		List<Goods> GoodsList = namedParameterJdbcTemplate.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Goods>(Goods.class));
		return GoodsList;
	}*/

	

	/**
	 * 根据条件查询商品数量（value）
	 * @param searchType
	 * @param searchvalue
	 * @return
	 */
	    public static int GoodsCountBySearchValue(String searchvalue) {
		MapSqlParameterSource sps = new MapSqlParameterSource();
		String sql = "select count(*) total from freshmall_goods where goods_name like '%"+searchvalue+"%'";
		int totals = 0;
		totals = (int) namedParameterJdbcTemplate.queryForLong(sql, sps);
		return totals;
	}

/*	    public static int GoodsCountBySearchValue(String searchvalue) {
		// TODO Auto-generated method stub
		MapSqlParameterSource sps = new MapSqlParameterSource();
		String sql = "select count(*) total from freshmall_goods where goods_name like '%"+searchvalue+"%'";
		int totals = 0;
		totals = (int) namedParameterJdbcTemplate.queryForLong(sql, sps);
		return totals;
	}*/
	
}
