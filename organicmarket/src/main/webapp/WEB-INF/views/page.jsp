<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<spring:url var="css" value="/resources/css" />
<spring:url var="vendor" value="/resources/vendor" />

<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Organic Market - ${title}</title>

<script>
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}';
</script>

<!-- Bootstrap core CSS -->

<link href="${vendor}/bootstrap/css/bootstrap.min.css" rel="stylesheet">



<!-- Bootstrap Readable Theme -->
<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">


<!-- Custom styles for this template -->
<link href="${css}/shop-homepage.css" rel="stylesheet">

<%-- <link href="${vendor}/bootstrap/css/dataTables.bootstrap.css" rel="stylesheet"> --%>
<link href="${css}/dataTables.bootstrap4.css" rel="stylesheet">
<link href="${css}/glyphicon.css" rel="stylesheet">

</head>

<body>
	<div class="wrapper">
		<!-- Navigation -->
		<%@include file="./shared/navbar.jsp"%>

		<!-- Page Content -->
		<!--Loding home page  -->
		<div class="content">
			<c:if test="${userClickHome == true}">
				<%@include file="home.jsp"%>
			</c:if>

			<!-- Laod only when user click about -->
			<c:if test="${userClickAbout == true}">
				<%@include file="about.jsp"%>
			</c:if>

			<!-- Laod only when user click about -->
			<c:if test="${userClickContact == true}">
				<%@include file="contact.jsp"%>
			</c:if>

			<!-- Laod only when user click Product -->
			<c:if
				test="${userClickAllProducts == true or userClickCategoryProducts == true}">
				<%@include file="listproduct.jsp"%>
			</c:if>

			<c:if
				test="${userClickShowproduct == true }">
				<%@include file="singleProduct.jsp"%>
			</c:if>
		</div>

		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>

		<!-- Bootstrap core JavaScript -->

		<script src="${vendor}/jquery/jquery.min.js"></script>
		<script src="${vendor}/bootstrap/js/bootstrap.bundle.min.js"></script>

		<script src="${vendor}/jquery/jquery.dataTables.js"></script>
		<script src="${vendor}/jquery/dataTables.bootstrap4.js"></script>

		<!-- Self creating java script -->
		<script src="${vendor}/jquery/myapp.js"></script>


	</div>

</body>

</html>
