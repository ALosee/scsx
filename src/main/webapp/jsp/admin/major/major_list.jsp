<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>专业信息管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/x-admin.css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pag.css" media="all">
    <script type="text/javascript">
        function del(id) {
            if (confirm("您确定要删除吗?")) {
                var visitPath = "delete?id=" + id;
                location.href = visitPath
            }
        }
        function deleteByIds() {
            if (window.confirm("确认删除吗?")) {
                //向后台发送删除请求，同时传递删除的数据（ids）
                //创建数组存储id的值
                var arr = new Array();
                var ids = document.getElementsByName("majorIds");
                for (var i = 0; i < ids.length; i++) {
                    if (ids[i].checked) {
                        arr.push(ids[i].value);
                    }
                }
                if (arr.length == 0) {
                    alert("请先选中要删除的元素");
                    return;
                }
                window.location.href = "deleteByIds?ids=" + arr;
            }
        }
    </script>
</head>
<body>

<div class="x-nav">
            <span class="layui-breadcrumb">
              <a><cite>首页</cite></a>
              <a><cite>专业信息管理</cite></a>
            </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       href="javascript:location.replace(location.href);" title="刷新"><i class="layui-icon"
                                                                        style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <div class="tools">
        ${tip_info }
        <ul class="toolbar">
            <li onclick="deleteByIds()"><span><img src="${pageContext.request.contextPath}/images/t03.png"/></span>批量删除</li>
            <li onclick="user_management_add('添加专业信息','add_page','600','500')">
                <span><img src="${pageContext.request.contextPath}/images/t01.png"/></span>添加
            </li>
        </ul>
    </div>
    <table class="tablelist">
        <thead>
        <tr>
            <th>编号</th>
            <th>专业名称</th>
            <th>学院名称</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${majors}" var="major" varStatus="i">
            <tr>
                <td class="td-manage"><input type="checkbox" name="majorIds" value="${major.id}"> &nbsp;${i.count}</td>
                <td class="center">${major.majorName}</td>
                <td class="center">${major.academyInfo.academyName}</td>
                <td class="td-manage">
                    <a title="编辑" href="#"
                       onclick="user_management_add('修改专业信息','updatePage?id=${major.id}','600','500')"
                       class="ml-5" style="text-decoration:none">
                        <i class="layui-icon">&#xe642;</i>
                    </a>
                    <a title="删除" href="#" onclick="del('${major.id}')"
                       style="text-decoration:none">
                        <i class="layui-icon">&#xe640;</i>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="turnPage center fr">
        <span style="margin-right:20px;">共${pageInfo.total}条记录,当前第${pageInfo.pageNum}页,共${pageInfo.pages}页  </span>
        <a href="findByPage?pageNum=1">首页</a>
        <c:if test="${pageInfo.pageNum gt 1 }">
            <a href="findByPage?pageNum=${pageInfo.pageNum-1}">上一页</a>
        </c:if>
        <c:if test="${pageInfo.pageNum le 1 }">
            <a href="#">上一页</a>
        </c:if>
        <c:if test="${pageInfo.pageNum lt pageInfo.pages }">
            <a href="findByPage?pageNum=${pageInfo.pageNum+1}">下一页</a>
        </c:if>
        <c:if test="${pageInfo.pageNum ge pageInfo.pages }">
            <a href="#">下一页</a>
        </c:if>

        <a href="findByPage?pageNum=${pageInfo.pages}">尾页</a>

    </div>
</div>
<br/>
<br/>
<br/>
<script src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/x-layui.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/jquery2.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/js.js" charset="utf-8"></script>
<script>
    layui.use(['laydate', 'element', 'laypage', 'layer'], function () {
        $ = layui.jquery;//jquery
        lement = layui.element();//面包导航
        laypage = layui.laypage;//分页
        layer = layui.layer;//弹出层

    });

    /*用户-添加*/
    function user_management_add(title, url, w, h) {
        x_admin_show(title, url, w, h);
    }

    /*用户-查看*/
    function user_management_show(title, url, id, w, h) {
        x_admin_show(title, url, w, h);
    }

    // 用户-编辑
    function user_management_edit(title, url, id, w, h) {
        x_admin_show(title, url, w, h);
    }

    /*密码-修改*/
    function user_management_password(title, url, id, w, h) {
        x_admin_show(title, url, w, h);
    }

    $('.tablelist tbody tr:odd').addClass('odd');
</script>
</body>
</html>