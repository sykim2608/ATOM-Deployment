<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="content table-responsive table-full-width">
<table class="table table-hover table-striped">
<thead>

                               	<th>ID</th>

                           		<th>Name</th>

                           		<th>Salary</th>

                           		<th>Country</th>

                           		<th>City</th>
                           		<th>date</th>

                           	</thead>

<tbody>
    <c:forEach items="${list}" var="list">
    <tr>
    	            <td>${list.serviceId}</td>
    	            <td>${list.serviceName}</td>
    	            <td>${list.architecture}</td>
    	            <td>${list.description}</td>
    	            <td>${list.status}</td>
    	            <td>${list.date}</td>
    	        </tr>
</c:forEach>
</tbody>
</table>
</body>
</div>
</html>





