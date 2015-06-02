<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    String basePath = request.getContextPath();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>pageInfo</title>
<script src="<%=basePath %>/js/jquery-1.7.2.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=basePath %>/js/add.js">

</script>
</head>
<body>
<form method="post" action="<%=basePath%>/inputPageInfo/generate">
<div style="width:1200px;height:100px" ><div class="logo h1"></div><center><H3>代码生成辅助页面</H3></center></div>
<div style="width:auto;height:800px">
	<div style="width:70%;height:800px;float:left">
		<table id="table" border="1px">
			<thead>
				<tr id="head">
					<th>英文名</th>
					<th>注释</th>
					<th>方式</th>
					<th>------定位元素值------</th>
					<th>动作类型</th>
					<th>增减操作</th>
				</tr>
			</thead>
			<tbody>
				<tr id="content">
					<td><input type="text" name="eName" id="eName" value="addButton"/></td>
					<td><input type="text" name="annotation" id="annotation" value="添加按钮"/></td>
					<td><select name ="locatorWay" id="locatorWay" >
							<option>xpath</option>
							<option>name</option>
							<option>id</option>
							<option>css</option>
						</select>
					</td>
					<td><input type="text" name="value" id="value" value="//button[text()='添加']" size=50/>
					</td>
					<td><select name ="actType" id="actType">
							<option>click</option>
							<option>input</option>
							<option>select</option>
						</select>
					</td>
					<td><input id="btnAddRow" class="btn" onclick="AddStructureRow()" type="button" value="+" /></td>	
				</tr>
			</tbody>
		</table>
	</div>
	<div style="width:25%;height:800px;float:right">
	<table border="1px">
		<tr><td>package名:</td><td><input type="text" name="packageStr"  id="packageStr"/></td></tr>
		<tr><td> import名:</td><td><input type="text" name="importStr" id="importStr"/></td></tr>
		<tr><td>     类名:</td><td><input type="text" name="className" id="className"/></td></tr>
		<tr><td>     父类:</td><td><input type="text" name="extendsStr" id="extendsStr"/></td></tr>
		<tr><td>     作者:</td><td><input type="text" name="author" id="author"/></td></tr>
		<tr><td>     描述:</td><td><input type="text" name="description" id="description"/></td></tr>
		<tr><td colspan="2"><input type="button" onclick="toSubmit()" value="-生成-" /></td></tr>
		</table>
	</div>
</div>
</form>
</body>
</html>