var myapp=angular.module("myApp",['ngRoute']);
myapp.config(function($routeProvider) 
{
		$routeProvider.when("#/",{templateUrl:"index.html"})
					  .when("#/",{templateUrl:"home.html",controller:"mainController"})
					  .when("/Blog",{templateUrl:"Blog/Blog.html",controller:'BlogController.js'})
					  .when("/Forum",{templateUrl:"Forum/forum.html",controller:'forumController.js'})
					  .when("/adminBlog",{templateUrl:"Blog/adminBlog.html"})
					  .when("/jobs",{templateUrl:"jobs/jobs.html",controller:'jobsController.js'})
					  .when("/login",{templateUrl:"User/login.html",controller:'userController'})
					  .when("/registration",{templateUrl:"User/registration.html",controller:'userController'})
					  .when("/friend",{templateUrl:"friend/friend.html"})

});














