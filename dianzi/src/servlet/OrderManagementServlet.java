package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Order;
import dao.OrderDao;

public class OrderManagementServlet extends HttpServlet {

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
		OrderDao dao=new OrderDao();
		List<Order> list=dao.getAll();
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("<HEAD><TITLE>订单管理</TITLE></HEAD>");
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
		
		out.println("<center><font size='15'><b>订单管理</b></font></center>");
	
		out.println("<br/><br/>");
		out.println("<table border=1 width=100%>");
		out.println("<tr bgcolor='#CDC673'>");
		out.println("<td><b>订单号</b></td><td><b>商家</b></td><td><b>商品名称</b></td><td><b>下单人</b></td><td><b>单价</b></td><td><b>数量</b></td><td><b>总价</b></td><td><b>送货地址</b></td><td><b>电话</b></td><td><b>状态</b></td><td><b>操作</b></td>");
		out.println("</tr>");
		for(Order d:list){
			out.println("<tr>");
			out.println("<td>");
			out.println(d.getOid());
			out.println("</td>");
			out.println("<td>");
			out.println(d.getSellername());
			out.println("</td>");
			out.println("<td>");
			out.println(d.getGoodsname());
			out.println("</td>");
			out.println("<td>");
			out.println(d.getUsername());
			out.println("</td>");
			out.println("<td>");
			out.println(d.getPrice());
			out.println("</td>");
			out.println("<td>");
			out.println(d.getAmount());
			out.println("</td>");
			out.println("<td>");
			out.println(d.getTotal());
			out.println("</td>");
			out.println("<td>");
			out.println(d.getAddress());
			out.println("</td>");
			out.println("<td>");
			out.println(d.getTel());
			out.println("</td>");
			out.println("<td>");
			out.println(d.getFlag());
			out.println("</td>");
			out.println("<td>");

			out.println("<a href='DeleteAOrderServlet?oid="+d.getOid()+"'>删除</a>");
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
