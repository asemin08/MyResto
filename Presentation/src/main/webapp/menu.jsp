<%@ page import="eu.ensup.myresto.Product" %>
<%@ page import="java.util.Set" %>
<%@ page import="eu.ensup.myresto.ProductDto" %>
<%@ page import="eu.ensup.myresto.CategoryService" %><%--
  Created by IntelliJ IDEA.
  eu.ensup.myresto.User: A
  Date: 28/06/2021
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<div class="menu-box">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="heading-title text-center">
                    <h2>Special Menu</h2>
                    <p>Lorem Ipsum is simply dummy text of the printing and typesetting</p>
                </div>
            </div>
        </div>

        <div class="row inner-menu-box">
            <div class="col-3">
                <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">

                    <a class="nav-link active" id="v-pills-All-tab" data-toggle="pill" href="#v-pills-All" role="tab"
                       aria-controls="v-pills-All" aria-selected="true">Tout</a>
                    <a class="nav-link" id="v-pills-boisson-tab" data-toggle="pill" href="#v-pills-boisson" role="tab"
                       aria-controls="v-pills-boisson" aria-selected="false">Boissons</a>
                    <a class="nav-link" id="v-pills-entrees-tab" data-toggle="pill" href="#v-pills-entrees" role="tab"
                       aria-controls="v-pills-entrees" aria-selected="false">Entrées</a>
                    <a class="nav-link" id="v-pills-plats-tab" data-toggle="pill" href="#v-pills-plats" role="tab"
                       aria-controls="v-pills-plats" aria-selected="false">Plats</a>
                    <a class="nav-link" id="v-pills-desserts-tab" data-toggle="pill" href="#v-pills-desserts" role="tab"
                       aria-controls="v-pills-desserts" aria-selected="false">Desserts</a>
                </div>
            </div>

            <div class="col-9">
                <div class="tab-content" id="v-pills-tabContent">
                    <div class="tab-pane fade show active" id="v-pills-All" role="tabpanel"
                         aria-labelledby="v-pills-All-tab">
                        <div class="row">
                            <%
                                for (ProductDto p : (Set<ProductDto>) session.getAttribute("listProducts")) {

                            %>
                            <div class="col-lg-4 col-md-6 special-grid " <%=new CategoryService().get(p.getIdCategory()).getName()%>>
                                <div class="gallery-single fix">
                                    <img src="assets/images/<%=p.getPicture()%>" class="img-fluid" alt="Image">
                                    <div class="why-text">
                                        <h4><%= p.getName()%>
                                        </h4>
                                        <p><%= p.getDescription()%>
                                        </p>
                                        <h5><%= p.getPrice()%>€</h5>
                                        <a class="nav-link" href="#">Ajouter</a>
                                    </div>
                                </div>
                            </div>
                            <%
                                }
                            %>
                        </div>

                    </div>
                    <div class="tab-pane fade" id="v-pills-boisson" role="tabpanel"
                         aria-labelledby="v-pills-boisson-tab">
                        <div class="row">
                            <%
                                for (ProductDto p : (Set<ProductDto>) session.getAttribute("listBoisson")) {
                            %>
                                        <div class="col-lg-4 col-md-6 special-grid <%=new CategoryService().get(p.getIdCategory()).getName()%>">
                                            <div class="gallery-single fix">
                                                <img src="assets/images/<%=p.getPicture()%>" class="img-fluid" alt="Image">
                                                <div class="why-text">
                                                    <h4><%= p.getName()%></h4>
                                                    <p><%= p.getDescription()%></p>
                                                    <h5><%= p.getPrice()%>€</h5>
                                                    <a class="nav-link" href="#">Ajouter</a>
                                                </div>
                                            </div>
                                        </div>
                            <%
                                }
                            %>

                        </div>

                    </div>
                    <div class="tab-pane fade" id="v-pills-entrees" role="tabpanel"
                         aria-labelledby="v-pills-entrees-tab">
                        <div class="row">
                            <%
                                for (ProductDto p : (Set<ProductDto>) session.getAttribute("listEntree")) {
                            %>
                            <div class="col-lg-4 col-md-6 special-grid "<%=new CategoryService().get(p.getIdCategory()).getName()%>>
                                <div class="gallery-single fix">
                                    <img src="assets/images/<%=p.getPicture()%>" class="img-fluid" alt="Image">
                                    <div class="why-text">
                                        <h4><%= p.getName()%>
                                        </h4>
                                        <p><%= p.getDescription()%>
                                        </p>
                                        <h5><%= p.getPrice()%>€</h5>
                                        <a class="nav-link" href="#">Ajouter</a>
                                    </div>
                                </div>
                            </div>
                            <%
                                }
                            %>

                        </div>
                    </div>
                    <div class="tab-pane fade" id="v-pills-plats" role="tabpanel"
                         aria-labelledby="v-pills-plats-tab">
                        <div class="row">
                            <%
                                for (ProductDto p : (Set<ProductDto>) session.getAttribute("listPlat")) {
                            %>
                            <div class="col-lg-4 col-md-6 special-grid "<%=new CategoryService().get(p.getIdCategory()).getName()%>>
                                <div class="gallery-single fix">
                                    <img src="assets/images/<%=p.getPicture()%>" class="img-fluid" alt="Image">
                                    <div class="why-text">
                                        <h4><%= p.getName()%>
                                        </h4>
                                        <p><%= p.getDescription()%>
                                        </p>
                                        <h5><%= p.getPrice()%>€</h5>
                                        <a class="nav-link" href="#">Ajouter</a>
                                    </div>
                                </div>
                            </div>
                            <%
                                }
                            %>

                        </div>
                    </div>
                    <div class="tab-pane fade" id="v-pills-desserts" role="tabpanel"
                         aria-labelledby="v-pills-desserts-tab">
                        <div class="row">
                            <%
                                for (ProductDto p : (Set<ProductDto>) session.getAttribute("listDessert")) {
                            %>
                            <div class="col-lg-4 col-md-6 special-grid "<%=new CategoryService().get(p.getIdCategory()).getName()%>>
                                <div class="gallery-single fix">
                                    <img src="assets/images/<%=p.getPicture()%>" class="img-fluid" alt="Image">
                                    <div class="why-text">
                                        <h4><%= p.getName()%>
                                        </h4>
                                        <p><%= p.getDescription()%>
                                        </p>
                                        <h5><%= p.getPrice()%>€</h5>
                                        <a class="nav-link" href="#">Ajouter</a>
                                    </div>
                                </div>
                            </div>
                            <%
                                }
                            %>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
<!-- End Menu -->

<%@include file="footer.jsp" %>
</body>
</html>


