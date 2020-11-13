<%-- 
    Document   : viewCart
    Created on : Nov 5, 2020, 3:09:14 PM
    Author     : macbook
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Page</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link rel="stylesheet" href="css/styleViewCart.css">
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    </head>
    <body>
        <c:if test="${sessionScope.USER.roleID != 'user'}">
            <c:url var="lF" value="MainController">
                <c:param name="btnAction" value="LoginFirst"></c:param>
            </c:url>
            <c:redirect url="${lF}"></c:redirect>
        </c:if>
        <section class="jumbotron text-center">
            <div class="container">
                <h1 class="jumbotron-heading">Booking Confirmation</h1>
            </div>
        </section>
        <c:set var="cart" value="${sessionScope.CART}"></c:set>       
        <c:if test="${cart != null && not empty cart}">
            <div class="container mb-4">
                <div class="row">
                    <div class="col-12">
                        <div class="table-responsive">
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th scope="col"> </th>
                                        <th scope="col">Product</th>
                                        <th scope="col" class="text-center">Arrival - Departure</th>
                                        <th scope="col" class="text-center">Date</th>
                                        <th scope="col" class="text-right">Price</th>
                                        <th scope="col" class="text-right">Total</th>
                                        <th> </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:set var="total" value="0"></c:set>
                                    <c:set var="totalDate" value="1"></c:set>
                                    <c:forEach var="dto" items="${cart.getCart().values()}">  

                                        <tr>
                                            <td><img src="https://dummyimage.com/50x50/55595c/fff" /> </td>
                                            <td>${dto.roomID}</td>
                                            <td class="text-center">
                                                ${dto.checkIn} to ${dto.checkOut}
                                            </td>
                                            <td class="text-center">
                                                <fmt:parseDate value="${dto.checkIn}" var="arrival" pattern="yyyy-MM-dd"/>
                                                <fmt:parseDate value="${dto.checkOut}" var="departure" pattern="yyyy-MM-dd"/>
                                                <c:set var="date" value="${departure.getTime() - arrival.getTime()}"></c:set>
                                                <c:set var="totalDate" value="${date / (24 * 60 * 60 * 1000)}"></c:set>
                                                ${totalDate}
                                            </td>
                                            <td class="text-right">US$${dto.price}</td>
                                            <td class="text-right">US$${dto.price * totalDate}</td>
                                            <td class="text-right">
                                                <c:url var="delete" value="MainController">
                                                    <c:param name="btnAction" value="Delete"></c:param>
                                                    <c:param name="txtRoomID" value="${dto.roomID}"></c:param>
                                                </c:url>
                                                <a  href="${delete}">
                                                    <button class="btn btn-sm btn-danger"><i class="fa fa-trash"></i> </button>
                                                </a>
                                            </td>
                                        </tr>   
                                        <c:set var="total" value="${total + (dto.price * totalDate)}"></c:set>
                                    </c:forEach>
                                    <tr>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td>Your email to confirm</td>
                                        <td class="text-right">
                                            ${cart.userID}
                                        </td>
                                    </tr>
                                    <tr>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td><strong>Total</strong></td>
                                        <td class="text-right"><strong>US$${total}</strong></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="col mb-2">
                        <div class="row">
                            <div class="col-sm-12  col-md-6">
                            </div>

                            <div class="col-sm-12 col-md-6 text-right">
                                <c:url var="save" value="MainController">
                                    <c:param name="btnAction" value="Save"></c:param>
                                    <c:param name="txtTotal" value="${total}"></c:param>
                                </c:url>
                                <a  href="${save}">
                                    <button class="btn btn-lg btn-block btn-success text-uppercase">I'll reserve</button>
                                </a>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>
        <div class="col mb-4">
            <div class="row">
                <div class="col-sm-12  col-md-6">
                    <c:url var="search" value="MainController">
                        <c:param name="btnAction" value="Search"></c:param>
                    </c:url>
                    <a  href="${search}">
                        <button class="btn btn-block btn-light">Continue Shopping</button>
                    </a>
                </div>
            </div>
        </div>
    </div>

    <!-- Footer -->
    <footer class="text-light">
        <div class="container">
            <div class="row">
                <div class="col-md-3 col-lg-4 col-xl-3">
                    <h5>About</h5>
                    <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                    <p class="mb-0">
                        Best time to stay at Dat resort: special rates for shot breaks and staycations. Book today! Enjoy a relaxing getaway at Dat resort, multiple award winning luxury beach resort. Chat Support Available. Sign Up For Offers. Multiple Payment Options.
                    </p>
                </div>

                <div class="col-md-2 col-lg-2 col-xl-2 mx-auto">
                    <h5>Informations</h5>
                    <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                    <ul class="list-unstyled">
                        <li>Datnlm</li>
                        <li>SE140870</li>
                    </ul>
                </div>

                <div class="col-md-3 col-lg-2 col-xl-2 mx-auto">                                            
                </div>

                <div class="col-md-4 col-lg-3 col-xl-3">
                    <h5>Contact</h5>
                    <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                    <ul class="list-unstyled">
                        <li><i class="fa fa-home mr-2"></i> Dat Resort</li>
                        <li><i class="fa fa-envelope mr-2"></i> datnlm@fpt.com</li>
                        <li><i class="fa fa-phone mr-2"></i> + 33 12 14 15 16</li>
                        <li><i class="fa fa-print mr-2"></i> + 33 12 14 15 16</li>
                    </ul>
                </div>                   
            </div>
        </div>
    </footer>
</body>
</html>
