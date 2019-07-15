<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset = UTF-8" %>
<html>
<body>
    <h2>Requests</h2>
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
    <form method="post" action="/employee/{id}/requests" >
        <input type="hidden" name="command" value="add">
        <input type="hidden" name="id" value=${employeeId}>
        <input type="submit" value="Add">
    </form>
    <form method="post" action="/employee/{id}/requests" >
        <input type="hidden" name="command" value="delete">
        <input type="hidden" name="id" value=${employeeId}>
        <input type="submit" value="Delete">
    </form>
    <form method="post" action="/employee/{id}/requests" >
        <input type="hidden" name="command" value="find_vacancies">
        <input type="hidden" name="id" value=${employeeId}>
        <input type="submit" value="Find vacancies">
    </form>
<%--    <h3>Vacancies</h3>--%>
<%--    <table border="1">--%>
<%--        <tr>--%>
<%--            <td>Id</td>--%>
<%--            <td>Country</td>--%>
<%--            <td>Profession</td>--%>
<%--            <td>Min</td>--%>
<%--            <td>Max</td>--%>
<%--            <td>house</td>--%>
<%--        </tr>--%>
<%--        <c:forEach var="vacancy" items="${vacancies}" varStatus="status">--%>
<%--        <tr>--%>
<%--            <td><c:out value="${vacancy.id}"/></td>--%>
<%--            <td><c:out value="${vacancy.country.name}"/></td>--%>
<%--            <td><c:out value="${vacancy.profession.name}"/></td>--%>
<%--            <td><c:out value="${vacancy.minSalary}"/></td>--%>
<%--            <td><c:out value="${vacancy.maxSalary}"/></td>--%>
<%--            <td><c:out value="${vacancy.house}"/></td>--%>
<%--        </tr>--%>
<%--        </c:forEach>--%>
<%--    </table>--%>
</body>
</html>