<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新增产品</title>
    
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
    <form action="InsertGoodsServlet" method="post">
   		<table style="padding-top:50px">
   			<tr>
   				<td>
   					产品名称：
   				</td>
   				<td>
   					<input type="text" name="goodsname" style="width:200px;"/>
   				</td>
   			</tr>
   			
   			<tr>
   				<td>
   					销售价格：
   				</td>
   				<td>
   					<input type="text" name="price" style="width:200px;"/>
   				</td>
   			</tr>
   			
   			<tr>
   				<td>
   					产品图片：
   				</td>
   				<td>
   					<input type="text" name="photo" style="width:200px;"/>
   				</td>
   			</tr>
   			
   			<tr>
   				<td>
   					产品介绍：
   				</td>
   				<td>
   					<textarea name="introduce" style="height:150px;width:350px">
   					</textarea>
   				</td>
   			</tr> 		
   			
   			<tr>
   				<td colspan="2" style="padding-top:20px">
   					<input type="submit" value="提交" style="width:450px;"/>
   				</td>
   			</tr> 
   		</table>
   	</form>
   	</center><br/>
 <img src='images/banner.jpg' width='100%'>
  </body>
</html>
