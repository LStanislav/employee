<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html; charset = UTF-8" %>
<html>
    <body>
        <form method="post" action="" >
            <p><input type="text" name="vac_id" placeholder="Id"></p>
            <p><input type="hidden" name="id" value="${employerId}"></p>
            <p><input type="submit" value="Find"></p>
        </form>
    </body>
</html>