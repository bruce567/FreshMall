package com.freshmall.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.freshmall.model.AdminUser;
import com.freshmall.model.PageBean;

/**
 * 管理员实现类
 * @author Administrator
 *
 */
public class AdminUserDao {
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return namedParameterJdbcTemplate;
	}

	public void setNamedParameterJdbcTemplate(
			NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public AdminUser adminLogin(String adminuser_username, String adminuser_password) {
		String sql = "select * from freshmall_adminuser where adminuser_username=:adminuser_username and adminuser_password=:adminuser_password and role_id=1";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("adminuser_username", adminuser_username);
		sps.addValue("adminuser_password", adminuser_password);
		final AdminUser adminUser = new AdminUser();
		namedParameterJdbcTemplate.query(sql,sps, new RowCallbackHandler() {
			public void processRow(ResultSet rs) throws SQLException {
				adminUser.setAdminuser_username(rs.getString("adminuser_username"));
				adminUser.setAdminuser_id(rs.getInt("adminuser_id"));
				adminUser.setAdminuser_lastertime(rs.getString("adminuser_lastertime"));
				adminUser.setAdminuser_iphone(rs.getString("adminuser_iphone"));
				adminUser.setAdminuser_status(rs.getInt("adminuser_status"));
				adminUser.setRole_id(rs.getInt("role_id"));
			}
		});
		return adminUser;
	}
	
	public int addAdminUser(AdminUser adminuser) {
		String sql = "INSERT INTO freshmall_adminuser(adminuser_sn,adminuser_username,"
				+ "adminuser_password,adminuser_sex,adminuser_age,adminuser_iphone,"
				+ "adminuser_email,adminuser_lastertime,"
				+ "adminuser_lasterip,adminuser_registertime,"
				+ "adminuser_status,role_id,adminuser_image) " +
				"VALUES(:adminuser_sn,:adminuser_username,"
				+ ":adminuser_password,:adminuser_sex,:adminuser_age,:adminuser_iphone,"
				+ ":adminuser_email,:adminuser_lastertime,"
				+ ":adminuser_lasterip,:adminuser_registertime,"
				+ ":adminuser_status,:role_id,:adminuser_image)";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("adminuser_sn", adminuser.getAdminuser_sn());
		sps.addValue("adminuser_username", adminuser.getAdminuser_username());
		sps.addValue("adminuser_password", adminuser.getAdminuser_password());
		sps.addValue("adminuser_sex", adminuser.getAdminuser_sex());
		sps.addValue("adminuser_age", adminuser.getAdminuser_age());
		sps.addValue("adminuser_iphone", adminuser.getAdminuser_iphone());
		sps.addValue("adminuser_email", adminuser.getAdminuser_email());
		sps.addValue("adminuser_lastertime", adminuser.getAdminuser_lastertime());
		sps.addValue("adminuser_lasterip", adminuser.getAdminuser_lasterip());
		sps.addValue("adminuser_registertime", adminuser.getAdminuser_registertime());
		sps.addValue("adminuser_status", adminuser.getAdminuser_status());
		sps.addValue("role_id", adminuser.getRole_id());
		sps.addValue("adminuser_image", adminuser.getAdminuser_image());
		KeyHolder keyholder = new GeneratedKeyHolder();
		namedParameterJdbcTemplate.update(sql, sps, keyholder);
		// 加上KeyHolder这个参数可以得到添加后主键的值
		int m = keyholder.getKey().intValue();
		return m;
	}

	public int updateAdminUser(AdminUser adminuser) {
		String sql = "update freshmall_adminuser set adminuser_sn=:adminuser_sn,"
				+ "adminuser_username=:adminuser_username,adminuser_password=:adminuser_password,"
				+ "adminuser_sex=:adminuser_sex,adminuser_age=:adminuser_age,"
				+ "adminuser_iphone=:adminuser_iphone,adminuser_email=:adminuser_email,"
				+ "adminuser_image=:adminuser_image  where adminuser_id=:adminuser_id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("adminuser_sn", adminuser.getAdminuser_sn());
		sps.addValue("adminuser_username", adminuser.getAdminuser_username());
		sps.addValue("adminuser_password", adminuser.getAdminuser_password());
		sps.addValue("adminuser_sex", adminuser.getAdminuser_sex());
		sps.addValue("adminuser_age", adminuser.getAdminuser_age());
		sps.addValue("adminuser_iphone", adminuser.getAdminuser_iphone());
		sps.addValue("adminuser_email", adminuser.getAdminuser_email());
		sps.addValue("adminuser_image", adminuser.getAdminuser_image());
		sps.addValue("adminuser_id", adminuser.getAdminuser_id());
		return namedParameterJdbcTemplate.update(sql, sps);
	}
	
	public int deleteAdminUser(int adminuser_id) {
		String sql = "delete from freshmall_adminuser where adminuser_id=:adminuser_id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("adminuser_id", adminuser_id);
		return namedParameterJdbcTemplate.update(sql, sps);
	}
	
	public List<AdminUser> findAdminUserByPage(AdminUser adminuser, PageBean pageBean) {
		String sql = "select * from freshmall_adminuser where role_id=1 limit " + pageBean.getStart()
		+ "," + pageBean.getPageSize() + "";
		List<AdminUser> AdminUserList = namedParameterJdbcTemplate.getJdbcOperations().query(sql,new BeanPropertyRowMapper<AdminUser>(AdminUser.class));
		return AdminUserList;
	}

	public int AdminUserCount(AdminUser adminuser) {
		String sql = "select count(*) total from freshmall_adminuser where role_id=1";
		int totals = 0;
		MapSqlParameterSource sps = new MapSqlParameterSource();
		totals = (int) namedParameterJdbcTemplate.queryForLong(sql, sps);
		return totals;
	}
	
	/**
	 * 根据条件查询管理员信息
	 * @param searchType
	 * @param searchvalue
	 * @param pageBean
	 * @return
	 */
	public List<AdminUser> findAdminUserBySearchPage(String searchType, String searchvalue, PageBean pageBean) {
		String sql = null;
		if (searchType.equals("adminusername")) {//如果搜索类型为按用户名称搜索
			sql = "select * from freshmall_adminuser where role_id=1 and adminuser_username like '%"+searchvalue+"%' limit " + pageBean.getStart()
					+ "," + pageBean.getPageSize() + "";
		} else if (searchType.equals("adminusersn")) {//如果搜索类型为按用户编号搜索
			sql = "select * from freshmall_adminuser where role_id=1 and adminuser_sn like '%"+searchvalue+"%' limit " + pageBean.getStart()
					+ "," + pageBean.getPageSize() + "";
		}
		List<AdminUser> AdminUserList = namedParameterJdbcTemplate.getJdbcOperations().query(sql,new BeanPropertyRowMapper<AdminUser>(AdminUser.class));
		return AdminUserList;
	}

	/**
	 * 根据条件查询管理员数量
	 * @param searchType
	 * @param searchvalue
	 * @return
	 */
	public int AdminUserCountBySearch(String searchType, String searchvalue) {
		MapSqlParameterSource sps = new MapSqlParameterSource();
		String sql = null;
		if (searchType.equals("adminusername")) {
			sql = "select count(*) total from freshmall_adminuser where role_id=1 and adminuser_username like '%"+searchvalue+"%'";
		} else if (searchType.equals("adminusersn")) {
			sql = "select count(*) total from freshmall_adminuser where role_id=1 and adminuser_sn like '%"+searchvalue+"%'";
		}
		int totals = 0;
		totals = (int) namedParameterJdbcTemplate.queryForLong(sql, sps);
		return totals;
	}

	public List<AdminUser> findAdminUsers(AdminUser AdminUser) {
		String sql = "select * from freshmall_adminuser ";
		List<AdminUser> AdminUserList = namedParameterJdbcTemplate.getJdbcOperations().query(sql,new BeanPropertyRowMapper<AdminUser>(AdminUser.class));
		return AdminUserList;
	}

	/**
	 * 通过管理员id查询管理员
	 * 
	 * @param adminuser_id
	 *            管理员id
	 * @return
	 */
	public AdminUser getAdminUserById(int AdminUser_id) {
		String sql = "select * from freshmall_adminuser where adminuser_id=:adminuser_id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("adminuser_id", AdminUser_id);
		return (AdminUser) namedParameterJdbcTemplate.queryForObject(sql, sps,
				new BeanPropertyRowMapper<AdminUser>(AdminUser.class));
	}
	
	/**
	 * 查询管理员的最大编号
	 * @param adminuser_id
	 * @return
	 */
	public int getAdminUserSnToMax() {
		String sql = "select max(adminuser_sn) from freshmall_adminuser";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		int totals = 0;
		totals = (int) namedParameterJdbcTemplate.queryForLong(sql, sps);
		return totals;
	}
	
	
	/**
	 * 根据管理员id设置管理员状态为锁定状态
	 * @param adminuser_id
	 * @return
	 */
	public int updateadminusertoclose(int adminuser_id) {
		String sql = "update freshmall_adminuser set adminuser_status=2 where adminuser_id=:adminuser_id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("adminuser_id", adminuser_id);
		return namedParameterJdbcTemplate.update(sql, sps);
	}
	
	/**
	 * 根据管理员id设置管理员状态为解锁状态
	 * @param adminuser_id
	 * @return
	 */
	public int updateadminusertoopen(int adminuser_id) {
		String sql = "update freshmall_adminuser set adminuser_status=1 where adminuser_id=:adminuser_id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("adminuser_id", adminuser_id);
		return namedParameterJdbcTemplate.update(sql, sps);
	}
	
	/**
	 * 根据管理员id和原密码查询管理员信息
	 * @param adminuser_id
	 * @param older_password
	 * @return
	 */
	public List<AdminUser> findOlderPasswordByAdminuserId(int adminuser_id, String older_password) {
		String sql = "select adminuser_id,adminuser_password from freshmall_adminuser where adminuser_id=:adminuser_id and adminuser_password=:older_password";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("adminuser_id", adminuser_id);
		sps.addValue("older_password", older_password);
		List<AdminUser> AdminUserList = namedParameterJdbcTemplate.query(sql,sps,new BeanPropertyRowMapper<AdminUser>(AdminUser.class));
		return AdminUserList;
	}
	
	/**
	 * 根据管理员id修改
	 * @param adminuser_id
	 * @return
	 */
	public int updateadminuserpassword(int adminuser_id, String older_password) {
		String sql = "update freshmall_adminuser set adminuser_password=:older_password where adminuser_id=:adminuser_id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("older_password", older_password);
		sps.addValue("adminuser_id", adminuser_id);
		return namedParameterJdbcTemplate.update(sql, sps);
	}
	
	/**
	 * 根据用户名查询用户信息
	 * @param adminuser_username
	 * @return
	 */
	public List<AdminUser> findAdminUserByAdminusername(String adminuser_username) {
		String sql = "select * from freshmall_adminuser where adminuser_username=:adminuser_username";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("adminuser_username", adminuser_username);
		List<AdminUser> AdminUserList = namedParameterJdbcTemplate.query(sql,sps,new BeanPropertyRowMapper<AdminUser>(AdminUser.class));
		return AdminUserList;
	}
	
	/**
	 * 根据管理员id修改该管理员的登录时间和登录ip
	 * @param adminuser_id
	 * @param adminuser_lastertime
	 * @param adminuser_lasterip
	 * @return
	 */
	public int updateAdminUserLasterTimeAndLasterIp(int adminuser_id, String adminuser_lastertime, String adminuser_lasterip) {
		String sql = "update freshmall_adminuser set adminuser_lastertime=:adminuser_lastertime,adminuser_lasterip=:adminuser_lasterip where adminuser_id=:adminuser_id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("adminuser_lastertime", adminuser_lastertime);
		sps.addValue("adminuser_lasterip", adminuser_lasterip);
		sps.addValue("adminuser_id", adminuser_id);
		return namedParameterJdbcTemplate.update(sql, sps);
	}
	
	public AdminUser userLogin(String adminuser_iphone, String adminuser_password) {
		String sql = "select * from freshmall_adminuser where adminuser_iphone=:adminuser_iphone and adminuser_password=:adminuser_password";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("adminuser_iphone", adminuser_iphone);
		sps.addValue("adminuser_password", adminuser_password);
		final AdminUser adminuser = new AdminUser();
		namedParameterJdbcTemplate.query(sql,sps, new RowCallbackHandler() {
			public void processRow(ResultSet rs) throws SQLException {
				adminuser.setAdminuser_id(rs.getInt("adminuser_id"));
				adminuser.setAdminuser_username(rs.getString("adminuser_username"));
				adminuser.setAdminuser_iphone(rs.getString("adminuser_iphone"));
			}
		});
		return adminuser;
	}
	
	/**
	 * 通过手机号码查询用户信息
	 * @param user_iphone
	 * @return
	 */
	public List<AdminUser> findUserByIphone(String adminuser_iphone) {
		String sql = "select * from freshmall_adminuser where adminuser_iphone=:adminuser_iphone";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("adminuser_iphone", adminuser_iphone);
		List<AdminUser> UserList = namedParameterJdbcTemplate.query(sql,sps,new BeanPropertyRowMapper<AdminUser>(AdminUser.class));
		return UserList;
	}
	
	public List<AdminUser> findAdminUserById(int adminuser_id) {
		String sql = "select * from freshmall_adminuser where adminuser_id=:adminuser_id ";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("adminuser_id", adminuser_id);
		List<AdminUser> AdminUserList = namedParameterJdbcTemplate.query(sql,sps,new BeanPropertyRowMapper<AdminUser>(AdminUser.class));
		return AdminUserList;
	}
	
	public int updateUserInfo(AdminUser adminuser) {
		String sql = "update freshmall_adminuser set adminuser_username=:adminuser_username,"
				+ "adminuser_password=:adminuser_password where adminuser_id=:adminuser_id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("adminuser_username", adminuser.getAdminuser_username());
		sps.addValue("adminuser_password", adminuser.getAdminuser_password());
		sps.addValue("adminuser_id", adminuser.getAdminuser_id());
		return namedParameterJdbcTemplate.update(sql, sps);
	}
	
	/**
	 * 根据条件查询用户信息
	 * @param searchType
	 * @param searchvalue
	 * @param pageBean
	 * @return
	 */
	public List<AdminUser> findUserBySearchPage(String searchType, String searchvalue, PageBean pageBean) {
		String sql = null;
		if (searchType.equals("adminusername")) {//如果搜索类型为按用户名称搜索
			sql = "select * from freshmall_adminuser where role_id=2 and adminuser_username like '%"+searchvalue+"%' limit " + pageBean.getStart()
					+ "," + pageBean.getPageSize() + "";
		} else if (searchType.equals("adminusersn")) {//如果搜索类型为按用户编号搜索
			sql = "select * from freshmall_adminuser where role_id=2 and adminuser_sn like '%"+searchvalue+"%' limit " + pageBean.getStart()
					+ "," + pageBean.getPageSize() + "";
		}
		List<AdminUser> AdminUserList = namedParameterJdbcTemplate.getJdbcOperations().query(sql,new BeanPropertyRowMapper<AdminUser>(AdminUser.class));
		return AdminUserList;
	}

	/**
	 * 根据条件查询用户数量
	 * @param searchType
	 * @param searchvalue
	 * @return
	 */
	public int UserCountBySearch(String searchType, String searchvalue) {
		MapSqlParameterSource sps = new MapSqlParameterSource();
		String sql = null;
		if (searchType.equals("adminusername")) {
			sql = "select count(*) total from freshmall_adminuser where role_id=2 and adminuser_username like '%"+searchvalue+"%'";
		} else if (searchType.equals("adminusersn")) {
			sql = "select count(*) total from freshmall_adminuser where role_id=2 and adminuser_sn like '%"+searchvalue+"%'";
		}
		int totals = 0;
		totals = (int) namedParameterJdbcTemplate.queryForLong(sql, sps);
		return totals;
	}
	
	public List<AdminUser> findUserByPage(AdminUser adminuser, PageBean pageBean) {
		String sql = "select * from freshmall_adminuser where role_id=2 limit " + pageBean.getStart()
		+ "," + pageBean.getPageSize() + "";
		List<AdminUser> AdminUserList = namedParameterJdbcTemplate.getJdbcOperations().query(sql,new BeanPropertyRowMapper<AdminUser>(AdminUser.class));
		return AdminUserList;
	}

	public int UserCount(AdminUser adminuser) {
		String sql = "select count(*) total from freshmall_adminuser where role_id=2";
		int totals = 0;
		MapSqlParameterSource sps = new MapSqlParameterSource();
		totals = (int) namedParameterJdbcTemplate.queryForLong(sql, sps);
		return totals;
	}
	
	
}
