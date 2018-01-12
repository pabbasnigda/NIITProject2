var myapp=angular.module("myApp",['ngRoute','ngCookies']);

myapp.config(function($routeProvider)
		{
			$routeProvider.when("#/",{templateUrl:"index.html"})
						  
						  .when("/Blog",{templateUrl:"Blog/Blog.html"})
						  .when("/ViewBlog",{templateUrl:"Blog/ViewBlog.html"})
						  .when("/postblog",{templateUrl:"Blog/Blog.html"})
						  .when("/ViewForum",{templateUrl:"Forum/viewforum.html"})
						  .when("/postforum",{templateUrl:"Forum/Forum.html"})
						  .when("/Forum",{templateUrl:"Forum/Forum.html"})
						  .when("/adminBlog",{templateUrl:"Blog/adminBlog.html"})
						  .when("/adminForum",{templateUrl:"Forum/adminForum.html"})
						  .when("/registration",{templateUrl:"User/registration.html"})
						  .when("/login",{templateUrl:"User/login.html"})
						  .when("/Home",{templateUrl:"User/Home.html"})
						  .when("/Userhome",{templateUrl:"User/UserHome.html"})
						  .when("/Friend",{templateUrl:"User/Friend.html"})
						  .when("/jobs",{templateUrl:"Jobs/jobs.html" })
        		          .when("/showjobs",{templateUrl:"Jobs/Showjobs.html"})	
						  .when("/FriendRequest",{templateUrl:"Friend/showFriendRequest.html"})
						  .when("/ProfilePic",{templateUrl:"User/ProfilePic.html"})
						  
						  .when("/Chat",{templateUrl:"Chat/Chat.html"});
			
		});

myapp.run(function($rootScope,$cookieStore)
		{
			console.log('I am in run function');
			
			console.log($rootScope.currentUser);
			
				if($rootScope.currentUser==undefined)
				{
				$rootScope.currentUser=$cookieStore.get('userDetails');
				}
				else
				{
				console.log($rootScope.currentUser.username);
				console.log($rootScope.currentUser.role);
				}
		});