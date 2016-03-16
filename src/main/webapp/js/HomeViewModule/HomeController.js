angular.module('HomeViewModule').controller('HomeController',
    function($scope, $http) {
       $scope.title = "Movies!";

       // Get all movie summaries
       $http.get("/movies").success(function(response) {
             $scope.movies = response;
       });

       // Get movie by ID
       $http.get("/movies/97719c50-e797-11e3-90ce-5f98e903bf02").success(function(response) {
            $scope.movieDetails = response;
       });
});