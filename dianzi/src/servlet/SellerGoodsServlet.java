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
import vo.Goods;
import dao.SellerDao;
import dao.GoodsDao;

public class SellerGoodsServlet extends HttpServlet {

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
		GoodsDao dao=new GoodsDao();
		
		String flag=request.getParameter("flag");
		
		String sellername="";
		
		
		HttpSession hs=request.getSession();
		SellerDao sdao=new SellerDao();
		
		List<Seller> slist=sdao.getSellername(hs.getAttribute("username").toString());
		sellername=slist.get(0).getSellername();
	
				
		List<Goods> list=dao.getSeller(sellername);
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("<HEAD><TITLE>商品管理</TITLE></HEAD>");
		out.print("<body>");
		out.print("<div style='widht:100%;height:100px;margin-bottom:10px'>");	   
		out.print("<div style='margin:0 auto;position:relative'>");
		out.print("<div style='margin-left:2%;margin-top:10px;position:absolute'>");
		out.print("<img src='images/title.png' width='60px'>");
		out.print("<a href='SellerPage.jsp'><b><font size='+3'>商家权限</font></b></a>");
		out.print("</div>");
		
		out.print("<div style='margin-left:70%;margin-top:10px;position:absolute'>");
		out.print("<a href='UpdateSellerServlet?flag=s'><img src='images/ss1.png' width='30px'>商家信息管理</a><br/>");
		out.print("<a href='SellerGoodsServlet?flag=s'><img src='images/ss2.png' width='30px'>商家商品管理</a>");
		out.print("</div>");
			    
		out.print("<div style='margin-left:80%;margin-top:10px;position:absolute'>");
		out.print("<hr style='height:60px;width:1px;'/>");
		out.print("</div>");
			    
		out.print("<div style='margin-left:82%;margin-top:10px;position:absolute'>");
		out.print("<a href='MyOrderServlet'><img src='images/ss3.png' width='30px'>商家订单管理</a><br/>");
		out.print("<a href='index.jsp'><img src='images/ss4.png' width='30px'>商家账号退出</a>");
		out.print("</div>");

		out.print("</div>");
		out.print("</div>");
			    
		out.print("<div style='widht:100%;height:50px;background:#5CACEE;margin-bottom:10px'></div>");
		
		
		out.println("<input type='button' value='新增商品' style='width:150px;height:50px' onclick='javascript:window.location=\"AddGoods.jsp\"'/>");
		
		out.println("<br/><br/>");
		out.println("<table border=1 width=100%>");
		out.println("<tr bgcolor='#CDC673'>");
		out.println("<td width='210px'><b>图片</b></td><td><b>编号</b></td><td><b>商品名称</b></td><td><b>商家名称</b></td><td><b>价格</b></td><td><b>销量</b></td><td><b>介绍</b></td><td><b>操作</b></td>");
		out.println("</tr>");
		for(Goods f:list){
			out.println("<tr>");
			out.println("<td>");
			out.println("<img src='images/goods/"+f.getPhoto()+".jpg' width='200' height='200'/>");
			out.println("</td>");
			out.println("<td>");
			out.println(f.getFid());
			out.println("</td>");
			out.println("<td>");
			out.println(f.getGoodsname());
			out.println("</td>");
			out.println("<td>");
			out.println(f.getSellername());
			out.println("</td>");
			out.println("<td>");
			out.println(f.getPrice());
			out.println("</td>");
			out.println("<td>");
			out.println(f.getAmount());
			out.println("</td>");
			out.println("<td>");
			out.println(f.getIntroduce());
			out.println("</td>");
			
		
			out.println("<td>");
			out.println("<a href='UpdateGoodsServlet?fid="+f.getFid()+"&&goodsname="+f.getGoodsname()+"&&sellername="+f.getSellername()+"&&flag="+flag+"'>修改</a>");			
			out.println("<a href='DeleteGoodsServlet?fid="+f.getFid()+"'>下架</a>");
			
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
