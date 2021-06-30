<%@ page import="eu.ensup.myresto.Product" %>
<%@ page import="java.util.Set" %>
<%@ page import="eu.ensup.myresto.ProductDto" %>
<%@ page import="java.util.Map" %>
<%--
  Created by IntelliJ IDEA.
  User: cherif
  Date: 29/06/2021
  Time: 09:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="header.jsp" %>

<!-- Start Panier -->
<div class="reservation-box">
    <div class="panel-body table-responsive">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Prénom</th>
                <th scope="col">Image</th>
                <th scope="col">Nom</th>
                <th scope="col">Description</th>
                <th scope="col">Prix</th>
                <th scope="col">Quantité</th>
            </tr>
            </thead>
            <tbody>
            <%
                Map<Integer,Integer> productCount = (Map<Integer, Integer>) session.getAttribute("productCount");
                for(ProductDto p : (Set<ProductDto>) session.getAttribute("productSet")){
            %>
            <tr>
                <td><%= p.getId()%></td>
                <td><%= p.getPicture()%></td>
                <td><%= p.getName()%></td>
                <td><%= p.getDescription()%></td>
                <td><%=p.getPrice()%></td>
                <td><%= productCount.get(p.getId()) %></td>
                <td>
                    <ul class="action-list">
                        <li><a href="remove?id=<%=p.getId()%>"><i class="fas fa-minus"></i></a></li>
                        <li><a href="add?id=<%=p.getId()%>"><i class="fas fa-plus"></i></a></li>
                    </ul>
                </td>
            </tr>
            <%
                }
            %>

            </tbody>
        </table>
    </div>
</div>
<!-- End Panier -->
<%@include file="footer.jsp" %>
