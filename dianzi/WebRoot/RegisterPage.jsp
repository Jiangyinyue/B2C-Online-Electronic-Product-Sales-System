<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>�û�ע��</title>
    
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
  	<div style="widht:100%;height:100px;margin-bottom:10px">
   
   <div style="margin:0 auto;position:relative">
    <div style="margin-left:2%;margin-top:10px;position:absolute">
    <img src='images/title.png' width='60px'>
	<b><font size='+3'>��ӭ������վ��</font></b>
    </div>
    
     <div style="margin-left:80%;margin-top:10px;position:absolute">
    	<hr style="height:60px;width:1px;" />
    </div>
    <div style="margin-left:85%;margin-top:10px;position:absolute">
    	<a href='index.jsp'><img src='images/aaa.png' width='70px'/></a><br/>
    	�ص���ҳ
    </div>
  
  </div>
</div>
 <div style="widht:100%;height:40px;background:#5CACEE;margin-bottom:10px"></div>
 
  <div style="background:url('images/reg.jpg');height:500px;width:100%">
  	<center>
 <br/><br/><br/><br/>
      	 <form action="RegisterServlet" method="post">
   		<table style="padding-top:80px">
   			<tr>
   				<td>
   					��&nbsp;&nbsp;�ţ�
   				</td>
   				<td>
   					<input type="text" name="username" style="width:200px;"/>
   				</td>
   			</tr>
   			
   			<tr>
   				<td>
   					��&nbsp;&nbsp;�룺
   				</td>
   				<td>
   					<input type="password" name="userpass" style="width:200px;"/>
   				</td>
   			</tr>
   			
   			<tr>
   				<td>
   					��&nbsp;&nbsp;����
   				</td>
   				<td>
   					<input type="text" name="truename" style="width:200px;"/>
   				</td>
   			</tr>
   			
   			<tr>
   				<td>
   					��&nbsp;&nbsp;ַ��
   				</td>
   				<td>
   					<input type="text" name="address" style="width:200px;"/>
   				</td>
   			</tr>
   			
   			<tr>
   				<td>
   					��&nbsp;&nbsp;����
   				</td>
   				<td>
   					<input type="text" name="tel" style="width:200px;"/>
   				</td>
   			</tr>
   			
   			<tr>
   				<td colspan="2" style="padding-top:20px">
   					<input type="submit" value="�ύ" style="width:290px;"/>
   				</td>
   			</tr> 
   		</table>
   	</form>
   	</center>
   	</div>
   	<img src='images/banner.jpg' width='100%'>
  </body>
</html>


<script>  
    var obj = document.getElementById('myform');  
    var check = function(){  
        if (confirm('ȷ��ע��ô��')==true){//��֤��������just a demo  
            return true;  
        }else{  
            return false;  
        }  
    }  
          
    obj.onsubmit = function(){  
        return check();  
    }  
</script>  
