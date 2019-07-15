<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html; charset = UTF-8" %>
<html>
    <body>
        <form method="post" action="/employer/{id}/vacancies/add" modelAttributte="vacancy">
            <p><input type="text" name="country.id" placeholder="Country"></p>
            <p><input type="text" name="profession.id" placeholder="Profession"></p>
            <p><input type="text" name="minSalary" placeholder="Min Salary"></p>
            <p><input type="text" name="maxSalary" placeholder="Max Salary"></p>
            <p> House <input type="radio" name="house" placeholder="house"></p>
            <p><input type="hidden" name="employerId" value=${employerId}></p>
            <p><input type="submit" value="Add"></p>
        </form>
    </body>
</html>