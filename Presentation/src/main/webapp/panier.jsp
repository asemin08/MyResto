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
<div class="reservation-box">
    <div class="panel-body table-responsive" id="panelcart">
        <%
            Map<Integer,Integer> productIds = (Map<Integer, Integer>) session.getAttribute("order");
            if(productIds != null && !productIds.isEmpty()){
        %>
        <table class="table" id="tablecart" aria-label="tableau des commandes">

            <tbody>
            <%
                for(ProductDto p : (Set<ProductDto>) session.getAttribute("productSet")){
            %>
            <tr><th scope="col" class="tdifno"><%= p.getName()%></th></tr>
            <tr>
                <td><img src="assets/images/<%= p.getPicture()%>" alt="image du produit"/></td>
                <td><%= p.getDescription()%></td>
                <td><%= productIds.get(p.getId()) %></td>
                <td>
                    <ul class="action-list">
                        <li><a href="removeproductcart?id=<%=p.getId()%>"><i class="fa fa-minus" aria-hidden="true"></i></a> <a href="addproductcart?id=<%=p.getId()%>"><i class="fa fa-plus" aria-hidden="true"></i></a></li>
                    </ul>
                </td>
            </tr>
            <tr id="finproduct"><td class="tdifno"><%=p.getPrice() %> €</td></tr>

            <%
                }
            %>
            <tr>
                <td class="font-weight-bold">TOTAL</td>
                <td colspan="3" >${totalPrice} €</td>
                <td colspan="2" ><a  href="ordercart">Commander</a></td>
            </tr>
            <% if(request.getParameter("error") != null) { %>
            <td colspan="6">${error}</td>
            <% } %>
            </tbody>
        </table>
        <% }else{ %>
                <h3> Aucun éléments dans le panier </h3>
        <% } %>

    </div>
</div>

<!-- End Panier -->
<%@include file="footer.jsp" %>
