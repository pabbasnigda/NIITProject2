myapp.controller("BlogController",function($scope,$http,$location)
	{
	$scope.blog={blogId:' ',blogName:'',blogContent:'',userId:'',createDate:'',status:'',likes:''};
	$scope.blogdata;
	
	function fetchAllBlog()
	{
		console.log('Fetching all blogs');
		$http.get("http://localhost:8181/SocialAppRest/getAllBlogs")
		.then(function(response)
		{
			$scope.blogdata=response.data;
			
		});
	}
	
	
	fetchAllBlog();
	$scope.insertBlog=function()
	{
		console.log('Inserted the blog');
		$http.post('http://localhost:8181/SocialAppRest/insertBlog',$scope.blog)
		.then(function(response)
		{
			console.log('Successfully Blog inserted');
			$location.path("/Forum");
		});
	}
	}	
);