<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>学生管理</title>
   
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/x-admin.css" media="all" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pag.css" media="all" /> 
    <script type="text/javascript">
    function del(id){
	if(confirm("您确定要删除吗?")){
		var visitPath="delete?id="+id;
	    location.href=visitPath
	}
}

</script>  
</head>
<body>
        <div class="x-nav">
            <span class="layui-breadcrumb">
              <a><cite>首页</cite></a>
              <a><cite>学生信息管理</cite></a>
            </span>
            
        </div>
	<div class="x-body">
      <div class="tools">
      ${tip_info }
   		<ul class="toolbar">
        <li><span><img src="${pageContext.request.contextPath}/images/t03.png" /></span>批量删除</li>
        <li onclick="user_management_add('添加学生','addPage','600','500')"><span><img src="${pageContext.request.contextPath}/images/t01.png" /></span>添加</li>
        
      </ul>  
   </div>
            <table class="tablelist">
                <thead>
                    <tr>
                        <th>学号</th>
                        <th>姓名</th>
                        <th>性别</th>
                         <th>学院名称</th>
                        <th>专业名称</th>
                        <th>手机号</th>
                        <th>省份</th>
                        <th>分数</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                	<c:forEach items="${StudentInfos}" var="student">
                    <tr>
                    <td class="center">${student.studentNum}</td>
					<td class="center">${student.studentName}</td>
					<td class="center">
					<c:if test="${student.studentGender eq '0' }">男</c:if>
					<c:if test="${student.studentGender eq '1' }">女</c:if>
					</td>
					  <td class="center">${student.academyInfo.academyName}</td>
					<td class="center">${student.majorInfo.majorName}</td>
					<td class="center">${student.studentPhone}</td>
					<td class="center">${student.studentProvince}</td>
					<td class="center">${student.totalScore}</td>
                    <td class="td-manage">
                    <a style="text-decoration:none"  onclick="user_management_password('查看学生答题情况','studentinfo.do?action=findall&stu_num=${student.studentNum}','10001','600','400')"
                            href="javascript:;" title="查看学生答题情况">
                                <i class="layui-icon">&#xe631;</i>
                            </a>
                    <a title="编辑" href="#"  onclick="user_management_add('修改学生','updatePage?id=${student.id}','600','500')"
                            class="ml-5" style="text-decoration:none">
                                <i class="layui-icon">&#xe642;</i></a>
                    <a title="删除" href="#" onclick="del(${student.studentNum})"
                                     style="text-decoration:none">
                                <i class="layui-icon">&#xe640;</i></a>
                        </td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
   <div class="turnPage center fr">
	       <span style="margin-right:20px;">共${StudentInfo.total}条记录,当前第${StudentInfo.pageNum}页,共${StudentInfo.pages}页  </span>
	   <a href="search?pageNum=1">首页</a>
	   <c:if test="${StudentInfo.pageNum gt 1 }">
	   <a href="search?pageNum=${StudentInfo.pageNum-1}">上一页</a>
	   </c:if>
	   <c:if test="${StudentInfo.pageNum le 1 }">
	   <a href="#">上一页</a>
	   </c:if>
	   <c:if test="${StudentInfo.pageNum lt StudentInfo.pages }">
	   <a href="search?pageNum=${StudentInfo.pageNum+1}">下一页</a>
	   </c:if>
	    <c:if test="${StudentInfo.pageNum ge StudentInfo.pages }">
	   <a href="#">下一页</a>
	   </c:if>
	
	   <a href="search?pageNum=${StudentInfo.pages}">尾页</a>
	   
</div>
</div>
<br />
<br />
<br />
        <script src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
        <script src="${pageContext.request.contextPath}/js/x-layui.js" charset="utf-8"></script> 
<script src="${pageContext.request.contextPath}/js/jquery2.js" charset="utf-8"></script> 
<script src="${pageContext.request.contextPath}/js/js.js" charset="utf-8"></script>
        <script>
            layui.use(['laydate','element','laypage','layer'], function(){
                $ = layui.jquery;//jquery
              lement = layui.element();//面包导航
              laypage = layui.laypage;//分页
              layer = layui.layer;//弹出层

            });

             /*用户-添加*/
            function user_management_add(title,url,w,h){
                x_admin_show(title,url,w,h);
            }
            /*用户-查看*/
            function user_management_show(title,url,id,w,h){
                x_admin_show(title,url,w,h);
            }

             /*用户-停用*/
            function member_stop(obj,id){
                layer.confirm('确认要停用吗？',function(index){
                    //发异步把用户状态进行更改
                    $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_start(this,id)" href="javascript:;" title="启用"><i class="layui-icon">&#xe62f;</i></a>');
                    $(obj).parents("tr").find(".td-status").html('<button class="sp3">已停用</button>');
                    $(obj).remove();
                    layer.msg('已停用!',{icon: 5,time:1000});
                });
            }

            /*用户-启用*/
            function member_start(obj,id){
                layer.confirm('确认要启用吗？',function(index){
                    //发异步把用户状态进行更改
                    $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_stop(this,id)" href="javascript:;" title="停用"><i class="layui-icon">&#xe601;</i></a>');
                    $(obj).parents("tr").find(".td-status").html('<button class="sp">已启用</button>');
                    $(obj).remove();
                    layer.msg('已启用!',{icon: 6,time:1000});
                });
            }
            // 用户-编辑
            function user_management_edit (title,url,id,w,h) {
                x_admin_show(title,url,w,h); 
            }
            /*密码-修改*/
            function user_management_password(title,url,id,w,h){
                x_admin_show(title,url,w,h);  
            }
           
	$('.tablelist tbody tr:odd').addClass('odd');
            </script>
    </body>
</html>