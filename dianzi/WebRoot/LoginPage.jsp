<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录界面</title>
    
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
  <center>
  	<div style="widht:100%;height:100px;margin-bottom:10px">
   
   <div style="margin:0 auto;position:relative">
    <div style="margin-left:2%;margin-top:10px;position:absolute">
    <img src='images/title.png' width='60px'>
	<b><font size='+3'>欢迎来到网站！</font></b>
    </div>
    
     <div style="margin-left:80%;margin-top:10px;position:absolute">
    	<hr style="height:60px;width:1px;" />
    </div>
    <div style="margin-left:85%;margin-top:10px;position:absolute">
    	<a href='RegisterPage.jsp'><img src='images/reg.png' width='70px'/></a><br/>
    	账号注册
    </div>
  
  </div>
</div>
 <div style="widht:100%;height:40px;background:#5CACEE;margin-bottom:10px"></div>
 
 <div style="background:url('images/reg.jpg');height:500px;width:100%">
   <br/><br/><br/><br/>
     <form action="SubmitServlet" method="post">
   		<table style="padding-top:80px">
   			<tr>
   				<td>
   					账号：
   				</td>
   				<td>
   					<input type="text" name="username" style="width:200px;"/>
   				</td>
   			</tr>
   			
   			<tr>
   				<td>
   					密码：
   				</td>
   				<td>
   					<input type="password" name="userpass" style="width:200px;"/>
   				</td>
   			</tr>
   			
   			<tr>
   				<td>
   					权限：
   				</td>
   				<td>
   					<select name="power" style='width:200px' >
				     <option value="用户">用户</option>
				     <option value="商家">商家</option>
				     <option value="管理员">管理员</option>
				     </select> 
   				</td>
   			</tr>
   			
   			<tr>
   				<td colspan="2" style="padding-top:20px">
   					<input type="submit" value="登录" style="width:130px;"/>
   					<a href="RegisterPage.jsp"><input type="button" value="注册" style="width:130px;"/></a>
   				</td>
   			</tr> 
   		</table>
   	</form>
   	</div>
   	</center> 
   	<img src='images/banner.jpg' width='100%'>
 
  </body>
</html>
