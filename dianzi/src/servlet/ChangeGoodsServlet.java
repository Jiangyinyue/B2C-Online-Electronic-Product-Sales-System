package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GoodsDao;
import dao.SellerDao;

public class ChangeGoodsServlet extends HttpServlet {

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
	
		String goodsname=new String(request.getParameter("goodsname").getBytes("ISO-8859-1"),"GBK");
		String sellername=new String(request.getParameter("sellername").getBytes("ISO-8859-1"),"GBK");
		float price=Float.parseFloat(request.getParameter("price"));
		String photo=new String(request.getParameter("photo").getBytes("ISO-8859-1"),"GBK");
		String introduce=new String(request.getParameter("introduce").getBytes("ISO-8859-1"),"GBK");
		
		String flag=request.getParameter("flag");
		
		GoodsDao dao = new GoodsDao();
		dao.update(goodsname,sellername,price,photo,introduce);
		
		
		response.sendRedirect("SellerPage.jsp");
		
		
	}

}
