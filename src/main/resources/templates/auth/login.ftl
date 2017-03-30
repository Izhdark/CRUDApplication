<html lang="en">
<head>
    <meta charset="UTF-8">
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery-3.1.1.min.js"></script>
    <link rel="stylesheet" href="cssBootstrap/bootstrap.min.css">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <div class="panel panel-primary" style="margin:100px 200px 100px 200px ">

            <div class="panel-heading">Авторизуйтесь, пожалуйста</div>
            <div class="panel-body">
            <#if error>
                <div class="alert alert-dismissible alert-danger">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <strong>Ошибка</strong>Неправильный email или пароль.
                </div>
            </#if>
                <form name="login" method="post" action="/login">

                    <div class="input-group">
                        <span></i></span>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </div><br>
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input id="email" type="text" class="form-control" name="email" placeholder="Email">
                    </div><br>
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        <input id="password" type="password" class="form-control" name="password" placeholder="Password">
                    </div><br>
                    <div class="checkbox">
                        <label><input type="checkbox" name="remember-me">Запомнить меня</label>
                    </div>
                    <button type="submit" class="btn btn-primary">Авторизоваться</button><br>
                    <a href="#">Забыли пароль?</a><br>
                </form>
                <div>
                    <form action="/google/login" method="post">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <input type="image" src="/icons/google_signin.png" >
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>