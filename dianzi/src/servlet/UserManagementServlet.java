package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Goods;
import vo.Order;
import vo.User;
import dao.GoodsDao;
import dao.UserDao;

public class UserManagementServlet extends HttpServlet {

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
		
		UserDao dao=new UserDao();
		//查询所有用户
		List<User> list=dao.getAll();
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("<HEAD><TITLE>注册用户管理</TITLE></HEAD>");
		out.println("<body>");
		out.println("<div style='widht:100%;height:100px;margin-bottom:10px'>");	   
		out.println("<div style='margin:0 auto;position:relative'>");
		out.println("<div style='margin-left:2%;margin-top:10px;position:absolute'>");
		out.println("<img src='images/title.png' width='60px'>");
		out.println("<a href='AdminPage.jsp'><b><font size='+3'>管理员权限</font></b></a>");
		out.println("</div>");
	
		out.println("<div style='margin-left:70%;margin-top:10px;position:absolute'>");
		out.println("<a href='UserManagementServlet'><img src='images/a1.png' width='30px'>网站用户管理</a><br/>");
		out.println("<a href='SellerManagementServlet'><img src='images/a2.png' width='30px'>商家信息管理</a>");
		out.println("</div>");
		    
		out.println("<div style='margin-left:80%;margin-top:10px;position:absolute'>");
		out.println("<hr style='height:60px;width:1px;'/>");
		out.println("</div>");
		    
		out.println("<div style='margin-left:82%;margin-top:10px;position:absolute'>");
		out.println("<a href='OrderManagementServlet'><img src='images/a3.png' width='30px'>订单信息管理</a><br/>");
		out.println("<a href='index.jsp'><img src='images/a4.png' width='30px'>管理账号退出</a>");
		out.println("</div>");

		out.println("</div>");
		out.println("</div>");
		out.println("<div style='widht:100%;height:50px;background:#5CACEE;margin-bottom:10px'></div>");

		
		out.println("<br/><br/>");
		out.println("<center><font size='15'><b>注册用户管理</b></font></center>");
		
		out.println("<br/><br/>");
		out.println("<table border=1 width=100%>");
		out.println("<tr bgcolor='#CDC673'>");
		out.println("<td><b>账号</b></td><td><b>地址</b></td><td><b>姓名</b></td><td><b>联系电话</b></td><td><b>操作</b></td>");
		out.println("</tr>");
		for(User u:list){
			out.println("<tr>");
			out.println("<td>");
			out.println(u.getUsername());
			out.println("</td>");
			out.println("<td>");
			out.println(u.getAddress());
			out.println("</td>");
			out.println("<td>");
			out.println(u.getTruename());
			out.println("</td>");
			out.println("<td>");
			out.println(u.getTel());
			out.println("</td>");
			
			out.println("<td>");
			out.println("<a href='DeleteUserServlet?username="+u.getUsername()+"'>屏蔽用户</a>");
			out.println("</td>");
			
			out.println("</tr>");
		}
		
		out.println("</table>");
		
		out.println("</br><img src='images/banner.jpg' width='100%'>");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
