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
		1.�������ݿ�
		2.�����ݿ⵱�л�ȡ����
		3.�Ѵ����ݿ���ȡ�������ݴ�ŵ�request����
		4.ת������Ʒ�б�ҳ�棬ת��ʱ��request������
		*/
		// 0.���ղ��� id
		String id = request.getParameter("id");
		//1.�������ݿ�
		QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
		//2.�����ݿ⵱�л�ȡ����
		String sql ="select * from goods where cid = ?";
		List<Goods> allGoods = null;
		try {
			
			allGoods = qr.query(sql, new BeanListHandler<Goods>(Goods.class),Integer.parseInt(id));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(allGoods);
		//3.�Ѵ����ݿ���ȡ�������ݴ�ŵ�request����
		request.setAttribute("allGoods", allGoods);
		//4.ת������Ʒ�б�ҳ�棬ת��ʱ��request������
		request.getRequestDispatcher("/goods_list.jsp").forward(request, response);
	}
}
