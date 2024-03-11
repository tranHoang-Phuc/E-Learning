<%-- 
    Document   : lesson
    Created on : Feb 11, 2024, 9:29:32 PM
    Author     : tran Hoang Phuc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <!-- META ============================================= -->
	<meta charset="utf-8">
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
	<link rel="icon" href="../error-404.html" type="image/x-icon" />
	<link rel="shortcut icon" type="image/x-icon" href="adminassets/images/favicon.png" />
	
	<!-- PAGE TITLE HERE ============================================= -->
	<title>EduChamp : Education HTML Template </title>
	
	<!-- MOBILE SPECIFIC ============================================= -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!--[if lt IE 9]>
	<script src="assets/js/html5shiv.min.js"></script>
	<script src="assets/js/respond.min.js"></script>
	<![endif]-->
	
	<!-- All PLUGINS CSS ============================================= -->
	<link rel="stylesheet" type="text/css" href="adminassets/css/assets.css">
	<link rel="stylesheet" type="text/css" href="adminassets/vendors/calendar/fullcalendar.css">
	
	<!-- TYPOGRAPHY ============================================= -->
	<link rel="stylesheet" type="text/css" href="adminassets/css/typography.css">
	
	<!-- SHORTCODES ============================================= -->
	<link rel="stylesheet" type="text/css" href="adminassets/css/shortcodes/shortcodes.css">
	
	<!-- STYLESHEETS ============================================= -->
	<link rel="stylesheet" type="text/css" href="adminassets/css/style.css">
	<link rel="stylesheet" type="text/css" href="adminassets/css/dashboard.css">
	<link class="skin" rel="stylesheet" type="text/css" href="adminassets/css/color/color-1.css">
        
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <meta name="keywords" content />
        <meta name="author" content />
        <meta name="robots" content />
        <meta name="description" content="EduChamp : Education HTML Template" />
        <meta property="og:title" content="EduChamp : Education HTML Template" />
        <meta property="og:description" content="EduChamp : Education HTML Template" />
        <meta property="og:image" content />
        <meta name="format-detection" content="telephone=no">
        <link rel="icon" href="assets/images/favicon.ico" type="image/x-icon" />
        <link rel="shortcut icon" type="image/x-icon" href="assets/images/favicon.png" />
        <title>E-Learning : Education & Course </title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="assets/css/assets.css">
        <link rel="stylesheet" type="text/css" href="assets/css/typography.css">
        <link rel="stylesheet" type="text/css" href="assets/css/shortcodes/shortcodes.css">
        <link rel="stylesheet" type="text/css" href="assets/css/style.css">
        <link class="skin" rel="stylesheet" type="text/css" href="assets/css/color/color-1.css">
        
        <style>
            * {
                margin: 0;
                padding: 0;
                
                /* box-sizing: border-box; */
            }

            .header {
                display: flex;
                justify-content: space-between;
                align-items: center;
                padding: 10px 20px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
                position: fixed;
                width: 100%;
                z-index: 100;
                background-color: white;
            }

            .logo img {
                width: 100px;
            }

            .info {
                display: flex;
                align-items: center;
                margin-right: 100px;
            }

            .img-info img {
                width: 50px;
                height: 50px;
                border-radius: 50%;
            }

            .name {
                margin-left: 10px;
            }

            .arrow {
                font-size: 20px;
                padding: 10px;
                cursor: pointer;
            }

            .dropdown-list {
                display: none;
                position: absolute;
                top: 65px;
                right: 130px;
                background-color: white;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
                width: 150px;
                z-index: 4;
            }

            .dropdown-list ul {
                list-style-type: none;
                padding: 10px;
            }

            .dropdown-list ul li {
                margin-bottom: 10px;
            }

            .overlay {
                height: 100%;
                width: 0;
                position: fixed;
                z-index: 2;
                left: 0;
                top: 0;
                background-color: rgb(0, 0, 0);
                background-color: rgba(0, 0, 0, 0);
                overflow-x: hidden;
            }

            li a {
                text-decoration: none;
                color: black;
                padding-left: 10px;
            }

            .btn {
                padding: 10px;
                margin-top: 10px;
                cursor: pointer;
            }

            .left-nav {
                width: fit-content;
                height: max-content;
                position: fixed;
                top: 180px;
                left: 0;
                transform: translateY(-50%);
            }

            .body {
                padding-top: 74px;
                display: flex;
            }

            .current-lesson {
                padding-left: 70px;
                padding-top: 30px;
            }

            .learn-playlist {
                margin-left: 30px;
            }

            .list-header {
                padding: 15px 0px;
                font-size: 25px;
                width: 550px;
            }

            .lessons {
                display: none;
            }

            .chapter .chapter-name {
                padding: 15px 0px;
                font-size: 20px;
            }

            .chapter {
                border-bottom: 1px solid #dedfe0;
            }

            .chapter-name:hover {
                background-color: #edeff1;
                cursor: pointer;
            }

            .chapter h5 {
                margin-left: 10px;
            }

            .choose {
                background-color: #fcdcd3;
                cursor: pointer;
            }

            .lesson {
                padding: 10px 0px;
                font-size: 15px;
                border-bottom: 1px solid #dedfe0;
            }

            .lessons a {
                text-decoration: none;
                color: black;
            }

            .lessons a i {
                font-style: normal;
                margin-left: 20px;
            }

            .lesson:hover {
                background-color: #f1f1f1;
            }

            .ti-control-play {
                color:orangered;
                margin-right: 10px;
            }
            .ti-file {
                color: greenyellow;
                margin-right: 10px;
            }
            .ti-pencil {
                color: purple;
                margin-right: 10px;
            }
            .learn-playlist {
                overflow-x: scroll;
                width: fit-content;
            }
            .status-button {
                display: flex;
                position: relative;
            }
            #next {
                position: absolute;
                right: 0px;
            }
            #mark {
                position: absolute;
                left: 50%;
                transform: translateX(-50%);
            }
            .widget-inner a {
                display: inline-block;
                margin-right: 10px; /* Điều này có thể được điều chỉnh tùy thuộc vào khoảng cách bạn muốn giữa các thẻ a */
                margin-bottom: 10px;
            }
            #finish-attempt {
                display: block;
                margin-top: 10px; /* Điều này có thể được điều chỉnh tùy thuộc vào khoảng cách bạn muốn giữa "Finish attempt" và các thẻ khác */
            }
            .answer{
                margin-bottom: 10px;
            }
            .wc-title h4{
                line-height: 2;
            }
            .navigation-button{
                position: relative;
                margin-top: 50px;
            }
            .btn:hover{
                color: white;
            }
            .previous-btn{
                position: absolute;
                bottom: 20px;
                left: 20px;
            }
            .next-btn{
                position: absolute;
                bottom: 20px;
                right: 20px;
            }
            .quiz-navigation{
                padding: 3px;
                border: 1px solid;
                border-radius: 5px;
            }
            .selected-question{
                padding: 3px;
                border: 4px solid;
                border-radius: 5px;
            }
            .display-trueanswer{
                background-color: #FFCC99;
                margin: 0 30px 100px 30px;
            }
            a {
            text-decoration: none; /* Loại bỏ gạch dưới mặc định của liên kết */
            transition: text-decoration 0.3s; /* Tạo hiệu ứng chuyển động cho gạch dưới */
          }

          a:hover {
            text-decoration: underline; /* Thêm gạch dưới khi trỏ vào liên kết */
          }
        </style>
        
    </head>

    <body>
        <div id="myNav" class="overlay" onclick="closeNav()">
        </div>

        <div class="header">
            <div class="logo">
                <img src="assets/images/logoBlack.png" alt="logo">
            </div>
            <div class="info" style="padding: 20px">
                <div class="img-info">
                    <span><img src="${sessionScope.user.img}"
                               alt="logo">
                    </span>
                </div>
                <div class="name">
                    <span>${sessionScope.user.name}</span>
                </div>
                <div class="arrow" onclick="toggleDropdown()">
                    <span><svg xmlns="http://www.w3.org/2000/svg"
                               width="16"
                               height="16" fill="currentColor"
                               class="bi bi-caret-down-fill" viewBox="0 0 16 16">
                        <path
                            d="M7.247 11.14 2.451 5.658C1.885 5.013 2.345 4 3.204 4h9.592a1 1 0 0 1 .753 1.659l-4.796 5.48a1 1 0 0 1-1.506 0z" />
                        </svg></span>
                </div>
                <div class="dropdown-list" id="dropdownList">
                    <ul>
                        <li><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
                            <path
                                d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6m2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0m4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4m-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10s-3.516.68-4.168 1.332c-.678.678-.83 1.418-.832 1.664z" />
                            </svg><a href="editprofile">Profile</a></li>
                        <li><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box-arrow-right" viewBox="0 0 16 16">
                            <path fill-rule="evenodd"
                                  d="M10 12.5a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v2a.5.5 0 0 0 1 0v-2A1.5 1.5 0 0 0 9.5 2h-8A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-2a.5.5 0 0 0-1 0z" />
                            <path fill-rule="evenodd"
                                  d="M15.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 0 0-.708.708L14.293 7.5H5.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708z" />
                            </svg><a href="logout">Logout</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="body">
            <div class="left-nav">
                <ul>
                    <a href="home">
                        <li class="btn">
                            <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-house" viewBox="0 0 16 16">
                            <path
                                d="M8.707 1.5a1 1 0 0 0-1.414 0L.646 8.146a.5.5 0 0 0 .708.708L2 8.207V13.5A1.5 1.5 0 0 0 3.5 15h9a1.5 1.5 0 0 0 1.5-1.5V8.207l.646.647a.5.5 0 0 0 .708-.708L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293zM13 7.207V13.5a.5.5 0 0 1-.5.5h-9a.5.5 0 0 1-.5-.5V7.207l5-5z" />
                            </svg>
                        </li>
                    </a> <br>
                    <a href="bloglist">
                        <li class="btn">
                            <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-book" viewBox="0 0 16 16">
                            <path
                                d="M1 2.828c.885-.37 2.154-.769 3.388-.893 1.33-.134 2.458.063 3.112.752v9.746c-.935-.53-2.12-.603-3.213-.493-1.18.12-2.37.461-3.287.811zm7.5-.141c.654-.689 1.782-.886 3.112-.752 1.234.124 2.503.523 3.388.893v9.923c-.918-.35-2.107-.692-3.287-.81-1.094-.111-2.278-.039-3.213.492zM8 1.783C7.015.936 5.587.81 4.287.94c-1.514.153-3.042.672-3.994 1.105A.5.5 0 0 0 0 2.5v11a.5.5 0 0 0 .707.455c.882-.4 2.303-.881 3.68-1.02 1.409-.142 2.59.087 3.223.877a.5.5 0 0 0 .78 0c.633-.79 1.814-1.019 3.222-.877 1.378.139 2.8.62 3.681 1.02A.5.5 0 0 0 16 13.5v-11a.5.5 0 0 0-.293-.455c-.952-.433-2.48-.952-3.994-1.105C10.413.809 8.985.936 8 1.783" />
                            </svg>
                        </li>
                    </a>

                </ul>
            </div>
            
                
            
        </div>
        <div class="row" style="margin-top: 100px ;margin-left:120px">
            <div class="col-lg-8 m-b30">
                <div class="widget-box">
                    <div class="wc-title">
                        <h4>Question ${requestScope.index}: ${requestScope.question.content}</h4>
                    </div>
                    <div class="widget-inner" style="margin-left: 50px">
                        <p>Select
                            <c:if test="${requestScope.numOfAnswer eq 1}">
                                one
                            </c:if>
                            <c:if test="${requestScope.numOfAnswer eq 2}">
                                two
                            </c:if>
                            <c:if test="${requestScope.numOfAnswer eq 3}">
                                three
                            </c:if>
                            .</p>
                        <form id="answerForm" action="quizlesson" method="post">
                            <c:forEach items="${requestScope.answerList}" var="a">
                                <input class="answer" type="checkbox" name="selectedAnswers" value="${a.answerId}" disabled
                                    <c:forEach items="${requestScope.answersQuestion}" var="aq">
                                        <c:if test="${a.answerId eq aq.answerId}">
                                            checked="check"
                                        </c:if>
                                    </c:forEach>
                                        
                                      
                                       > ${a.content} <br>
                                <input type="hidden" name="tempId" value="${requestScope.tempId}">
                                <input type="hidden" name="courseId" value="${requestScope.courseId}">
                                <input type="hidden" name="questionId" value="${requestScope.questionId}">
                                <input type="hidden" name="url" class="urlInput">
                            </c:forEach>
                             
                        </form>
                        
                        
                    </div>
                    
                    <div class="display-trueanswer">
                        
                        The correct answer:
                            <c:forEach items="${requestScope.trueAnswerList}" var="t">
                                ${t.content}<br>  
                            </c:forEach>
                        
                        
                    </div>
                    
                    <div class="navigation-button">
                        <c:if test="${index>=2}">
                            <btn class="btn previous-btn"><a href="reviewquiz?courseId=${param.courseId}&lessonId=${param.lessonId}&tempId=${requestScope.tempId}&questionId=${requestScope.questionList[requestScope.index-2].questionId}">Previous Page</a></btn>
                        </c:if>
                                
                        <c:if test="${index < requestScope.questionList.size()}">
                            <btn class="btn next-btn"><a href="reviewquiz?courseId=${param.courseId}&lessonId=${param.lessonId}&tempId=${requestScope.tempId}&questionId=${requestScope.questionList[requestScope.index].questionId}">Next Page</a></btn>
                        </c:if>
                        
                    </div>
                </div>
            </div>
            <div class="col-lg-3 m-b30">
                <div class="widget-box">
                    <div class="wc-title">
                        <h4>Quiz navigation</h4>
                    </div>
                    <div class="widget-inner">
                        <c:forEach items="${requestScope.questionList}" var="q">
                            <c:set var="i" value="${i+1}"/>
                            <a href="quizlesson?courseId=${param.courseId}&lessonId=${param.lessonId}&tempId=${requestScope.tempId}&questionId=${q.questionId}" class="submitLink" onclick="showUrl(this)">
                                <c:if test="${q.questionId eq questionId}">
                                    <div class="selected-question">${i}</div>
                                </c:if>
                                <c:if test="${q.questionId ne questionId}">
                                    <div class="quiz-navigation">${i}</div>
                                </c:if>
                                
                            </a>
                        </c:forEach>
                        <a href="lesson?courseId=${param.courseId}&lessonId=${param.lessonId}" id='finish-attempt'>Finish review</a>
                    </div>
                    <div class="quiz-summary">
                        <table>
                            <tr>
                                <td>Questions:</td>
                                <td>${requestScope.trueAnswers}/${requestScope.questionSize}</td>
                            </tr>
                            <tr>
                                <td>Grades:</td>
                                <td>${requestScope.tempQuiz.result}/${10}</td>
                            </tr>
                        </table>
                    </div>
                </div>
                
            </div>
        </div>
        
        <script>
            function submitForm() {
                
                document.getElementById("answerForm").submit();
            }

            document.addEventListener("DOMContentLoaded", function() {
                // Lặp qua tất cả các liên kết có class "submitLink"
                var submitLinks = document.querySelectorAll('.submitLink');
                for (var i = 0; i < submitLinks.length; i++) {
                    submitLinks[i].addEventListener('click', function(event) {
                        event.preventDefault(); // Ngăn chặn chuyển hướng mặc định của liên kết
                        submitForm();
                    });
                }
            });
        </script>
        <script>
            function showUrl(element) {
                // Lấy giá trị href từ thẻ a
                var url = element.getAttribute("href");

                var urlInputs = document.querySelectorAll('.urlInput');

                // Gán giá trị url vào từng thẻ input
                urlInputs.forEach(function(input) {
                    input.value = url;
                });
            }
        </script>
        <script>
            function toggleDropdown() {
                var dropdown = document.getElementById("dropdownList");

                if (dropdown.style.display === "block") {
                    dropdown.style.display = "none";
                    document.getElementById("myNav").style.width = "0%";
                } else {
                    dropdown.style.display = "block";
                    document.getElementById("myNav").style.width = "100%";
                }
            }

            function closeNav() {
                document.getElementById("myNav").style.width = "0%";
                var dropdown = document.getElementById("dropdownList");

                dropdown.style.display = "none";
            }

            function chooseChapter(current) {
                var parent = current.parentElement;
                current.style.border = "none";
                var lessons = parent.querySelector(".lessons");
                var lessonArray = lessons.querySelectorAll(".lesson");
                lessonArray[lessonArray.length - 1].style.border = "none";
                if (lessons.style.display === "block") {
                    lessons.style.display = "none";
                } else {
                    lessons.style.display = "block";
                }
            }

            document.addEventListener('DOMContentLoaded', function () {
                var lessonChosen = document.querySelector(".choose");
                var parent = lessonChosen.parentElement.parentElement;
                parent.style.display = "block";
                console.log(parent);
                parent[parent.length - 1].style.border = "none";
            });
        </script>
        <script>
            var items = document.querySelectorAll('.quiz-navigation');
            var maxWidth = 0;

            items.forEach(function (item) {
                var itemWidth = item.clientWidth;
                if (itemWidth > maxWidth) {
                    maxWidth = itemWidth;
                }
            });

            // Set the width of all elements to the calculated maxWidth
            items.forEach(function (item) {
                item.style.width = maxWidth + 'px';
            });
        </script>
        <script src="adminassets/js/jquery.min.js"></script>
        <script src="adminassets/vendors/bootstrap/js/popper.min.js"></script>
        <script src="adminassets/vendors/bootstrap/js/bootstrap.min.js"></script>
        <script src="adminassets/vendors/bootstrap-select/bootstrap-select.min.js"></script>
        <script src="adminassets/vendors/bootstrap-touchspin/jquery.bootstrap-touchspin.js"></script>
        <script src="adminassets/vendors/magnific-popup/magnific-popup.js"></script>
        <script src="adminassets/vendors/counter/waypoints-min.js"></script>
        <script src="adminassets/vendors/counter/counterup.min.js"></script>
        <script src="adminassets/vendors/imagesloaded/imagesloaded.js"></script>
        <script src="adminassets/vendors/masonry/masonry.js"></script>
        <script src="adminassets/vendors/masonry/filter.js"></script>
        <script src="adminassets/vendors/owl-carousel/owl.carousel.js"></script>
        <script src='adminassets/vendors/scroll/scrollbar.min.js'></script>
        <script src="adminassets/js/functions.js"></script>
        <script src="adminassets/vendors/chart/chart.min.js"></script>
        <script src="adminassets/js/admin.js"></script>
        <script src='adminassets/vendors/calendar/moment.min.js'></script>
        <script src='adminassets/vendors/calendar/fullcalendar.js'></script>
        <script src='adminassets/vendors/switcher/switcher.js'></script>
    </body>

</html>