angular.module('MoviesModule').controller('MainController',
function($scope, $location) {
    $scope.go = function ( hash ) {
      $location.path( hash );
    };

    $scope.title = "FilmFox - find your film.";
});