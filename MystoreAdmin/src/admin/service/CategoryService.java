package admin.service;

import java.util.List;

import admin.dao.CategoryDao;
import admin.domain.Category;

public class CategoryService {

	//��ȡ���еķ�����Ϣ
	public List<Category> findCategory() throws Exception {
		//�����ݿ⵱�в���
		CategoryDao categoryDao = new CategoryDao();
		List<Category> allCategory = categoryDao.getAllCategory();
		return allCategory;
	}

}