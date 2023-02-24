package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SellerDao;

public class ChangeSellerServlet extends HttpServlet {

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
	
		String sellername=new String(request.getParameter("sellername").getBytes("ISO-8859-1"),"GBK");
		//int sid=Integer.parseInt(request.getParameter("sid"));
		String address=new String(request.getParameter("address").getBytes("ISO-8859-1"),"GBK");
		int peisong=Integer.parseInt(request.getParameter("peisong"));
		String photo=new String(request.getParameter("photo").getBytes("ISO-8859-1"),"GBK");
		
		String flag=request.getParameter("flag");
		
		SellerDao dao = new SellerDao();
		dao.update(sellername,address,peisong,photo);
		
		if(flag.equals("a"))
			response.sendRedirect("SellerManagementServlet");
		else
			response.sendRedirect("SellerPage.jsp");
		
	}

}
