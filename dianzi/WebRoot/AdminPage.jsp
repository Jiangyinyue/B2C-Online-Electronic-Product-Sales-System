<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员主界面</title>
    
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
		
   <center>
    <img src='images/mainlogo.jpg' width='90%'>
    <br/><img src='images/banner.jpg' width='100%'>
    </center>
    
  </body>
</html>
