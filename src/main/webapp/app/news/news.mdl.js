(function() {
	'use strict';

	angular
		.module('posts', [
			'ui.router'
			])
		.config(configure);

		configure.$inject = ['$injectProvider', '$urlRouterProvider'];
		function configure($stateProvider, $urlRouterProvider) {
			$stateProvider
				.state('main.news', {
					url: 'posts',
					controller: 'PostsCtrl',
					templateUrl: 'app/news.view.html',
					data: {
						is_granted: ["ROLE_USER", "ROLE_ADMIN"]
					}
				})
				.state('main.newPost', {
					url: 'post/new',
					controller: 'PostNewCtrl',
					templateUrl: 'app/news/news.new.view.html',
					data: {
						is_granted: ["ROLE_ADMIN"]
					}
				});
		}
})();