package service;

import java.sql.SQLException;
import java.util.List;

import dao.UserDao;
import domain.User;

public class UserService {
	private  UserDao userDao = new UserDao();
	public List<User> getUser() throws SQLException {
		//从数据库当中获取所有的数据
		List<User> user = userDao.getUser();
		return user;
	}

	/*public void deleteGoods(String id) throws Exception {
		//调用dao让其删除商品
		UserDao.deluser(Integer.parseInt(id)); 
	}*/

	/*public void addGoods(User goods) throws Exception {
		//调用dao 插入操作
		UserDao.addGoods(goods);
		
	}*/

	public User getuserWithId(String uid) throws Exception {
		//调用dao 查询一个商品根据id操作
		User user = userDao.getuserWithId(uid);
	 	return user;
	}

	public void updateUser(User user) throws Exception {
		//调用dao 更新商品
		UserDao.updateUser(user);
	}

}
