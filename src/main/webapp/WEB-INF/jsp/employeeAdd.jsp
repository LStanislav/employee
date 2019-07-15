<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html; charset = UTF-8" %>
<html>
    <body>
        <form method="post" action="/employee/add" modelAttribute="employee">
            <p><input type="text" name="name" placeholder="Name"></p>
            <p><input type="text" name="surname" placeholder="Surname"></p>
            <p><input type="text" name="birthDate" placeholder="Birthday"></p>
            <%--<input type="text"  name = "birthDate" />--%>
            <p><input type="text" name="country.id" placeholder="Country"></p>
            <p><input type="text" name="profession.id" placeholder="Profession"></p>
            <p><input type="submit" value="Add"></p>
        </form>
    </body>
</html>