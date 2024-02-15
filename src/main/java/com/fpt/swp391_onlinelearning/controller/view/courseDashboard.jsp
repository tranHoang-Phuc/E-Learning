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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />
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
        </style>
    </head>

    <body>
        <div class="left-sider">
            <div class="logo">
                <img src="../assets/images/logoBlack.png" alt>
            </div>
            <div class="navigator">
                <ul class="list-task">
                    <!-- style này là để đánh dấu xem cái nào đang được chọn -->

                    <!--  cái c:if này để phân quyền giao diện tại tính năng mỗi role là khác nhau-->
                    <c:if test="${sessionScope.session.role.roleId eq 2}">
                        <li class="list-item" onmouseover="toWhite(this)" onmouseout="toBlack()">
                            <span class="material-symbols-outlined">tv</span><a href="#">Dashboard</a>
                        </li>
                    </c:if>

                    <c:if test="${sessionScope.session.role.roleId eq 2}">
                        <li class="list-item" onmouseover="toWhite(this)" onmouseout="toBlack()">
                            <span class="material-symbols-outlined">person</span><a href="#">Users</a>
                        </li>
                    </c:if>

                    <!--style="background-color: #f7b205;"  Cái này để đổi sang màu vàng cái thẻ đang đc chọn -->
                    <c:if test="${sessionScope.session.role.roleId eq 2}">
                        <li class="list-item" style="background-color: #f7b205;" class="list-item" onmouseover="toWhite(this)" onmouseout="toBlack()">
                            <span class="material-symbols-outlined">book</span><a href="#">Courses</a>
                        </li>
                    </c:if>

                    <c:if test="${sessionScope.session.role.roleId eq 2}">
                        <li class="list-item" onmouseover="toWhite(this)" onmouseout="toBlack()">
                            <span class="material-symbols-outlined">two_pager</span><a href="#">Blogs</a>
                        </li>
                    </c:if>

                    <c:if test="${sessionScope.session.role.roleId eq 2}">
                        <li class="list-item" onmouseover="toWhite(this)" onmouseout="toBlack()">
                            <span class="material-symbols-outlined">post_add</span>Posts</a>
                        </li>
                    </c:if>

                    <c:if test="${sessionScope.session.role.roleId eq 2}">
                        <li class="list-item" onmouseover="toWhite(this)" onmouseout="toBlack()">
                            <span class="material-symbols-outlined">sliders</span>Sliders</a>
                        </li>
                    </c:if>

                    <c:if test="${sessionScope.session.role.roleId eq 2}">
                        <li class="list-item" onmouseover="toWhite(this)" onmouseout="toBlack()">
                            <span class="material-symbols-outlined">how_to_reg</span><a href="#">Enrollment</a>
                        </li>
                    </c:if>
                    <c:if test="${sessionScope.session.role.roleId eq 2}">
                        <li class="list-item" onmouseover="toWhite(this)" onmouseout="toBlack()">
                            <span class="material-symbols-outlined">settings</span><a href="#">Setting</a>
                        </li>
                    </c:if>

                </ul>
            </div>
            <div class="logout"><span class="material-symbols-outlined">logout</span><a href="../logout">Logout</a></div>
        </div>
        <div class="right-sider">
            <div class="header">
                <div class="title"><span>COURSES</span></div>
                <div class="info">
                    <span class="avatar">
                        <img src="${sessionScope.user.img}" alt>
                    </span>
                    <div class="name">
                        <span class="fullname">${sessionScope.user.name}</span>
                    </div>
                </div>
            </div>


            <!--Code nội dung cm vào đây-->


        </div>

        <script>
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
