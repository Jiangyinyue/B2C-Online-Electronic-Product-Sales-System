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
import vo.Seller;
import dao.GoodsDao;
import dao.SellerDao;

public class InsertGoodsServlet extends HttpServlet {

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

		//通过session获得当前操作的商家
		HttpSession hs =request.getSession();
		String username=hs.getAttribute("username").toString();
		
		SellerDao sdao=new SellerDao();
		List<Seller> slist=sdao.getName(username);
		
		String sellername=slist.get(0).getSellername();
		
	
		String goodsname=request.getParameter("goodsname");
		float price=Float.parseFloat(request.getParameter("price"));
		String photo=request.getParameter("photo");
		String introduce=request.getParameter("introduce");
		
		//新增商品销量为0
		int amount=0;
		
		PrintWriter out = response.getWriter();   //做输出流
		GoodsDao dao = new GoodsDao();
		
		try {
			List<Goods> list= dao.getGoodsMessage(sellername, goodsname) ; //查出是否已经有该商品
			if(list.size()==0){          //没有该商品
				dao.insert(sellername,goodsname,price,amount,introduce,photo);
				response.getWriter().print("<script charset='utf-8' type='text/javascript'>alert('SUCESS!');window.location.href='SellerGoodsServlet';</script>");
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
