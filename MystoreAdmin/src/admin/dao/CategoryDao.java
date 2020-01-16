package admin.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import admin.domain.Category;
import admin.utils.JdbcUtil;

public class CategoryDao {

	//��ȡ���з�����Ϣ
	public List<Category> getAllCategory() throws Exception {
		
		QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
		List<Category> allCategory = null;
		allCategory = qr.query("select * from category", new BeanListHandler<Category>(Category.class));
		return allCategory;
		
	}

}
