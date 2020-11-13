<%-- 
    Document   : register
    Created on : Nov 4, 2020, 9:52:41 AM
    Author     : macbook
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html><!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Register Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- MATERIAL DESIGN ICONIC FONT -->
        <link rel="stylesheet" href="fonts/material-design-iconic-font/css/material-design-iconic-font.min.css">

        <!-- STYLE CSS -->
        <link rel="stylesheet" href="css/styleRegister.css">
    </head>

    <body>
        <c:set var="error" value="${requestScope.ERROR}"></c:set>
            <div class="wrapper" style="background-image: url('images/background.jpg');">
                <div class="inner">
                    <div class="image-holder">
                        <img src="images/Anderson Design Group.jpeg" alt="">
                    </div>
                    <form action="MainController" method="POST">
                        <h3>Registration Form</h3>
                        <div class="form-wrapper">
                            <font color="red">${error.getFullNameError()}</font>
                        <input type="text" name="txtFullName" placeholder="Full name" value="${param.txtFullName}" class="form-control">
                    </div>
                    <div class="form-wrapper">
                        <font color="red">${error.getUserIDError()}</font>
                        <input type="text" name="txtUserID" placeholder="User id" value="${param.txtUserID}" class="form-control">
                        <i class="zmdi zmdi-account"></i>
                    </div>
                    <div class="form-wrapper">
                        <font color="red">${error.getEmailError()}</font>
                        <input type="text" name="txtEmail" placeholder="${error.getEmailError() == null ? "Email Address" : error.getEmailError()}" value="${param.txtEmail}" class="form-control">
                        <i class="zmdi zmdi-email"></i>                       
                    </div>
                    <div class="form-wrapper">
                        <font color="red">${error.getGenderError()}</font>
                        <select name="cmbGender" id="" class="form-control">
                            <option value="${param.cmbGender}">Gender</option>
                            <option value="male">Male</option>
                            <option value="female">Female</option>
                        </select>
                        <i class="zmdi zmdi-caret-down" style="font-size: 17px"></i>
                    </div>
                    <div class="form-wrapper">
                        <font color="red">${error.getPasswordError()}</font>
                        <input type="password" name="txtPassword" placeholder="Password" class="form-control">
                        <i class="zmdi zmdi-lock"></i>                       
                    </div>
                    <div class="form-wrapper">
                        <font color="red">${error.getConfirmError()}</font>
                        <input type="password" name="txtConfirmPassword" placeholder="Confirm Password" class="form-control">
                        <i class="zmdi zmdi-lock"></i>
                    </div>       
                    <button name="btnAction" value="Create">Register
                        <i class="zmdi zmdi-arrow-right"></i>                 
                    </button>
                    <button name="btnAction" value="ViewLogin">Login
                        <i class="zmdi zmdi-arrow-left"></i>   
                    </button>
                </form>
            </div>
        </div>     
    </body>
</html>