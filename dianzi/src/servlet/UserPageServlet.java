package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Goods;
import vo.User;
import dao.GoodsDao;
import dao.UserDao;

public class UserPageServlet extends HttpServlet {

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
		
		GoodsDao dao=new GoodsDao();
		List<Goods> slist=dao.getTongji();
		
		
		PrintWriter out = response.getWriter();
		
		out.println("<head>");
		out.println("<script>");
		out.println("var imgs =['images/zhong1.jpg','images/zhong2.jpg','images/zhong3.jpg','images/zhong4.jpg'];");
		out.println("var index=0;");
		out.println("var timer_timeout = null;");
		out.println("function a(){");
		out.println("var myimg=document.getElementById('img');");
		out.println("if(index!=imgs.length-1){");
		out.println("index++;");
		out.println("}else{");
		out.println("index=0;");
		out.println("}");
		out.println("myimg.src=imgs[index];");
		out.println("timer_timeout = setTimeout(a, 1500);");	
		out.println("}");
		out.println("</script></head>");
		
		out.println("<body onload='a()'>");
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
	
		out.println("<center>");
		out.println("<img src='images/zhong1.jpg' id='img' width='1200px' height='500px'/>");
		out.println("</center>");
		out.println("<br/>");

		
		
		out.println("<div style='widht:100%;height:50px;background:#5CACEE;margin-bottom:10px'></div>");
		out.println("<hr/>");
		
		out.println("<div style='margin-left:1000px'>");
		out.println("<a href='ListSellerServlet?flag=''' style='text-decoration:none;'><font size='+2'><b>-------------------------------->>>>更多</b></font></a>");
		out.println("</div><br/>");
		
		out.println("<center>");
		out.println("<table>");
		out.println("<tr>");
		 for(int i=0;i<4;i++)
		 {
			 out.println("<td width='25%'>");
			 out.println("<a href='GoodsDetailServlet?goodsname="+slist.get(i).getGoodsname()+"'>");
			 out.println("<img src='images/goods/"+slist.get(i).getPhoto()+".jpg' width='300' height='300'/><br/>");
			 out.println("<font size='+2'>"+slist.get(i).getGoodsname()+"</font>");
			 out.println("价格："+slist.get(i).getPrice());
			 out.println("</a>");
			 out.println("</td>");
		 }
		 
		 out.println("</tr>");
	
		 out.println("</table>");
		 out.println("</center>");
		 out.println("</br><img src='images/banner.jpg' width='100%'>");
		 
		out.println("</body>");
		
	}

}
