myapp.controller("adminBlogController", function($scope, $http, $location) 
{
	$scope.blog={blogId:0,blogName:'',blogContent:'',createDate:'',likes:0,username:'',status:'A'};
	$scope.blogdata;

	
	function fetchAllApproveBlog() 
	{
		console.log("fetching all Admin Blogs");
		$http.get("http://localhost:8181/SocialAppRest/getAllBlogs")

		.then(function(response) {
			$scope.approveblogdata = response.data;
			console.log("data fetched from Admin blog");
		});

	};
	fetchAllApproveBlog();
	
	$scope.approveBlog=function(blogId)
	{
		$http.get('http://localhost:8181/SocialAppRest/approveBlog/'+blogId)
		.then(fetchAllBlog(),function(response)
		{
			console.log('Blog is Approved');
		}
		)
	}
	
	$scope.rejectBlog=function(blogId)
	{
		$http.get('http://localhost:8181/SocialAppRest/rejectBlog/'+blogId)
		.then(fetchAllBlog(),function(response)
		{
			console.log('Blog is Rejected');
		}
		)
	}
	
});