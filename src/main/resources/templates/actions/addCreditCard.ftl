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
        Форма добавления банковской карты
    </h3>
</div>
    <div>
        <form action="/main/tables/creditCard/addData" method="post" name="creditCard" id="form" ">
        <label style="padding-right: 80px" for="Type"> Тип карты</label>
        <input type="text" id="Type" name="type" required="required" size="50"> <br>
        <label style="padding-right: 60px" for="numberCard">Номер карты</label>
        <input type="text" id="numberCard" name="number" required="required" size="50"><br>
        <label style="padding-right: 40px" for="Money">Деньги на карте </label>
        <input type="text" id="Money" name="money" required="required" size="50"><br>
        <label style="padding-right: 40px" for="LinkPerson">Привязать карту с человеком</label>
            <select name="selected" id="LinkPerson" form="form">
                <option selected disabled>Выберете человека из списка</option>
            <#list persons as person>
                <option  value="${person.id}"> ${person.firstName} ${person.lastName}</option>
            </#list>
            </select><br>
        <label style="padding-right: 40px" for="LinkBank">Привязать карту с человеком</label>
        <select name="selectedBank" id="LinkBank" form="form">
            <option selected disabled>Выберете банк из списка</option>
        <#list banks as bank>
            <option  value="${bank.id}"> ${bank.name}</option>
        </#list>
        </select><br>

        <input type="submit" value="Занести в базу">
        </form>
        <form action="/main/tables/creditCard/cancel">
            <input type="submit" value="Отмена">
        </form>
    </div>
</body>
</html>