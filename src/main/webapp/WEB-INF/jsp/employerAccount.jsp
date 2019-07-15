
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
                <td>ID: </td>
                <td><c:out value="${employer.id}"/></td>
            </tr>
            <tr>
                <td>Organization: </td>
                <td><c:out value="${employer.organization}"/></td>
            </tr>
            <tr>
                <td>Contacts: </td>
                <td><c:out value="${employer.contacts}"/></td>
            </tr>
<%--            <tr>--%>
<%--                <td>Rating: </td>--%>
<%--                <td><c:out value="${employee.rating}"/></td>--%>
<%--            </tr>--%>
        </table>
    </div>
    <div>
        <form  method="post" action="/employer/{id}">
            <input type="hidden" name="command" value="vacancies">
            <input type="hidden" name="id" value="${employer.id}">
            <input type="submit" value="Vacancies" >
        </form>
    </div>
</body>
</html>
