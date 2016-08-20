(function () {
	'use strict';
	angular
		.module('main')
		.controller('PostCtrl', PostCtrl);

		function PostCtrl($scope, $state, postService, $location, ngDialog) {
				var sc = $scope;

				sc.gePosts = function() {
					function success(response) {
						sc.posts = response.data;
					}

					function failed(response) {
						sc.posts = response.data;
						console.log(response.status);
					}
					
				};

				sc.openCreatePost = function() {
					$state.go('main.newPost');
				}


		}
})