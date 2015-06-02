<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String basePath = request.getContextPath();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>pageInfo</title>
<script src="<%=basePath%>/js/jquery-1.7.2.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=basePath%>/js/add.js"></script>
<script type="text/javascript">
function run( schedulerId){
	var schedulerId = schedulerId;
	var basePath=self.location.href;
	alert(schedulerId);
	$.ajax({
		   type : 'post',
		   url: basePath+"/run",
		   dataType:'text',
		   data : {
			   scheduler_id : schedulerId, 
			   },
		   success: "success"
		});
}
function restart(){
	var basePath=self.location.href;

}
</script>

</head>
<body>
	<div style="width: 1200px; height: 800px">
		<div style="width: 59%; height: 800px; float: left">
			<table border="1">
				<tr>
					<th><span>任务名称：</span></th>
					<th><span>脚本内容：</span></th>
					<th><span>启动时间：</span></th>
					<th><span>操作：</span></th>
				</tr>
				<c:forEach items="${schedulerList }" var="scheduler">
					<tr>
						<form action="<%=basePath%>/scheduler/delScheduler" method="post">
							<td><span><input readonly="readonly" type="text"
									value="${scheduler.scheduler_name }" /></span></td>
							<td><span><textarea readonly="readonly"> ${scheduler.scheduler_bat }</textarea></span></td>
							<td><span><input readonly="readonly" type="text"
									value="${scheduler.startTime }" /> </span></td>
							<td><input type="hidden" id="schedulerId" name="schedulerId"
								value="${scheduler.scheduler_id }" /> <input type="submit"
								value="删除" /> <input type="button" value="立即执行"
								onclick="run(${scheduler.scheduler_id })" /></td>
						</form>
					</tr>
				</c:forEach>

			</table>

		</div>
		<div style="width: 40%; height: 800px; float: right">
			<form action="<%=basePath%>/scheduler/setTime" method="post">
				<table border="1px">
					<tr>
						<td><span>任务名称：</span></td>
						<td><input title="任务名称" name="jobName" type="text" /></td>
					</tr>
					<tr>
						<td><span>执行脚本: </span></td>
						<td><textarea rows="9" cols="40" title="执行脚本" name="bat"></textarea></td>
					</tr>
					<tr>
						<td><span>设定时间：</span></td>
						<td><input title="设定时间" name="startTime" type="text" value="00:00:00"/></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="添加任务" /><a style="color: red;">*新添加的任务重启后生效</a></td>
					
					</tr>
					<tr>
						<td colspan="2" >
						<input type="button" value="立即重启" onclick="window.open('<%=basePath%>/scheduler/restart');" />
						</td>
					</tr>
				</table>
				<br>
			</form>
		
			<form action="<%=basePath%>/systemSet/update" method="post">
				<span>系统设置:</span> <br><textarea cols="40" rows="8" name="systemset_bat">${restartBat}</textarea>
				 <input type="hidden" name="systemset_id" value="${systemset_id}">
				<br> <input type="submit" value="设置">
			</form>

		</div>
	</div>
</body>
</html>