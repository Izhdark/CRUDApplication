<html lang="en">
<head>
    <style>
        h3 {
            background: #DCDCDC;
            color: #FF0000;
            padding: 2px;
        }
    </style>
    <link rel="stylesheet" href="/css/tables.css">
    <link rel="stylesheet" href="/css/buttonFirst.css" >
    <meta charset="UTF-8">
</head>
<body style="background-color:#FFFAFA">
    <div>
        <#if person?size==0>
            <h3>
                Прежде чем работать с банковскими картами, сначала заполните базу с людьми.
            </h3>
        <#elseif bank?size==0>
            <h3>
                Прежде чем работать с банковскими картами, сначала заполните базу с банками.
            </h3>
        <#elseif creditCards?size==0>
            <h3 >
                В базе нет никаких данных
            </h3>
            <form action="/main/tables/creditCard/add">
                <input type="submit" class="button" value="Добавить кредитную карту">
            </form>
        <#else>
            <div>
                <table class="table">
                    <thead>
                    <tr>
                        <th>№</th>
                        <th>Тип карты</th>
                        <th>Номер</th>
                        <th>Количество средств</th>
                        <th colspan="1">Функции обработки</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                        <#list creditCards as creditCard>
                        <tr>
                            <td>${creditCard.idCard}</td>
                            <td>${creditCard.type}</td>
                            <td>${creditCard.number}</td>
                            <td>${creditCard.money}</td>
                            <td>
                                <form action="/main/tables/creditCard/edit" method="post">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                    <input type="image" src="/icons/edit.png" name="idEdit" value="${creditCard.idCard}" alt="Добавить" >
                                </form>
                            </td>
                            <td>
                                <form action="/main/tables/creditCard/delete" method="post">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                    <input type="image" src="/icons/delete.png" name="idDelete" value="${creditCard.idCard}" alt="Удалить">
                                </form>
                            </td>
                        </tr>
                        </#list>
                    </tbody>
                </table>
            </div>
            <div>
                <form action="/main/tables/creditCard/add">
                    <input type="submit" class="button" value="Добавить кредитную карту">
                </form>
            </div>
            <div>
                <form action="/main/tables/creditCard/cancelCreditCard">
                    <input type="submit" class="button" value="Отмена">
                </form>
            </div>
        </#if>
    </div>
</body>
</html>