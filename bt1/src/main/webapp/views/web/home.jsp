<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Trang Chủ</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
</head>
<body>
	<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Simple Header with Login Button</title>
<style>
/* Style for the header */
header {
	display: flex;
	justify-content: space-between;
	align-items: center;
	background-color: #333;
	color: white;
	padding: 15px 30px;
}

/* Style for the logo */
.logo {
	font-size: 24px;
	font-weight: bold;
}

/* Style for the login button */
.login-btn {
	background-color: #4CAF50;
	color: white;
	padding: 5px 10px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	font-size: 16px;
}

.login-btn:hover {
	background-color: #45a049;
}
</style>
</head>
<body>

	<header>
		<div class="logo col-sm-10">My Website</div>
		<c:choose>
		
			<c:when test="${sessionScope.account == null}" >
				<div class="col-sm-2">
					<ul class="list-inline right-topbar pull-right">
						<li><a href="${pageContext.request.contextPath }/login"><button class="login-btn">Dang Nhap</button></a>
						<a href="${pageContext.request.contextPath}/register"><button class="login-btn">Dang Ky</button></a></li>
					 <li><i class="search fa fa-search search-button"></i></li>
					</ul>
				</div>
			</c:when>
			<c:otherwise>
				<div class="col-sm-6 display:flex" >
					<ul class="list-inline right-topbar pull-right">
						<li class="color:black"><a >${sessionScope.account.fullName}</a>
							<a href="${pageContext.request.contextPath }/logout"><button class="login-btn">Dang Xuat</button></a></li>
						<li><i class="search fa fa-search search-button"></i></li>
					</ul>
				</div>
			</c:otherwise>
		</c:choose>
	</header>

</body>
</html>


</body>
</html>
