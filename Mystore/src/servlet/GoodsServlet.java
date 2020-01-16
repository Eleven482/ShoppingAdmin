package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import domain.Goods;
import util.JdbcUtil;

@WebServlet("/GoodsServlet")
public class GoodsServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/**
		1.连接数据库
		2.从数据库当中获取数据
		3.把从数据库中取出的数据存放到request域当中
		4.转发到商品列表页面，转发时把request对象传入
		*/
		// 0.接收参数 id
		String id = request.getParameter("id");
		//1.连接数据库
		QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
		//2.从数据库当中获取数据
		String sql ="select * from goods where cid = ?";
		List<Goods> allGoods = null;
		try {
			
			allGoods = qr.query(sql, new BeanListHandler<Goods>(Goods.class),Integer.parseInt(id));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(allGoods);
		//3.把从数据库中取出的数据存放到request域当中
		request.setAttribute("allGoods", allGoods);
		//4.转发到商品列表页面，转发时把request对象传入
		request.getRequestDispatcher("/goods_list.jsp").forward(request, response);
	}
}
