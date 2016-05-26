angular.module('MoviesModule').controller('ListMoviesController',
    function($scope, $http, $sce) {
       // Get all movie summaries
       $http.get("/movies").success(function(response) {
             response.forEach(function(movie) {
                movie['trailer-link'] = $sce.trustAsResourceUrl(movie['trailer-link']);
             });
             $scope.movies = response;
       });
});