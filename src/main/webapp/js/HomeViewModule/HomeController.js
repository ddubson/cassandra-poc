angular.module('HomeViewModule').controller('HomeController',
    function($scope, $http, $sce) {
       $scope.title = "FilmFox - find your film.";

       // Get all movie summaries
       $http.get("/movies").success(function(response) {
             console.log(response);
             response.forEach(function(movie) {
                movie['trailer-link'] = $sce.trustAsResourceUrl(movie['trailer-link']);
             });
             $scope.movies = response;
       });
});