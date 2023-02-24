package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.Car;
import vo.Seller;
import dao.CarDao;
import dao.SellerDao;

public class InsertSellerServlet extends HttpServlet {

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

		String name=request.getParameter("name");
		String pass=request.getParameter("pass");
		String sellername=request.getParameter("sellername");
		String address=request.getParameter("address");
		String photo=request.getParameter("photo");
		int peisong=Integer.parseInt(request.getParameter("peisong"));
		//新增商家销量为0
		int xiaoliang=0;
		
		PrintWriter out = response.getWriter();   //做输出流
		SellerDao dao = new SellerDao();
		
		try {
			List<Seller> list= dao.getDetail(sellername);  //查出是否已经有该商家
			if(list.size()==0){          //没有该商家
				dao.insert(name,pass,sellername,address,peisong,photo,xiaoliang);
				response.getWriter().print("<script charset='utf-8' type='text/javascript'>alert('SUCESS!');window.location.href='SellerManagementServlet';</script>");
			}else{
				out.println("<script language = javascript>alert('This seller has exists!')");
				out.println("window.history.go(-1)</script>"); 					
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
