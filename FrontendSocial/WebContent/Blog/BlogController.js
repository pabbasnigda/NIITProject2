myapp.controller("BlogController",function($scope,$http,$location,$rootScope)
{
		$scope.blog={blogId:'',blogName:'',blogContent:'',createDate:'',likes:0,username:'',status:"NA"}
		$scope.blog;

		var BASE_URL='http://localhost:8181/SocialAppRest/'
		$scope.insertBlog=function()
		{
			console.log('Entered into InsertBlog');
			$http.post(BASE_URL+"/insertBlog", $scope.blog).then(function(response)
				{
				console.log('Successful Blog Entered');
				});
		}

	
		$http.get("http://localhost:8181/SocialAppRest/getAllBlogs")
		.then(function(response)
		{
			$scope.blogdata=response.data;
		});

});