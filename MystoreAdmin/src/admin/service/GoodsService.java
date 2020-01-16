package admin.service;

import java.sql.SQLException;
import java.util.List;

import admin.dao.GoodsDao;
import admin.domain.Goods;
import admin.domain.PageBean;

public class GoodsService {
	private  GoodsDao goodsDao = new GoodsDao();
	public List<Goods> getAllGoods() throws SQLException {
		//�����ݿ⵱�л�ȡ���е�����
		List<Goods> allGoods = goodsDao.getAllGoods();
		return allGoods;
	}

	public void deleteGoods(String id) throws Exception {
		//����dao����ɾ����Ʒ
		goodsDao.delGoods(Integer.parseInt(id)); 
	}

	public void addGoods(Goods goods) throws Exception {
		//����dao �������
		goodsDao.addGoods(goods);
		
	}

	public Goods getGoodsWithId(String id) throws Exception {
		//����dao ��ѯһ����Ʒ����id����
	 	Goods goods = goodsDao.getGoodsWithId(id);
	 	return goods;
	}

	public void updateGoods(Goods goods) throws Exception {
		//����dao ������Ʒ
		goodsDao.updateGoods(goods);
	}


    public PageBean getPageBean(Integer currentPage) throws SQLException {
		PageBean pageBean = new PageBean();
		//���õ�ǰҳ
		pageBean.setCurrentPage(currentPage);
		//��ȡ�ж�������¼ -- �����ݿ��в�ѯ
		Long count = goodsDao.getCount();
		pageBean.setTotalCount(count.intValue());
		//һҳչʾ��������
		Integer pageCount = 5;
		//��ҳ��  -- ����ȡ��
		double totalPage = Math.ceil(1.0 * pageBean.getTotalCount() / pageCount);
		pageBean.setTotalPage((int) totalPage);
		//��ǰҳ��ѯ�ĽǱ�
		Integer index = (pageBean.getCurrentPage()-1 )* pageCount;
		List<Goods> list = goodsDao.getPageData(index, pageCount);
		pageBean.setGoodsList(list);
		return pageBean;
    }
}
