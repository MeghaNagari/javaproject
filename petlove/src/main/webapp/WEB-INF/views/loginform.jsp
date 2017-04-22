<%@include file="header.jsp" %>
<div class="content">

	<div class="row">

		<div class="col-sm-4"></div>
		<div class="col-sm-4">

			<div class="container-fluid">
				<div class="row">
					<div class="col-sm-12">
					
					<br>
					<br>
						<center><b><h1 style="font-size:350%;color:RGB(26,92,183);">Log In</h1></b></center>

					</div>
				</div>
				<div class="row">
					<div class="col-sm-12">
						<form class="form" action="login" method="post">

							${error}

							<div class="form-group">
								<label>Email</label> <input type="text" name="username"
									class="form-control" required>

							</div>
							<div class="form-group">
								<label>Password</label> <input type="password" name="password"
									class="form-control" required>
							</div>
							<center>
							
							<input type="submit" value="Log In" class="btn btn-primary">
						<div class="btn-group btn-group-lg">
						
							<a href="registration">"<button type="button" class="btn btn-info" >SignUp</button></a>

						</div>
					</center>
							
						</form>
						

					</div>
				</div>

			</div>



		</div>
		<div class="col-sm-4"></div>

	</div>

</div>
</div>
<%@include file="footer.jsp" %>