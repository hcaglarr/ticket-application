<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="./includes/layout/header.jsp" %>
<div class="container p-3">
    <div class="row">
        <div class="col-md-12 col-lg-4 mb-3">
            <form>
                <div class="form-floating mb-2">
                    <select class="form-select" id="departure-point" aria-label="Kalkış Noktası">
                        <option selected>İstanbul</option>
                    </select>
                    <label for="departure-point">Kalkış Noktası</label>
                </div>
                <div class="form-floating mb-2">
                    <select class="form-select" id="destination" aria-label="Varış Noktası">
                        <option selected>Ankara</option>
                    </select>
                    <label for="destination">Varış Noktası</label>
                </div>
                <div class="form-floating mb-3">
                    <input type="date" class="form-control" id="trip-date" placeholder="name@example.com">
                    <label for="trip-date">Yolculuk Tarihi</label>
                </div>
                <div class="row">
                    <div class="col">
                        <div class="d-grid gap-2">
                            <button type="submit" class="btn btn-outline-success">Otobüs Bileti Bul</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-md-12 col-lg-8 mb-3 border rounded-3">
            <div class="d-flex justify-content-center align-items-center">
                <img class="img-fluid" id="bus" src="/img/bus.png">
            </div>
        </div>
    </div>
</div>
<%@include file="./includes/layout/footer.jsp" %>