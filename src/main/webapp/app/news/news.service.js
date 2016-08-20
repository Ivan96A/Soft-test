(function () {
	'use strict';

	angular
		.module('main')
		.service('PostService', function($http) {
			var ulrBase = '/post';

			this.getAll = function() {
				return $http.get(urlBase);
			};

			this.create = function(post) {
				return $http.post(urlBase + post);
			}
		});
})();