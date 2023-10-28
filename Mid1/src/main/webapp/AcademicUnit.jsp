<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10/27/2023
  Time: 7:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.mid1.model.Teacher" %>
<%@ page import="com.example.mid1.service.TeacherServiceImpl" %>
<%@ page import="com.example.mid1.service.TeacherService" %>
<%@ page import="java.util.UUID" %>
<%@ page import="com.example.mid1.model.EQualification" %>
<%@ page import="com.example.mid1.model.AcademicUnit" %>
<%@ page import="com.example.mid1.service.AcademicUnitService" %>
<%@ page import="com.example.mid1.service.AcademicUnitServiceImpl" %>
<%@ page import="com.example.mid1.model.EAcademicUnit" %>
<%
    AcademicUnit unit = new AcademicUnit();
    AcademicUnitService AcademicUnitServ = new AcademicUnitServiceImpl();

    if ("POST".equalsIgnoreCase(request.getMethod())) {
        try {
            unit.setID(UUID.randomUUID());

            unit.setName(request.getParameter("name"));
            unit.setCode(Integer.parseInt(request.getParameter("code")));
            String unitType = request.getParameter("unitType");
            EAcademicUnit Eunit = EAcademicUnit.valueOf(unitType);
            unit.setUnit(Eunit);

            AcademicUnitServ.addAcademicUnit(unit);

            request.setAttribute("Success", "Academic Unit successfully created.");
        } catch (Exception ex) {
            ex.printStackTrace();  // Log the error
            request.setAttribute("error", ex);
            request.getRequestDispatcher("student.jsp").forward(request, response);
        }
    }
%>
<html>
<head>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600">
    <!-- https://fonts.google.com/specimen/Open+Sans -->
    <link rel="stylesheet" href="css/fontawesome.min.css">
    <!-- https://fontawesome.com/ -->
    <link rel="stylesheet" href="jquery-ui-datepicker/jquery-ui.min.css" type="text/css" />
    <!-- http://api.jqueryui.com/datepicker/ -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- https://getbootstrap.com/ -->
    <link rel="stylesheet" href="css/tooplate.css">
    <title>Academic Unit</title>
</head>
<body class="bg02">
<div class="container">
    <div class="row">
        <div class="col-12">
            <nav class="navbar navbar-expand-xl navbar-light bg-light">
                <a class="navbar-brand" href="dashboard.jsp">
                    <i class="fas fa-3x fa-tachometer-alt tm-site-icon"></i>
                    <h1 class="tm-site-title mb-0">Dashboard</h1>
                </a>
                <button class="navbar-toggler ml-auto mr-0" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mx-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="dashboard.jsp">Dashboard
                                <span class="sr-only">(current)</span>
                            </a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#"  role="button" data-toggle="dropdown" aria-haspopup="true"
                               aria-expanded="false">
                                Reports
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="StudPerCourseAndSem.jsp">Students Per Course and Sem</a>
                                <a class="dropdown-item" href="CoursePerStud.jsp">Courses per Student</a>
                                <a class="dropdown-item" href="studBySemandDep.jsp">Student Per Sem and Dep</a>
                                <a class="dropdown-item" href="stdBySem.jsp">Student Per Sem</a>
                                <a class="dropdown-item" href="dashboard.jsp">Courses Per Dep and Sem</a>
                            </div>
                        </li>

                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true"
                               aria-expanded="false">
                                Registration
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="nav-link" href="addStudent.jsp">Student</a>
                                <a class="nav-link" href="addSemester.jsp">Semester</a>
                                <a class="nav-link" href="addTeacher.jsp">Teacher</a>
                                <a class="nav-link" href="CourseDefinition.jsp">Course Definition</a>
                                <a class="dropdown-item" href="AddStudentRegistration.jsp">Student Registration</a>
                                <a class="dropdown-item" href="AddStudentCourse.jsp">Student Course</a>
                                <a class="dropdown-item" href="AddCourse.jsp">Course</a>
                                <a class="nav-link" href="AcademicUnit.jsp">AcademicUnit</a>
                            </div>
                        </li>

                    </ul>

                </div>
            </nav>
        </div>
    </div>
    <!-- row -->
    <div class="row tm-mt-big">
        <div class="col-xl-8 col-lg-10 col-md-12 col-sm-12">
            <div class="bg-white tm-block">
                <div class="row">
                    <div class="col-12">
                        <h2 class="tm-block-title d-inline-block">Add Teacher</h2>
                    </div>
                </div>
                <div class="row mt-4 tm-edit-product-row">
                    <div class="col-xl-7 col-lg-7 col-md-12">
                        <form action="AcademicUnit.jsp" class="tm-edit-product-form" method="POST">
                            <div class="input-group mb-3">
                                <label for="name" class="col-xl-4 col-lg-4 col-md-4 col-sm-5 col-form-label">AcademicUnit code

                                </label>
                                <input id="name" name="code" type="text" class="form-control validate col-xl-9 col-lg-8 col-md-8 col-sm-7">
                            </div>
                            <div class="input-group mb-3">
                                <label for="firstName" class="col-xl-4 col-lg-4 col-md-4 col-sm-5 mb-2">Academic Unit Name</label>
                                <input id="firstName" name="name" type="text" class="form-control validate col-xl-9 col-lg-8 col-md-8 col-sm-7">
                            </div>

                            <div class="input-group mb-3">
                                <label for="qualification" class="col-xl-4 col-lg-4 col-md-4 col-sm-5 col-form-label">Unit Type
                                </label>
                                <select class="custom-select col-xl-9 col-lg-8 col-md-8 col-sm-7" id="qualification" name="unitType">
                                    <option selected>Select one</option>
                                    <option value="PROGRAM">PROGRAM</option>
                                    <option value="DEPARTMENT">DEPARTMENT</option>
                                    <option value="FACULTY">FACULTY</option>
                                </select>
                            </div>


                            <div class="input-group mb-3">
                                <div class="ml-auto col-xl-8 col-lg-8 col-md-8 col-sm-7 pl-0">
                                    <button type="submit" class="btn btn-primary">Add
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <footer class="row tm-mt-big">
        <div class="col-12 font-weight-light">
            <p class="d-inline-block tm-bg-black text-white py-2 px-4">
                Copyright &copy; 2018 Admin Dashboard . Created by
                <a rel="nofollow" href="#" class="text-white tm-footer-link">Raphaela</a>
            </p>
        </div>
    </footer>
</div>

<script src="js/jquery-3.3.1.min.js"></script>
<!-- https://jquery.com/download/ -->
<script src="jquery-ui-datepicker/jquery-ui.min.js"></script>
<!-- https://jqueryui.com/download/ -->
<script src="js/bootstrap.min.js"></script>
<!-- https://getbootstrap.com/ -->
</body>

</html>
