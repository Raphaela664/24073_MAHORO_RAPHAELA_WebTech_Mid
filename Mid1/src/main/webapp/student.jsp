<%@ page import="com.example.mid1.service.StudentService" %>
<%@ page import="com.example.mid1.service.StudentServiceImpl" %>
<%@ page import="com.example.mid1.model.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10/23/2023
  Time: 1:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600">
    <!-- https://fonts.google.com/specimen/Open+Sans -->
    <link rel="stylesheet" href="css/fontawesome.min.css">
    <!-- https://fontawesome.com/ -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- https://getbootstrap.com/ -->
    <link rel="stylesheet" href="css/tooplate.css">
    <title>Students</title>
</head>
<body id="reportsPage" class="bg02">
<div class="" id="home">
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
        <div class="row tm-content-row tm-mt-big">
            <div class="col-xl-8 col-lg-12 tm-md-12 tm-sm-12 tm-col">
                <div class="bg-white tm-block h-100">
                    <div class="row">
                        <div class="col-md-8 col-sm-12">
                            <h2 class="tm-block-title d-inline-block">Students</h2>

                        </div>

                    </div>
                    <div class="table-responsive">
                        <table class="table table-hover table-striped tm-table-striped-even mt-3">
                            <thead>
                            <tr class="tm-bg-gray">
                                <th scope="col">&nbsp;</th>
                                <th scope="col">Student ID</th>
                                <th scope="col" class="text-center">Student Name</th>
                                <th scope="col" class="text-center">DOB</th>
                                <th scope="col">&nbsp;</th>
                            </tr>
                            </thead>
                            <tbody>


                            <%
                                StudentService studentService = new StudentServiceImpl();
                                List<Student> studentList = studentService.fetchAllStudents();
                                for(Student st : studentList ) {
                            %>
                            <tr>

                                <th scope="row">
                                    <input type="checkbox" aria-label="Checkbox">
                                </th>
                                <td hidden="true"><%= st.getID() %></td>
                                <td class="tm-product-name"><%= st.getRegNo() %></td>
                                <td class="text-center"><%= st.getFirstName() %></td>
                                <td class="text-center"><%= st.getDateOfBirth() %></td>

                                <td><i class="fas fa-trash-alt tm-trash-icon"></i></td>


                            </tr>
                            <%
                                }
                            %>

                            </tbody>
                        </table>
                    </div>

                    <div class="tm-table-mt tm-table-actions-row">
                        <div class="tm-table-actions-col-left">
                            <button class="btn btn-danger">Delete Selected Items</button>
                        </div>
                        <div class="tm-table-actions-col-right">
                            <span class="tm-pagination-label">Page</span>
                            <nav aria-label="Page navigation" class="d-inline-block">
                                <ul class="pagination tm-pagination">
                                    <li class="page-item active"><a class="page-link" href="#">1</a></li>
                                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                                    <li class="page-item">
                                        <span class="tm-dots d-block">...</span>
                                    </li>
                                    <li class="page-item"><a class="page-link" href="#">13</a></li>
                                    <li class="page-item"><a class="page-link" href="#">14</a></li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-xl-4 col-lg-12 tm-md-12 tm-sm-12 tm-col">
                <div class="bg-white tm-block h-100">
                    <h2 class="tm-block-title d-inline-block">Product Categories</h2>
                    <table class="table table-hover table-striped mt-3">
                        <tbody>
                        <tr>
                            <td>1. Cras efficitur lacus</td>
                            <td class="tm-trash-icon-cell"><i class="fas fa-trash-alt tm-trash-icon"></i></td>
                        </tr>

                        </tbody>
                    </table>

                    <a href="#" class="btn btn-primary tm-table-mt">Add New Category</a>
                </div>
            </div>
        </div>
        <footer class="row tm-mt-small">
            <div class="col-12 font-weight-light">
                <p class="d-inline-block tm-bg-black text-white py-2 px-4">
                    Copyright &copy; 2018 Admin Dashboard . Created by
                    <a rel="nofollow" href="https://www.tooplate.com" class="text-white tm-footer-link">Raphaela</a>
                </p>
            </div>
        </footer>
    </div>
</div>
<script src="js/jquery-3.3.1.min.js"></script>
<!-- https://jquery.com/download/ -->
<script src="js/bootstrap.min.js"></script>
<!-- https://getbootstrap.com/ -->
<script>
    $(function () {
        $('.tm-product-name').on('click', function () {
            window.location.href = "edit-product.html";
        });
    })
</script>
</body>
</html>
