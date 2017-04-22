<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="header.jsp" %>
<div class="content">
			<div class="container-fluid">

				<div class="row">
					<div class="col-sm-4"></div>
					<div class="col-sm-4">
						<center><b><h2 style="font-size:350%;color:RGB(26,92,183);">Sign Up</h2></b></center>
						<br>
						<form:form method="post" modelAttribute="userDetails">
							<div class="form-group">
								<label for="userName">User Name</label>
								<form:input path="uName" class="form-control" />
								<form:errors path="uName"></form:errors>
							</div>
							<div class="form-group">
								<label for="email">Email</label>
								<form:input path="email" class="form-control" />
								<form:errors path="email"></form:errors>
							</div>
							<div class="form-group">
								<label for="email">Mobile</label>
								<form:input path="mobileNo" class="form-control" />
								<form:errors path="mobileNo"></form:errors>
							</div>
							<div class="form-group">
								<label for="password">Password</label>
								<form:password path="password" class="form-control" />
								<form:errors path="password"></form:errors>
							</div>
							<div class="form-group">

								<form:hidden path="role" value="CUSTOMER" hidden='true'
									class="form-control" />
							</div>
							<div class="form-group">

								<form:hidden path="is_Active" value="true" hidden="true"
									class="form-control" />
							</div>
							<center><input type="submit" name="_eventId_submit"
								class="btn btn-primary" value="SUBMIT">&nbsp;&nbsp;<input
								type="submit" name="_eventId_cancel" value="CANCEL"
								class="btn btn-danger" /></center>


						</form:form>



					</div>
					<div class="col-sm-4"></div>
				</div>

			</div>
		</div>
	
	<%@include file="footer.jsp"%>