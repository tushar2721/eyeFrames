<!DOCTYPE html>
<html lang="en">
<head>
	<link rel="import" href="links.html">
  <title>Talisco.com</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
  .modal-header, h4, .close {
      background-color: #12a9ba;
      color:white !important;
      text-align: center;
      font-size: 30px;
  }
  .modal-footer {
      background-color: #f9f9f9;
  }
  </style>
  <script src="App.js"></script>
  <script src="RegisterController.js"></script>
  <script src="ProfileController.js"></script>
  <script src="BlogController.js"></script>
  <script src="ForumController.js"></script>
  <script src="FriendsController.js"></script>
  <script src="ChatController.js"></script>
  <script src="JobController.js"></script>
  <script src="AboutController.js"></script>
  <script src="ContactController.js"></script>
</head>
<body ng-app="myApp">


<div class="container">
  <!-- Modal -->
  <div class="modal fade" id="LoginModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header" style="padding:35px 50px;">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4><span class="glyphicon glyphicon-lock"></span> Login</h4>
        </div>
        <div class="modal-body" style="padding:40px 50px;">
          <form role="form">
            <div class="form-group">
              <label for="usrname"><span class="glyphicon glyphicon-user"></span> Username</label>
              <input type="text" class="form-control" id="usrname" placeholder="Enter Email">
            </div>
            <div class="form-group">
              <label for="psw"><span class="glyphicon glyphicon-eye-open"></span> Password</label>
              <input type="text" class="form-control" id="psw" placeholder="Enter Password">
            </div>
            <div class="checkbox">
              <label><input type="checkbox" value="" checked>Remember Me</label>
            </div>
              <button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span> Login</button>
          </form>
        </div>
        <div class="modal-footer">
          <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
          <p>Forgot <a href="#">Password?</a></p>
        </div>
      </div>
      
    </div>
  </div> 
</div>


<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <!-- <a class="navbar-brand" href="#">WebSiteName</a> -->
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">HOME</a></li>
      <li><a href="#!/contact">CONTACT US</a></li>
      <li><a href="#!/about">ABOUT US</a></li>
      <li><a href="#!/blog">BLOG</a></li>
      <li><a href="#!/forum">FORUM</a></li>
      <li><a href="#!/job">JOB</a></li>
      <li><a href="#!/friends">FRIENDS</a></li>
      <li><a href="#!/chat">CHAT</a></li>
    </ul>
     <ul class="nav navbar-nav navbar-right">
     <li><a href="#"><button class="btn btn-danger navbar-btn" data-toggle="modal" data-target="#LoginModal">LOGIN</button></a></li>
          <li><a href="#!/register"><button class="btn btn-danger navbar-btn" >REGISTER</button></a></li>
          <li><a href="#!/profile"><button class="btn btn-danger navbar-btn" >PROFILE</button></a></li>
     </ul>
  </div>
</nav>

<div class="container">
	<div ng-view>
	
	</div>

</div>
 

</body>
</html>
