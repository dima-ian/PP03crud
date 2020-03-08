<%@ page import="java.util.List" %>
<%@ page import="model.User" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Edit User's Data</title>
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
    <h6 class="w3-left-align">Hiber Version  |  Pred.Prod Task # 5</h6>
</div>


<div class="w3-container w3-padding">

    <div class="w3-card-4 w3-padding">
        <div class="w3-container w3-green w3-padding">
            <h2 class="w3-xlarge">Updating User's Data</h2>
        </div>
        <form method="post" class="w3-selection w3-light-grey w3-padding">

            <div class="w3-padding">
                <label class="w3-padding">Enter user's SSN :
                    <input type="text" name="ssn" required="required" pattern="[A-Za-z0-9]{1,20}" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
                </label>
                <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Submit</button> </br>
            </div>

            <label>Name:
                <input type="text" name="name" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <label>Sex:
                <input type="text" name="sex" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%" ><br />
            </label>
            <label>Age:
                <input type="number" name="age" value="0" min="1" max="150" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <label>Email:
                <input type="email" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <label>Role:
                <input type="text" placeholder="USER | ADMIN" name="role" pattern="USER|ADMIN" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
        </form>
    </div>

    <div class="w3-container w3-center w3-margin-bottom w3-padding">
        <div class="w3-card-4">
            <div class="w3-container w3-light-blue">
                <h2 class="w3-xlarge">Users List</h2>
            </div>


            <table class="TFtable">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Sex</th>
                    <th>Age</th>
                    <th>Email</th>
                    <th>SSN</th>
                    <th>Role</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach items="${usrsLst}" var="user">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.name}</td>
                        <td>${user.sex}</td>
                        <td>${user.age}</td>
                        <td>${user.email}</td>
                        <td>${user.ssn}</td>
                        <td>${user.role}</td>
                        <td>
                            <form method="post" action="<c:url value='/admin/del'/>">
                                <input type="text" hidden name="ssn" value="${user.ssn}"/>
                                <input type="submit" name="delete" value="Удалить"/>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

</div>



<div class="w3-container w3-grey w3-opacity w3-center w3-padding">
    <button class="w3-btn w3-round-large w3-green" onclick="location.href='/authpage.jsp'">Back to main</button>
</div>

</body>
</html>
