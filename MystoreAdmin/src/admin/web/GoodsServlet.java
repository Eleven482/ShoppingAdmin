package admin.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import admin.domain.Category;
import admin.domain.Goods;
import admin.domain.PageBean;
import admin.service.CategoryService;
import admin.service.GoodsService;

@WebServlet("/GoodsServlet")
public class GoodsServlet extends BaseServlet {

	// ����id��ѯ��Ʒ
	public String search(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 1.���ղ��� id
		String id = request.getParameter("id");
		System.out.println("id is :" + id);
		// ��ȡ��ǰҳ��
		String currentPage = request.getParameter("currentPage");
		// 2.���÷���㣬���������Ʒ
		GoodsService goodsService = new GoodsService();
		try {
			goodsService.getGoodsWithId(id);
			return "/GoodsServlet?action=getPageData&currentPage=" + currentPage;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// �����Ʒ
	public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// ��ȡ���в���
		Map<String, String[]> parameterMap = request.getParameterMap();
		System.out.println(parameterMap);
		// �Ѳ�����װ����
		Goods goods = new Goods();
		try {
			BeanUtils.populate(goods, parameterMap);
			goods.setImage("goods_011.png"); // д����ͼƬ����Ҫ�Ľ���
			System.out.println(goods);
			// ���÷����
			GoodsService goodsService = new GoodsService();
			goodsService.addGoods(goods);
			// ��ת�б�
			return "/GoodsServlet?action=getPageData&currentPage=1";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// �����ƷUI
	public String addUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.ȡ�����еķ���
		CategoryService categoryService = new CategoryService();
		try {
			List<Category> allCategory = categoryService.findCategory();
			// 2.�ѷ������ ����
			request.setAttribute("allCategory", allCategory);
			System.out.println(allCategory);
			// 3.ת��add.jsp
			return "admin/add.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// �༭��Ʒ
	public String edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		// 1.��ȡ���еĲ���
		Map<String, String[]> parameterMap = request.getParameterMap();
		Goods goods = new Goods();
		// 2.��װ��goods����
		try {
			BeanUtils.populate(goods, parameterMap);
			// 3-1.����id��������
			System.out.println(goods);
			// 3-2.��ȡҪ�޸ĵ���Ʒ���ڵ�ҳ��
			String thecurrentPage = request.getParameter("currentPage");
			System.out.println("currentPage is :" + thecurrentPage);
			// 4.���÷���㣬��������
			GoodsService goodsService = new GoodsService();
			goods.setImage("goods_010.png");
			goodsService.updateGoods(goods);
			// 5.��ת��main.jsp �б�
			return "/GoodsServlet?action=getPageData&currentPage=" + thecurrentPage;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// �༭��ƷUI
	public String editUI(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ��ǰ��Ʒ��id
		String id = request.getParameter("id");
		// ��ȡ��ǰҳ��
		String currentPage = request.getParameter("currentPage");
		try {
			// 1.��ȡ��ǰ��Ʒ
			GoodsService goodsService = new GoodsService();
			Goods goods = goodsService.getGoodsWithId(id);
			// ����Ʒд����
			request.setAttribute("goods", goods);
			// ��ҳ��д����
			request.setAttribute("currentPage", currentPage);
			// 2.��ȡ���еķ���
			CategoryService categoryService = new CategoryService();
			List<Category> allCategory = categoryService.findCategory();
			request.setAttribute("allCategory", allCategory);
			// ת����edit.jsp
			return "/admin/edit.jsp";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// ɾ����Ʒ
	public String delGoods(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.���ղ��� id
		String id = request.getParameter("id");
		// 1-2.��ȡҪ�޸ĵ���Ʒ���ڵ�ҳ��
		String thecurrentPage = request.getParameter("currentPage");
		System.out.println("currentPage is :" + thecurrentPage);
		// 2.���÷���㣬����ɾ����Ʒ
		GoodsService goodsService = new GoodsService();
		try {
			goodsService.deleteGoods(id);
			return "/GoodsServlet?action=getPageData&currentPage=" + thecurrentPage;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// ��ȡ���е���Ʒ
	public String getListGoods(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.���÷����
		GoodsService goodsService = new GoodsService();
		try {
			List<Goods> allGoods = goodsService.getAllGoods();
			// �Լ��Ͻ��з�ת
			Collections.reverse(allGoods);
			// ������д��request��
			request.setAttribute("allGoods", allGoods);
			// ת��
			return "admin/main.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getPageData(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// ��ȡ��ǰҳ��
			String currentPage = request.getParameter("currentPage");
			// ��ҳ���ҵ��㣬����ҳ������һ��pageBean
			GoodsService goodsService = new GoodsService();
			PageBean pageBean = goodsService.getPageBean(Integer.parseInt(currentPage));
			// ��pageBeanд������
			request.setAttribute("pageBean", pageBean);
			// ת��
			return "admin/main.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

}
