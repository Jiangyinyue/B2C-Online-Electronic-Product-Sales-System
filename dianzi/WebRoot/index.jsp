<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    <title>首页</title>
 
	<script>
	var imgs =['images/shou1.jpg','images/shou2.jpg','images/shou3.jpg','images/shou4.jpg'];
	var index=0;
	var timer_timeout = null;
	function a(){
	var myimg=document.getElementById('img');
	if(index!=imgs.length-1){
	index++;
	}else{
	index=0;
	}
	myimg.src=imgs[index];
	timer_timeout = setTimeout(a, 1500);	
	}	
	</script>
  </head>
  
  <body onload='a()'>
   <div style="widht:100%;height:100px;margin-bottom:10px">
   
   <div style="margin:0 auto;position:relative">
    <div style="margin-left:2%;margin-top:10px;position:absolute">
    <img src='images/title.png' width='60px'>
	<b><font size='+3'>欢迎来到网站！</font></b>
    </div>
    <div style="margin-left:64%;margin-top:10px;position:absolute">
    	<a href='RegisterPage.jsp'><img src='images/aaa.png' width='30px'/><br/>
    	在线注册</a>
    </div>
    <div style="margin-left:70%;margin-top:10px;position:absolute">
    	<hr style="height:60px;width:1px;" />
    </div>
    
     <div style="margin-left:72%;margin-top:10px;position:absolute">
    	<a href='LoginPage.jsp'><img src='images/u1.png' width='30px'>账号信息</a><br/>
    	<a href='LoginPage.jsp'><img src='images/u2.png' width='30px'>商品信息</a>
    </div>
    
     <div style="margin-left:80%;margin-top:10px;position:absolute">
    	<hr style="height:60px;width:1px;" />
    </div>
    
     <div style="margin-left:82%;margin-top:10px;position:absolute">
    	<a href='LoginPage.jsp'><img src='images/u3.png' width='30px'>全部商家</a><br/>
    	<a href='LoginPage.jsp'><img src='images/u4.png' width='30px'>退出系统</a>
    </div>

  </div>
</div>
    
    <div style="widht:100%;height:40px;background:#5CACEE;margin-bottom:10px"></div>
    <center><img src='images/shou1.jpg' id='img' width='1000px' height='480px'/></center>
    <hr>
	
	<center>
	 <table>
	<tr>
	
	<td width="25%">
		<img src="images/goods/g1.jpg" width="300" height="300" /><br/>
		
	</td>
	<td width="25%">
		<img src="images/goods/g2.jpg" width="300" height="300" /><br/>
		
	</td>
	<td width="25%">
		<img src="images/goods/g3.jpg" width="300" height="300" /><br/>
		
	</td>
	<td width="25%">
		<img src="images/goods/g4.jpg" width="300" height="300" /><br/>
		
	</td>	
	</tr>
	</table>
	</center>
	<br/>
	<img src='images/banner.jpg' width='100%'>
  </body>
</html>
