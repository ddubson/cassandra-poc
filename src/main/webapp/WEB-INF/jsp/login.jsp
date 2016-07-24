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
<div class="container">
    <div tiles:fragment="content">
        <form name="f" th:action="@{/login}" method="post">
            <fieldset>
                <legend>Please Login</legend>
                <div th:if="${param.error}" class="alert alert-error">
                    Invalid username and password.
                </div>
                <div th:if="${param.logout}" class="alert alert-success">
                    You have been logged out.
                </div>
                <label for="username">E-Mail</label>
                <input type="text" id="username" name="username"/>
                <label for="password">Password</label>
                <input type="password" id="password" name="password"/>
                <div class="form-actions">
                    <button type="submit" class="btn">Log in</button>
                </div>
            </fieldset>
        </form>
    </div>


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
<script src="@{/bower_components/jquery/dist/jquery.min.js}"></script>
<script src="@{/bower_components/bootstrap/dist/bootstrap.min.js}"></script>
</body>
</html>