<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
    <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <title>FeePlaza - Login</title>
   	<base href="/home">
  	<link rel="stylesheet" href="styles.css">

    <!-- 1. Load libraries -->
    <!-- IE required polyfills, in this exact order -->
    <script src="node_modules/es6-shim/es6-shim.min.js"></script>
    <script src="node_modules/systemjs/dist/system-polyfills.js"></script>

    <script src="node_modules/angular2/bundles/angular2-polyfills.js"></script>
    <script src="node_modules/systemjs/dist/system.src.js"></script>
    <script src="node_modules/rxjs/bundles/Rx.js"></script>
    <script src="node_modules/angular2/bundles/angular2.dev.js"></script>
	<script src="node_modules/angular2/bundles/router.dev.js"></script>

    <!-- 2. Configure SystemJS -->
    <script>
      System.config({
        packages: {
          loginapp: {
            format: 'register',
            defaultExtension: 'js'
          }
        }
      });
      System.import('loginapp/main')
            .then(null, console.error.bind(console));
    </script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    </head>
    <body>
    <login-app>Loading...</login-app>
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
    </div>
    <div><span>or</span></div>
    <div>
        <form name="register" id="register" action="register">
        <fieldset>
            <legend>Register</legend>
            <label for="name">Name</label><input type="input" id="name" name="name" hint="Enter your name"/><br/>
            <label for="email">E-mail</label><input type="input" id="email" name="email" hint="Email"/><br/>
            <label for="mobile">Mobile</label><input type="input" id="mobile" name="mobile"/><br/>
            <label for="password">Password</label><input type="password" id="password" name="password"/><br/>
            <label for="confirm_password">Confirm Password<input type="password" id="confirm_password" name="confirm_password"/><br/>
            <div>
                <button type="submit" class="btn">Register</button>
            </div>
        </fieldset>
        </form>
    </div>
        <script>
            $(function () {
              var token = $("meta[name='_csrf']").attr("content");
              var header = $("meta[name='_csrf_header']").attr("content");
              $(document).ajaxSend(function(e, xhr, options) {
                xhr.setRequestHeader(header, token);
              });
            });

            $("#register").submit(function(event) {
                // Stop form from submitting normally
                event.preventDefault();

                // Get some values from elements on the page:
                var $form = $( this );
                var url = $form.attr("action");
                var name = $form.find("input[name='name']").val();
                var email = $form.find("input[name='email']").val();
                var mobile = parseInt($form.find("input[name='mobile']").val());
                var password = $form.find("input[name='password']").val();
                var confirm_password = $form.find("input[name='confirm_password']").val();

                // Send the data using post
                var posting = $.ajax({
                    url: url,
                    type: 'post',
                    contentType: 'application/json; charset=utf-8',
                    data: JSON.stringify({ name: name, email: email, mobile: mobile, password: password }),
                    dataType: 'json',
                    success: function (data) {
                        console.info(data);
                    }
                });
            });
        </script>
    </body>
</html>
