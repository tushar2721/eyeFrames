var app= angular.module('myApp',['ngRoute']);
var BASE_URL='http://localhost:9001/GossipBackEnd';

app.config(function ($routeProvider){
	
	$routeProvider
	
	.when('/register',{
		templateUrl :'Register.html',
		controller :'RegisterController'
		
	})
	.when ('/profile', {
		templateUrl : 'Profile.html',
		controller : 'ProfileController'
		
	})
    .when ('/blog', {
		templateUrl : 'Blog.html',
		controller : 'BlogController'
		
	})
	.when ('/forum', {
		templateUrl : 'Forum.html',
		controller : 'ForumController'
		
	})
	.when ('/friends', {
		templateUrl : 'Friends.html',
		controller : 'FriendsController'
		
	})
	.when ('/chat', {
		templateUrl : 'Chat.html',
		controller : 'ChatController'
		
	})
	.when ('/job', {
		templateUrl : 'Job.html',
		controller : 'JobController'
		
	})
	.when ('/contact', {
		templateUrl : 'Contact.html',
		controller : 'ContactController'
		
	})
	.when ('/about', {
		templateUrl : 'About.html',
		controller : 'AboutController'
		
	})
console.log($routeProvider);
})
