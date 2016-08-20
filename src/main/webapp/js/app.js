'use strict';

var softDealApp = angular.module('softDealApp', ['ngRoute']);

softDealApp.config(['$routeProvider', '$locationProvider', function($routeProvide, $locationProvider){
	$routeProvide
		.when('/', {
			templateUrl:'template/home.html',
			controller:'HomeController'
		})
		.when('/news', {
			templateUrl:'template/news.html',
			controller:'NewsController'
		}) 
		.when('/contact', {
			templateUrl:'template/contact.html',
			controller:'ContactController'
		})
		.when('/login', {
			templateUrl:'template/login.html',
			controller:'LoginController'
		})
		.otherwise({
			redirectTo: "/"
		});
	}]);

softDealApp.controller('HomeController', ['$scope', '$http', '$location', function($scope, $http, $location) {

}]);

softDealApp.controller('NewsController', ['$scope', '$http', '$location', function($scope, $http, $location) {
     $http.get('/comment').success(function(data, status, headers, config) {
     	$scope.news = data;
     });
}]);

softDealApp.controller('ContactController', ['$scope', '$http', '$location', function($scope, $http, $location) {

}]);

softDealApp.controller('LoginController', ['$scope', '$http', '$location', function($scope, $http, $location) {

}]);

