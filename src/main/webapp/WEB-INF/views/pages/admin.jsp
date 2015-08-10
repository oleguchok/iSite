<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<body>
<div class="container">
	<h1>Admin Page</h1>
	<table class="table">
		<thead>
			<tr>
				<th>Username</th>
				<th>Email</th>
				<th>Enabled</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users }" var="user">
				<tr>
					<th>${user.username }</th>
					<th>${user.email }</th>
					<th>${user.enabled }</th>
				</tr>
			</c:forEach>
		</tbody>	
	</table>
</div>
</body>
</html>