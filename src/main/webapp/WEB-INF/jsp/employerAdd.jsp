<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset = UTF-8" %>
<html>
    <body>
        <form method="post" action="/employer/add" modelAttribute="employer">
            <p><input type="text" name="organization" placeholder="Organization"></p>
            <p><input type="text" name="contacts" placeholder="Contacts"></p>
            <p><input type="submit" value="Add"></p>
        </form>
    </body>
</html>