package com.company.handlers.pages;

import com.company.Main;
import com.company.Student;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.util.List;

public class TablePageHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange t) {
        if (t.getRequestMethod().equalsIgnoreCase("GET")) {
            String resp =
                    "<table>" +
                            "<tr>" +
                            "<th>Имя</th>" +
                            "<th>Фамилия</th>" +
                            "<th>Год рождения</th>" +
                            "</tr>" +
                            getStudentList(Main.getStudentList()) +
                            "</table>";
            t.setAttribute("Content-Type", "text/html");
            Main.writeResponse(t, resp);
        }
    }

    private String getStudentList(List<Student> studentList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Student student :
                studentList) {
            stringBuilder.append(addStudent(student));
        }
        return stringBuilder.toString();
    }

    private String addStudent(Student student) {
        return String.format("<tr>" +
                "<td><input type=\"text\" readonly value=%s></td>" +
                "<td><input type=\"text\" readonly value=%s></td>" +
                "<td><input type=\"text\" readonly value=%s></td>" +
                "<td><span class=\"btn\" id=\"%s\" onclick=\"deleteStudent(event)\">&ndash;</span></td>" +
                "</tr>", student.getFirstName(), student.getLastName(), student.getYearBirth(), student.getId());
    }
}
