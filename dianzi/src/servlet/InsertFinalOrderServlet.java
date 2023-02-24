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
import vo.Car;
import vo.User;
import dao.OrderDao;
import dao.CarDao;
import dao.SellerDao;
import dao.UserDao;

public class InsertFinalOrderServlet extends HttpServlet {

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

		PrintWriter out = response.getWriter();   //做输出流

		HttpSession hs=request.getSession();
		response.setContentType("text/html charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		
		String goodsname=new String(request.getParameter("goodsname").getBytes("ISO-8859-1"),"GBK");
		String sellername=new String(request.getParameter("sellername").getBytes("ISO-8859-1"),"GBK");
		String username=hs.getAttribute("username").toString();
		int amount=Integer.parseInt(request.getParameter("myamount"));
		
		//根据用户名查询到电话和地址
		UserDao udao=new UserDao();
		List<User> ulist=udao.getMessage(username);
		String address=ulist.get(0).getAddress();
		String tel=ulist.get(0).getTel();
		
		//获得订单id，下单的同时删除预订单信息
		int id=Integer.parseInt(request.getParameter("id"));
		//强制转换一下，算价钱
		float price=Float.parseFloat(request.getParameter("price"));	
		
		//计算配送费用
		SellerDao sellerdao=new SellerDao();
		int peisong=sellerdao.getDetail(sellername).get(0).getPeisong();
	
		//如果有配送费用加上，没有不加
		float total=0;
		if(peisong==0)
			total=price*amount;
		else
			total=price*amount+peisong;
		
		String flag="等待商家确认";
		
		OrderDao dao = new OrderDao();
		CarDao ofdao=new CarDao();
		try {
			dao.insert(sellername,username,goodsname,flag,price,total,amount,address,tel);
			//删除预处理订单
			ofdao.delete(id);
			response.getWriter().print("<script charset='utf-8' type='text/javascript'>alert('SUCESS!');window.location.href='UserPageServlet';</script>");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
	}

}
