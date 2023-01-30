<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <!-- 引入 Bootstrap -->
    <script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- 引入 font-awesome -->
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <!-- 引入 datetimepicker -->
    <link href="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/moment.js/2.24.0/moment-with-locales.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
    <title>宿舍管理系统</title>
</head>
<body>
<div class="container-fluid">
    <form method="post" action="/absent/save" class="form-horizontal" style="margin-top: 0px" role="form"
          id="form_data" style="margin: 20px;">
        <div role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title" id="myModalLabel">添加缺寝信息</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal" role="form">
                            <div class="form-group">
                                <label for="user_id" class="col-sm-3 control-label">楼宇</label>
                                <div class="col-sm-9">
                                    <select id="building" required class="form-control" name="buildingId">
                                        <c:forEach items="${buildingList}" var="building">
                                            <option value="${building.id}">${building.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="user_id" class="col-sm-3 control-label">宿舍</label>
                                <div class="col-sm-9">
                                    <select id="dormitory" required class="form-control" name="dormitoryId">
                                        <c:forEach items="${dormitoryList}" var="dormitory">
                                            <option value="${dormitory.id}">${dormitory.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="user_id" class="col-sm-3 control-label">学生</label>
                                <div class="col-sm-9">
                                    <select id="student" required class="form-control" name="studentId">
                                        <c:forEach items="${studentList}" var="student">
                                            <option value="${student.id}">${student.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="user_id" class="col-sm-3 control-label">原因</label>
                                <div class="col-sm-9">
                                    <input type="text" required class="form-control" name="reason" placeholder="请输入缺寝原因">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="user_id" class="col-sm-3 control-label">日期</label>
                                <div class="col-sm-9">
                                    <div class='input-group date' id='datetimepicker'>
                                        <input type='text' name="createDate" required class="form-control"/>
                                        <span class="input-group-addon">
								    		<span class="glyphicon glyphicon-calendar"></span>
								    	</span>
                                    </div>
                                </div>
                            </div>

                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-primary">提交</button>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
<script>
    $(function(){
        $('#building').change(function(){
            var id = $(this).val();
            $.ajax({
                url:"/dormitory/findByBuildingId?buildingId="+id,
                type:"post",
                contentType:"application/json;charset=UTF-8",
                dataType:"text",
                success:function (data) {
                    var list = eval("("+data+")")
                    var dormitoryList = list[0];
                    var studentList = list[1];
                    var str = '';
                    for(var i = 0;i<dormitoryList.length;i++){
                        var dormitory = $(dormitoryList).get(i);
                        str += '<option value="'+dormitory.id+'">'+dormitory.name+'</option>'
                    }
                    $('#dormitory').html(str);
                    str = '';
                    for(var i = 0;i<studentList.length;i++){
                        var student = $(studentList).get(i);
                        str += '<option value="'+student.id+'">'+student.name+'</option>'
                    }
                    $('#student').html(str);
                }
            })
        })

        $('#dormitory').change(function(){
            var id = $(this).val();
            $.ajax({
                url:"/student/findByDormitoryId?dormitoryId="+id,
                type:"post",
                contentType:"application/json;charset=UTF-8",
                dataType:"text",
                success:function (data) {
                    var list = eval("("+data+")")
                    var str = '';
                    for(var i = 0;i<list.length;i++){
                        var student = $(list).get(i);
                        str += '<option value="'+student.id+'">'+student.name+'</option>'
                    }
                    $('#student').html(str);
                }
            })
        })

        $('#datetimepicker').datetimepicker({
            format: 'YYYY-MM-DD',
            locale: moment.locale('zh-cn'),
        });
    })
</script>
</body>

</html>