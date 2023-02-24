package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Order;
import vo.Seller;
import dao.OrderDao;
import dao.SellerDao;

public class SellerManagementServlet extends HttpServlet {

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
		SellerDao dao=new SellerDao();
		List<Seller> list=dao.getAll();
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("<HEAD><TITLE>商家管理</TITLE></HEAD>");
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
		
		out.println("<br/><br/><center><font size='15'><b>商家管理</b></font></center>");
		
		out.println("<br/><br/>");
		out.println("<input type='button' value='新增商家' style='width:150px;height:50px' onclick='javascript:window.location=\"AddSeller.jsp\"'/>");
		
		out.println("<br/><br/>");
		out.println("<table border=1 width=100%>");
		out.println("<tr bgcolor='#CDC673'>");
		out.println("<td width='210px'><b>图片</b></td><td><b>商家编号</b></td><td><b>商家名称</b></td><td><b>地址</b></td><td><b>配送价格</b></td><td><b>销量</b></td><td><b>操作</b></td>");
		out.println("</tr>");
		for(Seller s:list){
			out.println("<tr>");
			out.println("<td>");
			out.println("<img src='images/seller/"+s.getPhoto()+".jpg' width='200' height='100'/>");
			out.println("</td>");
			out.println("<td>");
			out.println(s.getSid());
			out.println("</td>");
			out.println("<td>");
			out.println(s.getSellername());
			out.println("</td>");
			out.println("<td>");
			out.println(s.getAddress());
			out.println("</td>");
			out.println("<td>");
			out.println(s.getPeisong());
			out.println("</td>");
			out.println("<td>");
			out.println(s.getXiaoliang());
			out.println("</td>");
			
		
			out.println("<td>");
			out.println("<a href='UpdateSellerServlet?sid="+s.getSid()+"&&sellername="+s.getSellername()+"&&address="+s.getAddress()+"&&peisong="+s.getPeisong()+"&&xiaoliang="+s.getXiaoliang()+"&&photo="+s.getPhoto()+"&&flag=a'>修改</a>");			
			out.println("<a href='DeleteSellerServlet?sid="+s.getSid()+"&&sellername="+s.getSellername()+"'>删除商家</a>");
			
			out.println("</td>");
			out.println("</tr>");
		}
		
		out.println("</table>");
		
		out.println("</br><img src='images/banner.jpg' width='100%'>");
		out.println("</BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
