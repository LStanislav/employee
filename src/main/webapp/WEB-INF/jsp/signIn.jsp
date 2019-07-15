<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <body>
    <%--<form  method="post" action="employee/{id}" modelAttribute="employee">--%>
        <%--<input type="text" name="id" placeholder="Id">--%>
        <%--<input type="submit" value="Sign in" >--%>
    <%--</form>--%>
    <form  method="post" action="/sign_in">
        <input type="hidden" name="command"  value="employee">
        <input type="text" name="id" placeholder="Employee id">
        <input type="submit" value="Sign in" >
    </form>
    <form method="post" action="/sign_in" >
        <input type="hidden" name="command" value="employer">
        <input type="text" name="id" placeholder="Employer id">
        <input type="submit" value="Sign in">
    </form>
    </body>
</html>