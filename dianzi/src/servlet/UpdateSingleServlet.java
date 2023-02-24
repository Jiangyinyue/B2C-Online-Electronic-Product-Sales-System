package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.User;
import dao.UserDao;

public class UpdateSingleServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=GBK");		
		request.setCharacterEncoding("GBK");
		
		HttpSession hs=request.getSession();
	
		//用户名为主键，不可以改变
		String username=new String(hs.getAttribute("username").toString().getBytes("ISO-8859-1"),"GBK");
		String userpass=new String(request.getParameter("userpass").getBytes("ISO-8859-1"),"GBK");
		String truename=new String(request.getParameter("truename").getBytes("ISO-8859-1"),"GBK");
		String address=new String(request.getParameter("address").getBytes("ISO-8859-1"),"GBK");
		String tel=new String(request.getParameter("tel").getBytes("ISO-8859-1"),"GBK");
		
		UserDao dao = new UserDao();
		User user = new User(username,userpass,address,truename,tel);
		dao.update(user);
		
		response.sendRedirect("UserPageServlet");
	}

}
