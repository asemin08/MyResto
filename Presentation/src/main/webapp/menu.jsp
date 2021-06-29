<%--
  Created by IntelliJ IDEA.
  eu.ensup.myresto.User: A
  Date: 28/06/2021
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="header.jsp"%>

<!-- Start Menu -->
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
                    <a class="nav-link active" id="v-pills-home-tab" data-toggle="pill" href="#v-pills-home" role="tab" aria-controls="v-pills-home" aria-selected="true">All</a>
                    <a class="nav-link" id="v-pills-profile-tab" data-toggle="pill" href="#v-pills-profile" role="tab" aria-controls="v-pills-profile" aria-selected="false">Drinks</a>
                    <a class="nav-link" id="v-pills-messages-tab" data-toggle="pill" href="#v-pills-messages" role="tab" aria-controls="v-pills-messages" aria-selected="false">Lunch</a>
                    <a class="nav-link" id="v-pills-settings-tab" data-toggle="pill" href="#v-pills-settings" role="tab" aria-controls="v-pills-settings" aria-selected="false">Dinner</a>
                </div>
            </div>

            <div class="col-9">
                <div class="tab-content" id="v-pills-tabContent">
                    <div class="tab-pane fade show active" id="v-pills-home" role="tabpanel" aria-labelledby="v-pills-home-tab">
                        <div class="row">
                            <div class="col-lg-4 col-md-6 special-grid drinks">
                                <div class="gallery-single fix">
                                    <img src="assets/images/img-01.jpg" class="img-fluid" alt="Image">
                                    <div class="why-text">
                                        <h4>Special Drinks 1</h4>
                                        <p>Sed id magna vitae eros sagittis euismod.</p>
                                        <h5> $7.79</h5>
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-4 col-md-6 special-grid drinks">
                                <div class="gallery-single fix">
                                    <img src="assets/images/img-02.jpg" class="img-fluid" alt="Image">
                                    <div class="why-text">
                                        <h4>Special Drinks 2</h4>
                                        <p>Sed id magna vitae eros sagittis euismod.</p>
                                        <h5> $9.79</h5>
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-4 col-md-6 special-grid drinks">
                                <div class="gallery-single fix">
                                    <img src="assets/images/img-03.jpg" class="img-fluid" alt="Image">
                                    <div class="why-text">
                                        <h4>Special Drinks 3</h4>
                                        <p>Sed id magna vitae eros sagittis euismod.</p>
                                        <h5> $10.79</h5>
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-4 col-md-6 special-grid lunch">
                                <div class="gallery-single fix">
                                    <img src="assets/images/img-04.jpg" class="img-fluid" alt="Image">
                                    <div class="why-text">
                                        <h4>Special Lunch 1</h4>
                                        <p>Sed id magna vitae eros sagittis euismod.</p>
                                        <h5> $15.79</h5>
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-4 col-md-6 special-grid lunch">
                                <div class="gallery-single fix">
                                    <img src="assets/images/img-05.jpg" class="img-fluid" alt="Image">
                                    <div class="why-text">
                                        <h4>Special Lunch 2</h4>
                                        <p>Sed id magna vitae eros sagittis euismod.</p>
                                        <h5> $18.79</h5>
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-4 col-md-6 special-grid lunch">
                                <div class="gallery-single fix">
                                    <img src="assets/images/img-06.jpg" class="img-fluid" alt="Image">
                                    <div class="why-text">
                                        <h4>Special Lunch 3</h4>
                                        <p>Sed id magna vitae eros sagittis euismod.</p>
                                        <h5> $20.79</h5>
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-4 col-md-6 special-grid dinner">
                                <div class="gallery-single fix">
                                    <img src="assets/images/img-07.jpg" class="img-fluid" alt="Image">
                                    <div class="why-text">
                                        <h4>Special Dinner 1</h4>
                                        <p>Sed id magna vitae eros sagittis euismod.</p>
                                        <h5> $25.79</h5>
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-4 col-md-6 special-grid dinner">
                                <div class="gallery-single fix">
                                    <img src="assets/images/img-08.jpg" class="img-fluid" alt="Image">
                                    <div class="why-text">
                                        <h4>Special Dinner 2</h4>
                                        <p>Sed id magna vitae eros sagittis euismod.</p>
                                        <h5> $22.79</h5>
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-4 col-md-6 special-grid dinner">
                                <div class="gallery-single fix">
                                    <img src="assets/images/img-09.jpg" class="img-fluid" alt="Image">
                                    <div class="why-text">
                                        <h4>Special Dinner 3</h4>
                                        <p>Sed id magna vitae eros sagittis euismod.</p>
                                        <h5> $24.79</h5>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="tab-pane fade" id="v-pills-profile" role="tabpanel" aria-labelledby="v-pills-profile-tab">
                        <div class="row">
                            <div class="col-lg-4 col-md-6 special-grid drinks">
                                <div class="gallery-single fix">
                                    <img src="assets/images/img-01.jpg" class="img-fluid" alt="Image">
                                    <div class="why-text">
                                        <h4>Special Drinks 1</h4>
                                        <p>Sed id magna vitae eros sagittis euismod.</p>
                                        <h5> $7.79</h5>
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-4 col-md-6 special-grid drinks">
                                <div class="gallery-single fix">
                                    <img src="assets/images/img-02.jpg" class="img-fluid" alt="Image">
                                    <div class="why-text">
                                        <h4>Special Drinks 2</h4>
                                        <p>Sed id magna vitae eros sagittis euismod.</p>
                                        <h5> $9.79</h5>
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-4 col-md-6 special-grid drinks">
                                <div class="gallery-single fix">
                                    <img src="assets/images/img-03.jpg" class="img-fluid" alt="Image">
                                    <div class="why-text">
                                        <h4>Special Drinks 3</h4>
                                        <p>Sed id magna vitae eros sagittis euismod.</p>
                                        <h5> $10.79</h5>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="tab-pane fade" id="v-pills-messages" role="tabpanel" aria-labelledby="v-pills-messages-tab">
                        <div class="row">
                            <div class="col-lg-4 col-md-6 special-grid lunch">
                                <div class="gallery-single fix">
                                    <img src="assets/images/img-04.jpg" class="img-fluid" alt="Image">
                                    <div class="why-text">
                                        <h4>Special Lunch 1</h4>
                                        <p>Sed id magna vitae eros sagittis euismod.</p>
                                        <h5> $15.79</h5>
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-4 col-md-6 special-grid lunch">
                                <div class="gallery-single fix">
                                    <img src="assets/images/img-05.jpg" class="img-fluid" alt="Image">
                                    <div class="why-text">
                                        <h4>Special Lunch 2</h4>
                                        <p>Sed id magna vitae eros sagittis euismod.</p>
                                        <h5> $18.79</h5>
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-4 col-md-6 special-grid lunch">
                                <div class="gallery-single fix">
                                    <img src="assets/images/img-06.jpg" class="img-fluid" alt="Image">
                                    <div class="why-text">
                                        <h4>Special Lunch 3</h4>
                                        <p>Sed id magna vitae eros sagittis euismod.</p>
                                        <h5> $20.79</h5>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane fade" id="v-pills-settings" role="tabpanel" aria-labelledby="v-pills-settings-tab">
                        <div class="row">
                            <div class="col-lg-4 col-md-6 special-grid dinner">
                                <div class="gallery-single fix">
                                    <img src="assets/images/img-07.jpg" class="img-fluid" alt="Image">
                                    <div class="why-text">
                                        <h4>Special Dinner 1</h4>
                                        <p>Sed id magna vitae eros sagittis euismod.</p>
                                        <h5> $25.79</h5>
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-4 col-md-6 special-grid dinner">
                                <div class="gallery-single fix">
                                    <img src="assets/images/img-08.jpg" class="img-fluid" alt="Image">
                                    <div class="why-text">
                                        <h4>Special Dinner 2</h4>
                                        <p>Sed id magna vitae eros sagittis euismod.</p>
                                        <h5> $22.79</h5>
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-4 col-md-6 special-grid dinner">
                                <div class="gallery-single fix">
                                    <img src="assets/images/img-09.jpg" class="img-fluid" alt="Image">
                                    <div class="why-text">
                                        <h4>Special Dinner 3</h4>
                                        <p>Sed id magna vitae eros sagittis euismod.</p>
                                        <h5> $24.79</h5>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
<!-- End Menu -->

<%@include file="footer.jsp"%>
</body>
</html>


