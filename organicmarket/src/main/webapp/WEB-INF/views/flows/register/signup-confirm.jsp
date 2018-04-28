<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<%@include file="../shared/flows-header.jsp"%>

<div class="container">
	<h1 class="my-5"></h1>




	<div class="row">
		<!-- Column to display the personal details -->
		<div class="col-md-6">
			<div class="card">
				<div class="card-header card bg-info text-white ">
					<h5>Personal Details</h5>
				</div>
				<div class="card-body">
				<div class="text-center">
				<h4> ${registerModel.user.firstName} ${registerModel.user.lastName} </h4>
				<h5>Email : ${registerModel.user.email}</h5>
				<h5>Contact Number: ${registerModel.user.contactNumber} </h5>
				<h5>Role : ${registerModel.user.role} </h5>			
				
				</div>
				
				</div>
				<div class="card-footer">
					<a href="${flowExecutionUrl}&_eventId_personal"
						class="btn btn-primary">Edit</a>
				</div>

			</div>
			
		</div>
		<!-- column to display the address details -->
		<div class="col-md-6">
			<div class="card">
				<div class="card-header card bg-info text-white ">
					<h5>Billing Address</h5>
				</div>
				<div class="card-body">
				<div class="text-center">
				
				<h4> ${registerModel.billing.addressLineOne } </h4>
				
				<h4> ${registerModel.billing.addressLineTwo } </h4>
				
				<h4> ${registerModel.billing.city} - ${registerModel.billing.postalCode} </h4>
				
				<h4> ${registerModel.billing.state} - ${registerModel.billing.country} </h4>
				
				</div>
				</div>
				<div class="card-footer">
					<a href="${flowExecutionUrl}&_eventId_billing"
						class="btn btn-primary">Edit</a>
				</div>

			</div>
		</div>
	</div>
	<h1 class="my-4"></h1>
	
	<div class="row">
		<div class="col-md-4">
			<div class="text-center">
				<a href="${flowExecutionUrl}&_eventId_submit"
					class="btn btn-primary">Confirm</a>
			</div>

		</div>
	</div>
</div>
<%@include file="../shared/flows-footer.jsp"%>