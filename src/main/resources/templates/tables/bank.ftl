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
    <link rel="stylesheet"href="/css/buttonFirst.css" >
</head>
<body style="background-color:#FFFAFA">
    <div>
    <#if banks?size ==0>
        <div class="h3" align="center">
            <h3 >
                В базе нет никаких данных
            </h3>
        </div>
        <div>
            <form action="/main/tables/bank/add">
                <input type="submit" class="button" value="Добавить">
            </form>
        </div>
    <#else>
        <div>
            <table class="table">
                <thead>
                <tr>
                    <th>№</th>
                    <th>Название банка</th>
                    <th>сайт банка</th>
                    <th>Адресс банка</th>
                    <th>Время выдачи карты</th>
                    <th colspan="1">Функции обработки</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                    <#list banks as bank>
                    <tr>
                        <td>${bank.id}</td>
                        <td>${bank.name}</td>
                        <td><a href="${bank.site}">${bank.site}</a></td>
                        <td>${bank.adress}</td>
                        <td>${bank.term_of_issue_of_bank_cards}</td>
                        <td>
                            <form action="/main/tables/bank/edit">
                                <input type="image" src="/icons/edit.png"  name="edit" value="${bank.id}" alt="Добавить" >
                            </form>
                        </td>
                        <td>
                            <form action="/main/tables/bank/delete" method="post">
                                <input type="image" src="/icons/delete.png" name="getIdBank" value="${bank.id}" alt="Удалить">
                            </form>
                        </td>
                    </tr>
                    </#list>
                </tbody>
            </table>
        </div>
        <div>
            <form action="/main/tables/bank/add">
                <input type="submit" class="button" value="Добавить пользователя карты">
            </form>
        </div>
        <div>
            <form action="/main/tables/cancel">
                <input type="submit" class="button" value="Отмена">
            </form>
        </div>
    </#if>
    </div>
</body>
</html>