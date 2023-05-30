<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<body>

<h2>All Employees</h2>
<br>
<table>
    <tr>
        <%--        table header - шабка таблицы--%>
        <th>Name</th>
        <th>Surname</th>
        <th>Department</th>
        <th>Salary</th>
        <th>Operations</tr>
            <%--        table row - строка таблица --%>
    <%--     var - temproary variable items - our list of Employees --%>
    <c:forEach var="emps" items="${allEmployees}">
        <%--        цикл foreach--%>
        <c:url var="updateButton" value="/updateInfo">
            <c:param name="employeeId" value="${emps.id}"/>
        </c:url>

        <c:url var="deleteButton" value="/deleteEmployee">
            <c:param name="employeeId" value="${emps.id}"/>
        </c:url>
        <tr>
                <%--  (table data)          td - ячейка таблицы--%>
            <td>${emps.name}</td>
            <td>${emps.surname}</td>
            <td>${emps.department}</td>
            <td>${emps.salary}</td>
            <td>
                <input type="button" value="Update"
                onclick="window.location.href='${updateButton}'"/>
<%--                будет переход к верхней кнопке, а та отправит в метод, в кнопке есть айди --%>
                <input type="button" value="Delete"
                       onclick="window.location.href='${deleteButton}'"/>
            </td>
        </tr>
    </c:forEach>


</table>

<br><br>
<input type="button" value="add employee"
       onclick="window.location.href='addNewEmployees'"/>

</body>

</html>