<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">


	<div class="row">

		<!-- to display side bar -->

		<div class="col-md-3">


			<%@include file="./shared/sidebar.jsp"%>

		</div>

		<!-- To display all products -->
		<div class="col-md-9">

			<!-- Adding a breadCrumb component -->
			<div class="row">
				<div class="col-lg-12">
					<c:if test="${userClickAllProducts == true}">

						<script>
							window.categoryID = '';
						</script>
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>&#160;
							<li>/</li>&#160;
							<li class="active">All Products</li>
						</ol>
					</c:if>

					<c:if test="${userClickCategoryProducts == true}">

						<script>
							window.categoryID = '${category.id}';
						</script>
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>&#160;
							<li>/</li>&#160;
							<li class="active">Category</li>&#160;
							<li>/</li>&#160;
							<li class="active">${category.name}</li>
						</ol>
					</c:if>
				</div>


			</div>
			<div class="row">
				<div class="col-xl-12">

					<div style="overflow: auto;">

						<table id="productListTable"
							class="table table-striped table-borderd">

							<thead>
								<tr>
									<th></th>
									<th>Name</th>
									<th>Brand</th>
									<th>Price</th>
									<th>Qty. Available</th>
									<th></th>
								</tr>

							</thead>
							<tfoot>
								<tr>
									<th></th>
									<th>Name</th>
									<th>Brand</th>
									<th>Price</th>
									<th>Qty. Available</th>
									<th></th>
								</tr>

							</tfoot>
							<tbody>
							</tbody>
						</table>

					</div>
				</div>



			</div>
		</div>

	</div>





</div>