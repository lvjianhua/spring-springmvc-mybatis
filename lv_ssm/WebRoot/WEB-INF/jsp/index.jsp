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
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	${jquery_js }
	<script type="text/javascript">
	 $(function(){
	   $(".addAnswers").click(function(){
	     var id=$(this).attr("rel");
	     window.location.href="${ctx}/getQuestionsById.html?id="+id;
	   })
	 })
	</script>
  </head>
  
  <body>
  <a href="${ctx }/toaddQuestion.html">提问</a>--------
  <a href="${ctx }/leadingexcel.html">导入</a>
  <form action="${ctx}/pagerindex.html" method="post">
  <!-- 隐藏页码 -->
  <input type="hidden" name="currentPage" id="pageIndex" value="${pager.currentPage }"/> 
  <input type="hidden" name="pageSize" id="pageSize" value="${pager.pageSize }"> 
    <table border="1">
         <tr>
           <td>编号</td>
           <td>问题</td>
           <td>回答次数</td>
           <td>最后修改时间</td>
         </tr>  
    <c:forEach items="${pager.pageRecords}" var="q">
    <tr>
      <td>${q.id }</td>
           <td><a href="javascript:void(0)" class="addAnswers" rel="${q.id}">${q.title }</a></td>
           <td>${q.answerCount}</td>
           <td><fmt:formatDate value="${q.lastModified}" pattern="yyyy-MM-dd"/></td>
           </tr>
    </c:forEach>
    <tr>
      <td colspan="4"><%@include file="../../statics/common/page.jsp" %></td>
    </tr>
    </table>
    
    </form>
  </body>
</html>
