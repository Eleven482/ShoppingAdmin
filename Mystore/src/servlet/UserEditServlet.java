package servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import domain.User;
import service.UserService;

/**
 * Servlet implementation class UserEditServlet
 */
@WebServlet("/UserEditServlet")
public class UserEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		// 测试
		System.out.println("UserEditServlet");

		// 1.获取所有参数
		Map<String, String[]> parameterMap = request.getParameterMap();
		User user = new User();
		try {
			// 2.封装成user对象
			BeanUtils.populate(user, parameterMap);

			// 3.根据uid 更新用户信息
			// 测试
			System.out.println(user + "+hello");

			// 4.调用服务层，更新数据
			UserService userService = new UserService();
			userService.updateUser(user);
			// 5.跳转到user_info页面
			request.getRequestDispatcher("/user_info.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
