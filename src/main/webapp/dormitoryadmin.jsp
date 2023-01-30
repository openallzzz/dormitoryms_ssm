<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <!-- 引入 Bootstrap -->
    <script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- 引入 font-awesome -->
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="application/javascript">
        function change(url,index){
            $(".list-group-item").removeClass("active");
            $(".list-group-item").eq(index).addClass("active");
            $("iframe").attr("src","/"+url);
        }
    </script>
</head>
<body>
<nav class="navbar navbar-inverse" role="navigation">
    <div class="container-fluid">
        <ul class="nav navbar-nav navbar-left">
            <li>
                <a style="font-size: 26px;">DORMS宿舍管理系统-宿舍管理员</a>
            </li>
        </ul>
        <span style="color: #CCCCCC;font-size: 26px;position: relative;top: 5px;"></span>
        <ul class="nav navbar-nav navbar-right">
            <li>
                <a>欢迎您,${dormitoryAdmin.name}</a>
            </li>
            <li>
                <a href="/account/logout">安全退出</a>
            </li>
        </ul>
    </div>
</nav>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-2">

            <a href="javascript:void(0)" class="list-group-item active" onclick="change('absent/init',0)">
						<span class="" aria-hidden="true">
							<i class="fa fa-bookmark fa-fw"></i>
						</span>学生缺寝登记
            </a>
            <a href="javascript:void(0)" class="list-group-item" onclick="change('absent/list',1)">
						<span class="" aria-hidden="true">
							<i class="fa fa-bookmark-o fa-fw"></i>
						</span>学生缺寝记录
            </a>

        </div>
        <!--右边内容-->
        <iframe style="width: 81%; height: 600px; border: 0px;" src="/absent/init"></iframe>
    </div>
</div>
<div class="footer">
    <p class="text-center">
        2023 © DORMS
    </p>
</div>
</body>
</html>
