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
        Форма добавления покупк с карты
    </h3>
</div>
    <div>
        <form action="/main/tables/purchase/addPurchase" method="post" name="Purchase" id="form"">
        <label style="padding-right: 50px" for="Date">Дата покупки</label>
        <input type="date" id="Date" name="date" required="required" size="50"> <br>
        <label style="padding-right: 80px" for="Cost">Цена покупки</label>
        <input type="text" id="Cost" name="cost" required="required" size="50"><br>
        <label style="padding-right: 100px" for="storeName">Название магазина </label>
        <input type="text" id="storeName" name="store_name" required="required" size="50"><br>
        <label style="padding-right: 40px" for="LinkPurchase">С какой карты была сделана покупка</label>
            <select name="selected" id="LinkPurchase" form="form">
                <option>Выберете с какой карты совершалась покупка</option>
            <#list creditCards as creditCard>
                <option  value="${creditCard.idCard}"> ${creditCard.type} ${creditCard.number}</option>
            </#list>
            </select><br>
        <input type="submit" value="Занести в базу">
        </form>
        <form action="/main/tables/purchase/add/cancel">
            <input type="submit" value="Отмена">
        </form>
    </div>
</body>
</html>