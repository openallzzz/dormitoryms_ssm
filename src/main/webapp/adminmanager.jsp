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
    <title>宿舍管理系统</title>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-10">
            <!-- 顶部搜索部分 -->
            <div class="panel panel-default">
                <div class="panel-heading">搜索</div>
                <div class="panel-body">
                    <form role="form" class="form-inline" action="/dormitoryAdmin/search" method="post">
                        <div class="form-group">
                            <label for="name">字段：</label>
                            <select name="key" class="form-control">
                                <option value="username">宿管帐号</option>
                                <option value="name">宿管姓名</option>
                                <option value="telephone">宿管电话</option>
                            </select>
                        </div>
                        <div class="form-group" style="margin-left: 20px">
                            <label for="value">值：</label>
                            <input type="text" class="form-control" name="value" placeholder="字段值" maxlength="12" style="width: 130px">
                        </div>
                        <div class="form-group " style="margin-left: 20px">
                            <button type="submit" class="btn btn-info ">
										<span style="margin-right: 5px"
                                              class="glyphicon glyphicon-search" aria-hidden="true">
										</span>开始搜索
                            </button>
                        </div>
                        <div class="form-group " style="margin-left: 48px">
                            <button type="button" class="btn btn-default"
                                    data-toggle="modal" data-target="#addUserModal">
										<span style="margin-right: 5px" class="" aria-hidden="true">
											<i class="fa fa-user-plus">添加宿管信息</i>
											</span>
                            </button>
                        </div>
                    </form>
                </div>
            </div>
            <!-- 列表展示-->
            <div class="table-responsive">
                <table class="table table-hover ">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>用户名</th>
                        <th>密码</th>
                        <th>姓名</th>
                        <th>性别</th>
                        <th>联系电话</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list}" var="dormitoryAdmin">
                        <tr>
                            <td>${dormitoryAdmin.id}</td>
                            <td>${dormitoryAdmin.username}</td>
                            <td>${dormitoryAdmin.password}</td>
                            <td>${dormitoryAdmin.name}</td>
                            <td>${dormitoryAdmin.gender}</td>
                            <td>${dormitoryAdmin.telephone}</td>
                            <td>
                                <div class="btn-group">
                                    <button type="button" class="btn btn-default "
                                            data-id="${dormitoryAdmin.id}"
                                            data-username="${dormitoryAdmin.username}"
                                            data-password="${dormitoryAdmin.password}"
                                            data-name="${dormitoryAdmin.name}"
                                            data-gender="${dormitoryAdmin.gender}"
                                            data-telephone="${dormitoryAdmin.telephone}"
                                            data-toggle="modal"
                                            data-target="#updateUserModal">
                                        <i class="fa fa-user-o">修改</i>
                                    </button>

                                    <button type="button" class="btn btn-danger "
                                            data-id="${dormitoryAdmin.id}" data-toggle="modal"
                                            onclick="" data-target="#delUserModal">
                                        <i class="fa fa-user-times">删除</i>
                                    </button>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <!-- add框示例（Modal） -->
                <form method="post" action="/dormitoryAdmin/save" class="form-horizontal" style="margin-top: 0px" role="form"
                      id="form_data" style="margin: 20px;">
                    <div class="modal fade" id="addUserModal" tabindex="-1"
                         role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal"
                                            aria-hidden="true">x</button>
                                    <h4 class="modal-title" id="myModalLabel">添加宿管信息</h4>
                                </div>
                                <div class="modal-body">
                                    <form class="form-horizontal" role="form">
                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">用户名</label>
                                            <div class="col-sm-9">
                                                <input type="text" required class="form-control" id="username"
                                                       name="username" placeholder="请输入用户名">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">密码</label>
                                            <div class="col-sm-9">
                                                <input type="text" required class="form-control" id="password"
                                                       name="password" value="" placeholder="请输入密码">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">姓名</label>
                                            <div class="col-sm-9">
                                                <input type="text" required class="form-control" id="name"
                                                       name="name" value="" placeholder="请输入姓名">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">性别</label>
                                            <div class="col-sm-9">
                                                <input type="radio" checked value="男" class="gender"
                                                       name="gender"> 男
                                                &nbsp;&nbsp;&nbsp;<input type="radio" value="女" class="gender"
                                                                         name="gender"> 女
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">联系电话</label>
                                            <div class="col-sm-9">
                                                <input type="text" required class="form-control" id="telephone"
                                                       name="telephone" value="" placeholder="请输入联系电话">
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                    <button type="submit" class="btn btn-primary">提交</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>

                <!-- update框示例（Modal） -->
                <form method="post" action="/dormitoryAdmin/update" class="form-horizontal" style="margin-top: 0px" role="form"
                      id="form_data" style="margin: 20px;">
                    <div class="modal fade" id="updateUserModal" tabindex="-1"
                         role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal"
                                            aria-hidden="true">x</button>
                                    <h4 class="modal-title" id="myModalLabel">用户信息</h4>
                                </div>
                                <div class="modal-body">
                                    <form class="form-horizontal" role="form">
                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">ID</label>
                                            <div class="col-sm-9">
                                                <input type="text" readonly required class="form-control" id="id"
                                                       name="id">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">用户名</label>
                                            <div class="col-sm-9">
                                                <input type="text" required class="form-control" id="username"
                                                       name="username" placeholder="请输入用户名">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">密码</label>
                                            <div class="col-sm-9">
                                                <input type="text" required class="form-control" id="password"
                                                       name="password" value="" placeholder="请输入密码">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">姓名</label>
                                            <div class="col-sm-9">
                                                <input type="text" required class="form-control" id="name"
                                                       name="name" value="" placeholder="请输入姓名">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">性别</label>
                                            <div class="col-sm-9">
                                                <input type="radio" checked value="男" class="gender"
                                                       name="gender"> 男
                                                &nbsp;&nbsp;&nbsp;<input type="radio" value="女" class="gender"
                                                                         name="gender"> 女
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">联系电话</label>
                                            <div class="col-sm-9">
                                                <input type="text" required class="form-control" id="telephone"
                                                       name="telephone" value="" placeholder="">
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                    <button type="submit" class="btn btn-primary">提交</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>

                <!-- 删除模态框示例（Modal） -->
                <form method="post" action="/dormitoryAdmin/delete"
                      class="form-horizontal" style="margin-top: 0px" role="form"
                      id="form_data" style="margin: 20px;">
                    <div class="modal fade" id="delUserModal" tabindex="-1"
                         role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal"
                                            aria-hidden="true">×</button>
                                    <h4 class="modal-title" id="myModalLabel">用户信息</h4>
                                </div>
                                <div class="modal-body">
                                    <form class="form-horizontal" role="form">
                                        <div class="form-group">
                                            <div class="col-sm-9">
                                                <h3 class="col-sm-18 control-label" id="deleteLabel">删除信息</h3>
                                                <input type="hidden" class="form-control" id="tab"
                                                       name="tab" placeholder="" value="dor_admin"> <input
                                                    type="hidden" class="form-control" id="id"
                                                    name="id" placeholder="">
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                    <button type="submit" class="btn btn-danger">删除</button>
                                    <span id="tip"> </span>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<script>
    $('#updateUserModal').on('show.bs.modal', function(event) {
        var button = $(event.relatedTarget)
        var id = button.data('id')
        var username = button.data('username')
        var password = button.data('password')
        var name = button.data('name')
        var gender = button.data('gender')
        var telephone = button.data('telephone')
        var modal = $(this)

        modal.find('.modal-title').text('修改宿管信息')
        modal.find('#id').val(id)
        modal.find('#username').val(username)
        modal.find('#password').val(password)
        modal.find('#name').val(name)
        var list = modal.find('.gender')
        for(var i=0;i<list.length;i++){
            if(gender == $(list.get(i)).val()){
                $(list.get(i)).prop('checked',true)
            }
        }
        modal.find('#telephone').val(telephone)

    })

    $('#delUserModal').on('show.bs.modal', function(event) {
        var button = $(event.relatedTarget)
        var id = button.data('id')
        var modal = $(this)
        modal.find('.modal-title').text('删除宿管信息')
        modal.find('#deleteLabel').text('是否删除ID为  ' + id + ' 的信息')
        modal.find('#id').val(id)
    })
</script>

</body>

</html>