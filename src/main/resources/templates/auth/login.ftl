<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="cssBootstrap/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="css/AdminLTE.min.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="css/blue.css">
</head>
<body class="hold-transition login-page">
    <!--
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
    -->

    <div class="login-box">
        <div class="login-logo">
            <a href="/"><b>KeryB</b>PROD</a>
        </div>
        <!-- /.login-logo -->
        <div class="login-box-body">
            <p class="login-box-msg">Авторизуйтесь, пожалуйста</p>
            <#if error>
                <div class="alert alert-danger alert-dismissible">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                    <h4><i class="icon fa fa-ban"></i> Ошибка!</h4>
                    Неправильный email или пароль.
                </div>
            </#if>
            <form action="/login" method="post">
                <div class="form-group has-feedback">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <input type="email" class="form-control" id="email" name="email" placeholder="Email">
                    <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                </div>
                <div class="form-group has-feedback">
                    <input type="password" class="form-control" id="password" name="password" placeholder="Пароль">
                    <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                </div>
                <div class="row">
                    <div class="col-xs-8">
                        <div class="checkbox icheck">
                            <label>
                                <input type="checkbox"> Remember Me
                            </label>
                        </div>
                    </div>
                    <!-- /.col -->
                    <div class="col-xs-4">
                        <button type="submit" class="btn btn-primary btn-block btn-flat">Войти</button>
                    </div>
                    <!-- /.col -->
                </div>
            </form>

            <div class="social-auth-links text-center">
                <p>- OR -</p>
                <a href="/google/login" class="btn btn-block btn-social btn-google btn-flat"><i class="fa fa-google-plus"></i> Авторизоваться через
                    Google</a>
            </div>

            <a href="#">I forgot my password</a><br>

        </div>
        <!-- /.login-box-body -->
    </div>

    <!-- jQuery 2.2.3 -->
    <script src="plugins/jquery-3.1.1.min.js"></script>
    <!-- Bootstrap 3.3.6 -->
    <script src="js/bootstrap.min.js"></script>
    <!-- iCheck -->
    <script src="js/icheck.min.js"></script>
    <script>
        $(function () {
            $('input').iCheck({
                checkboxClass: 'icheckbox_square-blue',
                radioClass: 'iradio_square-blue',
                increaseArea: '20%' // optional
            });
        });
    </script>
</body>
</html>