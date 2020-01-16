package admin.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import admin.domain.Admin;
import admin.domain.Goods;
import admin.utils.JdbcUtil;

public class addAdminDao {
	private QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
	//从数据库当中查询所有管理员列表
		public List<Admin> getAllAdmin() throws SQLException{
			
			//1.查询操作
			String sql = "select * from admin";
			//2执行sql
			List<Admin> alladmin = null;
			alladmin = qr.query(sql, new BeanListHandler<Admin>(Admin.class));
			return alladmin;
		}
	//添加管理员到数据库当中
		public void addAdmin(Admin admin) throws SQLException {
			//插入操作
			String sql = "insert into admin(username,password) value (?,?)";
			qr.update(sql,admin.getUsername(),admin.getPassword());
		}
}
