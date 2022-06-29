<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>测试题目管理</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/x-admin.css" media="all">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/pag.css" media="all">
<script type="text/javascript">
	function del(id) {
		if (confirm("您确定要删除吗?")) {
			var visitPath = "delete?id=" + id;
			location.href = visitPath
		}
	}
</script>
</head>
<body>

	<div class="x-nav">
		<span class="layui-breadcrumb"> <a><cite>首页</cite></a> <a><cite>测试题目管理</cite></a>
		</span>
	</div>
	<div class="x-body">
		${tip_info }
		<div class="tools">
			<ul class="toolbar">
				<li><span><img src="${pageContext.request.contextPath}/images/t03.png" /></span>批量删除</li>
				<li
					onclick="user_management_add('添加试题','addPage','600','500')"><span><img
						src="${pageContext.request.contextPath}/images/t01.png" /></span>添加</li>
			</ul>
		</div>
		<table class="tablelist">
			<thead>
				<tr>
					<th>题号</th>
					<th>题目</th>
					<th>正确答案</th>
					<th>分数</th>
					<th>选项</th>
					<!--<th>状态</th> -->
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${paperInfos}" var="paper">
					<tr>

						<td class="center">${paper.questionNum }</td>
						<td class="center">${paper.questionContent }</td>
						<td class="center">${paper.questionAnswer }</td>
						<td class="center">${paper.questionScore }</td>
						
						<td class="center">
						 <a title="维护选项A" href="javascript:;"

							onclick="paper_edit('维护选项A','${pageContext.request.contextPath}/admin/option/update_page?questionNumId=${paper.questionNum}&optionType=A','${paper.id}','','510')"
							class="ml-5" style="text-decoration: none"> 
							A
							</a>
							&nbsp;|&nbsp;
							 <a title="维护选项B" href="javascript:;"
							onclick="paper_edit('维护选项B','${pageContext.request.contextPath}/admin/option/update_page?questionNumId=${paper.questionNum }&optionType=B','${paper.id}','','510')"
							class="ml-5" style="text-decoration: none"> 
							B
							</a>
							&nbsp;|&nbsp;
							 <a title="维护选项C" href="javascript:;"
							onclick="paper_edit('维护选项C','${pageContext.request.contextPath}/admin/option/update_page?questionNumId=${paper.questionNum }&optionType=C','${paper.id}','','510')"
							class="ml-5" style="text-decoration: none"> 
							C
							</a>
						&nbsp;|&nbsp;
							 <a title="维护选项D" href="javascript:;"
							onclick="paper_edit('维护选项D','${pageContext.request.contextPath}/admin/option/update_page?questionNumId=${paper.questionNum }&optionType=D','${paper.id}','','510')"
							class="ml-5" style="text-decoration: none"> 
							D
							</a>
						
						
						</td>
						<!--  <td class="td-status">
								<button class="sp">已启用</button>
							</td>-->
						<td class="td-manage">
					<!-- 	<a style="text-decoration: none"
							onclick="member_stop(this,'10001')" href="javascript:;"
							title="停用"> <i class="layui-icon">&#xe601;</i>
						</a> -->
						 <a title="编辑" href="javascript:;"
							onclick="paper_edit('编辑','updatePage?id=${paper.id}','${paper.id}','','510')"
							class="ml-5" style="text-decoration: none"> <i
								class="layui-icon">&#xe642;</i>
						</a> <a title="删除" href="#" onclick="del('${paper.id}')"
							style="text-decoration: none"> <i class="layui-icon">&#xe640;</i></a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="turnPage center fr">
			<span style="margin-right: 20px;">共${pageInfo.total}条记录,当前第${pageInfo.pageNum }页,共${pageInfo.pages}页
			</span> <a href="search?pageNum=1">首页</a>
			<c:if test="${pageInfo.pageNum gt 1 }">
				<a href="search?pageNum=${pageInfo.pageNum-1}">上一页</a>
			</c:if>
			<c:if test="${pageInfo.pageNum le 1 }">
				<a href="#">上一页</a>
			</c:if>
			<c:if test="${pageInfo.pageNum lt pageInfo.pages }">
				<a href="search?pageNum=${pageInfo.pageNum+1}">下一页</a>
			</c:if>
			<c:if test="${pageInfo.pageNum ge pageInfo.pages }">
				<a href="#">下一页</a>
			</c:if>
			<a href="search?pageNum=${pageInfo.pages}">尾页</a>
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
		layui.use([ 'laydate', 'element', 'laypage', 'layer' ], function() {
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
		function paper_edit(title, url, id, w, h) {
			x_admin_show(title, url, w, h);
		}
		$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>