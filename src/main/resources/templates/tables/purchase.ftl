<html lang="en">
<head>
    <meta charset="UTF-8">
    <style>
        h3 {
            background: #DCDCDC;
            color: #FF0000;
            padding: 2px;
        }
    </style>
    <link rel="stylesheet" href="/css/tables.css">
    <link rel="stylesheet" href="/css/buttonFirst.css" >
</head>
<body style="background-color:#FFFAFA">
<div>
<#if purchases?size ==0>
    <div class="h3" align="center">
        <h3 >
            В базе нет никаких данных
        </h3>
    </div>
    <div>
        <form action="/main/tables/purchase/add">
            <input type="submit" class="button"value="Добавить">
        </form>
    </div>
<#else>
    <div>
        <table class="table">
            <thead>
            <tr>
                <th>№</th>
                <th>Дата покупки</th>
                <th>Цена покупки</th>
                <th>Название магазина</th>
                <th colspan="1">Функции обработки</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
                <#list purchases as purchase>
                <tr>
                    <td>${purchase.idPurchase}</td>
                    <td>${purchase.date}</td>
                    <td>${purchase.cost}</td>
                    <td>${purchase.store_name}</td>
                    <td>
                        <form action="/main/tables/purchase/edit" method="post">
                            <input type="image" src="/icons/edit.png"  name="edit" value="${purchase.idPurchase}" alt="Добавить" >
                        </form>
                    </td>
                    <td>
                        <form action="/main/tables/purchase/delete" method="post">
                            <input type="image" src="/icons/delete.png" name="getIdPurchase" value="${purchase.idPurchase}" alt="Удалить">
                        </form>
                    </td>
                </tr>
                </#list>
            </tbody>
        </table>
    </div>
    <div>
        <form action="/main/tables/purchase/add">
            <input class="button" type="submit" value="Добавить покупку">
        </form>
    </div>
    <div>
        <form action="/main/purchase/cancel">
            <input  class="button" type="submit" value="Отмена">
        </form>
    </div>
</#if>
</div>
</body>
</html>