<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>员工列表示例</title>
	</head>
	<body>
		<table border = "1">
			<tr>
				<td>编号</td>
				<td>姓名</td>
				<td>工资</td>
				<td>入职时间</td>
			</tr>
			<c:forEach items="${emps}" var="emp">
				<tr>
					<td>${emp.empno}</td>
					<td>${emp.ename}</td>
					<td>${emp.sal}</td>
					<td>${emp.hiredate}</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>