<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>�����̼�</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
 <body>
		<div style='widht:100%;height:100px;margin-bottom:10px'>	   
		<div style='margin:0 auto;position:relative'>
		<div style='margin-left:2%;margin-top:10px;position:absolute'>
		<img src='images/title.png' width='60px'>
		<a href='AdminPage.jsp'><b><font size='+3'>����ԱȨ��</font></b></a>
		</div>
	
		<div style='margin-left:70%;margin-top:10px;position:absolute'>
		<a href='UserManagementServlet'><img src='images/a1.png' width='30px'>��վ�û�����</a><br/>
		<a href='SellerManagementServlet'><img src='images/a2.png' width='30px'>�̼���Ϣ����</a>
		</div>
		    
		<div style='margin-left:80%;margin-top:10px;position:absolute'>
		<hr style='height:60px;width:1px;'/>
		</div>
		    
		<div style='margin-left:82%;margin-top:10px;position:absolute'>
		<a href='OrderManagementServlet'><img src='images/a3.png' width='30px'>������Ϣ����</a><br/>
		<a href='index.jsp'><img src='images/a4.png' width='30px'>�����˺��˳�</a>
		</div>

		</div>
		</div>
		<div style='widht:100%;height:50px;background:#5CACEE;margin-bottom:10px'></div>	
		<br/>
	
	 <center>	
  <font size="+5" color="#5CACEE"><b>�����̼�</b></font><br/><br/><br/>
  
   
    <form action="InsertSellerServlet" method="post">
   		<table style="padding-top:20px">
   			<tr>
   				<td>
   					�̼����ƣ�
   				</td>
   				<td>
   					<input type="text" name="sellername" style="width:200px;"/>
   				</td>
   			</tr>
   			
   			<tr>
   				<td>
   					�̼��˺ţ�
   				</td>
   				<td>
   					<input type="text" name="name" style="width:200px;"/>
   				</td>
   			</tr>
   			
   			<tr>
   				<td>
   					�˺����룺
   				</td>
   				<td>
   					<input type="text" name="pass" style="width:200px;"/>
   				</td>
   			</tr>
   			
   			<tr>
   				<td>
   					���̵�ַ��
   				</td>
   				<td>
   					<input type="text" name="address" style="width:200px;"/>
   				</td>
   			</tr>
   			
   			<tr>
   				<td>
   					���ͷ��ã�
   				</td>
   				<td>
   					<input type="text" name="peisong" style="width:200px;"/>
   				</td>
   			</tr> 		
   			
   			<tr>
   				<td>
   					�̼�ͼƬ��
   				</td>
   				<td>
   					<input type="text" name="photo" style="width:200px;"/>
   				</td>
   			</tr>
   			
   		
   			
   			<tr>
   				<td colspan="2" style="padding-top:20px">
   					<input type="submit" value="�ύ" style="width:300px;"/>
   				</td>
   			</tr> 
   		</table>
   	</form>
   	</center>
</br><img src='images/banner.jpg' width='100%'>
  </body>
</html>
