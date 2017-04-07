<html lang="en" xmlns:th="http://www.thymeleaf.org" xmlns="http://www.w3.org/1999/html">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style>
        h3 {
            background: #DCDCDC;
            color: #008B8B;
            padding: 2px;
        }
    </style>
</head>
<body style="background-color:#FFFAFA">
    <div>
        <h3>
            Форма добавления владельца банковской карты
        </h3>
    </div>
    <div>
        <form action="/main/tables/dataPerson" method="post" name="personId"  ">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <label style="padding-right: 115px" for="name"> Имя</label>
                <input type="text" id="name" name="firstName" required="required" size="50"> <br>
            <label style="padding-right: 82px" for="lastName">Фамилия</label>
                <input type="text" id="lastName" name="lastName" required="required" size="50"><br>
            <label style="padding-right: 40px" for="date">Дата Рождения </label>
                <input type="date" id="date" name="birthDate" required="required" size="50"><br>
            <input type="submit" value="Занести в базу">
        </form>
        <form action="/main/tables/person/cancel">
            <input type="submit" value="Отмена">
        </form>
    </div>
</body>
</html>