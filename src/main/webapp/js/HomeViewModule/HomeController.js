angular.module('HomeViewModule').controller('HomeController',
    function($scope, $http) {
       $scope.title = "Movies!";

       $http.get("/movies").success(function(response) {
             $scope.movies = response;
       });
});