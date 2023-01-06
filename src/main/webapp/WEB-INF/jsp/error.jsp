<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="./includes/layout/header.jsp" %>
<div class="container p-2 text-center">
    <div class="row justify-content-center">
        <div class="col align-self-center">
            <p class="h1">Redirecting ..</p>
            <a type="button" href="/" class="btn btn-link text-dark">Back <span id="count"></span></a>
        </div>
    </div>
</div>

<script>
    var count = 5;
    var baseUrl = "/" ;

    (function () { setCount() })()

    function setCount() {
        document.getElementById('count').innerHTML = count-- + ' sec';
    }

    function clear(ref){
        clearInterval(ref)
    }

    var intervalRef = setInterval(function () {
        if(count){
            setCount()
        }else {
            clear(intervalRef)
            window.location.href = baseUrl
        }}, 1000)

</script>
<%@include file="./includes/layout/footer.jsp" %>
