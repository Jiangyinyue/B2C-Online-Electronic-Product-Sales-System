<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>商家主界面</title>
    
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
		<a href='SellerPage.jsp'><b><font size='+3'>商家权限</font></b></a>
		</div>
	
		<div style='margin-left:70%;margin-top:10px;position:absolute'>
		<a href='UpdateSellerServlet?flag=s'><img src='images/ss1.png' width='30px'>商家信息管理</a><br/>
		<a href='SellerGoodsServlet'><img src='images/ss2.png' width='30px'>商家商品管理</a>
		</div>
		    
		<div style='margin-left:80%;margin-top:10px;position:absolute'>
		<hr style='height:60px;width:1px;'/>
		</div>
		    
		<div style='margin-left:82%;margin-top:10px;position:absolute'>
		<a href='MyOrderServlet'><img src='images/ss3.png' width='30px'>商家订单管理</a><br/>
		<a href='index.jsp'><img src='images/ss4.png' width='30px'>商家账号退出</a>
		</div>

		</div>
		</div>
		    
		<div style='widht:100%;height:50px;background:#5CACEE;margin-bottom:10px'></div>
   <center>
    <img src='images/sellermain.jpg' width='90%'>
    <br/><img src='images/banner.jpg' width='100%'>
    </center>
  
  </body>
</html>
