<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/css/buttonFirst.css">

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery-3.1.1.min.js"></script>
    <link rel="stylesheet" href="css/navbar.css">
    <link rel="stylesheet" href="cssBootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="css/notes.css">
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">KeryB</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="/main/tables">Показать таблицы</a></li>
            <li><a href="/queries">Выполнить запросы</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">

            <li><a href="/registration"><span class="glyphicon glyphicon-user"></span>Регистрация</a></li>
            <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Авторизация</a>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                   aria-expanded="false">${account}<span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="#">хз</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-pencil"></span>Профиль</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-flash"></span>Выполнить задачу</a></li>
                    <li role="separator" class="divider"></li>
                    <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span>Выход</a></li>
                </ul>
            </li>
        </ul>
        <div class="dropdown">
            <button class="dropbtn">Dropdown</button>
            <div class="dropdown-content">
                <a href="#">Link 1</a>
                <a href="#">Link 2</a>
                <a href="#">Link 3</a>
            </div>
        </div>
    </div>
</nav>

<div class="dropdown">
    <button id="dLabel" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        Dropdown trigger
        <span class="caret"></span>
    </button>
</div>
</body>
</html>