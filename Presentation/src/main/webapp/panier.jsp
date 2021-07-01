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
<%--<div class="wrapper">
    <div class="main-container">
        <div class="panel-body table-responsive" id="panelcart">
            <%
                Map<Integer, Integer> productIds = (Map<Integer, Integer>) session.getAttribute("order");
                if (productIds != null && !productIds.isEmpty()) {
            %>
            <table class="table" id="tablecart" aria-label="tableau des commandes">

                <tbody>
                <%
                    for (ProductDto p : (Set<ProductDto>) session.getAttribute("productSet")) {
                %>
                <tr>
                    <th scope="col" class="tdifno"><%= p.getName()%>
                    </th>
                </tr>
                <tr>
                    <td><img src="assets/images/<%= p.getPicture()%>" alt="image du produit"/></td>
                    <td><%= p.getDescription()%>
                    </td>
                    <td><%= productIds.get(p.getId()) %>
                    </td>
                    <td>
                        <ul class="action-list">
                            <li><a href="removeproductcart?id=<%=p.getId()%>"><i class="fa fa-minus"
                                                                                 aria-hidden="true"></i></a> <a
                                    href="addproductcart?id=<%=p.getId()%>"><i class="fa fa-plus"
                                                                               aria-hidden="true"></i></a></li>
                        </ul>
                    </td>
                </tr>
                <tr id="finproduct">
                    <td class="tdifno"><%=p.getPrice() %> €</td>
                </tr>

                <%
                    }
                %>
                <tr>
                    <td class="font-weight-bold">TOTAL</td>
                    <td colspan="3">${totalPrice} €</td>
                    <td colspan="2"><a href="removeordercart">Vider le panier</a></td>
                    <td colspan="2"><a href="ordercart">Commander</a></td>
                </tr>
                <% if (request.getParameter("error") != null) { %>
                <td colspan="6">${error}</td>
                <% } %>
                </tbody>
            </table>
            <% } else { %>
            <h3> Aucun éléments dans le panier </h3>
            <% } %>

        </div>
    </div>
    <div class="push"></div>
</div>--%>

<div class="wrapper">
    <div class="main-container">
            <%
            Map<Integer, Integer> productIds = (Map<Integer, Integer>) session.getAttribute("order");
            if (productIds != null && !productIds.isEmpty()) {

            %>
        <div class="row d-flex justify-content-center align-items-center h-100 m5-custom bg-white">
            <div class="col">

                <div class="table-responsive">
                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col" class="h5"><strong>Panier</strong></th>
                            <th scope="col" class="text-center">Produit</th>
                            <th scope="col" class="text-center">Quantité</th>
                            <th scope="col" class="text-center">Prix</th>
                        </tr>
                        </thead>
                        <tbody>

                        <%
                            for (ProductDto p : (Set<ProductDto>) session.getAttribute("productSet")) {
                        %>
                        <tr>
                            <th scope="row">
                                <div class="d-flex align-items-center">
                                    <img src="https://i.imgur.com/2DsA49b.jpg" class="img-fluid rounded-3"
                                         style="width: 120px;" alt="Book">
                                    <div class="flex-column m-4">
                                        <p class="mb-2">Thinking, Fast and Slow</p>
                                        <p class="mb-0">Daniel Kahneman</p>
                                    </div>
                                </div>
                            </th>
                            <td class="align-middle text-center">
                                <p class="mb-0" style="font-weight: 500;">Digital</p>
                            </td>
                            <td class="align-middle">
                                <div class="d-flex flex-row justify-content-center">
                                    <a class="btn btn-orange btn-link px-2" href="removeproductcart?id=<%=p.getId()%>">
                                        <i class="fa fa-minus"></i>
                                    </a>

                                    <span class="btn btn-orange btn-link px-2"><%= productIds.get(p.getId()) %></span>

                                    <a href="addproductcart?id=<%=p.getId()%>" class="btn btn-orange btn-link px-2">
                                        <i class="fa fa-plus"></i>
                                    </a>
                                </div>
                            </td>
                            <td class="align-middle text-center">
                                <p class="mb-0" style="font-weight: 500;">$9.99</p>
                            </td>
                        </tr>
                        <%
                            }
                        %>
                        <% if (request.getParameter("error") != null) { %>
                        <td colspan="6">${error}</td>
                        <% } %>
                        </tbody>
                    </table>
                </div>
                <div class="card shadow-2-strong mb-5 mb-lg-0" style="border-radius: 16px;">
                    <div class="card-body p-4">

                        <div class="row">
                            <div class="col-6"></div>
                            <div class="col-6">

                                <hr class="my-4">

                                <div class="d-flex justify-content-between mb-4" style="font-weight: 500;">
                                    <p class="mb-2"><strong>Total</strong></p>
                                    <p class="mb-2">${totalPrice} €</p>
                                </div>

                                <button type="button" class="btn btn-primary btn-block btn-lg">
                                    <div class="d-flex justify-content-between">
                                        <span>Commander</span>
                                    </div>
                                </button>

                            </div>
                        </div>

                    </div>
                </div>
                <% } else { %>
                <div class="alert alert-light text-center m5-custom">
                    <h3 class="alert-heading"> Aucun éléments dans le panier </h3>
                    <a href="menu" class="alert-link">Ajouter un produit</a>
                </div>
                <% } %>
                <%-- <div class="row d-flex justify-content-center align-items-center h-100 m5-custom bg-white">
                     <div class="col">

                         <div class="table-responsive">
                             <table class="table">
                                 <thead>
                                 <tr>
                                     <th scope="col" class="h5"><strong>Panier</strong></th>
                                     <th scope="col">Produit</th>
                                     <th scope="col">Quantité</th>
                                     <th scope="col">Prix</th>
                                 </tr>
                                 </thead>
                                 <tbody>
                                 <tr>
                                     <th scope="row">
                                         <div class="d-flex align-items-center">
                                             <img src="https://i.imgur.com/2DsA49b.jpg" class="img-fluid rounded-3" style="width: 120px;" alt="Book">
                                             <div class="flex-column m-4">
                                                 <p class="mb-2">Thinking, Fast and Slow</p>
                                                 <p class="mb-0">Daniel Kahneman</p>
                                             </div>
                                         </div>
                                     </th>
                                     <td class="align-middle">
                                         <p class="mb-0" style="font-weight: 500;">Digital</p>
                                     </td>
                                     <td class="align-middle">
                                         <div class="d-flex flex-row">
                                             <button class="btn btn-link px-2"
                                                     onclick="this.parentNode.querySelector('input[type=number]').stepDown()">
                                                 <i class="fas fa-minus"></i>
                                             </button>

                                             <input id="form1" min="0" name="quantity" value="2" type="number"
                                                    class="form-control form-control-sm" style="width: 50px;" />

                                             <button class="btn btn-link px-2"
                                                     onclick="this.parentNode.querySelector('input[type=number]').stepUp()">
                                                 <i class="fas fa-plus"></i>
                                             </button>
                                         </div>
                                     </td>
                                     <td class="align-middle">
                                         <p class="mb-0" style="font-weight: 500;">$9.99</p>
                                     </td>
                                 </tr>
                                 </tbody>
                             </table>
                         </div>

                         <div class="card shadow-2-strong mb-5 mb-lg-0" style="border-radius: 16px;">
                             <div class="card-body p-4">

                                 <div class="row">
                                     <div class="col-6"></div>
                                     <div class="col-6">

                                         <hr class="my-4">

                                         <div class="d-flex justify-content-between mb-4" style="font-weight: 500;">
                                             <p class="mb-2">Total</p>
                                             <p class="mb-2">$26.48</p>
                                         </div>

                                         <button type="button" class="btn btn-primary btn-block btn-lg">
                                             <div class="d-flex justify-content-between">
                                                 <span>Commander</span>
                                             </div>
                                         </button>

                                     </div>
                                 </div>

                             </div>
                         </div>

                     </div>
                 </div>--%>
                <%--
                <div class="container mb-4">
                    <div class="row justify-content-center text-center align-middle">
                        <div class="col-12">
                            <div class="table-responsive">
                                <%
                                    Map<Integer, Integer> productIds = (Map<Integer, Integer>) session.getAttribute("order");
                                    if (productIds != null && !productIds.isEmpty()) {

                                %>
                                <table class="table panel-body" id="panelcart">
                                    <tbody>
                                    <%
                                        for (ProductDto p : (Set<ProductDto>) session.getAttribute("productSet")) {
                                    %>
                                    <tr>
                                        <th scope="col" class="tdifno"><%= p.getName()%></th>
                                    </tr>
                                    <tr>
                                        <td><img src="assets/images/<%= p.getPicture()%>" alt="image du produit"/></td>
                                        <td><%= p.getDescription()%></td>
                                        <td><%= productIds.get(p.getId()) %></td>
                                        <td>
                                            <a href="removeproductcart?id=<%=p.getId()%>">
                                                <i class="fa fa-minus" aria-hidden="true"></i>
                                            </a>
                                        </td>
                                        <td>
                                            <a href="addproductcart?id=<%=p.getId()%>">
                                                <i class="fa fa-plus" aria-hidden="true"></i>
                                            </a>
                                        </td>
                                    </tr>
                                    <tr id="finproduct">
                                        <td class="tdifno"><%=p.getPrice() %> €</td>
                                    </tr>
                                    <%
                                        }
                                    %>
                                    <tr>
                                        <td><strong>Total</strong></td>
                                        <td colspan="3">${totalPrice} €</td>
                                        <td colspan="2"><a href="ordercart" class="">Commander</a></td>
                                    </tr>
                                    </tbody>
                                </table>
                                <% } else { %>
                                    <div class="alert alert-light">
                                        <h3 class="alert-heading"> Aucun éléments dans le panier </h3>
                                        <a href="menu" class="alert-link">Ajouter un produit</a>
                                    </div>

                                <% } %>


                            </div>
                        </div>

                    </div>
                </div>--%>
            </div>
            <div class="push"></div>

        </div>


        <!-- End Panier -->
        <%@include file="footer.jsp" %>
