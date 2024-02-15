<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>Document</title>
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
         background-color: #6a6ce4;
         height: 7vh;
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
      
/*      .row {
         position: absolute;
         top: 15vh;
         display: flex;
         justify-content: center;
         align-items: center;
         margin-left: 50px;
      }*/
        .row{
            margin: 20px;
        }
      .box {
         padding: 15px;
         border-radius: 7px;
         background-color: white;
         width: 300px;
         margin-right: 40px;
      }
      
      .box-body-header {
         display: flex;
         position: relative;
      }
      
      .box-body-header .symbol {
         position: absolute;
         right: 10px;
         color: green;
         font-size: 20px;
      }
      
      .box-body-content {
         padding-top: 35px;
      }
      
/*      #incomeChart {
         width: 800px !important;
         height: 500px !important;
      }*/
      
      #enrollChart {
         width: 550px !important;
         height: 230px !important;
         color: #f7b205;
      }
      
      #user-registeration {
         width: 550px !important;
         height: 230px !important;
         color: #f7b205;
      }
      
      .imcome-chart {
         margin-right: 50px;
         margin-top: 20px;
         box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
         width: fit-content;
         border-radius: 5px;
         padding: 10px;
         /* background-color: #4c1864; */
      }
      
      .chart-area {
         display: flex;
         justify-content: center;
      }
      
      .enroll-chart{
        margin-left: 3%;
        background-color: #fff;
        box-shadow:0 3px 10px 0px rgba(0,0,0,.08);
        border-radius: 4px;
        height: fit-content;
      }
      .enroll-chart .upper-chart{
        margin-bottom: 20px;
      }
      .enroll-chart .upper-chart .wc-title h4{
        padding: 15px 15px;       
        border-bottom:1px solid rgba(0,0,0,0.05);
        font-size:16px;
        line-height:18px;
        margin:0;
        color:#333;
        font-weight:500;
      }
      
      .enroll-chart .lower-chart .wc-title h4{
        padding: 15px 15px;       
        border-bottom:1px solid rgba(0,0,0,0.05);
        font-size:16px;
        line-height:18px;
        margin:0;
        color:#333;
        font-weight:500;
      }
      .view-more-btn {
        margin-left: auto; /* Di chuy?n n�t v? ph�a b�n ph?i */
        display: inline-block; /* Hi?n th? n�t tr�n c�ng c?a div cha */
        margin-top: -5px; /* ?i?u ch?nh ?? l?ch gi?a n�t v� ti�u ?? */
        padding: 5px 10px; /* ?i?u ch?nh ?? l?ch v� ?? l?n c?a n�t */
        background-color: #007bff; /* M�u n?n c?a n�t */
        color: #fff; /* M�u ch? c?a n�t */
        border: none; /* Lo?i b? ???ng vi?n c?a n�t */
        cursor: pointer; /* Bi?n con tr? th�nh h�nh tay khi di chu?t qua n�t */
        }
       
        .not_found {
            text-align: center;
        }
        #paging {
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 10px;
            background-color: #f2f2f2;
        }

        #paging a {
            color: #333;
            padding: 8px 12px;
            margin: 0 5px;  
            text-decoration: none;
            border: 1px solid #ddd;
            border-radius: 4px;
            display: inline-block;
            cursor: pointer;
        }

        #paging a span {
            display: inline-block;
        }

        #paging a:hover {
            background-color: #ddd;
        }
        .img_not_found {
            text-align: center;
        }

            
   </style>
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
	<link rel="shortcut icon" type="image/x-icon" href="../adminassets/images/favicon.png" />
	
	<!-- PAGE TITLE HERE ============================================= -->
	<title>EduChamp : Education HTML Template </title>
	
	<!-- MOBILE SPECIFIC ============================================= -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!--[if lt IE 9]>
	<script src="../adminassets/js/html5shiv.min.js"></script>
	<script src="../adminassets/js/respond.min.js"></script>
	<![endif]-->
	
	<!-- All PLUGINS CSS ============================================= -->
	<link rel="stylesheet" type="text/css" href="../adminassets/css/assets.css">
	<link rel="stylesheet" type="text/css" href="../adminassets/vendors/calendar/fullcalendar.css">
	
	<!-- TYPOGRAPHY ============================================= -->
	<link rel="stylesheet" type="text/css" href="../adminassets/css/typography.css">
	
	<!-- SHORTCODES ============================================= -->
	<link rel="stylesheet" type="text/css" href="../adminassets/css/shortcodes/shortcodes.css">
	
	<!-- STYLESHEETS ============================================= -->
	<link rel="stylesheet" type="text/css" href="../adminassets/css/style.css">
	<link rel="stylesheet" type="text/css" href="../adminassets/css/dashboard.css">
        
        <link href="../assets/css/sort.css" rel="stylesheet" type="text/css"/>
	<link class="skin" rel="stylesheet" type="text/css" href="../adminassets/css/color/color-1.css">
        <style>
            .search-btn{
                position: relative;
            }
            #export-btn2{
                position: absolute;
                right: 1px;
                top: 1px;
                padding: 10px;
            }
        </style>
</head>

<body class="ttr-opened-sidebar ttr-pinned-sidebar">
   <div class="left-sider">
      <div class="logo">
          <a href="../home"><img src="../assets/images/logoBlack.png" alt=""/></a> 
      </div>
      <div class="navigator">
         <ul class="list-task">
            <!-- style n�y l� ?? ?�nh d?u xem c�i n�o ?ang ???c ch?n -->
            <li style="background-color: #f7b205;" class="list-item" onmouseover="toWhite(this)" onmouseout="toBlack()">
               <span class="material-symbols-outlined">tv</span><a href="#">Dashboard</a>
            </li>
            <li class="list-item" onmouseover="toWhite(this)" onmouseout="toBlack()"><span class="material-symbols-outlined">person</span><a href="#">Users</a></li>
            <li class="list-item" onmouseover="toWhite(this)" onmouseout="toBlack()"><span class="material-symbols-outlined">book</span><a href="#">Courses</a></li>
            <li class="list-item" onmouseover="toWhite(this)" onmouseout="toBlack()"><span class="material-symbols-outlined">two_pager</span><a href="#">Blogs</a></li>
            <li class="list-item" onmouseover="toWhite(this)" onmouseout="toBlack()"><span class="material-symbols-outlined">post_add</span>Posts</a>
            </li>
            <li class="list-item" onmouseover="toWhite(this)" onmouseout="toBlack()"><span class="material-symbols-outlined">sliders</span>Sliders</a>
            </li>
            <li class="list-item" onmouseover="toWhite(this)" onmouseout="toBlack()"><span class="material-symbols-outlined">how_to_reg</span><a href="#">Enrollment</a></li>
            <li class="list-item" onmouseover="toWhite(this)" onmouseout="toBlack()"><span class="material-symbols-outlined">settings</span><a href="#">Setting</a></li>
         </ul>
      </div>
      <div class="logout"><span class="material-symbols-outlined">logout</span><a href="logout">Logout</a></div>
   </div>

   
   <!-- Xoa tu cho nay -->
   <div class="right-sider">
      <div class="header">
         <div class="title"><span>DASHBOARD</span></div>
         <div class="info">
            <span class="avatar">
                  <img src="${sessionScope.user.img}" alt>
               </span>
            <div class="name">
               <span class="fullname">${sessionScope.user.name}</span>
            </div>
         </div>
      </div>
        <div class="breadcrumb-row">
        <% String report = request.getContextPath() + "/dashboard/report"; %>
        <div class="container" style="margin-left: 10px">
            <ul class="list-inline">
                <li><a href="<%= report%>">Dashboard</a></li>
                <li>User Registration Stats</li>
            </ul>
        </div>
    </div>
       <div class="row" style="margin: 20px">
            <!-- Your Profile Views Chart -->
            <div class="col-lg-2 m-b30">
                
            </div>
            <div class="col-lg-8 m-b30">
                    <div class="widget-box">
                            <div class="wc-title">
                                <h4>User registration</h4>                               
                            </div>
                            <div class="widget-inner">
                                <div class="search-btn" style="margin-bottom: 20px" >
                                    <form method="get" action="userregisterStat"">
                                        From: <input type="date" name="from" value="${requestScope.from}">
                                        To: <input type="date" name="to" value="${requestScope.to}">
                                        Total registration: ${requestScope.totalRegistration}
                                        <input class="btn" type="submit" value="View" style="margin-left: 1rem">
                                    </form>
                                    <button id="export-btn2" class="btn">Export</button>
                                </div>
                                <table border="1px" class="table-sortable">
                                    <thead>
                                        <tr>
                                            <th style="text-align: center">No</th>
                                            <th style="text-align: center">Email</th>
                                            <th style="text-align: center">Name</th>
                                            <th style="text-align: center">Registered Time</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${requestScope.userList}" var="u">
                                            <c:set var="i" value="${i+1}"></c:set>
                                            <tr>
                                                <td>${i + requestScope.pageSize*(requestScope.pageIndex-1)}</td>
                                                <td>${u.account.email}</td>
                                                <td>${u.name}</td>
                                                <td>${u.account.registeredTime}</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                    
                                </table>
                                <div id="paging"></div>
                            </div>
                    </div>
                                        
            </div>
            <div class="col-lg-2 m-b30">
                
            </div>
            <table border="1px" id="userRegistration_table" style="display: none">
                <thead>
                    <tr>
                        <th style="text-align: center">No</th>
                        <th style="text-align: center">Email</th>
                        <th style="text-align: center">Name</th>
                        <th style="text-align: center">Registered Time</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.allUserList}" var="u">
                        <c:set var="j" value="${j+1}"></c:set>
                        <tr>
                            <td>${j}</td>
                            <td>${u.account.email}</td>
                            <td>${u.name}</td>
                            <td>${u.account.registeredTime}</td>
                        </tr>
                    </c:forEach>
                </tbody>

            </table>
    </div>
       


      </div>
   </div>
   <script>
       var btnXlsx = document.getElementById('export-btn2');

        btnXlsx.onclick = () => exportData('xlsx')

        function exportData(type){
            const fileName = 'userRegistration-sheet.' + type
            const userRegistration_table = document.getElementById("userRegistration_table")
            const wb = XLSX.utils.table_to_book(userRegistration_table)
            XLSX.writeFile(wb, fileName)
        }
   </script>
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
   <script>
        renderPaging('paging',${requestScope.pageIndex},${requestScope.totalPage}, 2, '${requestScope.from}','${requestScope.to}');
        function renderPaging(id, pageIndex, totalPage, gap, from, to) {
            var container = document.getElementById(id);
                if (pageIndex - gap > 1) {
                    container.innerHTML += '<a href="userregisterStat?pageIndex=1' + '&from=' + from + '&to=' + to + '">First</a> ';
                }
                for (var i = pageIndex - gap; i < pageIndex; i++) {
                    if (i > 0) {
                        container.innerHTML += '<a href="userregisterStat?pageIndex=' + i + '&from=' + from + '&to=' + to + '">' + i + '</a>';
                    }
                }
                container.innerHTML += '<span>' + pageIndex + '</span>';
                for (var i = pageIndex + 1; i <= pageIndex + gap && i <= totalPage; i++) {
                    container.innerHTML += '<a href="userregisterStat?pageIndex=' + i + '&from=' + from + '&to=' + to + '">' + i + '</a>';
                }
                if (pageIndex + gap < totalPage) {
                    container.innerHTML += '<a href="userregisterStat?pageIndex=' + totalPage + '&from=' + from + '&to=' + to + '">Last</a>';
                }
        }
        
   </script>

   <!-- hai script nay de ve bieu do -->
   <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
   <script>
      const ctx = document.getElementById('incomeChart');

      new Chart(ctx, {
         type: 'line',
         data: {
            labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'July', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
            datasets: [{
               label: 'Income',
               data: [12, 19, 3, 5, 2, 3, 12, 19, 3, 5, 2, 3],
               borderWidth: 1,
               borderColor: '#4c1864',
               backgroundColor: '#4c1864'

            }]
         },
         options: {
            legend: {
               labels: {
                  fontColor: "white",
                  fontSize: 18
               }
            },
            scales: {

               x: {
                  grid: {
                     drawOnChartArea: false,
                  },
                  ticks: {
                     fontColor: "green",
                     fontSize: 18,
                     stepSize: 1,
                     beginAtZero: true
                  }

               },
               y: {
                  beginAtZero: true,
                  // grid: {
                  //    drawOnChartArea: false
                  // }
               },
            }
         }
      });
   </script>
   <script>
      const enroll = document.getElementById('enrollChart');

      new Chart(enroll, {
         type: 'bar',
         data: {
            labels: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
            datasets: [{
               label: 'New people enroll',
               data: [12, 19, 3, 5, 2, 3, 10],
               borderWidth: 2,
               borderColor: '#f7b205',
               backgroundColor: '#f7b205',
               barPercentage: 0.2,
               categoryPercentage: 1
            }]
         },
         options: {
            indexAxis: 'x',
            scales: {
               x: {
                  grid: {
                     drawOnChartArea: false
                  }
               },
               y: {
                  beginAtZero: true,
                  // grid: {
                  //    drawOnChartArea: false
                  // }
               },
               barPercentage: 0.4

            }
         }
      });
   </script>

   <script>
      const registeration = document.getElementById('user-registeration');

      new Chart(registeration, {
         type: 'bar',
         data: {
            labels: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
            datasets: [{
               label: 'New people enroll',
               data: [12, 19, 3, 5, 2, 3, 10],
               borderWidth: 2,
               borderColor: '#f7b205',
               backgroundColor: '#f7b205',
               barPercentage: 0.2,
               categoryPercentage: 1
            }]
         },
         options: {
            indexAxis: 'x',
            scales: {
               x: {
                  grid: {
                     drawOnChartArea: false
                  }
               },
               y: {
                  beginAtZero: true,
                  // grid: {
                  //    drawOnChartArea: false
                  // }
               },
               barPercentage: 0.4
            }
         }
      });
   </script>
   <script src="../assets/js/sort.js" type="text/javascript"></script>
   <script src="../assets/js/sheet.js" type="text/javascript"></script>
</body>

</html>