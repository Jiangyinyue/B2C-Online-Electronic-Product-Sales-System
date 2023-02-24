package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.Goods;

import dao.GoodsDao;
import dao.SellerDao;

public class ListFinalOrderServlet extends HttpServlet {

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
		
		//Session获得当前用户
		HttpSession hs=request.getSession();
		String username=hs.getAttribute("username").toString();		
		//获得商品信息
		String goodsname=new String(request.getParameter("goodsname").getBytes("ISO-8859-1"),"GBK");
		//获得卖家信息
		String sellername=new String(request.getParameter("sellername").getBytes("ISO-8859-1"),"GBK");
		//获得购物车id
		int id=Integer.parseInt(request.getParameter("id"));
		//查询商品信息
		GoodsDao fddao=new GoodsDao();
		List<Goods> goodslist=fddao.getGoodsMessage(sellername,goodsname);
		//获得价格
		float price=goodslist.get(0).getPrice();
		
		//看店家是否有运费
		SellerDao sellerdao=new SellerDao();
		int peisong=sellerdao.getDetail(sellername).get(0).getPeisong();
		
		String flag="未确认";

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
		
		out.println("<br/><br/>");
		out.println("<center><td height='25'></td></tr></table><font size='15'><b>确认订单信息</b></font><br/><br/><br/>");
		out.println("<table><tr>");
		out.println("<td>");
		out.println("<b><font color='red'>(店家收取快递费用"+peisong+"元)</font></b><br/><br/><br/>");
		out.println("<b>商品名称:"+goodsname+"</b><br/><br/>");
		out.println("<b>商家名称:"+sellername+"</b><br/><br/>");
		out.println("<b>下单人:"+username+"</b><br/><br/>");
		out.println("<b>商品价格:"+price+"元</b><br/><br/>");
		
		out.println("<form action='InsertFinalOrderServlet?id="+id+"&&sellername="+sellername+"&&username="+username+"&&goodsname="+goodsname+"&&price="+price+"' method='post'>");
		out.println("<b>购买数量:<input type='text' name='myamount' style='width:50px;'>部</b><br/><br/><br/>");

		out.println("<b>订单状态:"+flag+"</b>");
		out.println("</td>");
		out.println("</tr>");
		
		
		out.println("</table>");
		out.println("<input type='submit' value='确认购买' style='width:250px;height:40px'/>");
		
		out.println("</form>");
		
		out.println("<br/><br/>");
		out.println("</br><img src='images/banner.jpg' width='100%'>");
		out.println("</center><body>");
		out.flush();
		out.close();
	}

}
