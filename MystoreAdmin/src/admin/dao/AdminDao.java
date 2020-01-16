package admin.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import admin.domain.Admin;
import admin.utils.JdbcUtil;

public class AdminDao {

	public Admin checkAdmin(String name, String pwd) throws SQLException {
		
		//到数据库当中查询
		//1.连接
		QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
		//2.查询
		String sql ="select * from admin where username=? and password=?";
		//3.执行查询
		Admin admin = null;
		admin = qr.query(sql, new BeanHandler<Admin>(Admin.class),name,pwd);
		//返回查询结果
		return admin;
		
	}

}
