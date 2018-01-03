var myapp=angular.module("myApp",['ngRoute','ngCookies']);
myapp.config(function($routeProvider) 
{
		$routeProvider.when("#/",{templateUrl:"index.html"})
					  .when('/', {templateUrl : 'pages/home.html',controller : 'mainController'})
					  .when("/Blog",{templateUrl:"Blog/Blog.html",controller:'BlogController'})
					  .when("/Forum",{templateUrl:"Forum/Forum.html",controller:'forumController'})
					  .when("/adminBlog",{templateUrl:"Blog/adminBlog.html",controller:'adminBlogController'})
					  .when("/Jobs",{templateUrl:"Jobs/jobs.html",controller:'jobsController'})
					  .when("/login",{templateUrl:"User/login.html",controller:'userController'})
					  .when("/register",{templateUrl:"User/registration.html",controller:'userController'})
					  .when("/friend",{templateUrl:"Friend/friend.html",controller:'friendController'})
					  .when("/Chat",{templateUrl:"Chat/Chat.html",controller:'chatController'})
					  
});

myapp.run(function($rootScope,$cookieStore){
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