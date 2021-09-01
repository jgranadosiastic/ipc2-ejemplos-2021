<%-- 
    Document   : index
    Created on : 31 ago. 2021, 14:40:41
    Author     : jose
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="/includes/resources.jsp" />
        <title>Ajax</title>
    </head>
    <body>
        <jsp:include page="/includes/header.jsp" />
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <button type="button" class="btn btn-primary btn-lg btn-block" onclick="ajaxWithJQuery('${pageContext.request.contextPath}')">Presioname</button>

                </div>
            </div>
            <div class="row">
                <div class="col-md-12" id="ajax-target">
                    ajax target
                </div>
            </div>
            <jsp:include page="/includes/footer.jsp" />
        </div>
    </body>
</html>
