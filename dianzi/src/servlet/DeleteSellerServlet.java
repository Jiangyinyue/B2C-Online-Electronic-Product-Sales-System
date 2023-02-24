package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GoodsDao;
import dao.CarDao;
import dao.SellerDao;

public class DeleteSellerServlet extends HttpServlet {

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

		response.setContentType("text/html charset=GBK");
		//获得商家名称
		//int sid=Integer.parseInt(request.getParameter("sid"));
		String sellername=new String(request.getParameter("sellername").getBytes("ISO-8859-1"),"GBK");
		
		//两个操作，一个删除商家，另一个是删除商家下属的菜品
		SellerDao sdao = new SellerDao();
		GoodsDao fdao = new GoodsDao();
		
		sdao.delete(sellername);
		fdao.deleteGoods(sellername);
		
		response.sendRedirect("SellerManagementServlet");
	}

}
