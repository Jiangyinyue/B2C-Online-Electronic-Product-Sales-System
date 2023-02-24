<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新增商家</title>
    
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
		<a href='AdminPage.jsp'><b><font size='+3'>管理员权限</font></b></a>
		</div>
	
		<div style='margin-left:70%;margin-top:10px;position:absolute'>
		<a href='UserManagementServlet'><img src='images/a1.png' width='30px'>网站用户管理</a><br/>
		<a href='SellerManagementServlet'><img src='images/a2.png' width='30px'>商家信息管理</a>
		</div>
		    
		<div style='margin-left:80%;margin-top:10px;position:absolute'>
		<hr style='height:60px;width:1px;'/>
		</div>
		    
		<div style='margin-left:82%;margin-top:10px;position:absolute'>
		<a href='OrderManagementServlet'><img src='images/a3.png' width='30px'>订单信息管理</a><br/>
		<a href='index.jsp'><img src='images/a4.png' width='30px'>管理账号退出</a>
		</div>

		</div>
		</div>
		<div style='widht:100%;height:50px;background:#5CACEE;margin-bottom:10px'></div>	
		<br/>
	
	 <center>	
  <font size="+5" color="#5CACEE"><b>新增商家</b></font><br/><br/><br/>
  
   
    <form action="InsertSellerServlet" method="post">
   		<table style="padding-top:20px">
   			<tr>
   				<td>
   					商家名称：
   				</td>
   				<td>
   					<input type="text" name="sellername" style="width:200px;"/>
   				</td>
   			</tr>
   			
   			<tr>
   				<td>
   					商家账号：
   				</td>
   				<td>
   					<input type="text" name="name" style="width:200px;"/>
   				</td>
   			</tr>
   			
   			<tr>
   				<td>
   					账号密码：
   				</td>
   				<td>
   					<input type="text" name="pass" style="width:200px;"/>
   				</td>
   			</tr>
   			
   			<tr>
   				<td>
   					店铺地址：
   				</td>
   				<td>
   					<input type="text" name="address" style="width:200px;"/>
   				</td>
   			</tr>
   			
   			<tr>
   				<td>
   					配送费用：
   				</td>
   				<td>
   					<input type="text" name="peisong" style="width:200px;"/>
   				</td>
   			</tr> 		
   			
   			<tr>
   				<td>
   					商家图片：
   				</td>
   				<td>
   					<input type="text" name="photo" style="width:200px;"/>
   				</td>
   			</tr>
   			
   		
   			
   			<tr>
   				<td colspan="2" style="padding-top:20px">
   					<input type="submit" value="提交" style="width:300px;"/>
   				</td>
   			</tr> 
   		</table>
   	</form>
   	</center>
</br><img src='images/banner.jpg' width='100%'>
  </body>
</html>
