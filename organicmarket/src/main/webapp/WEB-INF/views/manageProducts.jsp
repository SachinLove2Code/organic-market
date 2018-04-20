<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container">
	<h1 class="my-4"></h1>
	<div class="row">


		<div class="col-md-9">
			<c:if test="${not empty message}">
				<div class="col-xs-12">
					<div class="alert alert-success alert-dismissible">
						<button type="button" class="close" data-dismiss="alert">&times;</button>

						${message}
					</div>

				</div>
			</c:if>
			<div class="card ">
				<div class="card-header card bg-info text-white">
					<h5>Product Management</h5>
				</div>
				<div class="card-body"
					style="padding-top: 4px; padding-bottom: 1px; padding-left: 0px;">

					<sf:form class="form-horizontal" modelAttribute="product"
						action="${contextRoot}/manage/products" method="POST"
						enctype="multipart/form-data">
						<div class="form-group">

							<label class="control-label col-md-4" for="name">Enter
								The Product Name: </label>
							<div class="col-md-8">
								<sf:input type="text" path="name" id="name"
									placeholder="Product Name" class="form-control" />
								<sf:errors path="name" cssClass="help-block" element="em" />


							</div>

						</div>
						<div class="form-group">

							<label class="control-label col-md-4" for="brand">Enter
								The Brand Name: </label>
							<div class="col-md-8">
								<sf:input type="text" path="brand" id="brand"
									placeholder="Brand Name" class="form-control" />
								<sf:errors path="brand" cssClass="help-block" element="em" />

							</div>

						</div>

						<div class="form-group">

							<label class="control-label col-md-4" for="description">Product
								Description: </label>
							<div class="col-md-8">
								<sf:textarea path="discription" id="description" rows="4"
									placeholder="Write A Description" class="form-control"></sf:textarea>
								<sf:errors path="discription" cssClass="help-block" element="em" />

							</div>

						</div>

						<div class="form-group">

							<label class="control-label col-md-4" for="unitPrice">Enter
								The Unit Price: </label>
							<div class="col-md-8">
								<sf:input type="number" path="unitPrice" id="unitPrice"
									placeholder="Enter The Unit Price In &#8377;"
									class="form-control" />
								<sf:errors path="unitPrice" cssClass="help-block" element="em" />

							</div>

						</div>

						<div class="form-group">

							<label class="control-label col-md-4" for="quantity">Enter
								The Quantity Available: </label>
							<div class="col-md-8">
								<sf:input type="number" path="quantity" id="quantity"
									placeholder="Quantity Available" class="form-control" />
								<em class="help-block">Please Enter Quantity!</em>

							</div>

						</div>

						<div class="form-group">

							<label class="control-label col-md-4" for="file">Enter
								Select an Image :</label>
							<div class="col-md-8">
								<sf:input type="file" path="file" id="file"
								 class="form-control" />
								<em class="help-block">Please select the image!</em>

							</div>

						</div>

						<div class="form-group">

							<label class="control-label col-md-4" for="categoryId">Enter
								Select Category: </label>
							<div class="col-md-8">
								<sf:select class="form-control" id="categoryId"
									path="categoryId" items="${categories}" itemLabel="name"
									itemValue="id" />

								<em class="help-block">Select Category!</em>

							</div>

						</div>


						<div class="form-group">
							<div class="col-md-8">
								<input type="submit" name="submit" id="submit" value="Submit"
									class="btn btn-primary" />

							</div>

							<sf:hidden path="id" />
							<sf:hidden path="code" />
							<sf:hidden path="active" />
							<sf:hidden path="supplierId" />
							<sf:hidden path="views" />


						</div>



					</sf:form>

				</div>

			</div>

		</div>
	</div>

</div>

