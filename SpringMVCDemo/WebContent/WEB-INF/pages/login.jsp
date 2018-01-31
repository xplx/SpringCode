<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html> 
  <head>
    <base href="<%=basePath%>">
    <title>登录界面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
		html, body {
			margin: 0;
			padding: 0;
			height: 100%;
		}
		.section {
			margin: 0 auto;
			padding: 0;
			width: 100%;
			height: 100%;
			background: url(image/bg_all.jpg) no-repeat center center;
			background-size: 100% 100%;
		}
		.login {
			width: 500px;
			height: 600px;
			margin: 0 auto;
			background: url(image/squre.png) no-repeat center center ;
		}
		.list {
			width: 500px;
			height: 302px;
			margin: 0 auto;
			padding-top: 160px;
		}
		.list ul {
			width: 430px;
			height: 250px;
			margin-left:-15px;
		}
		.list ul li {
			height: 60px;
			width:430px;
			text-align:right;
		}
		
		.list ul li:nth-child(1) {
			height: 25px;
			width:430px;
			text-align:right;
		}
		
		.list ul .button a img {
			border: none;
		}
				
		.list ul li span {
			font-size: 16px;
			font-family: Arial Regular;
		}
		
		.list ul li input {
			width: 260px;
			height: 40px;
			font-size: 16px;
			font-family: Arial Regular;
		}
		.list ul li select {
			width: 260px;
			height: 40px;
			font-size: 16px;
			font-family: Arial Regular;
		}
		ul, li {
			display: block;
			list-style: none;
		}	
	</style>
	<script type="text/javascript" src="<%=basePath %>/js/jquery-1.12.3.min.js"></script>
	<script type="text/javascript">
	function doLogin() {
		$.ajax({
		    type: "post",
		    url: "<%=basePath%>/login",
		    data: {userInfo:$("#userName").val()+"#"+ $("#paWord").val() } ,
		    dataType: "text",
		    success: function(data){
		    			if (data=="9000") {
		    				window.location="<%=basePath%>/pages/success.jsp";
						}else if(data=="9001"){
							alert("Please enter user name and password ");
						}
		    			else if(data=="9002") {
							alert("user.name.error");
						}else if(data=="9003") {
							alert("user.password.error ");
						}
					}
		});
	}
	</script>
  </head>
<body>
	<div class="section">
	  <div class="login">
	    <div class="list">
	      <ul>	      
	        <li><span style="font-size:12px;color:red"></span></li>
	        <li><span>账户:</span>
	          <input type="text" id="userName" name="userName" maxlength="20"/>
	        </li>
	        <li><span>密码:</span>
	          <input type="password" id="paWord" name="paWord"  maxlength="20"/>
	        </li>
	        <li><button onclick="doLogin()" style="width: 160px;height: 41px;background: url('image/login.png');" value=""></button> </li>
	      </ul>
	    </div>
	  </div>
	</div>
</body>
</html>