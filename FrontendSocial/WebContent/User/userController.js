myapp.controller("userController", function($scope, $cookies, $http, $location,$rootScope) {
	$scope.user={userName:'',password:'',role:'',firstName:'',lastName:'',email:'',contact:'',isOnline:'',user_Id:''}
	$scope.allusers;
	$scope.user;
	
	var BASE_URL='http://localhost:8181/SocialAppRest'
	$scope.register=function()
	{
		console.log("entered into registerUser");
		$http.post(BASE_URL+"/register",$scope.user).then(function(response)
				{
					console.log("successfully registered");
					$location.path("/login");
				});
	}
	$scope.login=function()
	{ 
		console.log("logging function");
		
		$http.post(BASE_URL+"/login",$rootScope.currentUser)
		.then(function(response){
			$scope.user=response.data;
			$rootScope.currentUser=response.data;
			console.log($rootScope.currentUser.role);
			$location.path("/")
		});
	}
	function fetchAllUsers()
	{
		console.log("fetching all users");
		$http.get("http://localhost:8181/SocialAppRest/getAllUsers")
		.then(function(response)
				{
					$scope.allusers=response.data;
				});
	}
				fetchAllUsers();
});