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
        Форма добавления владельца банка
    </h3>
</div>
    <div>
        <form action="/main/tables/bank/addBank" method="post" name="bank" ">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <label style="padding-right: 50px" for="Name">Название банка</label>
        <input type="text" id="Name" name="name" required="required" size="50"> <br>
            <label style="padding-right: 80px" for="Site">Сайт банка</label>
        <input type="url" id="Site" name="site" required="required" size="50"><br>
            <label style="padding-right: 100px" for="Adress">Адресс </label>
        <input type="text" id="Adress" name="adress" required="required" size="50"><br>
            <label style="padding-right: 25px" for="time" >Время выдачи карты</label>
        <input type="time" id="time" name="term_of_issue_of_bank_cards">
        <input type="submit" value="Занести в базу">
        </form>
        <form action="/main/tables/bank/cancel">
            <input type="submit" value="Отмена">
        </form>
    </div>
</body>
</html>