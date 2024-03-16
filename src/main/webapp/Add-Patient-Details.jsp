<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <meta charset="ISO-8859-1">
    <title>Add Patient Details</title>
</head>
<body>
<div class="container-fluid">
    <ul class="nav nav-tabs">
        <li class="nav-item">
            <a class="nav-link" href="PatientDashboard.jsp">Patient</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="Search-Patient-Details.jsp">Search Specific & Update</a>
        </li>
        <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="#">Add</a>
        </li>
    </ul>
    <br/>
    <br/>
    <div class="container">
        <h3>Register Patient</h3>
        <br/>
        <p>${message}</p>
        <br/>
        <form method="post" action="patientController">
            <br/>
            <label for="patientFullName">Full Name:</label>
            <input type="text" class="form-control" id="patientFullName" name="patientFullName"/>
            <br/>
            <br/>
            <label for="patientPhoneNumber">Phone Number:</label>
            <input type="number" class="form-control" id="patientPhoneNumber" name="patientPhoneNumber"/>
            <br/>
            <br/>
            <label for="dateOfBirth">Date of Birth:</label>
            <input type="date" class="form-control" id="dateOfBirth" name="dateOfBirth"/>
            <br/>
            <br/>
            <label for="patientAddress">Address:</label>
            <input type="text" class="form-control" id="patientAddress" name="patientAddress"/>
            <br/>
            <br/>
            <label for="gender">Gender:</label>
            <select class="form-select" id="gender" name="gender">
                <option value="Male">Male</option>
                <option value="Female">Female</option>
                <option value="Other">Other</option>
            </select>
            <br/>
            <br/>
            <label for="patientEmail">Email:</label>
            <input type="email" class="form-control" id="patientEmail" name="patientEmail"/>
            <br/>
            <br/>
            <label for="patientUsername">Username:</label>
            <input type="text" class="form-control" id="patientUsername" name="patientUsername"/>
            <br/>
            <br/>
            <label for="patientPassword">Password:</label>
            <input type="password" class="form-control" id="patientPassword" name="patientPassword"/>
            <input type="hidden" name="type" value="add"/>
            <br/>
            <br/>
            <button type="submit" class="btn btn-primary">Register</button>
        </form>
    </div>
</div>
</body>
</html>
