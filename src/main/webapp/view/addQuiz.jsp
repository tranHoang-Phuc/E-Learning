<%-- 
    Document   : courseAddedDashboard
    Created on : Mar 4, 2024, 3:33:58 PM
    Author     : Admin
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />
        <link rel="icon" href="../assets/images/favicon.ico" type="image/x-icon" />
        <link rel="shortcut icon" type="image/x-icon" href="../assets/images/favicon.png" />
        <link rel="stylesheet" type="text/css" href="../assets/css/assets.css">
        <link rel="stylesheet" type="text/css" href="../assets/css/typography.css">
        <link rel="stylesheet" type="text/css" href="../assets/css/shortcodess/shortcodes.css">
        <link rel="stylesheet" type="text/css" href="../assets/css/style.css">
        <link class="skin" rel="stylesheet" type="text/css" href="../assets/css/color/color-1.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />
        <script src="https://cdn.tiny.cloud/1/fxl5y9orttfc7bs00l2bcgwyxaefx9f4s8dvb0qajm25dpu4/tinymce/6/tinymce.min.js" referrerpolicy="origin"></script>
        <style>
            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }

            .left-sider {
                width: 250px;
                height: 100vh;
                background-color: #fff;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
                position: fixed;
                top: 0;
                left: 0;
            }

            .logo {
                width: 100%;
                height: 100px;
                background-color: #fff;
                display: flex;
                justify-content: center;
                align-items: center;
            }

            .logo img {
                width: 50%;
            }

            .navigator {
                width: 100%;
                height: calc(100vh - 500px);
                background-color: #fff;
                display: flex;
                justify-content: center;
                align-items: center;
            }

            .list-task {
                width: 100%;
                height: 100%;
                list-style: none;
                display: flex;
                flex-direction: column;
                justify-content: space-around;
                align-items: center;
            }

            li a {
                text-decoration: none;
                color: black;
                transition: color 0.3s ease-in-out;
            }

            .list-task li {
                width: 100%;
                height: 50px;
                background-color: #fff;
                display: flex;
                justify-content: left;
                align-items: center;
                cursor: pointer;
                transition: all 0.3s ease-in-out;
                text-align: left;
            }

            .list-task li:hover {
                background-color: #4c1864;
                color: white;
            }

            .list-task li span {
                margin-left: 30px;
                margin-right: 35px;
            }

            .logout {
                position: absolute;
                bottom: 20px;
                left: 50%;
                transform: translateX(-50%);
            }

            .logout a {
                text-decoration: none;
                color: black;
            }

            .right-sider {
                margin-left: 250px;
                position: relative;
            }

            .right-sider .header {
                display: flex;
                background-color: #6a6ce4;
                height: 10vh;
            }

            .avatar img {
                width: 40px;
                height: 40px;
                border-radius: 50%;
            }

            .header .info {
                display: flex;
                position: absolute;
                right: 30px;
                top: 20px;
                color: white;
            }

            .header .title {
                position: absolute;
                left: 40px;
                top: 28px;
                color: white;
            }

            .name .fullname {
                margin-left: 10px;
                line-height: 40px;
            }
            #pagee {
                display: flex;
                justify-content: center;
                align-items: center;
                padding: 10px;
                background-color: #f2f2f2;
            }

            #pagee a {
                color: #333;
                padding: 8px 12px;
                margin: 0 5px; /* Khoảng cách giữa các số */
                text-decoration: none;
                border: 1px solid #ddd;
                border-radius: 4px;
                display: inline-block;
                cursor: pointer;
            }

            #pagee a span {
                display: inline-block;
            }

            #pagee a:hover {
                background-color: #ddd;
            }

            .btn {
                background-color: #f7b205;
                color: black;
                padding: 14px 18px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                font-size: 18px;
                font-weight: bold;
                transition: background-color 0.3s;
                width: 30%;
            }

            .btn:hover {
                background-color: #4c1863;
                color: white;
                opacity: 0.8;
            }
            .radio-group {
                margin-bottom: -10px;
                text-align: left;
            }

            .radio-group label {
                display: inline-block;
                margin-right: 15px;
            }

            .radio-group input {
                margin-right: 4px;
            }
            select {
                width: 100%;
                padding: 10px;
                font-size: 16px;
                border: 1px solid #ccc;
                border-radius: 5px;
                background-color: #f9f9f9;
                outline: none;
                transition: border-color 0.3s;
            }
            .arrow {
                font-size: 20px;
                padding: 10px;
                cursor: pointer;
            }

            .dropdown-list {
                display: none;
                position: absolute;
                top: 55px;
                right: 20px;
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
            .info {
                display: flex;
                align-items: center;
            }

            .img-info img {
                width: 50px;
                height: 50px;
                border-radius: 50%;
            }

            .name {
                margin-left: 10px;
            }
            li a {
                padding-left: 0;
            }
            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }

            .left-sider {
                width: 250px;
                height: 100vh;
                background-color: #fff;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
                position: fixed;
                top: 0;
                left: 0;
            }

            .logo {
                width: 100%;
                height: 100px;
                background-color: #fff;
                display: flex;
                justify-content: center;
                align-items: center;
            }

            .logo a {
                width: 50%;
            }

            .navigator {
                width: 100%;
                height: calc(100vh - 500px);
                background-color: #fff;
                display: flex;
                justify-content: center;
                align-items: center;
            }

            .list-task {
                width: 100%;
                height: 100%;
                list-style: none;
                display: flex;
                flex-direction: column;
                justify-content: space-around;
                align-items: center;
            }

            li a {
                text-decoration: none;
                color: black;
                transition: color 0.3s ease-in-out;
            }

            .list-task li {
                width: 100%;
                height: 50px;
                background-color: #fff;
                display: flex;
                justify-content: left;
                align-items: center;
                cursor: pointer;
                transition: all 0.3s ease-in-out;
                text-align: left;
            }

            .list-task li:hover {
                background-color: #4c1864;
                color: white;
            }

            .list-task li span {
                margin-left: 30px;
                margin-right: 35px;
            }

            .logout {
                position: absolute;
                bottom: 20px;
                left: 50%;
                transform: translateX(-50%);
            }

            .logout a {
                text-decoration: none;
                color: black;
            }

            .right-sider {
                margin-left: 250px;
                position: relative;
            }

            .right-sider .header {
                display: flex;
                background: linear-gradient(45deg, rgba(76, 24, 100, 0.85) 0%, rgba(63, 24, 154, 0.85) 100%);
                height: 9vh;
            }

            .avatar img {
                width: 40px;
                height: 40px;
                border-radius: 50%;
            }

            .header .info {
                display: flex;
                position: absolute;
                right: 30px;
                top: 20px;
                color: white;
            }

            .header .title {
                position: absolute;
                left: 40px;
                top: 28px;
                color: white;
            }

            .name .fullname {
                margin-left: 10px;
                line-height: 40px;
            }



            .question-container{
                margin-left: 15%;
                width: 70%;
                border-radius: 10px;
                box-shadow: 0 0 8px rgba(0, 0, 0, 0.5);
            }
            .question-text{
                padding-left: 2.1%;
                padding-top: 1%;
            }
            .delete-button{
                color: rgba(0, 0, 0, 0.5);
                margin-left: 85.5%;
                border: none;
                background: none;
            }

            .answer-box{
                width: 90%;
                margin: 0 auto;
                padding: 20px 5px 10px 10px;
                border-radius: 10px;
                border: 1px solid rgba(0, 0, 0, 0.2);
                margin-bottom: 20px;
            }

            input[type=checkbox] {
                display: none;
            }

            /* Thiết lập kích thước của checkbox hình tròn */
            .custom-checkbox {
                margin: 2% 0 0 2%;
                width: 30px;
                height: 30px;
                background-color: #fff;
                border: 2px solid #ccc;
                border-radius: 50%;
                display: inline-block;
                cursor: pointer;
            }

            /* Khi checkbox được chọn, thay đổi màu nền */
            input[type=checkbox]:checked + .custom-checkbox {
                background-color: green; /* Màu nền của checkbox khi được chọn */
            }

            #additional-answers {
                display: flex;
                flex-direction: column;
            }

            .add-new-answer {
                border: solid 1px rgba(0, 0, 0, 0.5);
                padding: 5px 10px;
                margin-left: 7.2%;
                border-radius: 10px;
                margin-bottom: 2%;
            }
            .add-or-save button {
                width: 20%;
                border-radius: 15px;
                /*margin: 1.5% 15%;*/
            }

            .breadcrumb-row {
                background: #fff;
                padding: 15px 0;
                border-bottom: 1px solid #e5e5e5;
            }

            #backlink:after {
                content: "\f105";
                margin-left: 7px;
                font-family: fontawesome;
            }

            #qname{
                margin-left: 1.5%;
                padding: 10px 0px 15px 0;
                font-size: 20px;
            }

        </style>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/xlsx/0.16.9/xlsx.full.min.js"></script>
    </head>
    <body>
        <div id="myNav" class="overlay" onclick="closeNav()">
        </div>
        <div class="left-sider">
            <div class="logo">
                <img src="../assets/images/logoBlack.png" onclick="goTo('../home')" alt>
            </div>
            <div class="navigator">
                <ul class="list-task">
                    <li style="background-color: #f7b205; margin-top: -240px;" class="list-item" onmouseover="toWhite(this)" onmouseout="toBlack()">
                        <span class="material-symbols-outlined">book</span><a>Courses</a>
                    </li>
                    <li onclick="goTo('blogs')" class="list-item" style="margin-top: -520px;" onmouseover="toWhite(this)" onmouseout="toBlack()"><span class="material-symbols-outlined">person</span><a>Blogs</a></li>
                </ul>

            </div>
        </div>
        <div class="right-sider">
            <div class="header" style="height: 10vh">
                <div class="title"><span>COURSE</span></div>
                <div class="info">
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
                                </svg><a href="../editprofile">Profile</a></li>
                            <li><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box-arrow-right" viewBox="0 0 16 16">
                                <path fill-rule="evenodd"
                                      d="M10 12.5a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v2a.5.5 0 0 0 1 0v-2A1.5 1.5 0 0 0 9.5 2h-8A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-2a.5.5 0 0 0-1 0z" />
                                <path fill-rule="evenodd"
                                      d="M15.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 0 0-.708.708L14.293 7.5H5.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708z" />
                                </svg><a href="../logout">Logout</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="breadcrumb-row">
                <% String course = request.getContextPath() + "/dashboard/course"; %>
                <div class="container" style="margin-left: 10px">
                    <ul class="list-inline" style="margin-bottom: 0;">
                        <li id="backlink"><a href="<%=course%>">Course</a></li>
                        <li>Create quiz</li>
                    </ul>
                </div>
            </div>
            <div class="content">
                <form action="editlesson?action=addquizzlesson" method="post">
                    
                    <input type="hidden" name="courseId" value="${param.courseId}">
                    <input type="hidden" name="chapterId" value="${param.chapterId}">
                    <input type="hidden" name="index" value="${param.index}">
                    <input type="hidden" name="sequence" value="${param.sequence}">
                    <input type="hidden" name="position" value="${param.position}">
                    <input type="hidden" name="lessonId" value="${param.lessonId}">
                    <input type="hidden" name="lessonType" value="${param.lessonType}">
                    <input type="hidden" name="newLessonName" value="${param.newLessonName}">
                    <input type="hidden" name="duration" value="${param.duration}">
                    <div style="display:flex; width: 85%; position: relative;">
                        <div name="qname" id="qname">Mastering Python Programming: From Basics to Advanced Concepts</div>
                        <div name="handleFile" id="handleFile" style="padding: 15px 0px; position: absolute; right: 0;">
                            <svg style="cursor: pointer;" onclick="exportToExcel()" xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-download" viewBox="0 0 16 16">
                            <path d="M.5 9.9a.5.5 0 0 1 .5.5v2.5a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1v-2.5a.5.5 0 0 1 1 0v2.5a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2v-2.5a.5.5 0 0 1 .5-.5"/>
                            <path d="M7.646 11.854a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 10.293V1.5a.5.5 0 0 0-1 0v8.793L5.354 8.146a.5.5 0 1 0-.708.708z"/>
                            </svg>
                            <label for="excel-file" style="cursor: pointer; margin-left: 20px">
                                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-upload" viewBox="0 0 16 16">
                                <path d="M.5 9.9a.5.5 0 0 1 .5.5v2.5a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1v-2.5a.5.5 0 0 1 1 0v2.5a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2v-2.5a.5.5 0 0 1 .5-.5"/>
                                <path d="M7.646 1.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1-.708.708L8.5 2.707V11.5a.5.5 0 0 1-1 0V2.707L5.354 4.854a.5.5 0 1 1-.708-.708z"/>
                                </svg>
                            </label>
                            <input style="display: none;" type="file" id="excel-file" accept=".xlsx, .xls" onchange="handleFile(this.files)">
                        </div>
                    </div>

                    <input type="hidden" value="1" id="quest" class="numOfQuesOutside">
                    <input type="hidden" value="1" id="index" name="numOfIndex">

                    <div id="questions">
                        <div class="question-container question1">
                            <input type="hidden" value="1" class="numOfQuesInside">
                            <input type="hidden" value="4" class="numOfAns">
                            <input type="hidden" value="4" class="indexAns" name="indexAns1">
                            <div class="question-text" style="position: relative; display: flex">
                                <textarea style="width: 89%; margin:1% 1.2% 1.5% 5.5%; border: none;" name="q1">Question:</textarea>
                                <button  style="position: absolute; right: 12px; top: 18px;" type="button" onclick="deleteQuestion(this)" class="delete-button" value="delete"><svg xmlns="http://www.w3.org/2000/svg" width="21" height="21" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                                    <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0z"/>
                                    <path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4zM2.5 3h11V2h-11z"/>
                                    </svg>
                                </button>
                            </div>
                            <div class="answers1">
                                <div style="display: flex" id="answerBox11">
                                    <td><input type="checkbox" name="question1-1" id="answer-1-1" value="true">
                                        <label for="answer-1-1" class="custom-checkbox"></label></td>
                                    <td style="width: 50%;"><div class="answer-box">
                                            <textarea style="width: 95%; margin:0 1.2% 0 1%; border: none;" name="q1-answer1">A1: </textarea>
                                            <button type="button" onclick="deleteAnswer('answerBox11')" style=" border: none; background: none;" type="submit" class="delete-answer" value="delete"><svg style="margin-bottom: 75%; color: rgba(0,0,0,0.5);" xmlns="http://www.w3.org/2000/svg" width="21" height="21" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                                                <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0z"/>
                                                <path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4zM2.5 3h11V2h-11z"/>
                                                </svg>
                                            </button>
                                        </div>
                                    </td>
                                </div>
                                <div style="display: flex" id="answerBox12">
                                    <td><input type="checkbox" name="question1-2" id="answer-1-2" value="true">
                                        <label for="answer-1-2" class="custom-checkbox"></label></td>
                                    <td style="width: 50%;"><div class="answer-box">
                                            <textarea style="width: 95%; margin:0 1.2% 0 1%; border: none;" name="q1-answer2">A2:</textarea>
                                            <button type="button" onclick="deleteAnswer('answerBox12')" style=" border: none; background: none;" type="submit" class="delete-answer" value="delete"><svg style="margin-bottom: 75%; color: rgba(0,0,0,0.5);" xmlns="http://www.w3.org/2000/svg" width="21" height="21" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                                                <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0z"/>
                                                <path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4zM2.5 3h11V2h-11z"/>
                                                </svg>
                                            </button>
                                        </div>
                                    </td>
                                </div>
                                <div style="display: flex" id="answerBox13">
                                    <td><input type="checkbox" name="question1-3" id="answer-1-3" value="true">
                                        <label for="answer-1-3" class="custom-checkbox"></label></td>
                                    <td style="width: 50%;"><div class="answer-box">
                                            <textarea style="width: 95%; margin:0 1.2% 0 1%; border: none;" name="q1-answer3">A3:</textarea>
                                            <button type="button" onclick="deleteAnswer('answerBox13')"style=" border: none; background: none;" type="submit" class="delete-answer" value="delete"><svg style="margin-bottom: 75%; color: rgba(0,0,0,0.5);" xmlns="http://www.w3.org/2000/svg" width="21" height="21" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                                                <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0z"/>
                                                <path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4zM2.5 3h11V2h-11z"/>
                                                </svg>
                                            </button>
                                        </div>
                                    </td>
                                </div>
                                <div style="display: flex" id="answerBox14">
                                    <td><input type="checkbox" name="question1-4" id="answer-1-4" value="true">
                                        <label for="answer-1-4" class="custom-checkbox"></label></td>
                                    <td style="width: 50%;"><div class="answer-box">
                                            <textarea style="width: 95%; margin:0 1.2% 0 1%; border: none;" name="q1-answer4">A4:</textarea>
                                            <button type="button" onclick="deleteAnswer('answerBox14')" style=" border: none; background: none;" type="submit" class="delete-answer" value="delete"><svg style="margin-bottom: 75%; color: rgba(0,0,0,0.5);" xmlns="http://www.w3.org/2000/svg" width="21" height="21" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                                                <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0z"/>
                                                <path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4zM2.5 3h11V2h-11z"/>
                                                </svg>
                                            </button>
                                        </div>
                                    </td>
                                </div>
                            </div>

                            <button class="add-new-answer" type="button" onclick="addNewAnswer(this)">Add new answer</button>
                        </div>
                    </div>

                    <div class="add-or-save">
                        <button type="button" style="margin: 1.8% 10% 1.5% 25%;" id="add-new-question-button" onclick="addQuestion(this)" class="btn">Add new question</button>
                        <button id="save-button" type="submit" class="btn">Save the quiz</button>
                    </div>
                </form>
            </div>
        </div>
        <script>
            function exportToExcel() {
                var data = [
                    ["Question ", "Answer 1", "IsTrue 1", "Answer 2", "IsTrue 2", "Answer 3", "IsTrue 3", "Answer 4", "IsTrue 4", "Answer 5", "IsTrue 5", "Answer 6", "IsTrue 6"],
                ];

                var ws = XLSX.utils.aoa_to_sheet(data);
                var wb = XLSX.utils.book_new();
                XLSX.utils.book_append_sheet(wb, ws, "Sheet1");
                var wbout = XLSX.write(wb, {bookType: 'xlsx', type: 'binary'});

                function s2ab(s) {
                    var buf = new ArrayBuffer(s.length);
                    var view = new Uint8Array(buf);
                    for (var i = 0; i < s.length; i++)
                        view[i] = s.charCodeAt(i) & 0xFF;
                    return buf;
                }

                var blob = new Blob([s2ab(wbout)], {type: "application/octet-stream"});
                var url = URL.createObjectURL(blob);

                var a = document.createElement("a");
                a.href = url;
                a.download = "Template_Input_Question.xlsx";
                document.body.appendChild(a);
                a.click();
                setTimeout(function () {
                    document.body.removeChild(a);
                    window.URL.revokeObjectURL(url);
                }, 0);
            }
        </script>
        <script>
            function handleFile(files) {
                const file = files[0];
                const reader = new FileReader();

                reader.onload = function (event) {
                    const data = new Uint8Array(event.target.result);
                    const workbook = XLSX.read(data, {type: 'array'});
                    const sheetName = workbook.SheetNames[0];
                    const sheet = workbook.Sheets[sheetName];
                    const excelData = XLSX.utils.sheet_to_json(sheet, {header: 1});

                    const questions = parseExcelData(excelData);
                    displayQuestions(questions);
                };

                reader.readAsArrayBuffer(file);
            }

            function parseExcelData(data) {
                const questions = [];
                data.forEach(function (row, rowIndex) {
                    if (rowIndex > 0) {
                        const question = row[0];
                        const answers = [];
                        const isTrue = [];
                        for (let i = 1; i < row.length; i += 2) {
                            const answer = row[i];
                            const isTrueValue = row[i + 1];
                            if (answer !== null && answer !== undefined) {
                                answers.push(answer);
                            }
                            if (isTrueValue !== null && isTrueValue !== undefined) {
                                isTrue.push(isTrueValue);
                            }
                            if (answers.length > 6)
                                break;
                        }
                        if (answers.length >= 2 && answers.length <= 6 && answers.length === isTrue.length) {
                            questions.push({question, answers, isTrue});
                        }
                    }
                });

                return questions;
            }


        </script>

        <script src="../assets/js/quizzes.js" type="text/javascript"></script>
        <script>
            function deleteAnswer(answer) {
                var grandparent = document.getElementById(answer).parentNode.parentNode;
                console.log(grandparent);
                var numOfAns = parseInt(grandparent.querySelector('.numOfAns').value);
                console.log(numOfAns);
                if (numOfAns > 2) {
                    numOfAns--;
                    document.getElementById(answer).innerHTML = '';
                    document.getElementById(answer).removeAttribute("id");
                    grandparent.querySelector('.numOfAns').value = numOfAns;
                } else {
                }
            }

            function deleteQuestion(button) {
                console.log(button);
                var question = button.parentNode.parentNode;
                console.log(question);
                var currentQuestNum = parseInt(document.getElementById('quest').value);
                if (currentQuestNum > 1) {
                    question.innerHTML = '';
                    question.removeAttribute("class");
                    document.getElementById('quest').value = currentQuestNum - 1;
                }
            }


            function goTo(url) {
                window.location = url;
            }
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

            function toWhite(element) {
                var anchor = element.querySelector('a');
                if (anchor) {
                    anchor.style.color = 'white';
                }
            }
            function toBlack() {
                var firstChild = document.querySelectorAll('.list-item > a');
                firstChild.forEach(element => {
                    element.style.color = 'black';
                });
            }

        </script>







    </body>
</html>
