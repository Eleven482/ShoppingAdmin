package admin.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;

import admin.domain.Admin;
import admin.domain.Goods;
import admin.service.GoodsService;
import admin.service.addAdminService;
import admin.utils.JdbcUtil;

@WebServlet("/addAdminServlet")
public class addAdminServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	// ��ȡ���й���Ա
		public String getListAdmin(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
			// 1.���÷����
			addAdminService addadminService = new addAdminService();
			try {
				List<Admin> alladmin = addadminService.getAllAdmin();
				
				// ������д��request��
				request.setAttribute("alladmin", alladmin);  
				// ת����jsp
				return "admin/account.jsp";
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
    //��ӹ���Ա
	public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("׼������û�");
		request.setCharacterEncoding("utf-8");
		//���ղ���
		Map<String, String[]> parameterMap = request.getParameterMap();
	
		Admin admin=new Admin();
		String name=request.getParameter("adminname");
		System.out.println(name);
		try {
			BeanUtils.populate(admin, parameterMap);
			System.out.println("nihao");
			System.out.println(admin);
			// ���÷����
				addAdminService addadminService = new addAdminService();
				addadminService.addAdmin(admin);
				// ��ת�б�
			return "addAdminServlet?action=getListAdmin";
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		return null;
	}

}
