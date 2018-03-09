app.controller("FriendsController",['$scope','$location','$window','$http',function($scope,$location,$window,$http){

$scope.AllFriends = [];

//Add Friend
$scope.User = undefined;

$scope.showProfileData = function(){
	
	$http({method:'post',url:BASE_URL + '/showProfileData', data: {"email":"tusthakre786@gmail.com"}, headers: {'Content-Type': 'application/json'}})
	.then(function(resp){
		$scope.User = resp.data;
	
		console.log( $scope.User )
	},function(resp){
		
		console.log( "showProfileData Error" )
	});
	
}

$scope.showProfileData();

$scope.AddFriend = function(arg1,arg2)
	{
		var json = 
				{
				'TargetEmail': arg1,
				'SourceEmail': arg2
				};
		
		console.log(json);
		//alert(json);
		
		$http({method:'post',url:BASE_URL + '/addFriend', data: json, headers: {'Content-Type': 'application/json'}}).then(function(data){
			console.log( data )
			
			switch( data.data.msg )
			{
			case 'Success':
				
				swal("Friend Request Sent", "", "success")
				
				$scope.showProfileData();
				
				break;
				
			case 'Failure':
				swal("Failed", "Something went wrong!", "error")
				break;
			}
			
		},function(data){
			console.log( data )
			
			switch( data.data.msg )
			{
			case 'Success':
				
				swal("Friend Request Sent", "", "success")
				
				$scope.fetchAllFriends();
				
				break;
				
			case 'Failure':
				swal("Failed", "Something went wrong!", "error")
				break;
			}
		});
	}

//Undo Friend
$scope.UndoFriend = function(arg1,arg2)
{
	var json = 
			{
			'TargetEmail': arg1,
			'SourceEmail': arg2
			};
	
	console.log(json);
	//alert(json);
	
	$http({method:'post',url:BASE_URL + '/undoFriend', data: json, headers: {'Content-Type': 'application/json'}}).then(function(data){
		console.log( data )
		
		switch( data.data.msg )
		{
		case 'Success':
			
			swal("Undo Request Done", "", "success")
			
			$scope.fetchAllFriends();
			
			break;
			
		case 'Failure':
			swal("Failed", "Something went wrong!", "error")
			break;
		}
		
	},function(data){
		console.log( data )
		
		switch( data.data.msg )
		{
		case 'Success':
			
			swal("Undo Request Done", "", "success")
			
			$scope.fetchAllFriends();
			
			break;
			
		case 'Failure':
			swal("Failed", "Something went wrong!", "error")
			break;
		}
	});
}

//Accept Friend Request
$scope.AcceptFriend = function(arg1,arg2)
{
	var json = 
			{
			'TargetEmail': arg1,
			'SourceEmail': arg2
			};
	
	console.log(json);
	//alert(json);
	
	$http({method:'post',url:BASE_URL + '/acceptFriend', data: json, headers: {'Content-Type': 'application/json'}}).then(function(data){
		console.log( data )
		
		switch( data.data.msg )
		{
		case 'Success':
			
			swal("Accepted Request", "", "success")
			
			$scope.fetchAllFriends();
			
			break;
			
		case 'Failure':
			swal("Failed", "Something went wrong!", "error")
			break;
		}
		
	},function(data){
		console.log( data )
		
		switch( data.data.msg )
		{
		case 'Success':
			
			swal("Accepted Request", "", "success")
			
			$scope.fetchAllFriends();
			
			break;
			
		case 'Failure':
			swal("Failed", "Something went wrong!", "error")
			break;
		}
	});
}


//Unfriend Friend Request
$scope.UnfriendFriend = function(arg1,arg2)
{
	var json = 
			{
			'TargetEmail': arg1,
			'SourceEmail': arg2
			};
	
	console.log(json);
	//alert(json);
	
	$http({method:'post',url:BASE_URL + '/unfriendFriend', data: json, headers: {'Content-Type': 'application/json'}}).then(function(data){
		console.log( data )
		
		switch( data.data.msg )
		{
		case 'Success':
			
			swal("Unfriend", "", "success")
			
			$scope.fetchAllFriends();
			
			break;
			
		case 'Failure':
			swal("Failed", "Something went wrong!", "error")
			break;
		}
		
	},function(data){
		console.log( data )
		
		switch( data.data.msg )
		{
		case 'Success':
			
			swal("Unfriend", "", "success")
			
			$scope.fetchAllFriends();
			
			break;
			
		case 'Failure':
			swal("Failed", "Something went wrong!", "error")
			break;
		}
	});
}


$scope.fetchAllFriends = function() {

    $http({method:'get',url:BASE_URL + '/fetchAllFriends', headers: {'Content-Type': 'application/json'}})
    .then(function(resp){
        console.log( resp.data )
    
        $scope.AllFriends = resp.data;
    },function(resp){
        
        console.log( "fetchAllFriends Error" )
    });
    
}

$scope.fetchAllFriends();
}]);