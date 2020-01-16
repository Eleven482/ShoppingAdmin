package admin.service;

import java.sql.SQLException;
import java.util.List;

import admin.dao.GoodsDao;
import admin.dao.addAdminDao;
import admin.domain.Admin;
import admin.domain.Goods;

 public class addAdminService {
	 private  addAdminDao addadminDao = new addAdminDao();
	 
	 public List<Admin> getAllAdmin() throws SQLException {
			//从数据库当中获取所有的数据
			List<Admin> alladmin = addadminDao.getAllAdmin();
			return alladmin;
		}

	 public void addAdmin(Admin admin) throws Exception {
			//调用dao 插入操作
			addadminDao.addAdmin(admin);
			
		}
}
