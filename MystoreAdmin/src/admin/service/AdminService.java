package admin.service;

import java.sql.SQLException;

import admin.dao.AdminDao;
import admin.domain.Admin;

public class AdminService {

	public Admin login(String name, String pwd) throws Exception {
		//����dao�㵽���ݿ⵱�в�ѯ
		AdminDao adminDao = new AdminDao();
		Admin admin = adminDao.checkAdmin(name,pwd);
		if(admin != null) {
			return admin;
		}else {
			throw new Exception("�û������������");
		}
	}

}
