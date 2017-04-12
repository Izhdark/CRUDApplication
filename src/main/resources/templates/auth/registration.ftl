<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
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
<body class="hold-transition register-page">
<!--
<div class="container">
    <div class="panel panel-primary" style="margin-top: 45px">
        <div class="panel-heading">Регистрация</div>
        <div class="panel-body">
            <h2>Форма регистрации</h2>
            <#if message>
                <div class="alert">
                    <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
                    На ваш email адрес <a href="${email}">${email}</a> было прислано письмо для завершения процесса регистрации!
                </div>
            </#if>
            <form method="post" name="Registration" action="/registration">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <div class="form-group" >
                    <label for="email">Email:</label>
                    <div class="input-group">
                        <span class="input-group-addon">@</span>
                        <input type="email" class="form-control" id="email" name="email" placeholder="Введите email">
                    </div>
                </div>
                <div class="form-group">
                    <label for="pwd">Пароль:</label>
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        <input type="password" class="form-control" id="pwd" name="password" placeholder="Введите пароль">
                    </div>
                </div>
                <div class="form-group">
                    <label for="cp">Подтвердите пароль:</label>
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        <input type="password" class="form-control" id="cp" name="confirmPassword" placeholder="Подтвердите пароль">
                    </div>
                </div>
                <div class="form-group">
                    <label for="name">Имя:</label>
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
                        <input type="text" class="form-control" id="name" name="firstName" placeholder="Введите имя">
                    </div>
                </div>
                <div class="form-group">
                    <label for="SecondName">Фамилия:</label>
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
                        <input type="text" class="form-control" id="SecondName" name="lastName" placeholder="Введите Фамилию">
                    </div>
                </div>
                <div class="checkbox">
                    <label><input type="checkbox">Запомнить меня</label>
                </div>
                <button type="submit" class="btn btn-default">Регистрация</button>
            </form>
        </div>
    </div>

</div>
-->

<div class="register-box">
    <div class="register-logo">
        <a href="/"><b>KeryB</b>PROD</a>
    </div>

    <div class="register-box-body">
        <p class="login-box-msg">Регистрация нового пользователя</p>
        <#if message>
            <div class="alert alert-success alert-dismissible">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                <h4><i class="icon fa fa-check"></i> Внимание!</h4>
                На ваш email адрес <a href="${email}">${email}</a> было прислано письмо для завершения процесса регистрации!
            </div>
        </#if>
        <form action="/registration" method="post">
            <div class="form-group has-feedback">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <input type="text" class="form-control" name="firstName" placeholder="Имя">
                <span class="glyphicon glyphicon-user form-control-feedback" ></span>
            </div>
            <div class="form-group has-feedback">
                <input type="email" class="form-control" name="email" placeholder="Email">
                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="password" class="form-control" name="password" placeholder="Пароль">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="password" class="form-control" placeholder="Повторите пароль">
                <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
            </div>
            <div class="row">
                <div class="col-xs-8">
                    <div class="checkbox icheck">
                        <label>
                            <input type="checkbox"> я соглашаюсь с правилами <a href="#">правила</a>
                        </label>
                    </div>
                </div>
                <!-- /.col -->
                <div class="col-xs-4">
                    <button type="submit" class="btn btn-primary btn-block btn-flat">Регистрация</button>
                </div>
                <!-- /.col -->
            </div>
        </form>

        <a href="/login" class="text-center">Я уже зарегистрирован</a>
    </div>
    <!-- /.form-box -->
</div>
<!-- /.register-box -->
<!-- jQuery 2.2.3 -->
<script src="../../plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="../../bootstrap/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="../../plugins/iCheck/icheck.min.js"></script>
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