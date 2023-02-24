package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Goods;

import dao.GoodsDao;

public class ListGoodsServlet extends HttpServlet {

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
		
		GoodsDao dao=new GoodsDao();
		//��ѯ��������۵���Ʒ
		List<Goods> list=dao.getSeller(sellername);
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("<HEAD><TITLE>�̼ң�"+sellername+"</TITLE></HEAD>");
		out.println("<body>");
		out.println("<div style='widht:100%;height:100px;margin-bottom:10px'>");		   
		out.println("<div style='margin:0 auto;position:relative'>");
		out.println("<div style='margin-left:2%;margin-top:10px;position:absolute'>");
		out.println("<img src='images/title.png' width='60px'>");
		out.println("<a href='UserPageServlet'><b><font size='+3'>��ӭ������վ��</font></b></a>");
		out.println("</div>");
		
		out.println("<div style='margin-left:63%;margin-top:10px;position:absolute'>");
		out.println("<a href='ListCarServlet'><img src='images/mycar.png'/><br/>");
		out.println("���ﳵ</a>");
		out.println("</div>");
		out.println("<div style='margin-left:70%;margin-top:10px;position:absolute'>");
		out.println("<hr style='height:60px;width:1px;'/>");
		out.println("</div>");
	
		out.println("<div style='margin-left:72%;margin-top:10px;position:absolute'>");
		out.println("<a href='SingleMessageServlet'><img src='images/u1.png' width='30px'>�˺���Ϣ</a><br/>");
		out.println("<a href='ListMyOrderServlet'><img src='images/u2.png' width='30px'>������Ϣ</a>");
		out.println("</div>");
		    
		out.println("<div style='margin-left:80%;margin-top:10px;position:absolute'>");
		out.println("<hr style='height:60px;width:1px;'/>");
		out.println("</div>");
		    
		out.println("<div style='margin-left:82%;margin-top:10px;position:absolute'>");
		out.println("<a href='ListSellerServlet?flag='''><img src='images/u3.png' width='30px'>ȫ���̼�</a><br/>");
		out.println("<a href='index.jsp'><img src='images/u4.png' width='30px'>�˳�ϵͳ</a>");
		out.println("</div>");

		out.println("</div>");
		out.println("</div>");
		    
		out.println("<div style='widht:100%;height:50px;background:#5CACEE;margin-bottom:10px'>");
		out.println("<form action='SearchSellerServlet' method='post'>");
		out.println("<div style='margin-left:60%'>");
		out.println("<br/>");
		out.println("<font color='#EEEE00'><b>�̼�����:</b></font>");
		out.println("<input type='text' name='search' size='30'/>"); 
		out.println("<input type='submit' value='����' />");
		out.println("</div>");
		out.println("</form></div>");
		
		out.println("<br/><center><font size='15'><b>�̼ң�<"+sellername+">������Ʒ</b></font></center><hr/>");
		
		out.println("<br/><br/>");
		out.println("<center><table>");
		for(Goods s:list){
			out.println("<tr>");
			
			out.println("<td vAlign=top width=100><img height='250px' width='200px' src='images/goods/"+s.getPhoto()+".jpg' align=left border=1/></td>");
			out.println("<td>");
			out.println("<b>��Ʒ����:"+s.getGoodsname()+"</b><br/><br/><br/>");
			out.println("<b>���ۼ۸�:"+s.getPrice()+"Ԫ</b><br/><br/><br/>");
			out.println("<b>��������:"+s.getAmount()+"</b><br/><br/><br/>");
			out.println("<b>����:"+s.getIntroduce()+"</b><br/><br/><br/>");		
			out.println("</td>");
			
			out.println("<td><a href='InsertOrderServlet?goodsname="+s.getGoodsname()+"&&sellername="+sellername+"'><IMG height=50 src='images/order.jpg'  width=50>");
			out.println("<font size='+2'><b>���빺�ﳵ</b></font></a>");	
			out.println("</td>");

			out.println("</tr>");
			out.println("<tr><td><hr/></td><td><br/><br/></td></tr>");			
		}
		
		out.println("</table></center>");
		
		out.println("</br><img src='images/banner.jpg' width='100%'>");
		out.println("</BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
