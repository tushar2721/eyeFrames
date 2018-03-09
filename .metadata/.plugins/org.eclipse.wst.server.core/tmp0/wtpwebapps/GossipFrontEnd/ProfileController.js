app.directive('fileModel', ['$parse', function ($parse) {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;

            element.bind('change', function(){
                scope.$apply(function(){
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
}]);

app.service('fileUpload', ['$http', function ($http) {
    this.uploadFileToUrl = function(file, uploadUrl, email , scope){
        var fd = new FormData();
        fd.append('file', file);
        fd.append('email', email);
        
        console.log( email );
        
        $http.post(uploadUrl, fd, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        })
        .then(function( response ){
        	console.log('Image Upload Result:');
   		 	console.log(response.data);
   		 	
   		 	switch( response.data.msg )
   		 	{
   		 	case "Success":
   		 		swal("Image Uploaded Successfully","","success");
   		 		scope.ProfileData.profilePicUrl = response.data.imageUrl;
   		 		break;
   		 	case "Failure":
		 		swal("Image Not Uploaded","","error");
		 		break;
   		 	}
   		 	
   		 },function(){
        	alert('not submitted');
        });
    }
}]);

app.controller("ProfileController" ,['$scope','$location','$window','$http','fileUpload', function($scope,$location,$window,$http,fileUpload){

	console.log("ProfileController");

	$scope.checkFileChange = function(){
		var file = $scope.myFile;
		
		console.log( file );
		console.log( $scope.Eemail.value  );
		
		//var uploadUrl = 'http://www.example.com/images';
		 fileUpload.uploadFileToUrl(file, BASE_URL + '/updateProfilePicture', $scope.ProfileData.email , $scope);
		 
	}
	
	$scope.Ename = {
			value: '',
			touched : false,
			error : true,
			validate : function(){
				this.touched = true;
				var regex= /^[A-Za-z]{2,30}$/;
				this.error=!regex.test(this.value);
			}
			
			
	};
	$scope.Eemail = {
			value: '',
			touched : false,
			error : true,
			validate : function(){
				this.touched = true;
				var regex= /^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z]+[\\.]{1}[A-Za-z]+([\\.]{1}[A-Za-z]+)?$/;
				this.error=!regex.test(this.value);
			}
			
			
	};
	$scope.Npassword = {
			value: '',
			touched : false,
			error : true,
			validate : function(){
				this.touched = true;
				var regex= /^((?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,})$/;
				this.error= !regex.test( this.value );
			}
	
	
			
			
	};
	$scope.Cpassword = {
			value: '',
			touched : false,
			error : true,
			validate : function(){
				this.touched = true;
				var regex= /^((?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,})$/;
				this.error=(this.value != $scope.Npassword.value);
			}
			
			
	};
	$scope.password = {
			value: '',
			touched : false,
			error : true,
			validate : function(){
				this.touched = true;
				
				this.error= (this.value != $scope.ProfileData.password);
			}
			
			
	};
	$scope.Emobile = {
			value: '',
			touched : false,
			error : true,
			validate : function(){
				this.touched = true;
				var regex= /^[7-9]{1}[0-9]{9}$/;
				console.log(this.value);
				this.error=!regex.test(this.value);
			}
			
			
	};
	$scope.Eaddress = {
			value: '',
			touched : false,
			error : true,
			validate : function(){
				this.touched = true;
				var regex= /^[a-zA-Z0-9 ,.-/#:]{2,60}$/;
				this.error=!regex.test(this.value);
			}
			
			
	};
	$scope.Epincode = {
			value: '',
			touched : false,
			error : true,
			validate : function(){
				this.touched = true;
				var regex= /^[1-9]{1}[0-9]{5}$/;
				this.error=!regex.test(this.value);
			}
			
			
	};
	
	
	
$scope.ProfileData={};
	$scope.showProfile = function(){
		var json= {email : 'tusthakre786@gmail.com'};
		console.log('helloooo');
		$http({method:'post',url:BASE_URL + '/showProfileData', data: json, headers: {'Content-Type': 'application/json'}}).then(function(response){
			console.log( response.data )
			
			$scope.ProfileData=response.data;
			
			
			
			/*switch( data.data.msg )
			{
				
			case 'Failure':
				swal("User Creation Failure", "Something went wrong!", "error")
				break;
			}*/
			
		},function(data){
			console.log( data )
			
			switch( data.data.msg )
			{
			case 'Success':
				
				swal("data fetched", "Login to continue", "success")
				
				break;
				
			case 'Failure':
				swal("fetching Failure", "Something went wrong!", "error")
				break;
			}
		});
		
	};
		
	$scope.showProfile();
	
	$scope.showEditData = function(){
		$scope.Ename.value=$scope.ProfileData.name;
		$scope.Ename.error=false;
		$scope.Ename.touched=true;
		
		$scope.Emobile.value=$scope.ProfileData.mobile;
		$scope.Emobile.error=false;
		$scope.Emobile.touched=true;
		
		
		$scope.Eaddress.value=$scope.ProfileData.address;
		$scope.Eaddress.error=false;
		$scope.Eaddress.touched=true;
		
		$scope.Eemail.value=$scope.ProfileData.email;
		$scope.Eemail.error=false;
		$scope.Eemail.touched=true;
		
		$scope.Epincode.value=$scope.ProfileData.pincode;
		$scope.Epincode.error=false;
		$scope.Epincode.touched=true;
		
		/*$scope.Epassword.value=$scope.ProfileData.password;
		$scope.Epassword.error=false;
		$scope.Epassword.touched=true;*/
		
		$scope.Egender.value=$scope.ProfileData.gender;
		$scope.Egender.error=false;
		$scope.Egender.touched=true;
		
		
	};
	
	
	$scope.UpdateUser=function(){
		console.log('In save function');
		
		var json=  {
				name: $scope.Ename.value ,
				mobile: $scope.Emobile.value,
				email:$scope.Eemail.value,
				address:$scope.Eaddress.value,
				/*password:$scope.Epassword.value,*/
				gender:$scope.Egender ,
				pincode :$scope.Epincode.value
				
		};
		$http({method:'post',url:BASE_URL + '/UpdateUser', data: json, headers: {'Content-Type': 'application/json'}}).then(function(data){
			console.log( data )
			
			switch( data.data.msg )
			{
			case 'Success':
				
				swal("profile updated", "Login to continue", "success")
				
				break;
				
			case 'Failure':
				swal("profile updation Failure", "Something went wrong!", "error")
				break;
			}
			
		},function(data){
			console.log( data )
			
			switch( data.data.msg )
			{
			case 'Success':
				
				swal("User Created", "Login to continue", "success")
				
				break;
				
			case 'Failure':
				swal("User Creation Failure", "Something went wrong!", "error")
				break;
			}
		});
		
	};
	
	
	
	$scope.UpdatePassword = function()
	{
		//alert('UpdateUser');
		
		var json = 
				{
				
				'email': "tusthakre786@gmail.com",
				'password': $scope.Npassword.value
				
				};
		
		console.log(json);
		//alert(json);
		
		$http({method:'post',url:BASE_URL + '/updatePassword', data: json, headers: {'Content-Type': 'application/json'}}).then(function(data){
			console.log( data )
			
			switch( data.data.msg )
			{
			case 'Success':
				
				swal("User Updated", "Congratulations", "success")
				
				break;
				
			case 'Failure':
				swal("User Update Failure", "Something went wrong!", "error")
				break;
			}
			
		},function(data){
			console.log( data )
			
			switch( data.data.msg )
			{
			case 'Success':
				
				swal("password Updated", "Congratulations", "success")
				
				break;
				
			case 'Failure':
				swal("password Updation Failure", "Something went wrong!", "error")
				break;
			}
		});
	}
	
	
	

}] );
