<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	로그인
	<form action="./login" method="post">
		<table border="1">
			<tr>
				<th>id</th>
				<td><input type="text" name="id" required></td>
			</tr>
			<tr>
				<th>password</th>
				<td><input type="text" name="password"></td>
			</tr>
			<tr>
				<th>&nbsp;</th>
				<td><input type="submit" value="저장"> 
				<input type="reset" value="취소"></td>
			</tr>

		</table>
	</form>
</body>
</html>