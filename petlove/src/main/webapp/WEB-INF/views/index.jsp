



<%@include file="header.jsp" %>

<div class="container-fluid">
  <br>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src= "resources/images/6859866-siberian-husky-wallpaper.jpg" alt="Chania" width="460" height="345">
      </div>

     <div class="item">
        <img src="resources/images/cokerspaniel.jpg" alt="Flower" width="460" height="345">
      </div>


      <div class="item">
        <img src="resources/images/chihuahua-puppies-shopping-cute.jpg" alt="Chania" width="460" height="345">
      </div>
    
    
      <div class="item">
        <img src="resources/images/germanshepherd.jpg" alt="Flower" width="460" height="345">
      </div>
      
      <div class="item">
        <img src="resources/images/pitbll.jpg" alt="Flower" width="460" height="345">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>
<br>
<br>
<!--  <center><h3><b>Welcome To Our One Stop Pet Store.</b></h3></center>
<div class="container">
<video width="100%" controls>
  <source src="resources/images/tyson.mp4" type="video/mp4">
</video>
</div>-->

<div class="container">
  <div class="row">
    <div class="col-sm-8">
    <br>
    
    <img src="resources/images/pickme3.jpg" class="img-rounded" height=300px width=700px >
    
    <center><button type="button" class="btn btn-info">Pick Me</button></center></div>
    
    <div class="col-sm-4">
    <br>
    <img src="resources/images/accessories4.jpg" class="img-rounded" height=300px width=350px>
  <br>  <center><button type="button" class="btn btn-info">Accessories</button></center></div>
    
  </div>
</div>

<%@include file="footer.jsp" %>
