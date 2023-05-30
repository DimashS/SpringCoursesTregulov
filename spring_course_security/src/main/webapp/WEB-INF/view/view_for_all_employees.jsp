<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<body>

<h3>Information for all Employees</h3>
<br><br>


<security:authorize access="hasRole('HR')">
<%--    авторизуем роль которые будут видеть данную кнопку--%>
<input type="button" value="Salary"
       onclick="window.location.href='hr_info'">
only for hr staff
</security:authorize>

<br><br>

<security:authorize access="hasRole('MANAGER')">
<input type="button" value="Performance"
       onclick="window.location.href='manager_info'">
only for Managers
</security:authorize>
</body>
</html>