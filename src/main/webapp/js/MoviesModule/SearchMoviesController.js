angular.module('MoviesModule').controller('SearchMoviesController',
function($scope, $location, $http) {
    $scope.search = function() {
        if($scope.movieToFind) {
            $http.post("/movies/search", $scope.movieToFind)
            .success(function(response) {
                $scope.movieResults = response;
            })
            .error(function(data, status, headers, config) {
                console.log("status: " + status);
                $scope.noResult = data;
            });
        }
    }
});