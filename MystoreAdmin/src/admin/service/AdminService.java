package admin.service;

import java.sql.SQLException;

import admin.dao.AdminDao;
import admin.domain.Admin;

public class AdminService {

	public Admin login(String name, String pwd) throws Exception {
		//调用dao层到数据库当中查询
		AdminDao adminDao = new AdminDao();
		Admin admin = adminDao.checkAdmin(name,pwd);
		if(admin != null) {
			return admin;
		}else {
			throw new Exception("用户名或密码错误");
		}
	}

}
