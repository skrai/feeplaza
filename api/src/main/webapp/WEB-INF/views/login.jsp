<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
    <head>
    <meta charset="UTF-8">
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <title>FeePlaza - Login</title>
    </head>
    <body>
    <div>
        <form action="login"  method="post">
            <fieldset>
                <legend>Please Login</legend>
                <c:if test="${not empty error}">
                    <div>${error}</div>
                </c:if>
                <c:if test="${not empty message}">
                    <div>${message}</div>
                </c:if>
                <label for="username">Username</label>
                <input type="text" name="username"/><br/>
                <label for="password">Password</label>
                <input type="password" name="password"/><br/>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                <div>
                    <button type="submit" class="btn">Log in</button>
                </div>
            </fieldset>
        </form>
    </body>
</html>
