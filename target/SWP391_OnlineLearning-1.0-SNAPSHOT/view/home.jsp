<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="en">

    <head>

        <!-- META ============================================= -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>E-Learning : Education & Course</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="keywords" content="" />
        <meta name="author" content="" />
        <meta name="robots" content="" />

        <!-- DESCRIPTION -->
        <meta name="description" content="EduChamp : Education HTML Template" />

        <!-- OG -->
        <meta property="og:title" content="EduChamp : Education HTML Template" />
        <meta property="og:description" content="EduChamp : Education HTML Template" />
        <meta property="og:image" content="" />
        <meta name="format-detection" content="telephone=no">

        <!-- FAVICONS ICON ============================================= -->
        <link rel="icon" href="assets/images/logoBlack.png" type="image/x-icon" />
        <link rel="shortcut icon" type="image/x-icon" href="assets/images/logoBlack.png" />

        <!-- PAGE TITLE HERE ============================================= -->

        <!-- MOBILE SPECIFIC ============================================= -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!--[if lt IE 9]>
        <script src="assets/js/html5shiv.min.js"></script>
        <script src="assets/js/respond.min.js"></script>
        <![endif]-->

        <!-- All PLUGINS CSS ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/assets.css">

        <!-- TYPOGRAPHY ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/typography.css">

        <!-- SHORTCODES ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/shortcodes/shortcodes.css">

        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/style.css">
        <link class="skin" rel="stylesheet" type="text/css" href="assets/css/color/color-1.css">

        <!-- REVOLUTION SLIDER CSS ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/vendors/revolution/css/layers.css">
        <link rel="stylesheet" type="text/css" href="assets/vendors/revolution/css/settings.css">
        <link rel="stylesheet" type="text/css" href="assets/vendors/revolution/css/navigation.css">
        <!-- REVOLUTION SLIDER END -->	
        <style>
            .loader {
                position: fixed;
                top: 0;
                left: 0;
                width: 100vw;
                height: 100vh;
                display: flex;
                justify-content: center;
                align-items: center;
                background-color: #f7f9fb;
                transition: opacity 0.75s, visibility 0.75s;
            }

            .loader-hidden {
                opacity: 0;
                visibility: hidden;
            }

            .loader::after {
                content: "";
                width: 75px;
                height: 75px;
                border: 15px solid #dddddd;
                border-top-color: #7449f5;
                border-radius: 50%;
                animation: loading 0.75s ease infinite;
            }

            @keyframes loading {
                from {
                    transform: rotate(0turn);
                }
                to {
                    transform: rotate(1turn);
                }
            }
            .item .cours-bx .action-box img {
                width: 300px; /* Thay th? gi� tr? n�y b?ng k�ch th??c mong mu?n */
                height: 200px; /* Thay th? gi� tr? n�y b?ng k�ch th??c mong mu?n */
                object-fit: cover;
            }
            .item .cours-bx .action-box img {
                width: 300px; /* Thay th? gi� tr? n�y b?ng k�ch th??c mong mu?n */
                height: 200px; /* Thay th? gi� tr? n�y b?ng k�ch th??c mong mu?n */
                object-fit: cover;
            }
        </style>
    </head>
    <body id="bg">
        <div class="page-wraper">
            <!--<div id="loading-icon-bx"></div>-->
            <div class="loader" id="loadingContainer"></div>
            <!-- Header Top ==== -->
            <jsp:include page="publicheader.jsp"/>
            <!-- Header Top END ==== -->
            <!-- Content -->
            <div class="page-content bg-white">
                <!-- Main Slider -->
                <div class="rev-slider">
                    <div id="rev_slider_486_1_wrapper" class="rev_slider_wrapper fullwidthbanner-container" data-alias="news-gallery36" data-source="gallery" style="margin:0px auto;background-color:#ffffff;padding:0px;margin-top:0px;margin-bottom:0px;">
                        <!-- START REVOLUTION SLIDER 5.3.0.2 fullwidth mode -->
                        <div id="rev_slider_486_1" class="rev_slider fullwidthabanner" style="display:none;" data-version="5.3.0.2">

                            <ul>	<!-- SLIDE  -->
                                <c:forEach items="${homeSliders}" var="h">
                                    <c:set var="i" value="${i+1}"/>

                                    <li data-index="rs-${i}00" 
                                        data-transition="parallaxvertical" 
                                        data-slotamount="default" 
                                        data-hideafterloop="0" 
                                        data-hideslideonmobile="off" 
                                        data-easein="default" 
                                        data-easeout="default" 
                                        data-masterspeed="default" 
                                        data-thumb="error-404.html" 
                                        data-rotate="0" 
                                        data-fstransition="fade" 
                                        data-fsmasterspeed="1500" 
                                        data-fsslotamount="7" 
                                        data-saveperformance="off" 
                                        data-title="A STUDY ON HAPPINESS" 
                                        data-param1="" data-param2="" 
                                        data-param3="" data-param4="" 
                                        data-param5="" data-param6="" 
                                        data-param7="" data-param8="" 
                                        data-param9="" data-param10="" 
                                        data-description="Science says that Women are generally happier">
                                        <!-- MAIN IMAGE -->
                                        <img src="${h.img}" alt="" 
                                             data-bgposition="center center" 
                                             data-bgfit="cover" 
                                             data-bgrepeat="no-repeat" 
                                             data-bgparallax="10" 
                                             class="rev-slidebg" 
                                             data-no-retina />

                                        <!-- LAYER NR. 1 -->
                                        <div class="tp-caption tp-shape tp-shapewrapper " 
                                             id="slide-${i}00-layer-1" 
                                             data-x="['center','center','center','center']" data-hoffset="['0','0','0','0']" 
                                             data-y="['middle','middle','middle','middle']" data-voffset="['0','0','0','0']" 
                                             data-width="full"
                                             data-height="full"
                                             data-whitespace="nowrap"
                                             data-type="shape" 
                                             data-basealign="slide" 
                                             data-responsive_offset="off" 
                                             data-responsive="off"
                                             data-frames='[{"from":"opacity:0;","speed":1,"to":"o:1;","delay":0,"ease":"Power4.easeOut"},{"delay":"wait","speed":1,"to":"opacity:0;","ease":"Power4.easeOut"}]'
                                             data-textAlign="['left','left','left','left']"
                                             data-paddingtop="[0,0,0,0]"
                                             data-paddingright="[0,0,0,0]"
                                             data-paddingbottom="[0,0,0,0]"
                                             data-paddingleft="[0,0,0,0]"
                                             style="z-index: 5;background-color:rgba(2, 0, 11, 0.80);border-color:rgba(0, 0, 0, 0);border-width:0px;"> </div>	
                                        <!-- LAYER NR. 2 -->
                                        <div class="tp-caption Newspaper-Title   tp-resizeme" 
                                             id="slide-${i}00-layer-2" 
                                             data-x="['center','center','center','center']" 
                                             data-hoffset="['0','0','0','0']" 
                                             data-y="['top','top','top','top']" 
                                             data-voffset="['250','250','250','240']" 
                                             data-fontsize="['50','50','50','30']"
                                             data-lineheight="['55','55','55','35']"
                                             data-width="full"
                                             data-height="none"
                                             data-whitespace="normal"
                                             data-type="text" 
                                             data-responsive_offset="on" 
                                             data-frames='[{"from":"y:[-100%];z:0;rX:0deg;rY:0;rZ:0;sX:1;sY:1;skX:0;skY:0;","mask":"x:0px;y:0px;s:inherit;e:inherit;","speed":1500,"to":"o:1;","delay":1000,"ease":"Power3.easeInOut"},{"delay":"wait","speed":1000,"to":"auto:auto;","mask":"x:0;y:0;s:inherit;e:inherit;","ease":"Power3.easeInOut"}]'
                                             data-textAlign="['center','center','center','center']"
                                             data-paddingtop="[0,0,0,0]"
                                             data-paddingright="[0,0,0,0]"
                                             data-paddingbottom="[10,10,10,10]"
                                             data-paddingleft="[0,0,0,0]"
                                             style="z-index: 6; font-family:rubik; font-weight:700; text-align:center; white-space: normal;">
                                            ${h.title}
                                        </div>

                                        <!-- LAYER NR. 3 -->
                                        <div class="tp-caption Newspaper-Subtitle   tp-resizeme" 
                                             id="slide-${i}00-layer-3" 
                                             data-x="['center','center','center','center']" 
                                             data-hoffset="['0','0','0','0']" 
                                             data-y="['top','top','top','top']" 
                                             data-voffset="['210','210','210','210']" 
                                             data-width="none"
                                             data-height="none"
                                             data-whitespace="nowrap"
                                             data-type="text" 
                                             data-responsive_offset="on"
                                             data-frames='[{"from":"y:[-100%];z:0;rX:0deg;rY:0;rZ:0;sX:1;sY:1;skX:0;skY:0;","mask":"x:0px;y:0px;s:inherit;e:inherit;","speed":1500,"to":"o:1;","delay":1000,"ease":"Power3.easeInOut"},{"delay":"wait","speed":1000,"to":"auto:auto;","mask":"x:0;y:0;s:inherit;e:inherit;","ease":"Power3.easeInOut"}]'
                                             data-textAlign="['left','left','left','left']"
                                             data-paddingtop="[0,0,0,0]"
                                             data-paddingright="[0,0,0,0]"
                                             data-paddingbottom="[0,0,0,0]"
                                             data-paddingleft="[0,0,0,0]"
                                             style="z-index: 7; white-space: nowrap; color:#fff; font-family:rubik; font-size:18px; font-weight:400;">
                                            <!--									Batter Education For A Better -->
                                        </div>

                                        <!-- LAYER NR. 3 -->
                                        <div class="tp-caption Newspaper-Subtitle   tp-resizeme" 
                                             id="slide-${i}00-layer-4" 
                                             data-x="['center','center','center','center']" 
                                             data-hoffset="['0','0','0','0']" 
                                             data-y="['top','top','top','top']" 
                                             data-voffset="['320','320','320','290']" 
                                             data-width="['800','800','700','420']"
                                             data-height="['100','100','100','120']"
                                             data-whitespace="unset"
                                             data-type="text" 
                                             data-responsive_offset="on"
                                             data-frames='[{"from":"y:[-100%];z:0;rX:0deg;rY:0;rZ:0;sX:1;sY:1;skX:0;skY:0;","mask":"x:0px;y:0px;s:inherit;e:inherit;","speed":1500,"to":"o:1;","delay":1000,"ease":"Power3.easeInOut"},{"delay":"wait","speed":1000,"to":"auto:auto;","mask":"x:0;y:0;s:inherit;e:inherit;","ease":"Power3.easeInOut"}]'
                                             data-textAlign="['center','center','center','center']"
                                             data-paddingtop="[0,0,0,0]"
                                             data-paddingright="[0,0,0,0]"
                                             data-paddingbottom="[0,0,0,0]"
                                             data-paddingleft="[0,0,0,0]"
                                             style="z-index: 7; text-transform:capitalize; white-space: unset; color:#fff; font-family:rubik; font-size:18px; line-height:28px; font-weight:400;">
                                            ${h.description}
                                        </div>
                                        <!-- LAYER NR. 4 -->
                                        <div class="tp-caption Newspaper-Button rev-btn " 
                                             id="slide-${i}00-layer-5" 
                                             data-x="['center','center','center','center']" 
                                             data-hoffset="['90','80','75','90']" 
                                             data-y="['top','top','top','top']" 
                                             data-voffset="['400','400','400','420']" 
                                             data-width="none"
                                             data-height="none"
                                             data-whitespace="nowrap"
                                             data-type="button" 
                                             data-responsive_offset="on" 
                                             data-responsive="off"
                                             data-frames='[{"from":"y:[-100%];z:0;rX:0deg;rY:0;rZ:0;sX:1;sY:1;skX:0;skY:0;","mask":"x:0px;y:0px;","speed":1500,"to":"o:1;","delay":1000,"ease":"Power3.easeInOut"},{"delay":"wait","speed":1000,"to":"auto:auto;","mask":"x:0;y:0;","ease":"Power3.easeInOut"},{"frame":"hover","speed":"300","ease":"Power1.easeInOut","to":"o:1;rX:0;rY:0;rZ:0;z:0;","style":"c:rgba(0, 0, 0, 1.00);bg:rgba(255, 255, 255, 1.00);bc:rgba(255, 255, 255, 1.00);bw:1px 1px 1px 1px;"}]'
                                             data-textAlign="['center','center','center','center']"
                                             data-paddingtop="[12,12,12,12]"
                                             data-paddingright="[30,35,35,15]"
                                             data-paddingbottom="[12,12,12,12]"
                                             data-paddingleft="[30,35,35,15]"
                                             style="z-index: 8; white-space: nowrap; outline:none;box-shadow:none;box-sizing:border-box;-moz-box-sizing:border-box;-webkit-box-sizing:border-box;cursor:pointer; background-color:var(--primary) !important; border:0; border-radius:30px; margin-right:5px;">READ MORE </div>
                                        <div class="tp-caption Newspaper-Button rev-btn" 
                                             id="slide-${i}00-layer-6" 
                                             data-x="['center','center','center','center']" 
                                             data-hoffset="['-90','-80','-75','-90']" 
                                             data-y="['top','top','top','top']" 
                                             data-voffset="['400','400','400','420']" 
                                             data-width="none"
                                             data-height="none"
                                             data-whitespace="nowrap"
                                             data-type="button" 
                                             data-responsive_offset="on" 
                                             data-responsive="off"
                                             data-frames='[{"from":"y:[-100%];z:0;rX:0deg;rY:0;rZ:0;sX:1;sY:1;skX:0;skY:0;","mask":"x:0px;y:0px;","speed":1500,"to":"o:1;","delay":1000,"ease":"Power3.easeInOut"},{"delay":"wait","speed":1000,"to":"auto:auto;","mask":"x:0;y:0;","ease":"Power3.easeInOut"},{"frame":"hover","speed":"300","ease":"Power1.easeInOut","to":"o:1;rX:0;rY:0;rZ:0;z:0;","style":"c:rgba(0, 0, 0, 1.00);bg:rgba(255, 255, 255, 1.00);bc:rgba(255, 255, 255, 1.00);bw:1px 1px 1px 1px;"}]'
                                             data-textAlign="['center','center','center','center']"
                                             data-paddingtop="[12,12,12,12]"
                                             data-paddingright="[30,35,35,15]"
                                             data-paddingbottom="[12,12,12,12]"
                                             data-paddingleft="[30,35,35,15]"
                                             style="z-index: 8; white-space: nowrap; outline:none;box-shadow:none;box-sizing:border-box;-moz-box-sizing:border-box;-webkit-box-sizing:border-box;cursor:pointer; border-radius:30px;">CONTACT US</div>
                                    </li>

                                </c:forEach>


                            </ul>
                        </div><!-- END REVOLUTION SLIDER -->  
                    </div>  
                </div>  
                <!-- Main Slider -->
                <div class="content-block">

                    <!-- Our Services -->
                    <div class="section-area content-inner service-info-bx">
                        <div class="container">
                            <div class="row">
                                <div class="col-lg-4 col-md-4 col-sm-6">
                                    <div class="service-bx">
                                        <div class="action-box">
                                            <img src="assets/images/our-services/pic1.jpg" alt="">
                                        </div>
                                        <div class="info-bx text-center">
                                            <div class="feature-box-sm radius bg-white">
                                                <i class="fa fa-bank text-primary"></i>
                                            </div>
                                            <h4><a href="bloglist">Expert's Blog</a></h4>
                                            <a href="bloglist" class="btn radius-xl">View More</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-4 col-sm-6">
                                    <div class="service-bx">
                                        <div class="action-box">
                                            <img src="assets/images/our-services/pic2.jpg" alt="">
                                        </div>
                                        <div class="info-bx text-center">
                                            <div class="feature-box-sm radius bg-white">
                                                <i class="fa fa-book text-primary"></i>
                                            </div>
                                            <h4><a href="courselist">Learn Courses Online</a></h4>
                                            <a href="courselist" class="btn radius-xl">View More</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-4 col-sm-12">
                                    <div class="service-bx m-b0">
                                        <div class="action-box">
                                            <img src="assets/images/our-services/pic3.jpg" alt="">
                                        </div>
                                        <div class="info-bx text-center">
                                            <div class="feature-box-sm radius bg-white">
                                                <i class="fa fa-file-text-o text-primary"></i>
                                            </div>
                                            <h4><a href="#">Ask for help</a></h4>
                                            <a href="#" class="btn radius-xl">View More</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Our Services END -->

                    <!-- Popular Courses -->
                    <div class="section-area section-sp2 popular-courses-bx">
                        <div class="container">
                            <div class="row">
                                <div class="col-md-12 heading-bx left">
                                    <h2 class="title-head">Recently <span>Courses</span></h2>
                                    <p>It is a long established fact that a reader will be distracted by the readable content of a page</p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="courses-carousel owl-carousel owl-btn-1 col-12 p-lr0">
                                    <c:forEach items="${requestScope.courseList}" var="c"> 
                                        <div class="item">
                                            <div class="cours-bx">
                                                <div class="action-box">
                                                    <img src="${c.img}" alt=""/>
                                                    <a href="coursedetail?id=${c.courseId}" class="btn">Read More</a>
                                                </div>
                                                <div class="info-bx text-center" class="course-content">
                                                    <h5><a href="coursedetail?id=${c.courseId}">${c.name}</a></h5>
                                                    <span>${c.category.name}</span>
                                                </div>
                                                <div class="cours-more-info">
                                                    <div class="review">
                                                        <span>${c.level.name}</span>
                                                        <ul class="cours-star">
                                                            <!--                                                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                                                                                                                <li class="active"><i class="fa fa-star"></i></li>
                                                                                                                                                <li class="active"><i class="fa fa-star"></i></li>
                                                                                                                                                <li><i class="fa fa-star"></i></li>                                                                                                                                   <li><i class="fa fa-star"></i></li>-->
                                                        </ul>
                                                    </div>
                                                    <div class="price">
                                                        <!--                                                                            <del>$190</del>-->
                                                        <h5><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${c.price}"/> d</h5>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>


                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Popular Courses END -->

                    <!-- Recent News -->
                    <div class="section-area section-sp2">
                        <div class="container">
                            <div class="row">
                                <div class="col-md-12 heading-bx left">
                                    <h2 class="title-head">Recently <span>Blogs</span></h2>
                                    <p>It is a long established fact that a reader will be distracted by the readable content of a page</p>
                                </div>
                            </div>
                            <div class="recent-news-carousel owl-carousel owl-btn-1 col-12 p-lr0">
                                <c:forEach items="${requestScope.blogList}" var="b">
                                    <div class="item">
                                        <div class="recent-news">
                                            
                                                
                                            
                                            <div class="action-box">
                                                <a href="blogdetail?id=${b.blogId}"><img src="${b.img}" alt=""/></a>
                                            </div>
<!--                                            <div class="info-bx" style="height:400px; position: relative; border-bottom: none;">-->
                                            <div class="info-bx">    
                                                <ul class="media-post">
                                                    <li><i class="fa fa-calendar"></i>${b.createdTime}</li>
                                                </ul>
                                                <div class="blog-content">
                                                    <h5 class="post-title"><a href="blogdetail?id=${b.blogId}">${b.title}</a></h5>

                                                    <p style="height: 50%; border-bottom: none;">${b.quickReview}</p>
                                                </div>
                                                <div class="post-extra">
                                                        <a class="btn-link">${b.category.name}</a>
                                                        <a href="#" class="comments-bx"><i class="fa fa-user"></i>By ${b.author.name}</a>
                                                </div>
                                                
                                                
                                            </div>  
                                        </div>
                                    </div>
                                </c:forEach>

                            </div>
                        </div>
                    </div>
                    
                    
                    <!-- Recent News End -->

                </div>
                <!-- contact area END -->
            </div>
            <!-- Content END-->
            <!-- Footer ==== -->
            <jsp:include page="publicfooter.jsp" />
            <!-- Footer END ==== -->
            <button class="back-to-top fa fa-chevron-up" ></button>
        </div>
        <script>
            window.addEventListener("load", () => {
                const loader = document.querySelector(".loader");
                loader.classList.add("loader-hidden");
                loader.addEventListener("transitioned", () => {
                    document.body.removeChild("loader");
                })
            })
        </script>
        <script>
            // S? d?ng JavaScript ?? thi?t l?p chi?u cao l?n nh?t
            window.onload = function () {
                var items = document.querySelectorAll('.blog-content');
                var maxHeight = 0;

                items.forEach(function (item) {
                    var itemHeight = item.clientHeight;
                    if (itemHeight > maxHeight) {
                        maxHeight = itemHeight;
                    }
                });

                // �p d?ng chi?u cao l?n nh?t cho t?t c? c�c item
                items.forEach(function (item) {
                    item.style.height = maxHeight + 'px';
                });
                var courses = document.querySelectorAll('.course-content');
                var maxHeightCourses = 0;

                courses.forEach(function (course) {
                    var courseHeight = course.clientHeight;
                    if (courseHeight > maxHeightCourses) {
                        maxHeightCourses = courseHeight;
                    }
                });

                courses.forEach(function (course) {
                    course.style.height = maxHeightCourses + 'px';
                });
            };
        </script>
        
        <!-- External JavaScripts -->
        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/vendors/bootstrap/js/popper.min.js"></script>
        <script src="assets/vendors/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/vendors/bootstrap-select/bootstrap-select.min.js"></script>
        <script src="assets/vendors/bootstrap-touchspin/jquery.bootstrap-touchspin.js"></script>
        <script src="assets/vendors/magnific-popup/magnific-popup.js"></script>
        <script src="assets/vendors/counter/waypoints-min.js"></script>
        <script src="assets/vendors/counter/counterup.min.js"></script>
        <script src="assets/vendors/imagesloaded/imagesloaded.js"></script>
        <script src="assets/vendors/masonry/masonry.js"></script>
        <script src="assets/vendors/masonry/filter.js"></script>
        <script src="assets/vendors/owl-carousel/owl.carousel.js"></script>
        <script src="assets/js/functions.js"></script>
        <script src="assets/js/contact.js"></script>
        <script src='assets/vendors/switcher/switcher.js'></script>
        <!-- Revolution JavaScripts Files -->
        <script src="assets/vendors/revolution/js/jquery.themepunch.tools.min.js"></script>
        <script src="assets/vendors/revolution/js/jquery.themepunch.revolution.min.js"></script>
        <!-- Slider revolution 5.0 Extensions  (Load Extensions only on Local File Systems !  The following part can be removed on Server for On Demand Loading) -->
        <script src="assets/vendors/revolution/js/extensions/revolution.extension.actions.min.js"></script>
        <script src="assets/vendors/revolution/js/extensions/revolution.extension.carousel.min.js"></script>
        <script src="assets/vendors/revolution/js/extensions/revolution.extension.kenburn.min.js"></script>
        <script src="assets/vendors/revolution/js/extensions/revolution.extension.layeranimation.min.js"></script>
        <script src="assets/vendors/revolution/js/extensions/revolution.extension.migration.min.js"></script>
        <script src="assets/vendors/revolution/js/extensions/revolution.extension.navigation.min.js"></script>
        <script src="assets/vendors/revolution/js/extensions/revolution.extension.parallax.min.js"></script>
        <script src="assets/vendors/revolution/js/extensions/revolution.extension.slideanims.min.js"></script>
        <script src="assets/vendors/revolution/js/extensions/revolution.extension.video.min.js"></script>
        <script>
            jQuery(document).ready(function () {
                var ttrevapi;
                var tpj = jQuery;
                if (tpj("#rev_slider_486_1").revolution == undefined) {
                    revslider_showDoubleJqueryError("#rev_slider_486_1");
                } else {
                    ttrevapi = tpj("#rev_slider_486_1").show().revolution({
                        sliderType: "standard",
                        jsFileLocation: "assets/vendors/revolution/js/",
                        sliderLayout: "fullwidth",
                        dottedOverlay: "none",
                        delay: 9000,
                        navigation: {
                            keyboardNavigation: "on",
                            keyboard_direction: "horizontal",
                            mouseScrollNavigation: "off",
                            mouseScrollReverse: "default",
                            onHoverStop: "on",
                            touch: {
                                touchenabled: "on",
                                swipe_threshold: 75,
                                swipe_min_touches: 1,
                                swipe_direction: "horizontal",
                                drag_block_vertical: false
                            }
                            ,
                            arrows: {
                                style: "uranus",
                                enable: true,
                                hide_onmobile: false,
                                hide_onleave: false,
                                tmp: '',
                                left: {
                                    h_align: "left",
                                    v_align: "center",
                                    h_offset: 10,
                                    v_offset: 0
                                },
                                right: {
                                    h_align: "right",
                                    v_align: "center",
                                    h_offset: 10,
                                    v_offset: 0
                                }
                            },

                        },
                        viewPort: {
                            enable: true,
                            outof: "pause",
                            visible_area: "80%",
                            presize: false
                        },
                        responsiveLevels: [1240, 1024, 778, 480],
                        visibilityLevels: [1240, 1024, 778, 480],
                        gridwidth: [1240, 1024, 778, 480],
                        gridheight: [768, 600, 600, 600],
                        lazyType: "none",
                        parallax: {
                            type: "scroll",
                            origo: "enterpoint",
                            speed: 400,
                            levels: [5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 46, 47, 48, 49, 50, 55],
                            type: "scroll",
                        },
                        shadow: 0,
                        spinner: "off",
                        stopLoop: "off",
                        stopAfterLoops: -1,
                        stopAtSlide: -1,
                        shuffle: "off",
                        autoHeight: "off",
                        hideThumbsOnMobile: "off",
                        hideSliderAtLimit: 0,
                        hideCaptionAtLimit: 0,
                        hideAllCaptionAtLilmit: 0,
                        debugMode: false,
                        fallbacks: {
                            simplifyAll: "off",
                            nextSlideOnWindowFocus: "off",
                            disableFocusListener: false,
                        }
                    });
                }
            });
        </script>
    </body>

</html>
