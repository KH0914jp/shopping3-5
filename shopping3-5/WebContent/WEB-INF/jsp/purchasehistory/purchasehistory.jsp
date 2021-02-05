<%@ page contentType="text/html;charset=Shift_JIS"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp"%>
<html>
<head>
<title>w“ü—š—ğ‰æ–Ê</title>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/cart_header.jsp"%>
	<div align="center" class="body">
		<h2>w“ü—š—ğ‰æ–Ê</h2>
		<table border="1">
			<tr class="header">
				<th align="center" width="320">w“ü“ú</th>
				<th align="center" width="80">¤•iID</th>
				<th align="center" width="200">¤•i–¼</th>
				<th align="center" width="100">ŒÂ”</th>
				<th align="center" width="100">‰¿Ši</th>
			</tr>
			<c:forEach items="${purchasehistory}" var="itemSet">
				<tr>
					<td align="left">${itemSet.updateTime}</td>
					<td align="center">${itemSet.itemId}</td>
					<td align="left">${itemSet.itemName}</td>
					<td align="right">${itemSet.quantity}</td>
					<td align="right">${itemSet.quantity * itemSet.price}‰~</td>
				</tr>
			</c:forEach>
		</table><br>
		<a href="../index/index.html">¡ˆê——‚É–ß‚é</a>
	</div>
</body>
</html>