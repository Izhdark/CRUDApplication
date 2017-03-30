<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <link rel="stylesheet" href="css/notes.css">
</head>
<body>
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
</body>
</html>