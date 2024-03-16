<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Doctor Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
    <ul class="nav nav-tabs">
        <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="#">Doctor</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="Search-Doctor-Details.jsp">Search Specific & Update</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="Add-Doctor-Details.jsp">Add</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="ReceptionistDashboard.jsp">Dashboard</a>
        </li>
    </ul>
    <br/>
    <p>${message}</p>
    <br/>
    <div class="container">
        <table class="table table-striped">
            <thead>
                <tr class="table-dark">
                    <th>Doctor ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Specialization</th>
                    <th>Email</th>
                    <th>Remove from Doctor List</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="doctor" items="${doctorList}">
                    <tr>
                        <td>${doctor.doctorID}</td>
                        <td>${doctor.doctorFirstName}</td>
                        <td>${doctor.doctorLastName}</td>
                        <td>${doctor.doctorSpecialization}</td>
                        <td>${doctor.doctorEmail}</td>
                        <td>
                            <form method="post" action="doctorController">
                                <input type="hidden" name="doctorID" value="${doctor.doctorID}"/>
                                <input type="hidden" name="type" value="delete"/>
                                <button type="submit" class="btn btn-danger">Remove</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<br/>
</body>
</html>
