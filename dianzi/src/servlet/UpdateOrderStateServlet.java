package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GoodsDao;
import dao.OrderDao;
import dao.SellerDao;

public class UpdateOrderStateServlet extends HttpServlet {

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
		SellerDao sdao=new SellerDao();
		GoodsDao fdao=new GoodsDao();

				
		int oid=Integer.parseInt(request.getParameter("oid"));
		String goodsname=new String(request.getParameter("goodsname").getBytes("ISO-8859-1"),"GBK");
		String sellername=new String(request.getParameter("sellername").getBytes("ISO-8859-1"),"GBK");
		
		//获得订单商品的数量
		int amount=Integer.parseInt(request.getParameter("amount"));
		
		//更新是否受理字段
		dao.updateflag(oid); 

		//更新销售数量
		fdao.updatenum(goodsname,amount);
		//更新商家的成交订单数量
		sdao.updatenum(sellername);
	
		
		response.sendRedirect("MyOrderServlet");
		
	}

}
