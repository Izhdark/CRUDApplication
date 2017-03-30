<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body style="background-color:#FFFAFA">
<div>
<#if cards?size==0>
    <h3 >
        В базе нет никаких данных
    </h3>
<#else>
    <div>
        <table>
            <thead>
            <tr>
                <th>№</th>
                <th>Тип карты</th>
                <th>Номер</th>
                <th>Количество средств</th>
            </tr>
            </thead>
            <tbody>
                <#list cards as card>
                <tr>
                    <td>${card.idCard}</td>
                    <td>${card.type}</td>
                    <td>${card.number}</td>
                    <td>${card.money}</td>
                </tr>
                </#list>
            </tbody>
        </table>
    </div>
    <div>
        <form action="/main/tables/showCreditCard/cancel">
            <input type="submit" value="Отмена">
        </form>
    </div>
</#if>
</div>
</body>
</html>