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
				<th align="center" width="320">�w������</th>
				<th align="center" width="80">���iID</th>
				<th align="center" width="200">���i��</th>
				<th align="center" width="100">��</th>
				<th align="center" width="100">���i</th>
			</tr>
			<c:forEach items="${purchasehistory}" var="itemSet">
				<tr>
					<td align="left">${itemSet.updateTime}</td>
					<td align="center">${itemSet.itemId}</td>
					<td align="left">${itemSet.itemName}</td>
					<td align="right">${itemSet.quantity}</td>
					<td align="right">${itemSet.quantity * itemSet.price}�~</td>
				</tr>
			</c:forEach>
		</table><br>
		<a href="../index/index.html">���ꗗ�ɖ߂�</a>
	</div>
</body>
</html>