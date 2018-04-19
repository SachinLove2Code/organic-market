<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<spring:url var="css" value="/resources/css" />


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

<%-- <link href="${vendor}/bootstrap/css/bootstrap.min.css" rel="stylesheet"> --%>



<!-- Bootstrap Readable Theme -->
<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">


<!-- Custom styles for this template -->
<link href="${css}/shop-homepage.css" rel="stylesheet">

<%-- <link href="${vendor}/bootstrap/css/dataTables.bootstrap.css" rel="stylesheet"> --%>
<%-- <link href="${css}/dataTables.bootstrap4.css" rel="stylesheet"> --%>
<link href="${css}/glyphicon.css" rel="stylesheet">

</head>

<body>

	<div class="wrapper">
	
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
			<div class="container">
				<div class="navbar-header">
					<a class="navbar-brand" href="${contextRoot}/home">Home<span
						class="glyphicon glyphicon-home"></span></a>
				</div>
			</div>
		</nav>
		
		<div class="content">
		<div class="container">
		
		<div class="row">

					<div class="col-xl-12">
						<div class="jumbotron">
						<hr />
							<h1>${errorTitle}</h1>
							<hr />

							<blockquote style="word-wrap:break-word">
							${errorDescription}
							</blockquote>
						</div>
					</div>
				</div>
		
		</div>
		</div>

		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>



	</div>

</body>

</html>
