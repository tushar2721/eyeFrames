app.controller("ForumController",['$scope','$location','$window','$http',function($scope,$location,$window,$http){

$scope.AllForums = [];

$scope.ftittle ={
			
			value :'',
			touched :false,
			error:true,
			validate : function(){
				this.touched =true;
				var regex = /^.{5,30}$/
				this.error=!regex.test(this.value)	
				console.log(this.value)
				
			}
}

$scope.fdesc ={
		
		value :'',
		touched :false,
		error:true,
		validate : function(){
			this.touched =true;
			var regex = /^.{20,2000}$/
			this.error=!regex.test(this.value)	
			console.log(this.value)
			
		}
}

$scope.eftittle ={
		
		value :'',
		touched :false,
		error:true,
		validate : function(){
			this.touched =true;
			var regex = /^.{5,20}$/
			this.error=!regex.test(this.value)	
			console.log(this.value)
			
		}
}

$scope.efdesc ={
	
	value :'',
	touched :false,
	error:true,
	validate : function(){
		this.touched =true;
		var regex = /^.{50,2000}$/
		this.error=!regex.test(this.value)	
		console.log(this.value)
		
	}
}

$scope.Eid = -1;

$scope.EditForum = function( arg ){
    
    
    
    for( var x in $scope.AllForums )
    {
        console.log( $scope.AllForums[x] );
        console.log( arg );
        
        if( $scope.AllForums[x].id == arg )
        {
            console.log( $scope.AllForums[x].id );
            
            $scope.eid = $scope.AllForums[x].id;
            $scope.eftittle.value = $scope.AllForums[x].ftittle;
            $scope.efdesc.value = $scope.AllForums[x].fdesc;
            break;
        }
        
    }
    
}

$scope.SaveForumeToDB = function()
{
	var json = 
			{
			'id': $scope.eid,
			'ftittle': $scope.eftittle.value,
			'fdesc': $scope.efdesc.value,
			
			};
	
	console.log(json);
	//alert(json);
	
	$http({method:'post',url:BASE_URL + '/EditSaveForum', data: json, headers: {'Content-Type': 'application/json'}}).then(function(data){
		console.log( data )
		
		switch( data.data.msg )
		{
		case 'Success':
			
			swal("Forum Updated", "Congratulations", "success")
			
			$http({method:'get',url:BASE_URL + '/fetchAllForums', headers: {'Content-Type': 'application/json'}})
			.then(function(resp){
				console.log( resp.data )
			
				$scope.AllForums = resp.data;
			},function(resp){
				
				console.log( "fetchAllForums Error" )
			});
			
			break;
			
		case 'Failure':
			swal("Forum Update Failure", "Something went wrong!", "error")
			break;
		}
		
	},function(data){
		console.log( data )
		
		switch( data.data.msg )
		{
		case 'Success':
			
			swal("Forum Updated", "Congratulations", "success")
			
			$http({method:'get',url:BASE_URL + '/fetchAllForums', headers: {'Content-Type': 'application/json'}})
			.then(function(resp){
				console.log( resp.data )
			
				$scope.AllForums = resp.data;
			},function(resp){
				
				console.log( "fetchAllForums Error" )
			});
			
			break;
			
		case 'Failure':
			swal("Forum Update Failure", "Something went wrong!", "error")
			break;
		}
	});
}


$scope.SaveForum=function(){
	console.log('In save function');
		
	var json=  {
			Ftittle: $scope.ftittle.value ,
			Fdescription: $scope.fdesc.value
	};
	
	console.log(json);
	
	$http({method:'post',url:BASE_URL + '/addForum', data: json, headers: {'Content-Type': 'application/json'}}).then(function(data){
		console.log( data )
		
		switch( data.data.msg )
		{
		case 'Success':
			
			swal("Forum Created", "success")
			
			break;
			
		case 'Failure':
			swal("Forum Creation Failure", "Something went wrong!", "error")
			break;
		}
		
	},function(data){
		console.log( data )
		
		switch( data.data.msg )
		{
		case 'Success':
			
			swal("Forum Created", "success")
			
			break;
			
		case 'Failure':
			swal("Forum Creation Failure", "Something went wrong!", "error")
			break;
		}
	});
	
};

$scope.DeleteForum = function( arg )
{
    
    
    var json = 
            {
            'id': arg
            };
    
    console.log(json);
    //alert(json);
    
    $http({method:'post',url:BASE_URL + '/deleteForum', data: json, headers: {'Content-Type': 'application/json'}}).then(function(data){
        console.log( data )
        
        switch( data.data.msg )
        {
        case 'Success':
            
            swal("Forum Deleted", "Congratulations", "success")
            
            $http({method:'get',url:BASE_URL + '/fetchAllForums', headers: {'Content-Type': 'application/json'}})
            .then(function(resp){
                console.log( resp.data )
            
                $scope.AllForums = resp.data;
            },function(resp){
                
                console.log( "fetchAllForums Error" )
            });
            
            break;
            
        case 'Failure':
            swal("Forum Delete Failure", "Something went wrong!", "error")
            break;
        }
        
    },function(data){
        console.log( data )
        
        switch( data.data.msg )
        {
        case 'Success':
            
            swal("Forum Deleted", "Congratulations", "success")
            
            $http({method:'get',url:BASE_URL + '/fetchAllForums', headers: {'Content-Type': 'application/json'}})
            .then(function(resp){
                console.log( resp.data )
            
                $scope.AllForums = resp.data;
            },function(resp){
                
                console.log( "fetchAllForums Error" )
            });
            
            break;
            
        case 'Failure':
            swal("Forum Delete Failure", "Something went wrong!", "error")
            break;
        }
    });
}


$scope.fetchAllForums = function() {

    $http({method:'get',url:BASE_URL + '/fetchAllForums', headers: {'Content-Type': 'application/json'}})
    .then(function(resp){
        console.log( resp.data )
    
        $scope.AllForums = resp.data;
    },function(resp){
        
        console.log( "fetchAllForums Error" )
    });
    
}

$scope.fetchAllForums();
}]);