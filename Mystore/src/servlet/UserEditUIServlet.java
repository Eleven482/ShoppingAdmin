package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import service.UserService;

/**
 * Servlet implementation class UserEditUIServlet
 */
@WebServlet("/UserEditUIServlet")
public class UserEditUIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取当前用户的id
		String uid = request.getParameter("uid");
		System.out.println("userEditUIServlet+"+uid);
		try {
			//获取当前用户
			UserService userservice = new UserService();
			User user = userservice.getuserWithId(uid);
			//把数据写到域
			request.setAttribute("user", user);
			System.out.println(user);
			//转发到user_info_edit.jsp
			request.getRequestDispatcher("/user_info_edit.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}

}
