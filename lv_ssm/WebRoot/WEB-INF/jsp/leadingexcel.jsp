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
   
           /*  ajax 方式上传文件操作 */  
             $(function(){
                $("#btn").click(function(){ if(checkData()){  
                        $('#form1').ajaxSubmit({    
                            url:'${ctx}/ajax',  
                            dataType: 'text',
                            type:'post',
                            success: resutlMsg,  
                            error: errorMsg  
                        });   
                        function resutlMsg(msg){  
                            alert(msg);     
                            $("#upfile").val("");  
                        }  
                        function errorMsg(){   
                            alert("导入excel出错！");      
                        }  
                    }   
                });  
             });  
               
             //JS校验form表单信息  
             function checkData(){  
                var fileDir = $("#upfile").val();  
                var suffix = fileDir.substr(fileDir.lastIndexOf("."));  
                if("" == fileDir){  
                    alert("选择需要导入的Excel文件！");  
                    return false;  
                }  
                if(".xls" != suffix && ".xlsx" != suffix ){  
                    alert("选择Excel格式的文件导入！");  
                    return false;  
                }  
                return true;  
             }   
    </script>   
   </head>
  <body>  
 
    <form method="POST"  enctype="multipart/form-data" id="form1" action="form">        
            <label>上传文件: </label>
            <input id="upfile" type="file" name="upfile"><br> <br> 
       
            <input type="submit" value="表单提交" onclick="return checkData()">
            <input type="button" value="ajax提交" id="btn" name="btn" >  
    </form>   
  </body>  
</html>