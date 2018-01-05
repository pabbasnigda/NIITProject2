myapp.controller("userController",function($scope,$http,$location,$rootScope,$cookieStore)
{
	$scope.user={username:'',password:'',role:'',firstName:'',lastName:'',email:'',status:''};
	$scope.allusers;
	
	function fetchAllUsers()
	{
		console.log("Fetching All Users");
		$http.get('http://localhost:8181/SocialAppRest/getAllUsers')
		.then(function(response)
				{
					$scope.allusers=response.data;
				});
	};
	
	fetchAllUsers();
	
	$scope.register=function()
	{
		console.log('Entered into registerUser');
		
		$http.post('http://localhost:8181/SocialAppRest/register',$scope.user)
		.then(function(response)
				{
					console.log('Successfully Registered');
				});
	};
	
	$rootScope.login=function()
	{
		console.log("Logging Function");
		
		$http.post('http://localhost:8181/SocialAppRest/login',$scope.user)
			.then(function(response)
			{
				$scope.user=response.data;
				$rootScope.currentUser=response.data;
				$cookieStore.put('userDetails',response.data);
				console.log($rootScope.currentUser.role);
				$location.path("/UserHome");
			});
	};
	
	$rootScope.logout=function()
	{
		console.log('Logout Function');
		delete $rootScope.currentUser;
		$cookieStore.remove('userDetails');
		$location.path("/logout");
		
	}
	
	
});