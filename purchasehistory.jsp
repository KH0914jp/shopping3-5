<%@ page contentType="text/html;charset=Shift_JIS"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp"%>
<html>
<head>
<title>�w���������</title>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/cart_header.jsp"%>
	<div align="center" class="body">
		<h2>�w���������</h2>
		<table border="1">
			<tr class="header">
				<th align="center" width="80">�w������</th>
				<th align="center" width="320">���iID</th>
				<th align="center" width="320">���i��</th>
				<th align="center" width="100">��</th>
				<th align="center" width="100">���i</th>
			</tr>
			<c:forEach items="${purchasehistory}" var="itemSet">
				<tr>
					<td>${itemSet.updateTime}</td>
					<td>${itemSet.itemId}</td>
					<td>${itemSet.itemName}</td>
					<td>${itemSet.quantity}</td>
					<td>${itemSet.price}</td>
				</tr>
			</c:forEach>
		</table>
		<a href="../index/index.html">���ꗗ�ɖ߂�</a>
	</div>
</body>
</html>