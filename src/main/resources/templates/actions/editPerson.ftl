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
            Форма редактирования данных для пользователя картой с Id=${personData.id}
        </h3>
    </div>
    <div>
        <form action="/main/tables/updatePerson" method="post" name="updatePersons" ">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="text" value="${personData.id}" name="id" hidden>
            <label style="padding-right: 115px" for="name"> Имя</label>
        <input type="text" value="${personData.firstName}" id="name" name="firstName"  required="required" size="50"> <br>
            <label style="padding-right: 82px" for="lastName">Фамилия</label>
        <input type="text" id="lastName" value="${personData.lastName}" name="lastName" required="required" size="50"><br>
            <label style="padding-right: 40px" for="date">Дата Рождения </label>
        <input type="date" id="date" name="birthDate" value="${personData.birthDate}" required="required" size="50"><br>
        <input type="submit" value="Занести в базу">
        </form>
        <form  action="/main/tables/cancel">
            <input type="submit" value="Отмена">
        </form>
    </div>
</body>
</html>