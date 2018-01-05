var myapp=angular.module("myApp",['ngRoute','ngCookies']);
myapp.config(function($routeProvider, $locationProvider) 
{
	$locationProvider.hashPrefix('');
	$routeProvider.when("#/",{templateUrl:"index.html"})
		.when("/home",{templateUrl:"pages/home.html"})
	  .when("/postblog",{templateUrl:"Blog/Blog.html"})
	  .when("/viewblog",{templateUrl:"Blog/ViewBlog.html"})
	  .when("/forum",{templateUrl:"Forum/Forum.html"})
	  .when("/adminBlog",{templateUrl:"Blog/adminBlog.html"})
	  .when("/register",{templateUrl:"User/registration.html"})
	  .when("/login",{templateUrl:"User/login.html"})
	  .when("/UserHome",{templateUrl:"User/UserHome.html"})
	  .when("/Friend",{templateUrl:"Friend/friend.html"})
	  .when("/jobs",{templateUrl:"Jobs/jobs.html"})
	  .when("/addjobs",{templateUrl:"jobs/addjobs.html"})
	  .when("/showFriendRequest",{templateUrl:"Friend/showFriendRequest.html"})
	 
	  .when("/logout",{templateUrl:"User/logout.html"})
	  .when("/Chat",{templateUrl:"Chat/Chat.html"});
});

myapp.run(function($rootScope,$cookieStore)
{
	console.log('i am in run function');
	console.log($rootScope.currentUser);
	if($rootScope.currentUser==undefined)
		{
		$rootScope.currentUser=$cookieStore.get('user');
		}
	else{
		console.log($rootScope.currentUser.username);
		console.log($rootScope.currentUser.role);
	}
});

/*app.controller('mainController', function($scope) {
	$scope.message = 'This is home page';
});*/