var myapp=angular.module("myApp",['ngRoute']);
myapp.config(function($routeProvider) 
{
		$routeProvider.when("#/",{templateUrl:"index.html"})
					  .when("/Blog",{templateUrl:"Blog/Blog.html",controller:'BlogController.js'})
					  .when("/Forum",{templateUrl:"Forum/forum.html",controller:'forumController.js'})
					  .when("/adminBlog",{templateUrl:"Blog/adminBlog.html",controller:'adminBlogController.js'})
					  .when("/jobs",{templateUrl:"jobs/jobs.html",controller:'jobsController.js'})
					  .when("/login",{templateUrl:"User/login.html",controller:'userController.js'})
					  .when("/register",{templateUrl:"User/registration.html",controller:'userController.js'})
					  .when("/friend",{templateUrl:"friend/friend.html",controller:'friendController.js'})
					  .when("/Chat",{templateUrl:"Chat/Chat.html",controller:'ChatController.js'})
					  .when("/ProfilePicture",{templateUrl:"ProfilePicture/ProfilePic.html"})
});














