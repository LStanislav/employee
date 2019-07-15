<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset = UTF-8" %>
<html>
<body>
    <h2>Vacancy</h2>
    <table border="1">
        <tr>
            <td>Id</td>
            <td>Country</td>
            <td>Profession</td>
            <td>Min</td>
            <td>Max</td>
            <td>house</td>
        </tr>
        <tr>
            <td><c:out value="${vacancy.id}"/></td>
            <td><c:out value="${vacancy.country.name}"/></td>
            <td><c:out value="${vacancy.profession.name}"/></td>
            <td><c:out value="${vacancy.minSalary}"/></td>
            <td><c:out value="${vacancy.maxSalary}"/></td>
            <td><c:out value="${vacancy.house}"/></td>
        </tr>
    </table>
    <h3>Requests</h3>
    <table border="1">
        <tr>
            <td>Id</td>
            <td>Country</td>
            <td>Profession</td>
            <td>Min</td>
            <td>Max</td>
            <td>house</td>
        </tr>
        <c:forEach var="request" items="${requests}" varStatus="status">
        <tr>
            <td><c:out value="${request.id}"/></td>
            <td><c:out value="${request.country.name}"/></td>
            <td><c:out value="${request.profession.name}"/></td>
            <td><c:out value="${request.minSalary}"/></td>
            <td><c:out value="${request.maxSalary}"/></td>
            <td><c:out value="${request.house}"/></td>
        </tr>
        </c:forEach>
    </table>
</body>
</html>