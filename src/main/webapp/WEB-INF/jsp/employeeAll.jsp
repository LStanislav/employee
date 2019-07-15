
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset = UTF-8" %>
<html>
<body>
<table>
    <c:forEach var="employee" items="${employeeList}" varStatus="status">
        <tr>
            <td><c:out value="${employee.name}"/></td>
            <td><c:out value="${employee.surname}"/></td>
            <td><c:out value="${employee.birthDate}"/></td>
            <td><c:out value="${employee.rating}"/></td>
            <td><c:out value="${employee.country.name}"/></td>

        </tr>
    </c:forEach>
</table>
</body>
</html>