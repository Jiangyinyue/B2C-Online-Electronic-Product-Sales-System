package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.Seller;
import vo.User;
import dao.SellerDao;
import dao.UserDao;

public class UpdateSellerServlet extends HttpServlet {

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
	
		String flag=request.getParameter("flag");
		String sellername="";
		//a是管理员，s是店铺
		if(flag.equals("a"))
		{
			sellername=new String(request.getParameter("sellername").getBytes("ISO-8859-1"),"GBK");			
		}
		else
		{
			HttpSession hs=request.getSession();
			SellerDao sdao=new SellerDao();
			List<Seller> slist=sdao.getSellername(hs.getAttribute("username").toString());
			sellername=slist.get(0).getSellername();
		}
		
		
		SellerDao dao=new SellerDao();
		List<Seller> list =dao.getDetail(sellername);
		
		
		if(flag.equals("a"))
		{
			out.println("<body>");
			out.println("<div style='widht:100%;height:100px;margin-bottom:10px'>");	   
			out.println("<div style='margin:0 auto;position:relative'>");
			out.println("<div style='margin-left:2%;margin-top:10px;position:absolute'>");
			out.println("<img src='images/title.png' width='60px'>");
			out.println("<a href='AdminPage.jsp'><b><font size='+3'>管理员权限</font></b></a>");
			out.println("</div>");
		
			out.println("<div style='margin-left:70%;margin-top:10px;position:absolute'>");
			out.println("<a href='UserManagementServlet'><img src='images/aa1.png' width='30px'>网站用户管理</a><br/>");
			out.println("<a href='SellerManagementServlet'><img src='images/aa2.png' width='30px'>商家信息管理</a>");
			out.println("</div>");
			    
			out.println("<div style='margin-left:80%;margin-top:10px;position:absolute'>");
			out.println("<hr style='height:60px;width:1px;'/>");
			out.println("</div>");
			    
			out.println("<div style='margin-left:82%;margin-top:10px;position:absolute'>");
			out.println("<a href='OrderManagementServlet'><img src='images/aa3.png' width='30px'>订单信息管理</a><br/>");
			out.println("<a href='index.jsp'><img src='images/aa4.png' width='30px'>管理账号退出</a>");
			out.println("</div>");

			out.println("</div>");
			out.println("</div>");
			out.println("<div style='widht:100%;height:50px;background:#5CACEE;margin-bottom:10px'></div>");
	
		}
		else
		{
			out.print("<body>");
			out.print("<div style='widht:100%;height:100px;margin-bottom:10px'>");	   
			out.print("<div style='margin:0 auto;position:relative'>");
			out.print("<div style='margin-left:2%;margin-top:10px;position:absolute'>");
			out.print("<img src='images/title.png' width='60px'>");
			out.print("<a href='SellerPage.jsp'><b><font size='+3'>商家权限</font></b></a>");
			out.print("</div>");
			
			out.print("<div style='margin-left:70%;margin-top:10px;position:absolute'>");
			out.print("<a href='UpdateSellerServlet?flag=s'><img src='images/ss1.png' width='30px'>商家信息管理</a><br/>");
			out.print("<a href='SellerGoodsServlet?flag=s'><img src='images/ss2.png' width='30px'>商家商品管理</a>");
			out.print("</div>");
				    
			out.print("<div style='margin-left:80%;margin-top:10px;position:absolute'>");
			out.print("<hr style='height:60px;width:1px;'/>");
			out.print("</div>");
				    
			out.print("<div style='margin-left:82%;margin-top:10px;position:absolute'>");
			out.print("<a href='MyOrderServlet'><img src='images/ss3.png' width='30px'>商家订单管理</a><br/>");
			out.print("<a href='index.jsp'><img src='images/ss4.png' width='30px'>商家账号退出</a>");
			out.print("</div>");

			out.print("</div>");
			out.print("</div>");
				    
			out.print("<div style='widht:100%;height:50px;background:#5CACEE;margin-bottom:10px'></div>");
		}
		

		out.print("<center><br/><br/><font size='+5' color='#5CACEE'><b>修改商家信息</b></font><br/><br/><br/>");
		
		out.println("<img src='images/seller/"+list.get(0).getPhoto()+".jpg' width='300px'>");
		
		out.print("<form action='ChangeSellerServlet'>");
		out.print("<table style='padding-top:20px'>");
		out.print("<tr><td>商家名称</td>");
		out.print("<td><input type='text' name='sellername' style='width:200px;' value='"+list.get(0).getSellername()+"' readonly='true'/></td></tr>");
		out.print("<tr><td>店铺位置：</td>");
		out.print("<td><input type='text' name='address' style='width:200px;' value='"+list.get(0).getAddress()+"'/></td></tr>");
		out.print("<tr><td>配送价格：</td>");
		out.print("<td><input type='text' name='peisong' style='width:200px;' value='"+list.get(0).getPeisong()+"'/></td></tr>");	
		out.print("<tr><td>商家照片：</td>");
		out.print("<td><input type='text' name='photo' style='width:200px;' value='"+list.get(0).getPhoto()+"'/></td></tr>");	
		
		out.print("<td><input type='hidden' name='flag' style='width:200px;' value='"+flag+"'/></td></tr>");	
		out.print("<tr><td colspan='2' style='padding-top:20px'><input type='submit' value='修改' style='width:300px;height:40px'/>");
		
		out.print("</table>");
		out.print("</form></center>");
		
		out.println("</br><img src='images/banner.jpg' width='100%'>");
		out.print("</body>");
	}

}
