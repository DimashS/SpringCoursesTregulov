<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>


<h2>Employee info</h2>
<br>
<form:form action="saveEmployee" modelAttribute="employee">
<%--    model attribute мы получаем с данными введенными из view в MyController --%>
    <form:hidden path="id"/>
    Name <form:input path="name"/>
    <br><br>
    Surname <form:input path="surname"/>
    <br><br>
    Department <form:input path="department"/>
    <br><br>
    Sal <form:input path="salary"/>
    <br><br>
    <input type="submit" value="OKAY">

</form:form>

</body>
</html>