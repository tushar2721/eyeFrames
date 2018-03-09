app.controller("JobController",['$scope','$location','$window','$http',function($scope,$location,$window,$http){

$scope.AllJobs = [];

$scope.jtittle ={
			
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

$scope.jdesc ={
		
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

$scope.salary ={
		
		value :'',
		touched :false,
		error:true,
		validate : function(){
			this.touched =true;
			var regex = /^(0|[1-9]\d*)$/
			this.error=!regex.test(this.value)	
			console.log(this.value)
			
		}
}

$scope.comment ={
		
		value :'',
		touched :false,
		error:true,
		validate : function(){
			this.touched =true;
			var regex = /^.{10,200}$/
			this.error=!regex.test(this.value)	
			console.log(this.value)
			
		}
}

$scope.ejtittle ={
		
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

$scope.ejdesc ={
	
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

$scope.esalary ={
		
		value :'',
		touched :false,
		error:true,
		validate : function(){
			this.touched =true;
			var regex = /^(0|[1-9]\d*)$/
			this.error=!regex.test(this.value)	
			console.log(this.value)
			
		}
}

$scope.ecomment ={
		
		value :'',
		touched :false,
		error:true,
		validate : function(){
			this.touched =true;
			var regex = /^.{10,200}$/
			this.error=!regex.test(this.value)	
			console.log(this.value)
			
		}
}

$scope.Eid = -1;

$scope.EditJob = function( arg ){
    
    
    
    for( var x in $scope.AllJobs )
    {
        console.log( $scope.AllJobs[x] );
        console.log( arg );
        
        if( $scope.AllJobs[x].id == arg )
        {
            console.log( $scope.AllJobs[x].id );
            
            $scope.eid = $scope.AllJobs[x].id;
            $scope.ejtittle.value = $scope.AllJobs[x].jtittle;
            $scope.ejdesc.value = $scope.AllJobs[x].jdesc;
            $scope.esalary.value = $scope.AllJobs[x].salary;
            $scope.ecomment.value = $scope.AllJobs[x].comment;
            break;
        }
        
    }
    
}

$scope.SaveJobeToDB = function()
{
	var json = 
			{
			'id': $scope.eid,
			'jtittle': $scope.ejtittle.value,
			'jdesc': $scope.ejdesc.value,
			'salary': $scope.esalary.value,
			'comment': $scope.ecomment.value
			
			};
	
	console.log(json);
	//alert(json);
	
	$http({method:'post',url:BASE_URL + '/EditSaveJob', data: json, headers: {'Content-Type': 'application/json'}}).then(function(data){
		console.log( data )
		
		switch( data.data.msg )
		{
		case 'Success':
			
			swal("Job Updated", "Congratulations", "success")
			
			$http({method:'get',url:BASE_URL + '/fetchAllJobs', headers: {'Content-Type': 'application/json'}})
			.then(function(resp){
				console.log( resp.data )
			
				$scope.AllJobs = resp.data;
			},function(resp){
				
				console.log( "fetchAllJobs Error" )
			});
			
			break;
			
		case 'Failure':
			swal("Job Update Failure", "Something went wrong!", "error")
			break;
		}
		
	},function(data){
		console.log( data )
		
		switch( data.data.msg )
		{
		case 'Success':
			
			swal("Job Updated", "Congratulations", "success")
			
			$http({method:'get',url:BASE_URL + '/fetchAllJobs', headers: {'Content-Type': 'application/json'}})
			.then(function(resp){
				console.log( resp.data )
			
				$scope.AllJobs = resp.data;
			},function(resp){
				
				console.log( "fetchAllJobs Error" )
			});
			
			break;
			
		case 'Failure':
			swal("Job Update Failure", "Something went wrong!", "error")
			break;
		}
	});
}


$scope.SaveJob=function(){
	console.log('In save function');
		
	var json=  {
			Jtittle: $scope.jtittle.value ,
			Jdescription: $scope.jdesc.value,
			Salary: $scope.salary.value,
	};
	
	console.log(json);
	
	$http({method:'post',url:BASE_URL + '/addJob', data: json, headers: {'Content-Type': 'application/json'}}).then(function(data){
		console.log( data )
		
		switch( data.data.msg )
		{
		case 'Success':
			
			swal("Job Created", "success")
			
			break;
			
		case 'Failure':
			swal("Job Creation Failure", "Something went wrong!", "error")
			break;
		}
		
	},function(data){
		console.log( data )
		
		switch( data.data.msg )
		{
		case 'Success':
			
			swal("Job Created", "success")
			
			break;
			
		case 'Failure':
			swal("Job Creation Failure", "Something went wrong!", "error")
			break;
		}
	});
	
};

$scope.DeleteJob = function( arg )
{
    
    
    var json = 
            {
            'id': arg
            };
    
    console.log(json);
    //alert(json);
    
    $http({method:'post',url:BASE_URL + '/deleteJob', data: json, headers: {'Content-Type': 'application/json'}}).then(function(data){
        console.log( data )
        
        switch( data.data.msg )
        {
        case 'Success':
            
            swal("Job Deleted", "Congratulations", "success")
            
            $http({method:'get',url:BASE_URL + '/fetchAllJobs', headers: {'Content-Type': 'application/json'}})
            .then(function(resp){
                console.log( resp.data )
            
                $scope.AllJobs = resp.data;
            },function(resp){
                
                console.log( "fetchAllJobs Error" )
            });
            
            break;
            
        case 'Failure':
            swal("Job Delete Failure", "Something went wrong!", "error")
            break;
        }
        
    },function(data){
        console.log( data )
        
        switch( data.data.msg )
        {
        case 'Success':
            
            swal("Job Deleted", "Congratulations", "success")
            
            $http({method:'get',url:BASE_URL + '/fetchAllJobs', headers: {'Content-Type': 'application/json'}})
            .then(function(resp){
                console.log( resp.data )
            
                $scope.AllJobs = resp.data;
            },function(resp){
                
                console.log( "fetchAllJobs Error" )
            });
            
            break;
            
        case 'Failure':
            swal("Job Delete Failure", "Something went wrong!", "error")
            break;
        }
    });
}


$scope.fetchAllJobs = function() {

    $http({method:'get',url:BASE_URL + '/fetchAllJobs', headers: {'Content-Type': 'application/json'}})
    .then(function(resp){
        console.log( resp.data )
    
        $scope.AllJobs = resp.data;
    },function(resp){
        
        console.log( "fetchAllJobs Error" )
    });
    
}

$scope.fetchAllJobs();
}]);