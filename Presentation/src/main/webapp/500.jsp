<%@include file="header.jsp" %>
<%@ page pageEncoding="UTF-8" %>
<div class="wrapper">

    <div class="reservation-box">

        <div class="qt-box qt-background">
            <div class="container">
                <div class="row">
                    <div class="col-md-8 ml-auto mr-auto text-center">
                        <p class="lead ">
                            Il y a eu un problème dans le serveur.
                            <% if (request.getAttribute("error") != null) {%>
                            Erreur : <%=session.getAttribute("error")%>
                            <% session.removeAttribute("error"); %>
                            <% } %>
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="push"></div>
</div>

<%@include file="footer.jsp" %>

