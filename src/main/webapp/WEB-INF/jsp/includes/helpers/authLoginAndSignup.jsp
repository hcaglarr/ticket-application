<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authorize access="isAnonymous()" >
    <ul class="navbar-nav ms-auto flex-row">
        <li class="nav-item">
            <a class="nav-link mx-1 rounded-3 text-dark" href="/account/login">Giriş Yap</a>
        </li>
    </ul>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
    <ul class="navbar-nav my-lg-0 flex-row">
        <li class="nav-item">
            <a class="nav-link mx-1 rounded-3 text-dark" href="/logout">Çıkış</a>
        </li>
    </ul>
</sec:authorize>