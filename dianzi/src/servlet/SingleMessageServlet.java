package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.User;
import dao.UserDao;

public class SingleMessageServlet extends HttpServlet {

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
		PrintWriter out = response.getWriter();
		
		//把登录用户信息赋值到界面上
		HttpSession hs=request.getSession();
		UserDao dao=new UserDao();
		List<User> list =dao.getMessage(hs.getAttribute("username").toString());
		
		out.println("<body>");
		out.println("<div style='widht:100%;height:100px;margin-bottom:10px'>");		   
		out.println("<div style='margin:0 auto;position:relative'>");
		out.println("<div style='margin-left:2%;margin-top:10px;position:absolute'>");
		out.println("<img src='images/title.png' width='60px'>");
		out.println("<a href='UserPageServlet'><b><font size='+3'>欢迎来到网站！</font></b></a>");
		out.println("</div>");
		
		out.println("<div style='margin-left:63%;margin-top:10px;position:absolute'>");
		out.println("<a href='ListCarServlet'><img src='images/mycar.png'/><br/>");
		out.println("购物车</a>");
		out.println("</div>");
		out.println("<div style='margin-left:70%;margin-top:10px;position:absolute'>");
		out.println("<hr style='height:60px;width:1px;'/>");
		out.println("</div>");
	
		out.println("<div style='margin-left:72%;margin-top:10px;position:absolute'>");
		out.println("<a href='SingleMessageServlet'><img src='images/u1.png' width='30px'>账号信息</a><br/>");
		out.println("<a href='ListMyOrderServlet'><img src='images/u2.png' width='30px'>订单信息</a>");
		out.println("</div>");
		    
		out.println("<div style='margin-left:80%;margin-top:10px;position:absolute'>");
		out.println("<hr style='height:60px;width:1px;'/>");
		out.println("</div>");
		    
		out.println("<div style='margin-left:82%;margin-top:10px;position:absolute'>");
		out.println("<a href='ListSellerServlet?flag='''><img src='images/u3.png' width='30px'>全部商家</a><br/>");
		out.println("<a href='index.jsp'><img src='images/u4.png' width='30px'>退出系统</a>");
		out.println("</div>");

		out.println("</div>");
		out.println("</div>");
		    
		out.println("<div style='widht:100%;height:50px;background:#5CACEE;margin-bottom:10px'>");
		out.println("<form action='SearchSellerServlet' method='post'>");
		out.println("<div style='margin-left:60%'>");
		out.println("<br/>");
		out.println("<font color='#EEEE00'><b>商家名称:</b></font>");
		out.println("<input type='text' name='search' size='30'/>"); 
		out.println("<input type='submit' value='搜索' />");
		out.println("</div>");
		out.println("</form></div>");
		
		out.print("<center><img src='images/up.jpg' width='70%'>");
		out.print("<form action='UpdateSingleServlet'>");
		out.print("<table style='padding-top:20px'>");
		out.print("<tr><td>账&nbsp&nbsp号：</td>");
		out.print("<td>"+list.get(0).getUsername()+"</td></tr>");
		out.print("<tr><td>密&nbsp&nbsp码：</td>");
		out.print("<td><input type='password' name='userpass' style='width:200px;' value='"+list.get(0).getUserpass()+"'/></td></tr>");
		out.print("<tr><td>姓&nbsp&nbsp名：</td>");
		out.print("<td><input type='text' name='truename' style='width:200px;' value='"+list.get(0).getTruename()+"'/></td></tr>");
		out.print("<tr><td>地&nbsp&nbsp址：</td>");
		out.print("<td><input type='text' name='address' style='width:200px;' value='"+list.get(0).getAddress()+"'/></td></tr>");	
		out.print("<tr><td>电&nbsp&nbsp话：</td>");
		out.print("<td><input type='text' name='tel' style='width:200px;' value='"+list.get(0).getTel()+"'/></td></tr>");	
		out.print("<tr><td colspan='2' style='padding-top:20px'><input type='submit' value='修改' style='width:300px;height:40px'/>");
		out.print("</td></tr> ");	
		out.print("</table>");
		out.print("</form></center>");
		
		out.println("</br><img src='images/banner.jpg' width='100%'>");
		out.print("</body>");
	}

}
