
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset = UTF-8" %>
<html>
<body>
<table>
    <c:forEach var="employer" items="${employerList}" varStatus="status">
        <tr>
            <td><c:out value="${employer.id}"/></td>
            <td><c:out value="${employer.organization}"/></td>
            <td><c:out value="${employer.contacts}"/></td>
            <td><c:out value="${employer.verification}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>