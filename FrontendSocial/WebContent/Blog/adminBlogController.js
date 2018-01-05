myapp.controller("adminBlogController", function($scope, $http, $location) 
{
	$scope.blog={blogId:'0',blogName:'',blogContent:'',createDate:'',likes:'0',userId:'',status:'A'};
	$scope.blogdata;
	
	function fetchAllBlog() 
	{
		console.log("Fetching all blogs Admin");
		$http.get("http://localhost:8181/SocialAppRest/getAllBlogs")

		.then(function(response) {
			$scope.blogdata = response.data;
			console.log("Blog fetched");
		});
	}	;
	
	fetchAllBlog();
	$scope.approveBlog=function(blogId) 
	{
		console.log("entered in approve blog");
		$http.get('http://localhost:8181/SocialAppRest/approveBlog/'+ blogId)
				.then(fetchAllBlog(), 
						function(response) 
		{
			console.log("Blog is approved");
		}
		)
	}
	
	
	$scope.rejectBlog=function(blogId)
	{
	$http.get('http://localhost:8181/SocialAppRest/rejectBlog/'+blogId)
	.then(fetchAllBlog(),function(response){
		console.log('blog rejected');
	})
	}
});