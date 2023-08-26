<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Register Form</title>
<style type="text/css">
.container {
	background-color: pink;
	width: 30%;
	border: 2px solid gray;
	border-radius: 20px;
	box-shadow: -6px 6px 12px #c5c5c5, -6px 6px 12px #ffffff;
	padding: 20px;
	font-size: 20px;
	margin-left: auto;
	margin-right: auto;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}
h1 {
	border-bottom: 1px solid black;
}
#empForm table tr td input {
	padding: 10px;
	font-size: 20px;
	border: none;
	border-radius: 0.5em;
	background: #e8e8e8;
	border: 1px solid #e8e8e8;
	transition: all .3s;
}
.inputLable {
	border-radius: 15px;
	text-align: right;
}
button {
	background-color: pink;
	margin-top: 20px;
	padding: 0.7em 1.7em;
	font-size: 20px;
	border-radius: 0.5em;
	border: 1px solid #e8e8e8;
	transition: all .3s;
	box-shadow: 6px 6px 12px #c5c5c5, -6px -6px 12px #ffffff;
}
button:hover {
	border: 1px solid gray;
}
a {
	text-decoration: none;
}
.outOfContainer {
	background-color: pink;
	margin-top: 20px;
	padding: 0.7em 1.7em;
	font-size: 20px;
	border-radius: 0.5em;
	border: 2px solid aqua;
	transition: all .3s;
	box-shadow: 6px 6px 12px #c5c5c5, -6px -6px 12px #ffffff;
	font-size: 20px;
	padding: 10px;
	margin-right: auto;
	display: flex;
	flex-direction: row;
}
</style>
</head>
<body>
	<div class="container">
		<h1>Add New Employee</h1>
		<form id="empForm" action="<%=request.getContextPath()%>/insert"
			method="post">
			<table>
				<tr>
					<td class="inputLable">Enter Employee Name:</td>
					<td><input type="text" name="empName"
						placeholder="enter name " required="required"></td>
				</tr>
				<tr>
					<td class="inputLable">Enter Employee Skills:</td>
					<td><input type="text" name="empSkills"
						placeholder="enter skills " required="required"></td>
				</tr>
				<tr>
					<td class="inputLable">Enter Employee Age:</td>
					<td><input type="number" name="empAge"
						placeholder="enter age " required="required"></td>
				</tr>
				<tr>
					<td class="inputLable">Enter Employee Salary:</td>
					<td><input type="number" name="empSalary"
						placeholder="enter salary " required="required"></td>
				</tr>
				<tr>
					<td class="inputLable">Enter Employee Joining Date:</td>
					<td><input type="date" name="empJoinDate"
						placeholder="enter joinDate " required="required"></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<button type="submit">Register</button>&nbsp;&nbsp;
						<button type="reset">Reset</button>
					</td>
				</tr>
			</table>
		</form>
		<br>
		<div class="outOfContainer">
			<a href="<%=request.getContextPath()%>/ListOfEmps">See All
				Employees</a>
		</div>
	</div>
</body>
</html>