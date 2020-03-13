<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Create an account</title>

      <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
      <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
  </head>

  <body>

    <div class="container">

        <form:form method="POST" modelAttribute="userForm" class="form-signin">
            <h2 class="form-signin-heading">Create your account</h2>
            <spring:bind path="username">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="username" class="form-control" placeholder="Username"
                                autofocus="true"></form:input>
                    <form:errors path="username"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="password">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="password" path="password" class="form-control" placeholder="Password"></form:input>
                    <form:errors path="password"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="passwordConfirm">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="password" path="passwordConfirm" class="form-control"
                                placeholder="Confirm your password"></form:input>
                    <form:errors path="passwordConfirm"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="firstName">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="firstName" class="form-control" placeholder="FirstName"
                                autofocus="true"></form:input>
                    <form:errors path="FirstName"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="lastName">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="lastName" class="form-control" placeholder="LastName"
                                autofocus="true"></form:input>
                    <form:errors path="LastName"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="email">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="email" class="form-control" placeholder="test@gmail.com"
                                autofocus="true"></form:input>
                    <form:errors path="Email"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="mobileNumber">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="mobileNumber" class="form-control" placeholder="+97154567878"
                                autofocus="true"></form:input>
                    <form:errors path="MobileNumber"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="gender">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="gender" class="form-control" placeholder="Male"
                                autofocus="true"></form:input>
                    <form:errors path="Gender"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="birthDay">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="birthDay" class="form-control" placeholder="12-02-1990"
                                autofocus="true"></form:input>
                    <form:errors path="birthDay"></form:errors>
                </div>
            </spring:bind>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
        </form:form>

    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
  </body>
</html>
