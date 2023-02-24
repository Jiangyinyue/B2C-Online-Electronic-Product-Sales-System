package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Goods;

import dao.GoodsDao;

public class GoodsDetailServlet extends HttpServlet {

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
		
		String goodsname=new String(request.getParameter("goodsname").getBytes("ISO-8859-1"),"GBK");
		
		//商品详情显示
		GoodsDao dao=new GoodsDao();
		List<Goods> list=dao.getDetail(goodsname);
		
		String sellername=list.get(0).getSellername();
		double price=list.get(0).getPrice();
		String introduce=list.get(0).getIntroduce();
		String photo=list.get(0).getPhoto();
		int amount=list.get(0).getAmount();
		
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
		
		
		out.println("<center>"); 

		out.println("<br/><br/><table><tr>");
		out.println("<TD vAlign=top width=100><IMG height=250 src='images/goods/"+photo+".jpg'  width=200 align=left border=1 valign='middle'></TD>");
		out.println("<td>");
		out.println("<b>商品名称:"+goodsname+"</b><br/><br/><br/>");
		out.println("<b>商家名称:"+sellername+"</b><br/><br/><br/>");
		out.println("<b>销售价格:"+price+"</b><br/><br/><br/>");
		out.println("<b>销售数量:"+amount+"</b><br/><br/><br/>");
		out.println("<b>商品介绍:"+introduce+"</b>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table><br/><br/>");
		out.println("<a href='InsertOrderServlet?goodsname="+list.get(0).getGoodsname()+"&&sellername="+list.get(0).getSellername()+"'><img src='images/tocar.png' width='80px'>加入购物车</a>&nbsp&nbsp&nbsp&nbsp");
		out.println("<br/><br/></center>");
	
		out.println("</br><img src='images/banner.jpg' width='100%'>");
		 
		out.println("</body>");
		out.flush();
		out.close();
	}

}
