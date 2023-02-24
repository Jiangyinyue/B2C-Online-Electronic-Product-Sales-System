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
import vo.Seller;
import dao.OrderDao;
import dao.SellerDao;

public class MyOrderServlet extends HttpServlet {

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
		SellerDao sdao=new SellerDao();
		List<Seller> slist=sdao.getSellername(hs.getAttribute("username").toString());
		String sellername=slist.get(0).getSellername();
		
		OrderDao dao=new OrderDao();
		List<Order> list=dao.getSellerOrder(sellername);
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("<HEAD><TITLE>�̼Ҷ���</TITLE></HEAD>");
		out.print("<body>");
		out.print("<div style='widht:100%;height:100px;margin-bottom:10px'>");	   
		out.print("<div style='margin:0 auto;position:relative'>");
		out.print("<div style='margin-left:2%;margin-top:10px;position:absolute'>");
		out.print("<img src='images/title.png' width='60px'>");
		out.print("<a href='SellerPage.jsp'><b><font size='+3'>�̼�Ȩ��</font></b></a>");
		out.print("</div>");
		
		out.print("<div style='margin-left:70%;margin-top:10px;position:absolute'>");
		out.print("<a href='UpdateSellerServlet?flag=s'><img src='images/ss1.png' width='30px'>�̼���Ϣ����</a><br/>");
		out.print("<a href='SellerGoodsServlet?flag=s'><img src='images/ss2.png' width='30px'>�̼���Ʒ����</a>");
		out.print("</div>");
			    
		out.print("<div style='margin-left:80%;margin-top:10px;position:absolute'>");
		out.print("<hr style='height:60px;width:1px;'/>");
		out.print("</div>");
			    
		out.print("<div style='margin-left:82%;margin-top:10px;position:absolute'>");
		out.print("<a href='MyOrderServlet'><img src='images/ss3.png' width='30px'>�̼Ҷ�������</a><br/>");
		out.print("<a href='index.jsp'><img src='images/ss4.png' width='30px'>�̼��˺��˳�</a>");
		out.print("</div>");

		out.print("</div>");
		out.print("</div>");
			    
		out.print("<div style='widht:100%;height:50px;background:#5CACEE;margin-bottom:10px'></div>");
		
		out.println("<br/><br/>");
		out.println("<table border=1 width=100%>");
		out.println("<tr bgcolor='#CDC673'>");
		out.println("<td><b>������</b></td><td><b>�̼�</b></td><td><b>��Ʒ����</b></td><td><b>�µ���</b></td><td><b>����</b></td><td><b>����</b></td><td><b>�ܼ�</b></td><td><b>��ҵ�ַ</b></td><td><b>�绰</b></td><td><b>״̬</b></td><td><b>����</b></td>");
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
			if(d.getFlag().equals("�ȴ��̼�ȷ��"))
			{
				out.println("<a href='UpdateOrderStateServlet?oid="+d.getOid()+"&&goodsname="+d.getGoodsname()+"&&sellername="+d.getSellername()+"&&amount="+d.getAmount()+"&&flag=s'>ȷ�϶���</a>");
			}
			out.println("<a href='DeleteOrderServlet?oid="+d.getOid()+"&&flag=s'>ɾ��</a>");
			out.println("</td>");
			out.println("</tr>");
		}
		
	
		out.println("</table>");	
		
		out.println("<br/><br/><br/><br/><img src='images/banner.jpg' width='100%'>");
		out.println("</BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
