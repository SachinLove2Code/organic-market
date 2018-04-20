<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1 class="my-4"></h1>
<div class="list-group">

	<c:forEach items="${categories}" var="category">

		<a href="${contextRoot}/show/category/${category.id}/products" class="list-group-item" id="a_${category.name}">${category.name}</a>
		<!--  <a href="#" class="list-group-item">Category 2</a> 
	 <a href="#" class="list-group-item">Category 3</a> -->

	</c:forEach>
	
</div>