<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>  
<head>
    <meta charset="utf-8">
    <title>班级信息管理-添加 </title>
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/x-admin.css" media="all" />
</head>
<body>
     <div class="x-body">
         <form action="addSave" method="post">
                <div class="layui-form-item">
                    <label for="L_username" class="layui-form-label">
                        <span class="x-red">*</span>班级名称</label>
                    <div class="layui-input-inline">
                        <input type="text" id="className" name="className"  class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux">
                        <span class="x-red">*</span>必填
                    </div>
                </div>
               <div class="layui-form-item">
                    <label for="L_username" class="layui-form-label">
                        <span class="x-red">*</span>分班规则之最高分</label>
                    <div class="layui-input-inline">
                        <input type="text" id="maxScore" name="maxScore"  class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux">
                        <span class="x-red">*</span>必填
                    </div>
                </div>
              <div class="layui-form-item">
                    <label for="L_username" class="layui-form-label">
                        <span class="x-red">*</span>分班规则之最低分</label>
                    <div class="layui-input-inline">
                        <input type="text" id="minScore" name="minScore"  class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux">
                        <span class="x-red">*</span>必填
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="L_repass" class="layui-form-label"></label>
                    <button  class="layui-btn">添加 </button>
                </div>
            </form>
        </div>
        <script src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8">
        </script>
        <script src="${pageContext.request.contextPath}/js/x-layui.js" charset="utf-8">
        </script>
    </body>

</html>