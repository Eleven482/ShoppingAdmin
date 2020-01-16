package admin.service;

import java.sql.SQLException;
import java.util.List;

import admin.dao.GoodsDao;
import admin.domain.Goods;
import admin.domain.PageBean;

public class GoodsService {
	private  GoodsDao goodsDao = new GoodsDao();
	public List<Goods> getAllGoods() throws SQLException {
		//从数据库当中获取所有的数据
		List<Goods> allGoods = goodsDao.getAllGoods();
		return allGoods;
	}

	public void deleteGoods(String id) throws Exception {
		//调用dao让其删除商品
		goodsDao.delGoods(Integer.parseInt(id)); 
	}

	public void addGoods(Goods goods) throws Exception {
		//调用dao 插入操作
		goodsDao.addGoods(goods);
		
	}

	public Goods getGoodsWithId(String id) throws Exception {
		//调用dao 查询一个商品根据id操作
	 	Goods goods = goodsDao.getGoodsWithId(id);
	 	return goods;
	}

	public void updateGoods(Goods goods) throws Exception {
		//调用dao 更新商品
		goodsDao.updateGoods(goods);
	}


    public PageBean getPageBean(Integer currentPage) throws SQLException {
		PageBean pageBean = new PageBean();
		//设置当前页
		pageBean.setCurrentPage(currentPage);
		//获取有多少条记录 -- 从数据库中查询
		Long count = goodsDao.getCount();
		pageBean.setTotalCount(count.intValue());
		//一页展示多少数据
		Integer pageCount = 5;
		//总页数  -- 向上取整
		double totalPage = Math.ceil(1.0 * pageBean.getTotalCount() / pageCount);
		pageBean.setTotalPage((int) totalPage);
		//当前页查询的角标
		Integer index = (pageBean.getCurrentPage()-1 )* pageCount;
		List<Goods> list = goodsDao.getPageData(index, pageCount);
		pageBean.setGoodsList(list);
		return pageBean;
    }
}
