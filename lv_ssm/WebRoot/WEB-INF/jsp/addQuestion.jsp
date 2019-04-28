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
    
    <title>My JSP 'addQuestion.jsp' starting page</title>
    
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
      var url="${ctx}/addQuestions";
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
  </head>
  
  <body>
    <form id="myform">
       <table>
         <tr>
           <td>问题名称</td>
           <td><input type="text" name="title"/></td>
         </tr>
         <tr>
           <td>问题描述</td>
           <td><input type="text" name="etailDesc"/></td>
         </tr>
         <tr>
           <td><input type="button" id="btn" value="提问"/></td>
           <td><input type="reset"/></td>
         </tr>
       </table>
    </form>
  </body>
</html>
