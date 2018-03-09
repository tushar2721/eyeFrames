app.controller("RegisterController",['$scope','$location','$window','$http',function($scope,$location,$window,$http){
	
$scope.name ={
			
			value :'',
			touched :false,
			error:true,
			validate : function(){
				this.touched =true;
				var regex = /^.{2,25}$/
				this.error=!regex.test(this.value)	
				console.log(this.value)
				
			}
			
	}
	
$scope.password ={
			
			value :'',
			touched :false,
			error:true,
			validate : function(){
				this.touched =true;
				var regex = /^.{7,20}$/
				this.error=!regex.test(this.value)	
				console.log(this.value)
				
			}
			
	}
	
$scope.email ={
			
			value :'',
			touched :false,
			error:true,
			validate : function(){
				this.touched =true;
				var regex = /^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z]+[\\.]{1}[A-Za-z]+([\\.]{1}[A-Za-z]+)?$/
				this.error=!regex.test(this.value)	
				console.log(this.value)
				
			}
			
	}
	
$scope.mobile ={
			
			value :'',
			touched :false,
			error:true,
			validate : function(){
				this.touched =true;
				var regex = /^[789]{1}[0-9]{9}$/
				this.error=!regex.test(this.value)	
				console.log(this.value)
				
			}
			
	}
	
$scope.address ={
			
			value :'',
			touched :false,
			error:true,
			validate : function(){
				this.touched =true;
				var regex = /^.{5,50}$/
				this.error=!regex.test(this.value)	
				console.log(this.value)
				
			}
			
	}
	
$scope.pincode ={
		
		value :'',
		touched :false,
		error:true,
		validate : function(){
			this.touched =true;
			var regex = /^\d{6}$/
			this.error=!regex.test(this.value)	
			console.log(this.value)
			
		}
		
}

$scope.SaveUser=function(){
	console.log('In save function');
		
	var json=  {
			name: $scope.name.value ,
			mobile: $scope.mobile.value,
			email:$scope.email.value,
			address:$scope.address.value,
			password:$scope.password.value,
			pincode :$scope.pincode.value,
			gender:$scope.gender
			
	};
	
	console.log(json);
	
	$http({method:'post',url:BASE_URL + '/addUser', data: json, headers: {'Content-Type': 'application/json'}}).then(function(data){
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


}]);