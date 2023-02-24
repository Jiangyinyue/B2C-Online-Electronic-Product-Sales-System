package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.Seller;
import vo.User;
import dao.SellerDao;
import dao.UserDao;

public class SubmitServlet extends HttpServlet {

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
		
		String username=request.getParameter("username");
		String userpass=request.getParameter("userpass");
		String power=request.getParameter("power");
		
		//�û����浽session����
		HttpSession hs=request.getSession();		
		hs.setAttribute("username",username);
	
		PrintWriter out = response.getWriter();   //�������
		
		if(power.equals("����Ա"))
		{
			if(username.equalsIgnoreCase("admin")&&userpass.equalsIgnoreCase("123"))
			{
				response.sendRedirect("AdminPage.jsp");
			}
			else{			
				out.println("<script language = javascript>alert('�û������������')");
				out.println("window.history.go(-1)</script>"); 
			}
		}
		else if(power.equals("�û�")){
			//���û���½���
			UserDao userdao = new UserDao();
			List<User> userlist=userdao.getMyMessage(username,userpass);
			if(userlist.isEmpty()){
				out.println("<script language = javascript>alert('�û������������')");
				out.println("window.history.go(-1)</script>"); 
			}
			else{			
				response.sendRedirect("UserPageServlet");
			}
		}
		else{
			SellerDao sellerdao=new SellerDao();
			List<Seller> sellerlist=sellerdao.getMyMessage(username,userpass);
			
			if(sellerlist.isEmpty()){
				out.println("<script language = javascript>alert('�û������������')");
				out.println("window.history.go(-1)</script>"); 
			}
			else{				
				response.sendRedirect("SellerPage.jsp");
			}
		}
	}

}
