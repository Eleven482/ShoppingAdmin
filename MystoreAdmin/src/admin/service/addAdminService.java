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
			//�����ݿ⵱�л�ȡ���е�����
			List<Admin> alladmin = addadminDao.getAllAdmin();
			return alladmin;
		}

	 public void addAdmin(Admin admin) throws Exception {
			//����dao �������
			addadminDao.addAdmin(admin);
			
		}
}
