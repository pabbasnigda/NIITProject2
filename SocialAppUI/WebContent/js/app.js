	// create the module and name it app
var app = angular.module('myApp', ['ngRoute']);

//configure our routes
app.config(function($routeProvider, $locationProvider) {
  $locationProvider.hashPrefix('');
	$routeProvider

		// route for the home page
		.when('/', {
			templateUrl : 'pages/home.html',
			controller  : 'mainController'
		})
        
		.when('/registration', {
			templateUrl : 'user/registration.html',
			controller  : 'registrationController'
		})
		// route for the about page
		.when('/login', {
			templateUrl : 'user/login.html',
			controller  : 'loginController'
		});		
});

app.controller('mainController', function($scope) {	
	$scope.message = 'This is home page';
});

