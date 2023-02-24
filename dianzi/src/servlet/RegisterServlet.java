package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.User;
import dao.UserDao;

public class RegisterServlet extends HttpServlet {

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

		response.setContentType("text/html charset=GBK");
		PrintWriter out = response.getWriter();   //×öÊä³öÁ÷
		
		request.setCharacterEncoding("GBK");
		String username=request.getParameter("username");
		String userpass=request.getParameter("userpass");
		String truename=request.getParameter("truename");
		String address=request.getParameter("address");
		String tel=request.getParameter("tel");
	
		if(username.equalsIgnoreCase("")||userpass.equalsIgnoreCase(""))
		{
			out.println("<script language = javascript>alert('WARNING')");
			out.println("window.history.go(-1)</script>"); 
		}
		else{
			UserDao dao = new UserDao();
			List<User> list=dao.getMessage(username);
			try {
				if(username.equalsIgnoreCase("admin")){
					out.println("<script language = javascript>alert('WARNING!')");
					out.println("window.history.go(-1)</script>"); 
					return;
				}else{
					if(!list.isEmpty()){
						out.println("<script language = javascript>alert('WARNING!')");
						out.println("window.history.go(-1)</script>"); 
					}else{
						User user = new User(username,userpass,address,truename,tel);
						dao.insert(user);	
						response.sendRedirect("LoginPage.jsp");
					}	
				}
			} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
		}
	}
}

