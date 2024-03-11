<%-- 
    Document   : courseDashboard
    Created on : Feb 5, 2024, 9:34:27 PM
    Author     : tran Hoang Phuc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            .course-list {
                width: fit-content;
            }
            .search td {
                padding: 3px 5px 0px 0px;
                margin-left: 2px;
            }
            .course-list {
                margin-left: 2%;
            }
            .search {
                margin: 10
            }
            .content {
                margin-top: 3%;
            }
            .chapter {
                margin-bottom: 10px;
            }

            .chapter-name .name {
                padding: 10px;
                width: 95%;
                border: 1px solid #ebebeb;
                background-color: #f5f5f5;
                border-radius: 6px;
                cursor: pointer;
            }


            .lessons .lesson {
                padding: 10px;
                border-bottom: 1px solid rgba(0, 0, 0, .03);
                width: 90%;
                margin-left: 10px;
            }

            .lesson span a {
                text-decoration: none;
                color: black;
            }

            .lesson span {
                margin-left: 30px;
            }

            .ti-control-play {
                color: orangered;
            }

            .ti-file {
                color:greenyellow;
            }
            .ti-pencil {
                color: purple;
            }
            .list-lesson {
                margin-top:3%;
                margin-left:2%;
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
                background: linear-gradient(45deg, rgba(76, 24, 100, 0.85) 0%, rgba(63, 24, 154, 0.85) 100%);
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

            .content{
                height: 100vh;
                margin-top: 3%;
            }



            .arrow {
                font-size: 20px;
                padding: 10px;
                cursor: pointer;
            }

            .dropdown-list {
                display: none;
                position: absolute;
                top: 50px;
                right: 10px;
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
            li a {
                padding-left:0px;
            }
            #choose {
                background-color: rgba(223, 223, 223, 0.2);
            }
            .info {
                display: flex;
                align-items: center;
                margin:0 0 0 30px;
            }

            .img-info img {
                width: 40px;
                height: 40px;
                border-radius: 50%;
            }

            .name {
                margin-left: 10px;
            }

            .btn-no {
                display: inline-block;
                font-weight: 400;
                text-align: center;
                white-space: nowrap;
                vertical-align: middle;
                -webkit-user-select: none;
                -moz-user-select: none;
                -ms-user-select: none;
                user-select: none;
                border: 1px solid transparent;
                padding: .375rem .75rem;
                font-size: 1rem;
                line-height: 1.5;
                border-radius: .25rem;
                transition: color .15s ease-in-out, background-color .15s ease-in-out, border-color .15s ease-in-out, box-shadow .15s ease-in-out;
                background-color: red;
                color: white;
            }
            .btn-no:hover {
                opacity: 0.8;
            }
        </style>
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
                    <li style="background-color: #f7b205; margin-top: -200px;" class="list-item" onmouseover="toWhite(this)" onmouseout="toBlack()">
                        <span class="material-symbols-outlined">book</span><a>Courses</a>
                    </li>
                    <li onclick="goTo('blogs')" class="list-item" style="margin-top: -520px;" onmouseover="toWhite(this)" onmouseout="toBlack()"><span class="material-symbols-outlined">person</span><a>Blogs</a></li>
                </ul>
            </div>
        </div>
        <div class="right-sider">
            <div class="header" style="height:10vh;">
                <div class="title"><span>COURSE</span></div>
                <div class="info">
                    <div class="img-info">
                        <span><img style="height:40px; width: 40px;" src="${sessionScope.user.img}"
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
            <div class="list-lesson" style="display:flex;">
                <div class="chapters" style="width:100%;">
                    <c:forEach items="${requestScope.lesson}" var="l" varStatus="loop">
                        <c:set var="c" value="${l.key}" />
                        <input type="hidden" value="${c.chapterId}" id="chapterValue">
                        <c:set var="list" value="${l.value}" />
                        <div class="chapter">
                            <div class="chapter-name" onclick="showLessons(this)" >
                                <div class="name" style="position: relative;">
                                    <span onclick="goTo('editlesson?action=addChapter&courseId=${param.courseId}&sequence=${c.sequence}&position=before${loop.index eq 0 ?"&index=first":""}')">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-caret-up-fill" viewBox="0 0 16 16">
                                        <path d="m7.247 4.86-4.796 5.481c-.566.647-.106 1.659.753 1.659h9.592a1 1 0 0 0 .753-1.659l-4.796-5.48a1 1 0 0 0-1.506 0z"/>
                                        </svg>
                                    </span>
                                    <span onclick="goTo('editlesson?action=addChapter&courseId=${param.courseId}&sequence=${c.sequence}&position=after${loop.index eq requestScope.lesson.size() - 1 ? "&index=last":""}')">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-caret-down-fill" viewBox="0 0 16 16">
                                        <path d="M7.247 11.14 2.451 5.658C1.885 5.013 2.345 4 3.204 4h9.592a1 1 0 0 1 .753 1.659l-4.796 5.48a1 1 0 0 1-1.506 0z"/>
                                        </svg>
                                    </span>

                                    <span style="font-weight: 500;"> ${loop.count}. ${c.name}</span>
                                    <span style="position: absolute; right: 10px;">
                                        <c:if test="${list.size() eq 0}">
                                            <svg style="cursor: pointer;" onclick="goTo('editlesson?action=addNewLesson&courseId=${param.courseId}&chapterId=${c.chapterId}')" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-lg" viewBox="0 0 16 16">
                                            <path fill-rule="evenodd" d="M8 2a.5.5 0 0 1 .5.5v5h5a.5.5 0 0 1 0 1h-5v5a.5.5 0 0 1-1 0v-5h-5a.5.5 0 0 1 0-1h5v-5A.5.5 0 0 1 8 2"/>
                                            </svg>
                                        </c:if>

                                        <svg onclick="goTo('editlesson?action=editChapter&courseId=${param.courseId}&chapterId=${c.chapterId}')" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
                                        <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
                                        <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5z"/>
                                        </svg>

                                        <svg onclick="goTo('editlesson?action=deleteChapter&courseId=${param.courseId}&chapterId=${c.chapterId}')" style="margin-left: 10px;" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                                        <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0z"/>
                                        <path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4zM2.5 3h11V2h-11z"/>
                                        </svg>


                                    </span>
                                </div>
                            </div>
                            <div class="lessons">
                                <c:forEach items="${list}" var="lesson" varStatus="loopLesson">
                                    <div class="lesson" style="width:95%; position: relative;">
                                        <span style="margin-left: -10px">


                                            <span style="cursor: pointer;" onclick="goTo('editlesson?action=addLesson&courseId=${param.courseId}&chapterId=${c.chapterId}&lessonId=${lesson.lessonId}&sequence=${lesson.sequence}&position=before${loopLesson.index eq 0 ?"&index=first":""}')">
                                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-caret-up-fill" viewBox="0 0 16 16">
                                                <path d="m7.247 4.86-4.796 5.481c-.566.647-.106 1.659.753 1.659h9.592a1 1 0 0 0 .753-1.659l-4.796-5.48a1 1 0 0 0-1.506 0z"/>
                                                </svg>
                                            </span>
                                            <span style="margin-left: -3px; cursor: pointer;" onclick="goTo('editlesson?action=addLesson&courseId=${param.courseId}&chapterId=${c.chapterId}&lessonId=${lesson.lessonId}&sequence=${lesson.sequence}&position=after${loopLesson.index eq list.size() - 1 ? "&index=last":""}')">
                                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-caret-down-fill" viewBox="0 0 16 16">
                                                <path d="M7.247 11.14 2.451 5.658C1.885 5.013 2.345 4 3.204 4h9.592a1 1 0 0 1 .753 1.659l-4.796 5.48a1 1 0 0 1-1.506 0z"/>
                                                </svg>
                                            </span>
                                            <i class="${lesson.type.typeId eq 1? "ti-control-play": lesson.type.typeId eq 2? "ti-file":"ti-pencil"}"></i>
                                            <span>${lesson.name}</span>
                                        </span>
                                        <span style="position: absolute; right: 10px;">
                                            <c:if test="${lesson.type.typeId ne 1}">
                           
                                                <svg style="cursor: pointer;" onclick="goTo('editlesson?action=editLesson&courseId=${param.courseId}&lessonId=${lesson.lessonId}&lst=${lesson.type.typeId}')" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
                                                <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
                                                <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5z"/>
                                                </svg>
                                            </c:if>

                                            <svg style="cursor: pointer;" onclick="goTo('editlesson?action=deleteLesson&courseId=${param.courseId}&lessonId=${lesson.lessonId}')" style="margin-left: 10px;" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                                            <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0z"/>
                                            <path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4zM2.5 3h11V2h-11z"/>
                                            </svg>
                                        </span>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </c:forEach>                           
                </div>
                <div class="lesson" style="width:1200px;">
                    <c:if test="${requestScope.action eq 'addChapter'}">
                        <div class="edit-chapter" style="width: fit-content; padding: 10px 30px 10px 0px; margin-left: 30px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);">
                            <span class="action-label"><label><strong style="font-size: 25px;">Add a new chapter</strong></label></span>
                            <div class="content-add-chapter">
                                <form action="editlesson?action=addChapter" method="post" id="addChapterForm">
                                    <input type="hidden" name="courseId" value="${param.courseId}">
                                    <input type="hidden" name="index" value="${param.index}">
                                    <input type="hidden" name="sequence" value="${param.sequence}">
                                    <input type="hidden" name="position" value="${param.position}">
                                    <input type="hidden" name="chapterId" id="fillChapterId">
                                    <span>Chapter name:</span>
                                    <span><input type="text" name="newChapterName" style="width: 300px"></span>
                                    <span><button type="button" class="btn" onclick="addChapter('addChapterForm', document.getElementById('chapterValue').value)">Add</button></span>
                                </form>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${requestScope.action eq 'editChapter'}">
                        <div class="edit-chapter" style="width: fit-content; padding: 10px 30px 10px 0px; margin-left: 30px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);">
                            <span class="action-label"><label><strong style="font-size: 25px;">Update a chapter</strong></label></span>
                            <div class="content-add-chapter">
                                <form action="editlesson?action=editChapter" method="post" id="editChapterForm">       
                                    <input type="hidden" name="courseId" value="${param.courseId}">
                                    <input type="hidden" name="chapterId" value="${requestScope.chapter.chapterId}">
                                    <span>Chapter name:</span>
                                    <span><input type="text" name="newChapterName" style="width: 300px" value="${requestScope.chapter.name}"></span>
                                    <span><button type="submit" class="btn">Save</button></span>
                                </form>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${requestScope.action eq 'addLesson'}">
                        <div class="edit-chapter" style="width: fit-content; padding: 10px 30px 10px 0px; margin-left: 15px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);">
                            <span class="action-label"><label><strong style="font-size: 25px;">Add a new lesson</strong></label></span>
                            <div class="content-add-chapter">
                                <form action="editlesson" method="get" id="addLessonForm">    
                                    <input type="hidden" name="action" value="AddLesson" id="inputActionAddLesson">
                                    <input type="hidden" name="courseId" value="${param.courseId}">
                                    <input type="hidden" name="chapterId" value="${param.chapterId}">
                                    <input type="hidden" name="index" value="${param.index}">
                                    <input type="hidden" name="sequence" value="${param.sequence}">
                                    <input type="hidden" name="position" value="${param.position}">
                                    <input type="hidden" name="lessonId" value="${param.lessonId}">
                                    <span>Lesson name:</span>
                                    <span><input type="text" name="newLessonName" style="width: 300px" value="${requestScope.chapter.name}"></span>

                                    <select name="lessonType" id="lsType" style="margin-left: 30px; padding: 2px; width: 100px;" onchange="changeButton(this)">
                                        <c:forEach items="${requestScope.type}" var="t">
                                            <option value="${t.typeId}">${t.name}</option>
                                        </c:forEach>
                                    </select>
                                    <br>
                                    <span>Duration:</span>
                                    <span><input style="margin-left: 35px;" type="text" name="duration"></span>
                                    <button type="button" onclick="addLesson('addLessonForm');" class="btn" style="margin: 10px 0px 0px 30px;" id="addLessonButton">Go to add video</button>
                                </form>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${requestScope.action eq 'addNewLesson'}">
                        <div class="edit-chapter" style="width: fit-content; padding: 10px 30px 10px 0px; margin-left: 15px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);">
                            <span class="action-label"><label><strong style="font-size: 25px;">Add a new lesson</strong></label></span>
                            <div class="content-add-chapter">
                                <form action="editlesson" method="get" id="addLessonForm">    
                                    <input type="hidden" name="action" value="addVideoLesson" id="inputActionAddLesson">
                                    <input type="hidden" name="courseId" value="${param.courseId}">
                                    <input type="hidden" name="chapterId" value="${param.chapterId}">
                                    <div class="form-group">
                                        <span>Lesson name:</span>
                                        <span><input type="text" name="newLessonName" style="width: 300px" value="${requestScope.chapter.name}"></span>
                                        <select name="lessonType" id="lsType" style="margin-left: 30px; padding: 2px; width: 100px;" onchange="changeButton(this)">
                                            <c:forEach items="${requestScope.type}" var="t">
                                                <option value="${t.typeId}">${t.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <span>Duration:</span>
                                    <span ><input style="margin-left: 35px;" type="text" name="duration"></span>
                                    <button type="button" onclick="addLesson('addLessonForm');" class="btn" style="margin: 10px 0px 0px 30px;" id="addLessonButton">Go to add video</button>
                                </form>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${requestScope.action eq 'deleteChapter'}">
                        <div class="edit-chapter" style="width: fit-content; padding: 10px 30px 10px 0px; margin-left: 90px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);">
                            <span class="action-label"><label><strong style="font-size: 25px;">Do you want to delete this chapter</strong></label></span>
                            <div class="content-add-chapter">
                                <form action="editlesson" method="post" id="addLessonForm">    
                                    <input type="hidden" name="action" value="deleteChapter" >
                                    <input type="hidden" name="courseId" value="${param.courseId}">
                                    <input type="hidden" name="chapterId" value="${param.chapterId}">
                                    <span>Chapter name: <b>${requestScope.chapter.name}</b></span>
                                    <div style="margin-left: 70px;">
                                        <span><button type="submit" class="btn" style="margin: 10px 0px 0px 30px;">Yes</button></span>
                                        <span><button type="button" onclick="goTo('editlesson?courseId=${param.courseId}')" class="btn-no" style="margin: 10px 0px 0px 10px;">No</button></span>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${requestScope.action eq 'deleteLesson'}">
                        <div class="edit-chapter" style="width: fit-content; padding: 10px 30px 10px 0px; margin-left: 90px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);">
                            <span class="action-label"><label><strong style="font-size: 25px;">Do you want to delete this lesson</strong></label></span>
                            <div class="content-add-chapter">
                                <form action="editlesson" method="post" id="addLessonForm">    
                                    <input type="hidden" name="action" value="deleteLesson" >
                                    <input type="hidden" name="courseId" value="${param.courseId}">
                                    <input type="hidden" name="lessonId" value="${param.lessonId}">
                                    <span>Lesson name: <b>${requestScope.les.name}</b></span>
                                    <div style="margin-left: 70px;">
                                        <span><button type="submit" class="btn" style="margin: 10px 0px 0px 30px;">Yes</button></span>
                                        <span><button type="button" onclick="goTo('editlesson?courseId=${param.courseId}')" class="btn-no" style="margin: 10px 0px 0px 10px;">No</button></span>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </c:if>
                </div>
            </div>
        </div>
        <script>
            function addLesson(form) {
                var select = document.getElementById('lsType');
                if (select.selectedIndex === 0) {
                    document.getElementById('inputActionAddLesson').value = 'addVideoLesson';
                } else if (select.selectedIndex === 1) {
                    document.getElementById('inputActionAddLesson').value = 'addArticleLesson';
                } else {
                    document.getElementById('inputActionAddLesson').value = 'addQuizzesLesson';
                }
                document.getElementById(form).submit();
            }
            function changeButton(selected) {
                var button = document.getElementById('addLessonButton');

                if (selected.selectedIndex === 0) {
                    button.innerHTML = 'Go to add video';
                } else if (selected.selectedIndex === 1) {
                    button.innerHTML = 'Go to add article';
                } else {
                    button.innerHTML = 'Go to add quizzes';
                }

            }
            function addChapter(form, chapterValue) {
                document.getElementById('fillChapterId').value = chapterValue;
                document.getElementById(form).submit();
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
            function showLessons(chapter) {
                var parent = chapter.parentNode;
                var lessons = parent.querySelector(".lessons").querySelectorAll(".lesson");

                lessons.forEach(function (lesson) {
                    lesson.style.display = lesson.style.display === "block" ? "none" : "block";
                });
            }
            document.addEventListener('DOMContentLoaded', function () {
                var lessonChosen = document.querySelector("#choose");
                var parent = lessonChosen.parentElement;
                var lessons = parent.querySelectorAll(".lesson");
                lessons.forEach(function (lesson) {
                    lesson.style.display = lesson.style.display === "block" ? "none" : "block";
                });
            });
        </script>
    </body>
</html>
