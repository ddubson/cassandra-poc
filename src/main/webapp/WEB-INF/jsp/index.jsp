<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Sample homepage</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/app.css" rel="stylesheet">
    <link href="//fonts.googleapis.com/css?family=Roboto+Slab:100,300,400,700" rel="stylesheet" type="text/css">
</head>
<body ng-app="app">
<div class="container" ng-controller="MainController">
    <div class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <h1>{{ title }}</h1>
            </div>
            <button ng-click="go('/search')">Search</button>
        </div>
    </div>
    <div ng-view></div>
</div>
<script src="bower_components/angularjs/angular.min.js"></script>
<script src="bower_components/angular-animate/angular-animate.min.js"></script>
<script src="bower_components/angular-route/angular-route.min.js"></script>
<script src="js/app.js"></script>
<script src="js/MoviesModule/MainController.js"></script>
<script src="js/MoviesModule/ListMoviesController.js"></script>
<script src="js/MoviesModule/SearchMoviesController.js"></script>
</body>
</html>