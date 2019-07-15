<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset = UTF-8" %>
<html>
<body>
    <h2>Vacancies</h2>
    <table border="1">
        <tr>
            <td>Id</td>
            <td>Country</td>
            <td>Profession</td>
            <td>Min</td>
            <td>Max</td>
            <td>house</td>
        </tr>
        <c:forEach var="vacancy" items="${vacancies}" varStatus="status">
        <tr>
            <td><c:out value="${vacancy.id}"/></td>
            <td><c:out value="${vacancy.country.name}"/></td>
            <td><c:out value="${vacancy.profession.name}"/></td>
            <td><c:out value="${vacancy.minSalary}"/></td>
            <td><c:out value="${vacancy.maxSalary}"/></td>
            <td><c:out value="${vacancy.house}"/></td>
        </tr>
        </c:forEach>
    </table>
    <form method="post" action="/employer/{id}/vacancies" >
        <input type="hidden" name="command" value="add">
        <input type="hidden" name="id" value=${employerId}>
        <input type="submit" value="Add">
    </form>
    <form method="post" action="/employer/{id}/vacancies" >
        <input type="hidden" name="command" value="delete">
        <input type="hidden" name="id" value=${employerId}>
        <input type="submit" value="Delete">
    </form>
    <form method="post" action="/employer/{id}/vacancies" >
        <input type="hidden" name="command" value="find_requests">
        <input type="hidden" name="id" value=${employerId}>
        <input type="submit" value="Find Requests">
    </form>

</body>
</html>