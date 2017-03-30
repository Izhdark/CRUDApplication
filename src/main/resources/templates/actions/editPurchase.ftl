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
        Форма редактирования данных покупки с карты
    </h3>
</div>
<div>
    <form action="/main/tables/purchase/updatePurchase" method="post" name="updatePurchase" id="form" ">

    <input type="text" value="${purchase.idPurchase}" name="idPurchase" hidden>
    <label style="padding-right: 115px" for="Date"> Дата покупки</label>
    <input type="date" value="${purchase.date}" id="Date" name="date"  required="required" size="50"> <br>
    <label style="padding-right: 82px" for="Cost">Цена покупки</label>
    <input type="text" id="Cost" value="${purchase.cost}" name="cost" required="required" size="50"><br>
    <label style="padding-right: 40px" for="StoreName">Название магазина</label>
    <input type="text" id="StoreName" name="store_name" value="${purchase.store_name}" required="required" size="50"><br>
    <label style="padding-right: 40px" for="LinkPerson">Покупка приналежит карте</label>
    <input id="LinkCards" value="${card.type} ${card.number}" disabled><br>
    <input type="text" value="${card.idCard}" name="getIdCard" hidden>
    <input type="submit" value="Занести в базу">
    </form>
    <form  action="/main/tables/cancel">
        <input type="submit" value="Отмена">
    </form>
</div>
</body>
</html>