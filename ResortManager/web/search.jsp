<%-- 
    Document   : search.jsp
    Created on : Nov 4, 2020, 2:16:17 PM
    Author     : macbook
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

        <title>Booking Resort</title>

        <!-- Google font -->
        <link href="https://fonts.googleapis.com/css?family=Cardo:700" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Josefin+Sans:400,700" rel="stylesheet">

        <!-- Bootstrap -->
        <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />

        <!-- Custom stlylesheet -->
        <link type="text/css" rel="stylesheet" href="css/styleSearch.css" />

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
                  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
                  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
                <![endif]-->

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <c:if test="${sessionScope.USER.roleID != 'user'}">
            <c:url var="lF" value="MainController">
                <c:param name="btnAction" value="LoginFirst"></c:param>
            </c:url>
            <c:redirect url="${lF}"></c:redirect>
        </c:if>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand">Resort Dat</a>
                </div>

                <ul class="nav navbar-nav navbar-right">
                    <li><a><span class="glyphicon glyphicon-user"></span> ${sessionScope.USER.email}</a></li>
                                <c:url var="logout" value="MainController">
                                    <c:param name="btnAction" value="Logout"></c:param>
                                </c:url>
                    <li><a href="${logout}"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
                </ul>
            </div>
        </nav>
        <!--nav-->
        <div id="booking" class="section">
            <div class="section-center">
                <div class="container">
                    <div class="row">
                        <div class="booking-form">
                            <div class="form-header">
                                <h1>Make your reservation</h1>
                            </div>
                            <form action="MainController">
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <span class="form-label">Check In</span>
                                            <input class="form-control" type="date" name="txtCheckIn" value="${param.txtCheckIn}">
                                        </div>
                                        <span class="in-out hidden-xs hidden-sm">&#8652;</span>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <span class="form-label">Check out</span>
                                            <input class="form-control" type="date" name="txtCheckOut" value="${param.txtCheckOut}">
                                        </div>
                                    </div>
                                    <h1 class="text-center"><font color="red">  ${requestScope.ERROR}</font></h1>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-btn">
                                            <button class="submit-btn" name="btnAction" value="Search">Check availability</button>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!------------------------- table ---------------------------->
        <c:set var="list" value="${requestScope.LIST}"></c:set>
        <c:if test="${list != null && not empty list}">
            <div class="row">
                <h1 class="text-center">Room avaliable</h1>
                <c:forEach var="dto" items="${list}">
                    <a class="list-group-item">
                        <div class="media col-md-3">
                            <figure class="pull-left">
                                <img class="media-object img-rounded img-responsive" src="http://placehold.it/350x250" alt="placehold.it/350x250" >
                            </figure>
                        </div>
                        <div class="col-md-6">
                            <h4 class="list-group-item-heading"> ${dto.roomID} </h4>
                            <p class="list-group-item-text">
                                ${dto.description}
                            </p>
                        </div>
                        <div class="col-md-3 text-center">
                            <h2> US$${dto.price}</h2>
                            <form action="MainController" method="POST">
                                <button type="submit" name="btnAction" value="Add" class="btn btn-primary btn-lg btn-block">Select your room</button>
                                <input type="hidden" name="txtRoomID" value="${dto.roomID}">
                                <input type="hidden" name="txtCheckIn" value="${param.txtCheckIn}">
                                <input type="hidden" name="txtCheckOut" value="${param.txtCheckOut}">
                                <input type="hidden" name="txtPrice" value="${dto.price}">
                                <!-- hidden from field -->
                            </form>
                        </div>              
                    </a>
                </c:forEach>
            </c:if>
            <div class="col-md-12 text-center">
                <c:url var="view" value="MainController">
                    <c:param name="btnAction" value="View"></c:param>
                </c:url>
                <a  href="${view}">
                    <button type="button" class="btn btn-primary btn-lg btn-block">View car</button>
                </a>
            </div>
        </div>
        <div class="container text-center">
            <hr />
            <div class="row">
            </div>
            <hr>
            <div class="row">
                <div class="col-lg-12">
                    <ul class="nav nav-pills nav-justified">
                        <li>© 2013 Dat Resort</li>
                        <li>Terms of Service</li>
                        <li>Privacy</li>
                    </ul>
                </div>
            </div>
        </div>
    </body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>