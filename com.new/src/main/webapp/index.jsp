<!DOCTYPE html>
<html lang="en">
<head>
  <title>Talisco.com</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <!-- <a class="navbar-brand" href="#">WebSiteName</a> -->
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">HOME</a></li>
      <li><a href="#">CONTACT US</a></li>
      <li><a href="#">ABOUT US</a></li>
    </ul>
     <ul class="nav navbar-nav navbar-right">
     <li><a href="#"><button class="btn btn-danger navbar-btn" >SIGNUP</button></a></li>
     <li><a href="#"><button class="btn btn-danger navbar-btn" >LOGIN</button></a></li>
     </ul>
  </div>
</nav>

<!-- LOGIN MODAL -->
<div class="container">
  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
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
 
<script>
$(document).ready(function(){
    $("#myBtn").click(function(){
        $("#myModal").modal();
    });
});
</script>

<!-- SIGNUP -->
<form action="/myBtn1">
<div class="container">
            <div class="form-group">
              <label for="name"><span class="glyphicon glyphicon-user"></span> Name</label>
              <input type="text" class="form-control" id="name" placeholder="Enter Name">
            </div>
            <div class="form-group">
              <label for="password"><span class="glyphicon glyphicon-eye-open"></span> Password</label>
              <input type="text" class="form-control" id="password" placeholder="Enter Password">
            </div>
            <div class="form-group">
              <label for="email"><span class="glyphicon glyphicon-send"></span> Email</label>
              <input type="text" class="form-control" id="email" placeholder="Enter Email">
            </div>
            <div class="form-group">
              <label for="Mobile"><span class="glyphicon glyphicon-phone"></span> Mobile</label>
              <input type="text" class="form-control" id="mobile" placeholder="Enter Mobile">
            </div>
            <div class="form-group">
              <label for="address"><span class="glyphicon glyphicon-globe"></span> Address</label>
              <input type="text" class="form-control" id="address" placeholder="Enter Address">
            </div>
            <div class="form-group">
              <label for="pin"><span class="glyphicon glyphicon-inbox"></span> Pincode</label>
              <input type="text" class="form-control" id="pin" placeholder="Enter Pincode">
            </div>
            <div class="form-group">
              <label for="gender"><span class="glyphicon glyphicon-check"></span> Gender</label><br>
              <input type="radio" name="gender" value="Male">Male<br>
              <input type="radio" name="gender" value="Female">Female 
            </div>
              <button type="submit" class="btn btn-primary btn-block"><span class="glyphicon glyphicon-user"></span> Signup</button>
              <button type="cancel" class="btn btn-danger btn-block"><span class="glyphicon glyphicon-user"></span> Cancel</button>
          </div>
</form>
</body>
</html>
