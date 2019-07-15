<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html; charset = UTF-8" %>
<html>
    <body>
        <form method="post" action="/employee/{id}/requests/delete" >
            <p><input type="text" name="req_id" placeholder="Id"></p>
            <p><input type="hidden" name="id" value=${employeeId}></p>
            <p><input type="submit" value="Delete"></p>
        </form>
    </body>
</html>