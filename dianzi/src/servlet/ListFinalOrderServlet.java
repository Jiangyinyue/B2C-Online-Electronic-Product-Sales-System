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

import dao.GoodsDao;
import dao.SellerDao;

public class ListFinalOrderServlet extends HttpServlet {

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
		
		//Session��õ�ǰ�û�
		HttpSession hs=request.getSession();
		String username=hs.getAttribute("username").toString();		
		//�����Ʒ��Ϣ
		String goodsname=new String(request.getParameter("goodsname").getBytes("ISO-8859-1"),"GBK");
		//���������Ϣ
		String sellername=new String(request.getParameter("sellername").getBytes("ISO-8859-1"),"GBK");
		//��ù��ﳵid
		int id=Integer.parseInt(request.getParameter("id"));
		//��ѯ��Ʒ��Ϣ
		GoodsDao fddao=new GoodsDao();
		List<Goods> goodslist=fddao.getGoodsMessage(sellername,goodsname);
		//��ü۸�
		float price=goodslist.get(0).getPrice();
		
		//������Ƿ����˷�
		SellerDao sellerdao=new SellerDao();
		int peisong=sellerdao.getDetail(sellername).get(0).getPeisong();
		
		String flag="δȷ��";

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
		
		out.println("<br/><br/>");
		out.println("<center><td height='25'></td></tr></table><font size='15'><b>ȷ�϶�����Ϣ</b></font><br/><br/><br/>");
		out.println("<table><tr>");
		out.println("<td>");
		out.println("<b><font color='red'>(�����ȡ��ݷ���"+peisong+"Ԫ)</font></b><br/><br/><br/>");
		out.println("<b>��Ʒ����:"+goodsname+"</b><br/><br/>");
		out.println("<b>�̼�����:"+sellername+"</b><br/><br/>");
		out.println("<b>�µ���:"+username+"</b><br/><br/>");
		out.println("<b>��Ʒ�۸�:"+price+"Ԫ</b><br/><br/>");
		
		out.println("<form action='InsertFinalOrderServlet?id="+id+"&&sellername="+sellername+"&&username="+username+"&&goodsname="+goodsname+"&&price="+price+"' method='post'>");
		out.println("<b>��������:<input type='text' name='myamount' style='width:50px;'>��</b><br/><br/><br/>");

		out.println("<b>����״̬:"+flag+"</b>");
		out.println("</td>");
		out.println("</tr>");
		
		
		out.println("</table>");
		out.println("<input type='submit' value='ȷ�Ϲ���' style='width:250px;height:40px'/>");
		
		out.println("</form>");
		
		out.println("<br/><br/>");
		out.println("</br><img src='images/banner.jpg' width='100%'>");
		out.println("</center><body>");
		out.flush();
		out.close();
	}

}
