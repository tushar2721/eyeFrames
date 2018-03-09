app.controller("BlogController",['$scope','$location','$window','$http',function($scope,$location,$window,$http){

$scope.AllBlogs = [];

$scope.tittle ={
			
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

$scope.desc ={
		
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

$scope.etittle ={
		
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

$scope.edesc ={
	
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

$scope.EditBlog = function( arg ){
    
    
    
    for( var x in $scope.AllBlogs )
    {
        console.log( $scope.AllBlogs[x] );
        console.log( arg );
        
        if( $scope.AllBlogs[x].id == arg )
        {
            console.log( $scope.AllBlogs[x].id );
            
            $scope.eid = $scope.AllBlogs[x].id;
            $scope.etittle.value = $scope.AllBlogs[x].tittle;
            $scope.edesc.value = $scope.AllBlogs[x].desc;
            break;
        }
        
    }
    
}

$scope.SaveBlogeToDB = function()
{
	var json = 
			{
			'id': $scope.eid,
			'tittle': $scope.etittle.value,
			'desc': $scope.edesc.value,
			
			};
	
	console.log(json);
	//alert(json);
	
	$http({method:'post',url:BASE_URL + '/EditSaveBlog', data: json, headers: {'Content-Type': 'application/json'}}).then(function(data){
		console.log( data )
		
		switch( data.data.msg )
		{
		case 'Success':
			
			swal("Blog Updated", "Congratulations", "success")
			
			$http({method:'get',url:BASE_URL + '/fetchAllBlogs', headers: {'Content-Type': 'application/json'}})
			.then(function(resp){
				console.log( resp.data )
			
				$scope.AllBlogs = resp.data;
			},function(resp){
				
				console.log( "fetchAllBlogs Error" )
			});
			
			break;
			
		case 'Failure':
			swal("Blog Update Failure", "Something went wrong!", "error")
			break;
		}
		
	},function(data){
		console.log( data )
		
		switch( data.data.msg )
		{
		case 'Success':
			
			swal("Blog Updated", "Congratulations", "success")
			
			$http({method:'get',url:BASE_URL + '/fetchAllBlogs', headers: {'Content-Type': 'application/json'}})
			.then(function(resp){
				console.log( resp.data )
			
				$scope.AllBlogs = resp.data;
			},function(resp){
				
				console.log( "fetchAllBlogs Error" )
			});
			
			break;
			
		case 'Failure':
			swal("Blog Update Failure", "Something went wrong!", "error")
			break;
		}
	});
}


$scope.SaveBlog=function(){
	console.log('In save function');
		
	var json=  {
			Tittle: $scope.tittle.value ,
			Description: $scope.desc.value
	};
	
	console.log(json);
	
	$http({method:'post',url:BASE_URL + '/addBlog', data: json, headers: {'Content-Type': 'application/json'}}).then(function(data){
		console.log( data )
		
		switch( data.data.msg )
		{
		case 'Success':
			
			swal("Blog Created", "success")
			
			break;
			
		case 'Failure':
			swal("Blog Creation Failure", "Something went wrong!", "error")
			break;
		}
		
	},function(data){
		console.log( data )
		
		switch( data.data.msg )
		{
		case 'Success':
			
			swal("Blog Created", "success")
			
			break;
			
		case 'Failure':
			swal("Blog Creation Failure", "Something went wrong!", "error")
			break;
		}
	});
	
};

$scope.DeleteBlog = function( arg )
{
    
    
    var json = 
            {
            'id': arg
            };
    
    console.log(json);
    //alert(json);
    
    $http({method:'post',url:BASE_URL + '/deleteBlog', data: json, headers: {'Content-Type': 'application/json'}}).then(function(data){
        console.log( data )
        
        switch( data.data.msg )
        {
        case 'Success':
            
            swal("Blog Deleted", "Congratulations", "success")
            
            $http({method:'get',url:BASE_URL + '/fetchAllBlogs', headers: {'Content-Type': 'application/json'}})
            .then(function(resp){
                console.log( resp.data )
            
                $scope.AllBlogs = resp.data;
            },function(resp){
                
                console.log( "fetchAllBlogs Error" )
            });
            
            break;
            
        case 'Failure':
            swal("Blog Delete Failure", "Something went wrong!", "error")
            break;
        }
        
    },function(data){
        console.log( data )
        
        switch( data.data.msg )
        {
        case 'Success':
            
            swal("Blog Deleted", "Congratulations", "success")
            
            $http({method:'get',url:BASE_URL + '/fetchAllBlogs', headers: {'Content-Type': 'application/json'}})
            .then(function(resp){
                console.log( resp.data )
            
                $scope.AllBlogs = resp.data;
            },function(resp){
                
                console.log( "fetchAllBlogs Error" )
            });
            
            break;
            
        case 'Failure':
            swal("Blog Delete Failure", "Something went wrong!", "error")
            break;
        }
    });
}


$scope.fetchAllBlogs = function() {

    $http({method:'get',url:BASE_URL + '/fetchAllBlogs', headers: {'Content-Type': 'application/json'}})
    .then(function(resp){
        console.log( resp.data )
    
        $scope.AllBlogs = resp.data;
    },function(resp){
        
        console.log( "fetchAllBlogs Error" )
    });
    
}

$scope.fetchAllBlogs();
}]);