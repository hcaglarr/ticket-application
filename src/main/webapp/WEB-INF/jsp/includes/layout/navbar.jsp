<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<nav class="navbar navbar-expand-lg elevation-z6 fixed-top">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">Ticket App</a>
        <%@include file="../helpers/authLoginAndSignup.jsp" %>
    </div>
</nav>
<nav class="navbar navbar-expand-lg mt-6 border-bottom">
    <div class="container-fluid ">
        <button class="navbar-toggler ms-auto" type="button" data-bs-toggle="collapse"
                data-bs-target="#bottomNavbarScroll"
                aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-center align-items-center" id="bottomNavbarScroll">
            <ul class="navbar-nav flex-row">
                <%@include file="../helpers/authNavItems.jsp" %>
            </ul>
        </div>
    </div>
</nav>
