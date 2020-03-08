<%@ page import="java.util.List" %>
<%@ page import="model.User" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Users List : </title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

    <style type="text/css">
        .TFtable{
            width:100%;
            border-collapse:collapse;
        }
        .TFtable td{
            padding:7px; border:#4e95f4 1px solid;
        }
        /* provide some minimal visual accomodation for IE8 and below */
        .TFtable tr{
            background: #b8d1f3;
        }
        /*  Define the background color for all the ODD background rows  */
        .TFtable tr:nth-child(odd){
            background: #b8d1f3;
        }
        /*  Define the background color for all the EVEN background rows  */
        .TFtable tr:nth-child(even){
            background: #dae5f4;
        }
    </style>

    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            text-align: left;
            padding: 8px;
        }
        tr:nth-child(even){background-color: #f2f2f2}
        th {
            background-color: #4CAF50;
            color: white;
        }
    </style>

    <style>
        form label { font-weight:bold; }
    </style>

</head>

<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h6 class="w3-left-align">Hibernate Version  |  Pred.Prod Task # 5</h6>
</div>

<div class="w3-container w3-center w3-margin-bottom w3-padding">

    <div class="w3-container w3-green w3-padding">
        <h2 class="w3-xlarge"> Something's not found...</h2>
    </div>

    <div>
        <div class="w3-container w3-grey w3-opacity w3-center w3-padding">
            <button class="w3-btn w3-round-large w3-green" onclick="location.href='/regpage.jsp'">Go to SIGN UP</button>
        </div>
    </div>

    <div>
        <div class="w3-container w3-grey w3-opacity w3-center w3-padding">
            <button class="w3-btn w3-round-large w3-green" onclick="location.href='/'">Go to SIGN IN</button>
        </div>
    </div>


</div>

</body>
</html>