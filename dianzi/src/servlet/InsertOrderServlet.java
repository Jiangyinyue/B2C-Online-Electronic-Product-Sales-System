package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CarDao;

import vo.Order;
import vo.Car;

public class InsertOrderServlet extends HttpServlet {

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
		request.setCharacterEncoding("GBK");
		HttpSession hs =request.getSession();
		
		String username=hs.getAttribute("username").toString();
		String goodsname=new String(request.getParameter("goodsname").getBytes("ISO-8859-1"),"GBK");
		String sellername=new String(request.getParameter("sellername").getBytes("ISO-8859-1"),"GBK");
		
		PrintWriter out = response.getWriter();   //做输出流
		CarDao dao = new CarDao();
		
		try {
			List<Car> list= dao.getRepeat(username,goodsname);  //查出当前用户购物车里面所有东西
			if(list.size()==0){          //如果是空的购物车
				dao.insert(goodsname,sellername,username);
				response.getWriter().print("<script charset='utf-8' type='text/javascript'>alert('SUCESS!');window.location.href='UserPageServlet';</script>");
			}else{
				out.println("<script language = javascript>alert('This goods has exists!')");
				out.println("window.history.go(-1)</script>"); 					
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
