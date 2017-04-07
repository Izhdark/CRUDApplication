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
    <link rel="stylesheet"href="/css/buttonFirst.css" >
    <meta charset="UTF-8">
</head>
<body style="background-color:#FFFAFA">
    <#if persons?size ==0>
        <div class="h3" align="center">
            <h3 >
                    В базе нет никаких данных
            </h3>
        </div>
        <div>
            <form action="/main/tables/person/add">
                <input type="submit" class="button" value="Добавить">
            </form>
        </div>
    <#else>
        <div>
            <table class="table">
                <thead>
                    <tr>
                        <th>№</th>
                        <th>Имя</th>
                        <th>Фамилия</th>
                        <th>Дата Рождения</th>
                        <th colspan="2">Функции обработки</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <#list persons as person>
                        <tr>
                            <td>${person.id}</td>
                            <td>${person.firstName}</td>
                            <td>${person.lastName}</td>
                            <td>${person.birthDate}</td>
                            <td>
                                <form action="/main/tables/person/edit">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                    <input type="image" src="/icons/edit.png" value="${person.id}" name="getIdToUpdate" alt="Добавить" >
                                </form>
                            </td>
                            <td>
                                <form action="/main/tables/person/delete" method="post">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                    <input type="image" src="/icons/delete.png" value="${person.id}"  name="getIdToDelete" alt="Удалить">
                                </form>
                            </td>
                            <td>
                                <div>
                                    <form action="/main/tables/person/creditCards">
                                        <input type="text" name="idCreditCard" value="${person.id}" hidden>
                                        <input class="button" type="submit"  value="Кредитные карты у данного человека">
                                    </form>
                                </div>
                            </td>
                        </tr>
                    </#list>
                </tbody>
            </table>
        </div>
        <br>
        <div>
            <form action="/main/tables/person/add"">
                <input class="button" type="submit" value="Добавить пользователя карты">
            </form>
        </div>
        <div>
            <form  action="/main/tables/person/cancelBack">
                <input  class="button" type="submit" value="Отмена">
            </form>
        </div>
    </#if>
</body>
</html>