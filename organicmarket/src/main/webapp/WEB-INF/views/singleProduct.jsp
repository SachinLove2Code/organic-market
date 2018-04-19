<div class="container">


	<div class="row">

		<div class="col-lg-12">

			<ol class="breadcrumb">
				<li><a href="${contextRoot}/home">Home</a></li> &#160;
				<li>/</li> &#160;
				<li><a href="${contextRoot}/show/all/products">Products</a></li> &#160;

				<li>/</li> &#160;
				<li class="active">${product.name}</li>
			</ol>

		</div>

	</div>

	<div class="row">
		<!-- Disply the product Image -->
		<div class="col-xs-12 col-sm-4">
			<div class="thumbnail">
				<img src="${images}/${product.code}.jpg" class="img img-responsive"
					width="300px" />
			</div>
		</div>

		<!-- Display Discription -->
		<div class="col-xs-12 col-sm-8">

			<h3>${product.name}</h3>
			<hr />

			<p>${product.discription}</p>

			<h4>
				Price : <strong> &#8377; ${product.unitPrice} /-</strong>
			</h4>
			<hr />
			<h6>Qty. Available: ${product.quantity}</h6>

			<a href="${contextRoot}/cart/add/${product.id}/product"
				class="btn btn-success"> <span
				class="glyphicon glyphicon-shopping-cart"></span> Add To cart
			</a> <a href="${contextRoot}/show/all/products" class="btn btn-primary">Back</a>

		</div>
	</div>



</div>