<%--
  Created by IntelliJ IDEA.
  User: A
  Date: 28/06/2021
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<div class="reservation-box">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="heading-title text-center">
                    <h2>S'authentifier</h2>

                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12 col-sm-12 col-xs-12 ">
                <div class="contact-block">
                    <form id="contactForm">
                        <div class="row">

                            <div class="col-md-6">


                                <div class="col-md-12">
                                    <div class="form-group">
                                        <input type="text" placeholder="Email" id="email" class="form-control" name="email" required data-error="Entrer votre email">
                                        <div class="help-block with-errors"></div>
                                    </div>
                                </div>



                                <div class="col-md-12">
                                    <div class="form-group">
                                        <input type="password" placeholder="Mot de Passe" id="adresse" class="form-control" name="Mot de Passe" required data-error="Entrer votre mot de Passe">
                                        <div class="help-block with-errors"></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-12">
                                <div class="submit-button text-center">
                                    <button class="btn btn-common" id="submitd" type="submit">Se Connecter</button>

                                    <div class="clearfix"></div>
                                </div>

                            </div>
                        </div>
                    </form>
                    <div class="col-md-12">
                        <div class="submit-button text-center">
                            <a href="register">  <button class="btn " id="submit" type="submit">Créer un compte</button></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="footer.jsp"%>