<%@include file="header.jsp"%>

<div class="container-fluid">
	<div class="row">
		<div class="col-sm-3"></div>
		<div class="col-sm-6">
			<div class="col-sm-6">
				<div class="thumbnail">
					<img src="" alt="product image">

				</div>

			</div>
			<div class="col-sm-6">
				<table class="table table-responsive">
					<tr>
					<td>Product Name</td>
					<td>${product.prodName}</td>
					
					</tr>
					<tr>
					<td>Product Price</td>
					<td>${product.prodPrice}</td>
					</tr>

					<tr>
					<td>Product productDespription</td>
					<td>${product.prodDesc}</td>
					</tr>

					<tr>
					<td>Product quantity</td>
					<td>${product.quantity}</td>
					</tr>

	<tr>
	<td><a href="${contextPath}/customer/${product.productId}/addcart"><input type ="submit" value="AddtoCart"/></a></td>
	</tr>



				</table>



			</div>
		</div>
	</div>
	<div class="col-sm-3"></div>

</div>

<%@include file="footer.jsp"%>
