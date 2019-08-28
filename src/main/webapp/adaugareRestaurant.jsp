<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Adaugare cont admin</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${contextPath}/resources/tema/vendor/bootstrap/css/bootstrap.min.css">
    <link href="${contextPath}/resources/tema/vendor/fonts/circular-std/style.css" rel="stylesheet">
    <link rel="stylesheet" href="${contextPath}/resources/tema/libs/css/style.css">
    <link rel="stylesheet" href="${contextPath}/resources/tema/vendor/fonts/fontawesome/css/fontawesome-all.css">
    <style>
        html,
        body {
            height: 100%;
        }

        body {
            display: -ms-flexbox;
            display: flex;
            -ms-flex-align: center;
            align-items: center;
            padding-top: 40px;
            padding-bottom: 40px;
        }
    </style>
</head>

<body>

<div class="container">


    <form:form method="POST" action="${contextPath}/salvareRestaurant"  modelAttribute="restaurantForm" class="splash-container">
    <div class="card">
        <div class="card-header">
            <c:if test="${add!=false}">
                <h3 class="mb-1">Adaugare restaurant</h3>
            </c:if>
            <c:if test="${add==false}">
                <h3 class="mb-1">Setari restaurant</h3>
            </c:if>
            <p>Introduceti informatiile despre restaurant.</p>
        </div>
        <div class="card-body">
            <spring:bind path="id">
            <div class="form-group">
                <form:input type="hidden" id="id" path="id" name="id"  class="form-control"></form:input>
                </spring:bind>

            <spring:bind path="denumire">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="denumire" class="form-control form-control-lg" placeholder="Denumire"
                                autofocus="true"></form:input>
                    <form:errors cssStyle="color: red" path="denumire"></form:errors>

                </div>
            </spring:bind>
            <spring:bind path="descriere">
                <div class="form-group ${status.error ? 'has-error' : ''}">

                    <form:input type="text" path="descriere" class="form-control form-control-lg" placeholder="Descriere"
                                autofocus="true"></form:input>
                    <form:errors cssStyle="color: red" path="descriere"></form:errors>
                </div>
            </spring:bind>
                <spring:bind path="imagine">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <label for="imagine" class=" form-control-label">Incarca o imagine</label>
                        <input type="file" id="imagine" class="form-control-file"/>
                        <form:input type="hidden" name="imagine" path="imagine" id="idS" />
                        <c:if test="${add==false}">
                            <label for="imagePreview" class=" form-control-label">Imagine veche</label>
                        </c:if>
                        <img style="max-width: 150px; max-height: 150px; margin: 0 auto;object-fit: cover" src="${imageSrc}" id="imagePreview">

                        <label id="label-preview"  for="preview" class=" form-control-label"></label>
                        <img style="max-width: 150px; max-height: 150px; margin: 0 auto; object-fit: cover" src="" id="preview">

                    </div>
                    <form:errors cssStyle="color: red" path="imagine"></form:errors>

                </spring:bind>

                <spring:bind path="comandaOnline">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label for="comandaOnline" class=" form-control-label">Optiune Comanda Online</label>
                    <form:select id="comandaOnline" path="comandaOnline" name="comandaOnline" class="form-control">
                        <option value="0" >Posibilitate comanda online</option>
                        <c:if test="${restaurantForm.comandaOnline=='-1'}">

                            <option value="1" >DA</option>
                            <option value="0">NU</option>
                        </c:if>
                        <c:if test="${restaurantForm.comandaOnline=='1'}">

                            <option value="1" selected>DA</option>
                            <option value="0">NU</option>
                        </c:if>
                        <c:if test="${restaurantForm.comandaOnline=='0'}">

                            <option value="1" >DA</option>
                            <option value="0" selected>NU</option>
                        </c:if>

                    </form:select>
                    <form:errors cssStyle="color: red" path="comandaOnline"></form:errors>
                    </spring:bind>
                    <spring:bind path="barCode">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <label for="barCode" class=" form-control-label">Optiune bar code</label>
                        <form:select id="barCode" path="barCode" name="barCode" class="form-control">
                            <option value="0" >Posibilitate barCode </option>
                            <c:if test="${restaurantForm.barCode=='-1'}">

                                <option value="1" >DA</option>
                                <option value="0">NU</option>
                            </c:if>
                            <c:if test="${restaurantForm.barCode=='1'}">

                                <option value="1" selected>DA</option>
                                <option value="0">NU</option>
                            </c:if>
                            <c:if test="${restaurantForm.barCode=='0'}">

                                <option value="1" >DA</option>
                                <option value="0" selected>NU</option>
                            </c:if>

                        </form:select>
                        <form:errors cssStyle="color: red" path="barCode"></form:errors>
                        </spring:bind>
                <div class="form-group pt-2">
                    <button class="btn btn-block btn-primary" type="submit">Salveaza modificarile</button>
                </div>
                <div class="card-footer bg-white">
                    <p>Vrei sa renunti?<a href="${contextPath}/welcome" class="text-secondary">Revino la pagina principala.</a></p>
                </div>


        </div>
    </div>
        </form:form>

    </div>
    <!-- /container -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
        <script>
            function getBase64(file) {
                var preview = document.getElementById("preview");

                var label= document.getElementById("label-preview");
                var reader = new FileReader();
                reader.readAsDataURL(file);
                reader.onload = function (e) {
                    console.log(reader.result);
                    document.getElementById("idS").value = reader.result;

                    console.log('a ajuns aici');
                    preview.setAttribute('src', e.target.result);
                    label.innerHTML='Imaginea noua' ;
                };
                reader.onerror = function (error) {
                    console.log('Error: ', error);
                };
            }


            $('#imagine').bind('change', function (e) {
                var files = document.getElementById('imagine').files;
                if (files.length > 0) {
                    getBase64(files[0]);
                }});



        </script>
</body>
</html>
