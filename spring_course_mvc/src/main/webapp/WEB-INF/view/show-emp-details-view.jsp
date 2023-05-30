<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>

<h2>Dear Employee, you are WELCOME!</h2>
<br>
<br>
<br>

<%--Your name: ${param.employeeName}--%>
<%--Your name: ${nameAttribute}--%>
Your name: ${employee.name}
<br>
Your surname: ${employee.surname}
<br>
Your salary: ${employee.salary}
<br>
Department: ${employee.department}
<br>
Your car: ${employee.carBrand}
<br>
Your language(s):
<%--ul - unorderit list--%>
<ul>
    <c:forEach var="languag" items="${employee.languages}">
<%--        output array with forEach loop; var is temproary variable items outputting variables--%>
    <li>      ${languag}  </li>
    </c:forEach>
</ul>

Phone number: ${employee.phoneNumber}
<br>
Your email: ${employee.email}
</body>

</html>