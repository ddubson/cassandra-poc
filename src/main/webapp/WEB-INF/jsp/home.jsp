<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>

    <title>FilmFox!</title>

    <!-- Custom CSS -->
    <link th:href="@{/css/3-col-portfolio.css}" rel="stylesheet"/>
    <link th:href="@{/bower_components/bootstrap/dist/css/bootstrap.min.css}" rel="stylesheet"/>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
<!-- Navigation -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="#">FilmFox</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li>
                    <a th:href="@{/logout}">Sign Out</a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>

<!-- Page Content -->
<div class="container">
    <!-- Page Header -->
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Popular Movies
                <small>old and new</small>
            </h1>
        </div>
    </div>
    <!-- /.row -->

    <!-- Movies Row -->
    <div class="row" th:each="movie : ${movies}">
        <div class="col-md-4 portfolio-item">
            <h3>
                <h2 th:text="${movie.name}+' ('+${movie.yearReleased}+')'">Movie Name</h2>
            </h3>
            <div class="embed-responsive embed-responsive-16by9">
                <iframe class="embed-responsive-item"
                        width="330"
                        height="220"
                        th:src="${movie.trailerLink}"
                        allowfullscreen="allowfullscreen">
                </iframe>
            </div>
        </div>
    </div>
    <!-- /.row -->
    <hr />

    <!-- Pagination -->
    <div class="row text-center">
        <div class="col-lg-12">
            <ul class="pagination">
                <li>
                    <a href="#">&laquo;</a>
                </li>
                <li class="active">
                    <a href="#">1</a>
                </li>
                <li>
                    <a href="#">&raquo;</a>
                </li>
            </ul>
        </div>
    </div>
    <!-- /.row -->

    <hr />

    <!-- Footer -->
    <footer>
        <div class="row">
            <div class="col-lg-12">
                <p>Copyright &copy; #FilmFox 2016</p>
            </div>
        </div>
        <!-- /.row -->
    </footer>

</div>
<!-- /.container -->

<script src="@{/bower_components/jquery/dist/jquery.min.js}"></script>
<script src="@{/bower_components/bootstrap/dist/bootstrap.min.js}"></script>
</body>
</html>