
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ page contentType="text/html; charset = UTF-8" %>--%>
<%--<html>--%>
<%--<head>--%>
    <%--<title></title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<img src="c:/Users/staliah/Downloads/dog.png" />--%>
<%--</body>--%>
<%--</html>--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset = UTF-8" %>
<html>
<body>

    <div>
        <table border="2">
            <tr>
                <%--${pageContext.request.contextPath}--%>
                <td><img src="/img/dog.png"/></td>
                    <%--<c:url value="/home" var="homeUrl" />--%>
                <%--<c: url value="/files/korali.jpg"/>--%>
                <%--<c: url value = "/file1.jsp" />--%>
            <%--<img src='<c: url value="c:/Users/staliah/Downloads/dog.png">' />--%>

            </tr>
            <tr>
                <td>Name: </td>
                <td><c:out value="${employee.name}"/></td>
            </tr>
            <tr>
                <td>Surname: </td>
                <td><c:out value="${employee.surname}"/></td>
            </tr>
            <tr>
                <td>BirthDate: </td>
                <td><c:out value="${employee.birthDate}"/></td>
            </tr>
            <tr>
                <td>Rating: </td>
                <td><c:out value="${employee.rating}"/></td>
            </tr>
            <tr>
                <td>Country: </td>
                <td><c:out value="${employee.country.name}"/></td>
            </tr>
        </table>
    </div>
    <div>
        <form  method="post" action="/employee/{id}">
            <input type="hidden" name="command" value="requests">
            <input type="hidden" name="id" value="${employee.id}">
            <input type="submit" value="Requests" >
        </form>
    </div>
</body>
</html>
