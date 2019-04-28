<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="../../statics/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addAnswers.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
${jquery_js }
${jquery_form_js }
<script type="text/javascript">
  $(function(){
    $("#btn").click(function(){
      var url="${ctx}/addAnswers";
       var option={
         url:url,
         type:'post',
         success:callback,
         dataType:'json'
       };
       $("#myform").ajaxSubmit(option);
    });
    
  });
  function callback(data){
    alert(data.remsg);
    if(data.recode==true){
       window.location.href="${ctx}/pagerindex.html";
    }
  }
</script>
  
  <body>
    <table>
        <tr>
         <td>问题：</td>
         <td>${q.title }</td>
       </tr>
       <tr>
         <td>问题描述</td>
         <td>${q.etailDesc}</td>
       </tr>
       <c:forEach items="${aList}" var="a">
           <tr>
           <td>网友回答</td>
           <td>
             <p><fmt:formatDate value="${a.ansDate}" pattern="yyyy-MM-dd"/></p>
             <p>${a.ansContent}</p>
             </td>
           </tr>
       </c:forEach>
    </table>
    <form id="myform">
       <input type="hidden" name="questions.id" value="${q.id}"/>
       <table>
         <tr>
          <td>我来回答</td>
          <td>
            <p><input type="text"  name="ansContent"></p>
            <p><input type="button" id="btn" value="提交答案"/><a href="${ctx }/pagerindex.html">返回首页</a></p>
          </td>
         </tr>
       </table>
    </form>
  </body>
</html>
