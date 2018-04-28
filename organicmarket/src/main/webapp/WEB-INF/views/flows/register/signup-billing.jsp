<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<%@include file="../shared/flows-header.jsp"%>

<div class="container">
	<h1 class="my-5"></h1>
	<div class="row">
		<h1 class="my-5"></h1>

		<div class="col-md-9">
			<div class="card ">
				<div class="card-header card bg-info text-white">
					<h5>Sign Up - Address</h5>
				</div>
				<div class="card-body"
					style="padding-top: 4px; padding-bottom: 1px; padding-left: 0px;">

					<sf:form method="POST" class="form-horizontal" id="billingForm"
						modelAttribute="billing">

						<div class="form-group">
							<label class="control-label col-md-4">Address Line One </label>
							<div class="col-md-8">
								<sf:input type="text" path="addressLineOne"
									placeholder="Enter The Address Line One" class="form-control" />
									<sf:errors path="addressLineOne" cssClass="help-block" element="em"/>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4">Address Line Two</label>
							<div class="col-md-8">
								<sf:input type="text" path="addressLineTwo"
									placeholder="Enter The Address Line Two" class="form-control" />
									<sf:errors path="addressLineTwo" cssClass="help-block" element="em"/>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">City</label>
							<div class="col-md-8">
								<sf:input path="city" type="text" placeholder="Enter The City"
									class="form-control" />
									<sf:errors path="city" cssClass="help-block" element="em"/>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">State</label>
							<div class="col-md-8">
								<sf:input type="text" path="state" placeholder="Enter The State"
									class="form-control" />
									<sf:errors path="state" cssClass="help-block" element="em"/>
							</div>
						</div>

						<div class="form-group">

							<label class="control-label col-md-4">Postal Code</label>
							<div class="col-md-8">
								<sf:input type="text" path="postalCode" placeholder="XXXXXX"
									class="form-control" />
								<sf:errors path="postalCode" cssClass="help-block" element="em"/>

							</div>

						</div>

						<div class="form-group">

							<label class="control-label col-md-4">Country</label>
							<div class="col-md-8">
								<sf:input type="text" path="country" placeholder="XXXXXX"
									class="form-control" />
								<sf:errors path="country" cssClass="help-block" element="em"/>

							</div>

						</div>

						<div class="form-group">
							<div class="col-md-8">
								<!-- submit for moving to the personal -->
								<button type="submit" class="btn btn-primary"
									name="_eventId_personal">
									<span class="glyphicon glyphicon-chevron-left"></span> Previous
									- Personal
								</button>

								<!-- submit for moving to the confirm -->
								<button type="submit" class="btn btn-primary"
									name="_eventId_confirm">
									
									Next - Confirm <span class="glyphicon glyphicon-chevron-right"></span>
								</button>
							</div>
						</div>
					</sf:form>

				</div>
			</div>
		</div>
	</div>
</div>
<%@include file="../shared/flows-footer.jsp"%>