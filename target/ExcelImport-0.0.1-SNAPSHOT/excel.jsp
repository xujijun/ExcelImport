<%@ page language="java" import="java.util.*,java.io.*,com.xjj.utils.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% 
String result = null;
try{
	ServletInputStream is = request.getInputStream();
	if(is==null){  
	   out.print("没有文件!");
       return;
	}else{
		//result = excelProcess.process(is);
		result = "test";
	}
	
}catch(IOException e) {
	out.print("同步失败!"+e);
}finally{
	out.print(result);
}



%>