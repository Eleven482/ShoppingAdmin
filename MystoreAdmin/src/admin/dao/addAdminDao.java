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
	//�����ݿ⵱�в�ѯ���й���Ա�б�
		public List<Admin> getAllAdmin() throws SQLException{
			
			//1.��ѯ����
			String sql = "select * from admin";
			//2ִ��sql
			List<Admin> alladmin = null;
			alladmin = qr.query(sql, new BeanListHandler<Admin>(Admin.class));
			return alladmin;
		}
	//��ӹ���Ա�����ݿ⵱��
		public void addAdmin(Admin admin) throws SQLException {
			//�������
			String sql = "insert into admin(username,password) value (?,?)";
			qr.update(sql,admin.getUsername(),admin.getPassword());
		}
}
