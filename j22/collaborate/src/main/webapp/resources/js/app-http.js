/**
 * 
 */

var myApp = angular.module('myApp', []);


myApp.controller('MyWebController', function($scope, $http){

	
	$scope.ButtonClick = function () {
       
    
	
	
	
    $http.get('http://localhost:9000/furniturehub/service/product/100')
		.then(function (response){
			$scope.product = response.data; 
			
			console.log("status:" + response.status);
		});
	}
});   
