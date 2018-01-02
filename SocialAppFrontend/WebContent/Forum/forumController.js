app.controller("forumController", function($scope, $http, $location) {
	function fetchAllForum() {
		console.log("fetching all forum");
		$http.get("http://localhost:8181/SocialAppRest/getAllForums")

		.then(function(response) {
			$scope.forumdata = response.data;
			console.log("data fetched or forum");
		});

	}
	;
	fetchAllForum();
	$scope.insertForum = function() {
		console.log('entered insertForum');
		$http.post('http://localhost:8181/SocialAppRest/insertForum',
				$scope.forum).then(fetchAllForum(), function(response) {
			console.log("successful forum entered");
			$location.path("/forum")
		});
	}
	$scope.deleteForum=function(forumId)
	{
		console.log("forum deleted");
		$http.get("http://localhost:8181/SocialAppRest/deleteForum/"+forumId)
		.success(fetchAllForum(),function(response){
			console.log('successful deletion');
			$scope.refresh();
			$location.path("/forum");
		});
	};
	
});