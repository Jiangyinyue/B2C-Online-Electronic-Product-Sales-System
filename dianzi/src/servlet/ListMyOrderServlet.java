package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.Order;
import dao.OrderDao;

public class ListMyOrderServlet extends HttpServlet {

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
		
		HttpSession hs =request.getSession();
		String username=hs.getAttribute("username").toString();
		
		OrderDao dao=new OrderDao();
		//查询当前用户过往订单
		List<Order> list=dao.getMyOrder(username);
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("<HEAD><TITLE>过往订单</TITLE></HEAD>");
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
		
		out.println("<br/><br/><center><font size='15'><b>过往订单</b></font></center>");
		
		out.println("<hr/>");
		
		out.println("<br/><br/>");
		out.println("<table border=1 width=100%>");
		out.println("<tr bgcolor='#CDC673'>");
		out.println("<td><b>商品名称</b></td><td><b>商铺名称</b></td><td><b>下单人</b></td><td><b>价格</b></td><td><b>总价</b></td><td><b>数量</b></td><td><b>送货地址</b></td><td><b>电话</b></td><td><b>状态</b></td><td><b>操作</b></td>");
		out.println("</tr>");
		for(Order o:list){
			out.println("<tr>");
		
			out.println("<td>");
			out.println(o.getGoodsname());
			out.println("</td>");
			out.println("<td>");
			out.println(o.getSellername());
			out.println("</td>");
			out.println("<td>");
			out.println(o.getUsername());
			out.println("</td>");
			out.println("<td>");
			out.println(o.getPrice());
			out.println("</td>");
			out.println("<td>");
			out.println(o.getTotal());
			out.println("</td>");
			out.println("<td>");
			out.println(o.getAmount());
			out.println("</td>");
			out.println("<td>");
			out.println(o.getAddress());
			out.println("</td>");
			out.println("<td>");
			out.println(o.getTel());
			out.println("</td>");
			out.println("<td>");
			out.println(o.getFlag());
			out.println("</td>");
			
			out.println("<td>");
			if(o.getFlag().equals("商家已接单，派送中"))
			{
				out.println("<a href='ShouOrderServlet?oid="+o.getOid()+"'>确认收货</a>");
			}
			out.println("</td>");
			
			out.println("</tr>");
		}
		
		out.println("</table>");
		
		out.println("</br></br></br><img src='images/banner.jpg' width='100%'>");
		out.println("</BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
