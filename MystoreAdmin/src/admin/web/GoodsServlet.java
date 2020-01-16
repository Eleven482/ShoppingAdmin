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

	// 根据id查询商品
	public String search(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 1.接收参数 id
		String id = request.getParameter("id");
		System.out.println("id is :" + id);
		// 获取当前页码
		String currentPage = request.getParameter("currentPage");
		// 2.调用服务层，让其查找商品
		GoodsService goodsService = new GoodsService();
		try {
			goodsService.getGoodsWithId(id);
			return "/GoodsServlet?action=getPageData&currentPage=" + currentPage;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// 添加商品
	public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 获取所有参数
		Map<String, String[]> parameterMap = request.getParameterMap();
		System.out.println(parameterMap);
		// 把参数封装对象
		Goods goods = new Goods();
		try {
			BeanUtils.populate(goods, parameterMap);
			goods.setImage("goods_011.png"); // 写死的图片，需要改进！
			System.out.println(goods);
			// 调用服务层
			GoodsService goodsService = new GoodsService();
			goodsService.addGoods(goods);
			// 跳转列表，
			return "/GoodsServlet?action=getPageData&currentPage=1";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 添加商品UI
	public String addUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.取出所有的分类
		CategoryService categoryService = new CategoryService();
		try {
			List<Category> allCategory = categoryService.findCategory();
			// 2.把分类存域 当中
			request.setAttribute("allCategory", allCategory);
			System.out.println(allCategory);
			// 3.转发add.jsp
			return "admin/add.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// 编辑商品
	public String edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		// 1.获取所有的参数
		Map<String, String[]> parameterMap = request.getParameterMap();
		Goods goods = new Goods();
		// 2.封装成goods对象
		try {
			BeanUtils.populate(goods, parameterMap);
			// 3-1.根据id更新数据
			System.out.println(goods);
			// 3-2.获取要修改的商品所在的页码
			String thecurrentPage = request.getParameter("currentPage");
			System.out.println("currentPage is :" + thecurrentPage);
			// 4.调用服务层，更新数据
			GoodsService goodsService = new GoodsService();
			goods.setImage("goods_010.png");
			goodsService.updateGoods(goods);
			// 5.跳转回main.jsp 列表
			return "/GoodsServlet?action=getPageData&currentPage=" + thecurrentPage;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// 编辑商品UI
	public String editUI(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取当前商品的id
		String id = request.getParameter("id");
		// 获取当前页码
		String currentPage = request.getParameter("currentPage");
		try {
			// 1.获取当前商品
			GoodsService goodsService = new GoodsService();
			Goods goods = goodsService.getGoodsWithId(id);
			// 把商品写到域
			request.setAttribute("goods", goods);
			// 把页码写到域
			request.setAttribute("currentPage", currentPage);
			// 2.获取所有的分类
			CategoryService categoryService = new CategoryService();
			List<Category> allCategory = categoryService.findCategory();
			request.setAttribute("allCategory", allCategory);
			// 转发到edit.jsp
			return "/admin/edit.jsp";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 删除商品
	public String delGoods(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.接收参数 id
		String id = request.getParameter("id");
		// 1-2.获取要修改的商品所在的页码
		String thecurrentPage = request.getParameter("currentPage");
		System.out.println("currentPage is :" + thecurrentPage);
		// 2.调用服务层，让其删除商品
		GoodsService goodsService = new GoodsService();
		try {
			goodsService.deleteGoods(id);
			return "/GoodsServlet?action=getPageData&currentPage=" + thecurrentPage;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// 获取所有的商品
	public String getListGoods(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.调用服务层
		GoodsService goodsService = new GoodsService();
		try {
			List<Goods> allGoods = goodsService.getAllGoods();
			// 对集合进行反转
			Collections.reverse(allGoods);
			// 把数据写到request域
			request.setAttribute("allGoods", allGoods);
			// 转发
			return "admin/main.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getPageData(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// 获取当前页码
			String currentPage = request.getParameter("currentPage");
			// 把页码给业务层，根据页码生成一个pageBean
			GoodsService goodsService = new GoodsService();
			PageBean pageBean = goodsService.getPageBean(Integer.parseInt(currentPage));
			// 把pageBean写到域中
			request.setAttribute("pageBean", pageBean);
			// 转发
			return "admin/main.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

}
