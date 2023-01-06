<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../includes/layout/header.jsp" %>
    <div class="container p-3">
        <div class="row justify-content-center align-items-center min-vh-100" style="transform: translateY(-112px)">
            <div class="col-md-4 mb-3">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title text-center">Üye Girişi</h5>
                        <form action="/login" method="post">
                            <input type="hidden"
                                   name="${_csrf.parameterName}"
                                   value="${_csrf.token}"/>
                            <div class="form-floating mb-3">
                                <input type="email" class="form-control" name="username" id="username"
                                       placeholder="name@example.com" autocomplete="off">
                                <label for="username">Email address</label>
                            </div>
                            <div class="form-floating mb-3">
                                <input type="password" class="form-control" name="password" id="password"
                                       placeholder="Password">
                                <label for="password">Password</label>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-check mb-3">
                                        <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked"
                                               checked>
                                        <label class="form-check-label" for="flexCheckChecked">
                                            Beni Hatırla
                                        </label>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <a href="#" class="link-dark">Şifrenizi mi Unuttunuz ?</a>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col">
                                    <div class="d-grid gap-2 mb-3">
                                        <button type="submit" class="btn btn-success bg-gradient">Giriş yap</button>
                                    </div>
                                </div>
                            </div>
                            <div class="row justify-content-center">
                                <div class="col-md-12">
                                    <p class="h6 text-center">Henüz üye değil misiniz?</p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col">
                                    <div class="d-grid gap-2">
                                        <button type="button" class="btn btn-danger bg-gradient">Üye Ol</button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
<%@include file="../includes/layout/footer.jsp" %>
