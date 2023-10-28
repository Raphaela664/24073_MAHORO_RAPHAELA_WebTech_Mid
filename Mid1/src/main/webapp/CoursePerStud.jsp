<%@ page import="com.example.mid1.model.StudentCourse" %>
<%@ page import="com.example.mid1.service.StudentCourseService" %>
<%@ page import="com.example.mid1.service.StudentCourseServiceImpl" %>
<%@ page import="com.example.mid1.model.Course" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.mid1.model.Student" %>
<%@ page import="com.example.mid1.service.StudentService" %>
<%@ page import="com.example.mid1.service.StudentServiceImpl" %>
<%@ page import="java.util.UUID" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10/28/2023
  Time: 10:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%


    StudentCourseService studCourseServ = new StudentCourseServiceImpl();
    StudentService studServ = new StudentServiceImpl();
    List<StudentCourse> CourseList = new ArrayList<>();
    if ("POST".equalsIgnoreCase(request.getMethod())) {
        try {

            request.getRequestDispatcher("CoursePerStud.jsp").forward(request,response);

        } catch (Exception ex) {
            ex.printStackTrace();  // Log the error
            request.setAttribute("error", ex);

        }
    }
%>
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

            <div class="table-responsive">
                <form method="POST" action="CoursePerStud.jsp">
                    <h2 class="text-center">Courses Per Student</h2>
                    <div class="input-group mb-3">
                        <label for="student" class="col-xl-4 col-lg-4 col-md-4 col-sm-5 col-form-label">Student</label>
                        <select class="custom-select col-xl-9 col-lg-8 col-md-8 col-sm-7" id="student" name="student">
                            <option selected>Select one</option>
                            <%
                                List<Student> StudList = studServ.fetchAllStudents();
                                for (Student Stud : StudList) {
                            %>
                            <option value="<%=Stud.getID().toString()%>"><%=Stud.getFirstName()%></option>
                            <%
                                }
                            %>
                        </select>
                    </div>

                    <div class="input-group mb-3">
                        <div class="ml-auto col-xl-8 col-lg-8 col-md-8 col-sm-7 pl-0">
                            <button type="submit" class="btn btn-primary">Search
                            </button>
                        </div>
                    </div>

                </form>


                <table class="bg-white table table-hover table-striped tm-table-striped-even mt-3">
                    <thead class="thead-dark">
                    <tr>
                        <th>Course Code</th>
                        <th>Course Name</th>
                        <th>Credit</th>
                        <th>Teacher</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        String selectedStudent = request.getParameter("student");

                        if (selectedStudent != null) {
                            Student newStud = new Student();
                            newStud= studServ.findById(UUID.fromString(selectedStudent));

                            CourseList = studCourseServ.getCoursesPerStudent(newStud);

                            for (StudentCourse cource : CourseList) {
                    %>

                    <tr>
                        <td><%= cource.getCourse().getCourse_id()%></td>
                        <td><%= cource.getCourse().getDefinition().getName() %></td>
                        <td><%= cource.getCourse().getUnit().getName() %></td>
                        <td><%= cource.getCourse().getTutor().getNames() %></td>

                    </tr>
                    <%

                        }
                    %>
                    </tbody>
                </table>
                <%

                    }
                %>


            </div>


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
<script src="js/jquery-3.3.1.min.js"></script>
<!-- https://jquery.com/download/ -->
<script src="js/bootstrap.min.js"></script>
<!-- https://getbootstrap.com/ -->

</body>
</html>

