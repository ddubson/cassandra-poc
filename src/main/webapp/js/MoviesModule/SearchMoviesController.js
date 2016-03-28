angular.module('MoviesModule').controller('SearchMoviesController',
function($scope, $location, $http) {
    $scope.search = function() {
        if($scope.movieToFind) {
            $http.post("/movies/search", $scope.movieToFind).success(function(response) {
                $scope.movieResults = response;
            });
        }
    }
});