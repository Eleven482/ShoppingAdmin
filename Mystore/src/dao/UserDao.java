package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import domain.User;
import util.JdbcUtil;

public class UserDao {
	private static  QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
	//1.从数据库当中查询所有商品列表
	public List<User> getUser() throws SQLException{
		
		//1.查询操作
		String sql = "select * from goods";
		//2执行sql
		List<User> user = null;
		user = qr.query(sql, new BeanListHandler<User>(User.class));
		return user;
	}
	/*//2.添加商品到数据库当中
	public void addGoods(Goods goods) throws SQLException {
		//插入操作9
		String sql = "insert into goods(name,price,image,gdesc,is_hot,cid) value (?,?,?,?,?,?)";
		qr.update(sql,goods.getName(),goods.getPrice(),goods.getImage(),goods.getGdesc(),goods.getIs_hot(),goods.getCid());
	}*/
	
	/*//3.根据id从数据库当中删除一个商品
	public void delGoods(int id) throws SQLException {
		//删除操作
		String sql = "delete from goods where id=?";
		qr.update(sql,id);
	}*/
	
	//4.传入一个商品，到数据库中根据id更新该商品
	public static  void updateUser(User user) throws SQLException {
		//更新操作
		String sql = "update user set username=?,password=?,phone=? where uid=?";
		qr.update(sql,user.getUsername(),user.getPassword(),user.getPhone(),user.getUid());
	}
	//5.根据id查询一个商品
	public User getuserWithId(String uid) throws Exception {
		
		String sql = "select * from user where uid=?";
		User user = qr.query(sql, new BeanHandler<User>(User.class),Integer.parseInt(uid));
		return user;
		
	}

   /* public Long getCount() throws SQLException {
		String sql = "select count(*) from goods";
		Long count = (Long) qr.query(sql,new ScalarHandler());
		return count;
    }

	public List<Goods> getPageData(Integer index, Integer pageCount) throws SQLException {
		String sql = "select * from goods limit ?,?";
		List<Goods> pageGoods  = qr.query(sql, new BeanListHandler<Goods>(Goods.class),index,pageCount);
		return pageGoods;
	}*/
}
