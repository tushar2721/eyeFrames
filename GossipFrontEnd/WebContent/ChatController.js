app.controller("ChatController",['$scope','$location','$window','$http',function($scope,$location,$window,$http){

$scope.AllMessages = [];

/*var stompClient = null;*/

//this function can remove a array element.
    Array.remove = function(array, from, to) {
    var rest = array.slice((to || from) + 1 || array.length);
    array.length = from < 0 ? array.length + from : from;
    return array.push.apply(array, rest);
};

//this variable represents the total number of popups can be displayed according to the viewport width
var total_popups = 0;

//arrays of popups ids
var popups = [];

//this is used to close a popup
$scope.close_popup=function (id)
{	
    for(var iii = 0; iii < popups.length; iii++)
    {
        if(id == popups[iii])
        {
        	Array.remove(popups, iii);
            
            document.getElementById(id).style.display = "none";
            
            $scope.calculate_popups();
            
            return;
        }
    }   
}

//displays the popups. Displays based on the maximum number of popups that can be displayed on the current viewport width
$scope.display_popups=function ()
{
    var right = 220;
    
    var iii = 0;
    for(iii; iii < total_popups; iii++)
    {
        if(popups[iii] != undefined)
        {
            var element = document.getElementById(popups[iii]);
            element.style.right = right + "px";
            right = right + 320;
            element.style.display = "block";
        }
    }
    
    for(var jjj = iii; jjj < popups.length; jjj++)
    {
        var element = document.getElementById(popups[jjj]);
        element.style.display = "none";
    }
}

//creates markup for a new popup. Adds the id to popups array.
$scope.register_popup=function(object)
{
    console.log(object);
    object = object.split(';;');
        
	console.log(object[0])
	console.log(object[1])
	
	id = (object[1])
	name = (object[0])
    
    for(var iii = 0; iii < popups.length; iii++)
    {   
        //already registered. Bring it to front.
        if(id == popups[iii])
        {
        	Array.remove(popups, iii);
        
            /*$scope.popups.unshift(id);*/
            
            $scope.calculate_popups();
            
            
            return;
        }
    }               
    
    var element = '<div class="popup-box chat-popup" id="'+ id +'">';
    element = element + '<div class="popup-head">';
    element = element + '<div class="popup-head-left">'+ name +'</div>';
    element = element + '<div class="popup-head-right"><a href="javascript:close_popup(\''+ id +'\');">&#10005;</a></div>';
    element = element + '<div style="clear: both"></div></div><div class="popup-messages"><br><br><br><br><br><br><br><br><br><textarea class="form-control" style="width:300px; height: 30px;"></textarea><button type="button" class="btn btn-danger">Send</button></div></div>';
    
    document.getElementsByTagName("body")[0].innerHTML = document.getElementsByTagName("body")[0].innerHTML + element;  

    /*$scope.popups.unshift(id);*/
            
    $scope.calculate_popups();
    
}

//calculate the total number of popups suitable and then populate the toatal_popups variable.
$scope.calculate_popups=function()
{
    var width = window.innerWidth;
    if(width < 540)
    {
        total_popups = 0;
    }
    else
    {
        width = width - 200;
        //320 is width of a single popup box
        $scope.total_popups = parseInt(width/320);
    }
    
    $scope.display_popups();

    
    window.addEventListener("resize", calculate_popups);
    window.addEventListener("load", calculate_popups);

}

//recalculate when window is loaded and also when window is resized.


$scope.connect=function() {
	console.log("yes");
	var socket = new SockJS('/GossipBackEnd/Chat');
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function(frame) {
		console.log('Connected: ' + frame);
		stompClient.subscribe('/topic/users', function(response) {
			console.log(response);
			console.log(JSON.parse(response.body));
		});
	});
}

$scope.disconnect=function() {
	stompClient.disconnect();
	console.log("Disconnected");
}

$scope.formatAMPM=function(date) {
	    var now     = new Date(); 
	    var year    = now.getFullYear();
	    var month   = now.getMonth()+1; 
	    var day     = now.getDate();
	    var hour    = now.getHours();
	    var minute  = now.getMinutes();
	    var second  = now.getSeconds(); 
	    if(month.toString().length == 1) {
	        var month = '0'+month;
	    }
	    if(day.toString().length == 1) {
	        var day = '0'+day;
	    }   
	    if(hour.toString().length == 1) {
	        var hour = '0'+hour;
	    }
	    if(minute.toString().length == 1) {
	        var minute = '0'+minute;
	    }
	    if(second.toString().length == 1) {
	        var second = '0'+second;
	    }   
	    var date = year+'/'+month+'/'+day+' '+hour+':'+minute+':'+second;   
	     return date;    
}   

$scope.send=function() {	
	console.log("sending");
	var from = document.getElementById("from").value;
	var to = document.getElementById("to").value;
	var text = document.getElementById("text").value;
	var date = formatAMPM(new Date());
	stompClient.send("/app/user/"+from,+to,+text, {}, JSON.stringify({'date':date}));

	console.log('In save function');
	console.log(date);
	
	var json=  {
			From: "tusthakre786@gmail.com",
			To:   $scope.to.value ,
		    Text: $scope.text.value ,
		    Date: $scope.date = new Date(),
	};
	
	console.log(json);
	
	$http({method:'post',url:BASE_URL + '/addMessage', data: json, headers: {'Content-Type': 'application/json'}}).then(function(data){
		console.log( data )
		
		switch( data.data.msg )
		{
		case 'Success':
			
			swal("Sent", "success")
			
			break;
			
		case 'Failure':
			swal("Sent Failure", "Something went wrong!", "error")
			break;
		}
		
	},function(data){
		console.log( data )
		
		switch( data.data.msg )
		{
		case 'Success':
			
			swal("Sent", "success")
			
			break;
			
		case 'Failure':
			swal("Sent Failure", "Something went wrong!", "error")
			break;
		}
	});
	
};

$scope.fetchAllMessages = function() {

    $http({method:'get',url:BASE_URL + '/fetchAllMessages', headers: {'Content-Type': 'application/json'}})
    .then(function(resp){
        console.log( resp.data )
    
        $scope.AllMessages = resp.data;
    },function(resp){
        
        console.log( "fetchAllMessages Error" )
    });
    
}

$scope.fetchAllMessages();

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