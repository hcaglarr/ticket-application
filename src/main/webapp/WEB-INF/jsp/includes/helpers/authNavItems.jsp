<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authorize access="hasAuthority('ADMIN')">
    <li class="nav-item">
        <a class="nav-link rounded-3 text-dark px-2 mx-1" aria-current="page" href="/">Bus Ticket</a>
    </li>
    <li class="nav-item">
        <a class="nav-link rounded-3 text-dark px-2 mx-1" aria-current="page" href="/admin/users">Users</a>
    </li>
</sec:authorize>
<sec:authorize access="hasAuthority('USER') || isAnonymous()">
    <li class="nav-item">
        <a class="nav-link rounded-3 text-dark px-2 mx-1" aria-current="page" href="/">Bus Ticket</a>
    </li>
</sec:authorize>