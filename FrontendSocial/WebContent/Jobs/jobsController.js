myapp.controller("jobsController", function($scope, $http, $location,$rootScope)
{
	

	$scope.insertJob=function()
	{
		console.log('Posting Job');
		
		$http.post('http://localhost:8181/SocialAppRest/insertJob',$scope.job)
		.then(function(response)
				{
				console.log('Successfully Posted the Job');
				$location.path("/jobs");
				});
	}
	
	$scope.deleteJob=function(jobId)
	{
		console.log('Deleting job');
		$http.get('http://localhost:8181/SocialAppRest/deleteJob'+jobId)
		.then(function(response)
				{
				console.log('Job Deleted');
				$location.path("/jobs");
				});
	}
	
	function fetchAllJobs()
	{
		$http.get('http://localhost:8181/SocialAppRest/getAllJobs')
		.then(function(response)
				{
				$scope.jobsdata=response.data;
			console.log("all jobs fetched");
				});
	}
	
	fetchAllJobs();
});