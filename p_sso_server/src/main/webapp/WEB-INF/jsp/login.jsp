<%--
  Created by IntelliJ IDEA.
  User: biga
  Date: 2017/11/8
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
</head>
<script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="application/javascript">
    function refreshcaptchacode(obj) {
        obj.setAttribute("src","${pageContext.request.contextPath}/captchacode?date=" + new Date());
    }
    $(document).ready(function () {
        $('.login_button').click(function () {
            //请求登录
            $.ajax({
                url : "${pageContext.request.contextPath}/loginValidate",
                async : true,
                type : "POST",
                dataType : "json",
                data :  $("form").serialize(),
                success : function(data) {
                    alert(data.status);
                    if(data.status == 0001){
                        alert("登录成功！");
                        location.href = data.redriectUrl;
                    }else if(data.status == 0000){
                        alert("登录失败"+data.msg);
                    }else if(data.status == 403){
                        alert(data.msg);
                    }
                }
            });
        });
    });

</script>
<body>
<div>
	<h1>Spring Security Oauth2 SSO Server</h1>
</div>
<form action="/loginValidate" method="post">
	<table border="1">
		<tr>
			<td colspan="2">用户登录</td>
		</tr>

		<tr>
			<td>用户名</td>
			<td><input type="text" name="username"></td>
		</tr>
		<tr>
			<td>密码</td>
			<td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td>
				<input type="text" name="validateCode" />
			</td>
			<td>
				<img id="cimg" src="/auth/captchacode" style="cursor:hand;" onclick="refreshcaptchacode(this)" />
			</td>

		</tr>
		<tr>
			<td colspan="2">
				<input type="button" class="login_button" value="登录"/>
			</td>
		</tr>
	</table>
</form>
</body>
</html>
