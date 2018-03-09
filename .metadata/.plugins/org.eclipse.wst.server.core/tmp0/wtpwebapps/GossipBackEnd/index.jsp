<html>
    <head>
        <title>Chat WebSocket</title>
        <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBgt4UODyJJkWhyR0sjgD9uec-bUWEKH2k" type="text/javascript"></script>
       
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.4/sockjs.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.js"></script>
        <script
        src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
       <!--  <script
	    src="http://maps.googleapis.com/maps/api/js?sensor=false&libraries=places"></script> -->
<script type="text/javascript">
function connect() {
	var socket = new SockJS('/GossipBackEnd/index');
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function(frame) {
		console.log('Connected: ' + frame);
		stompClient.subscribe('/topic/users', function(response) {
			console.log(response);
			console.log(JSON.parse(response.body));
		});
	});
}

function disconnect() {
	stompClient.disconnect();
	console.log("Disconnected");
}

function send() {	
	console.log("sending");
	var name = document.getElementById("name").value;
	stompClient.send("/app/user/"+name, {}, JSON.stringify({}));
}
</script>
<body>
<h1>Hello World</h1>

<input id="name">
<button onclick="connect()">Connect</button>
<button onclick="send()">Send</button>
<button onclick="disconnect()">Disconnect</button>

</body>
</html>