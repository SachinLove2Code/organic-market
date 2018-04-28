<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<%@include file="../shared/flows-header.jsp"%>

<div class="container">
<h1 class="my-5"></h1>
	<div class="row">
	<h1 class="my-5"></h1>
	
		<div class="col-md-9">
			<div class="card ">
				<div class="card-header card bg-info text-white">
					<h5>Sign Up - Personal</h5>
				</div>
				<div class="card-body"
					style="padding-top: 4px; padding-bottom: 1px; padding-left: 0px;">

					<sf:form method="POST" class="form-horizontal" id="registerForm" modelAttribute="user">

						<div class="form-group">
							<label class="control-label col-md-4">Enter First Name </label>
							<div class="col-md-8">
								<sf:input type="text" path="firstName" placeholder="First Name"
									class="form-control" />
									<sf:errors path="firstName" cssClass="help-block" element="em"/>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4">Last Name</label>
							<div class="col-md-8">
								<sf:input type="text" path="lastName" placeholder="Last Name"
									class="form-control" />
								<sf:errors path="lastName" cssClass="help-block" element="em"/>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Email</label>
							<div class="col-md-8">
								<sf:input path="email" type="text" placeholder="abc@xyz.com"
									class="form-control" />
									<sf:errors path="email" cssClass="help-block" element="em"/>									
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Contact Number</label>
							<div class="col-md-8">
								<sf:input type="number" path="contactNumber"
									placeholder="XXXXXXXXXX" class="form-control" />
									<sf:errors path="contactNumber" cssClass="help-block" element="em"/>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" >Password</label>
							<div class="col-md-8">
								<sf:input type="password" path="password" 
									placeholder="Passord" class="form-control" />
									<sf:errors path="password" cssClass="help-block" element="em"/>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" >Confirm Password</label>
							<div class="col-md-8">
								<sf:input type="password" path="confirmPassword" 
									placeholder="Re-enter Password" class="form-control" />
									<sf:errors path="confirmPassword" cssClass="help-block" element="em"/>
							</div>
						</div>
						<div class="form-group">

							<label class="control-label col-md-4" >Select Role</label>
							<div class="col-md-8">
								<label class="radio-inline">
								<sf:radiobutton path="role" value="USER" checked="checked"/>User
								</label>
								<label class="radio-inline">
								<sf:radiobutton path="role" value="SUPPLIER"/>SUPPLIER</label>
							</div>

						</div>
						<div class="form-group">
							<div class="col-md-8">
								<button type="submit" class="btn btn-primary" name="_eventId_billing">
								Next - Billing <span class ="glyphicon glyphicon-chevron-right"></span></button>
							</div>
						</div>
					</sf:form>

				</div>
			</div>
		</div>
	</div>
</div>
<%@include file="../shared/flows-footer.jsp"%>
