<html lang="en">
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
        Форма редактирования банковской карты с Id=${creditCards.idCard}
    </h3>
</div>
    <div>
        <form action="/main/tables/creditCard/editData" method="post" name="editCreditCard" id="form" ">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input name="idCard" value="${creditCards.idCard}" hidden>
            <label style="padding-right: 80px" for="Type"> Тип карты</label>
            <input type="text" id="Type" value="${creditCards.type}" name="type" required="required" size="50"><br>
            <label style="padding-right: 60px" for="numberCard">Номер карты</label>
            <input type="text" id="numberCard" value="${creditCards.number}" name="number" required="required" size="50"><br>
            <label style="padding-right: 40px" for="Money">Деньги на карте </label>
            <input type="text" id="Money" value="${creditCards.money}" name="money" required="required" size="50"><br>
            <label style="padding-right: 40px" for="LinkPerson">Карта приналежит</label>
            <input id="LinkPerson" value="${chosenPerson.firstName} ${chosenPerson.lastName}" disabled><br>
            <label style="padding-right: 40px" for="LinkBank">Карта выдана банком </label>
            <input id="LinkBank" value="${chosenBank.name}" disabled><br>
            <input type="text" value="${chosenPerson.id}" name="getIdPerson" hidden>
            <input type="text" value="${chosenBank.id}" name="getIdBank" hidden>
            <input type="submit" value="Занести в базу">
        </form>

        <form action="/main/tables/creditCard/cancel">
            <input type="submit" value="Отмена">
        </form>
    </div>
</body>
</html>