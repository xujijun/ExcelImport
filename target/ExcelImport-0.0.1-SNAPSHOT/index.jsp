<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
  </head>
  
  <body>
	Excel文件处理：
	<br>

<form name="form1" action="excel.jsp" method="post"  enctype="multipart/form-data">

  <table border="0" align="center" cellpadding="1" cellspacing="1" bgcolor="#CCCCCC">

    <tr>

      <th bgcolor="#FFFFFF" scope="row">请选择一个Excel文件</th>

      <td bgcolor="#FFFFFF"><input name="upFile" type="file"></td>

      <td bgcolor="#FFFFFF"><input type="submit" value="处理">

      </td>

    </tr>

  </table>

</form>
</body>
</html>
