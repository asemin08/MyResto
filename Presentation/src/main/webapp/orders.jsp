<%@ page import="eu.ensup.myresto.ProductDto" %>
<%@ page import="java.util.Set" %>
<%@ page import="eu.ensup.myresto.OrderProductDto" %>
<%@ page import="java.util.List" %>
<%@ page import="eu.ensup.myresto.ProductService" %><%--
  Created by IntelliJ IDEA.
  User: A
  Date: 29/06/2021
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="/header.jsp" %>
<div class="reservation-box">

</div>

<div class="container">

    <div class="row">

        <div class="col-lg-8 mx-auto">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="text-center text-marginTOP">
                            <h1>Mes commandes</h1>
                        </div>
                    </div>
                </div>
            </div>
            <!-- List group-->
            <ul class="list-group shadow">
                <%
                    int i = 1;
                    for (OrderProductDto o : (Set<OrderProductDto>) session.getAttribute("listOrders")) {
                        float price = 0.0f;

                %>
                <!-- list group item-->
                <li class="list-group-item">
                    <!-- Custom content-->
                    <div class="media align-items-lg-center flex-column flex-lg-row p-3">
                        <div class="media-body order-2 order-lg-1">
                            <h5 class="mt-0 font-weight-bold mb-2">Commande n°<%= i%>
                            <h6 class="mt-0 font-weight-bold mb-2">Status  : <%= o.getStatus()%>
                            </h6>
                            <%
                                for (Integer p : (List<Integer>) o.getIdProduct()) {
                                    ProductDto productDto = new ProductService().getOneProduct(p);
                            %>
                            <h5> - <%= productDto.getName() %></h5>
                            <p class="font-italic text-muted  small"> <%= productDto.getDescription() %></p>

                            <%
                                    price += productDto.getPrice();
                                }
                            %>
                            <div class="d-flex align-items-center justify-content-between mt-1">
                                <h6 class="font-weight-bold my-2">Prix de la commande: <%= price%>€</h6>
                            </div>
                        </div>
<%--                        <img src="assets/images/slider-02.jpg" alt="Generic placeholder image" width="200"--%>
<%--                             class="ml-lg-5 order-1 order-lg-2">--%>
                    </div>
                    <!-- End -->
                </li>
                <%
                        i++;
                    }
                %>

            </ul>
            <!-- End -->
        </div>
    </div>
</div>


<%@include file="/footer.jsp" %>

