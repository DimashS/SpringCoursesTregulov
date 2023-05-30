<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<body>

<h2> Dear Employee, Please Enter your details</h2>
<br>
<br>

<form:form action="showDetails" modelAttribute="employee" method="post">
<%--    с помощью method=get будет отправляться в url--%>
<%--    с помощью method=post не будет отправлться в url, всю информацию в тело самого http request, in body--%>
    Name
    <form:input path="name"/>
    <form:errors path="name"/>
<%--    форма отображающая ошибку--%>
    <br><br>

    Surname
    <form:input path="surname"/>
    <form:errors path="surname"/>
    <br><br>

    Salary
    <form:input path="salary"/>
    <form:errors path="salary"/>
    <br><br>

    Departments
    <form:select path="department">
    <form:options items="${employee.departments}"></form:options>
    </form:select>

    <br><br>
    Which car do you want?
    <form:radiobuttons path="carBrand" items="${employee.carBrands}"/>

    <%--    BMW<form:radiobutton path="carBrand" value="BMW"/>--%>
    <%--    Audi<form:radiobutton path="carBrand" value="AUDI"/>--%>
    <%--    Mercedes<form:radiobutton path="carBrand" value="Mercedes-Benz"/>--%>
    <br><br>

    Any foreign languages?
    <form:checkboxes path="languages" items="${employee.languageList}"/>
    <%--    EN<form:checkbox path="languages" value="English"/>--%>
    <%--    FR<form:checkbox path="languages" value="French"/>--%>
    <%--    GER<form:checkbox path="languages" value="German"/>--%>
    <br><br>
    Phone Number
    <form:input path="phoneNumber"/>
    <form:errors path="phoneNumber"/>
    <br><br>
    Email
    <form:input path="email"/>
    <form:errors path="email"/>
    <br><br>
    <input type="submit" value="Button OKAY">


</form:form>
<%--<form action="showDetails" method="get">--%>
<%--&lt;%&ndash;    action => connection with button Submit => trancition to showDetails&ndash;%&gt;--%>
<%--    <input type="text" name="employeeName"--%>
<%--&lt;%&ndash;           name is consist name value &ndash;%&gt;--%>
<%--           placeholder="Write your name"/>--%>

<%--    <input type="submit">--%>

</form>

</body>

</html>