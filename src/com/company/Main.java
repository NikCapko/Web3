package com.company;

import com.company.handlers.convert.ConvertHandler;
import com.company.handlers.files.IndexJsHandler;
import com.company.handlers.files.JQueryHandler;
import com.company.handlers.files.StylesHandler;
import com.company.handlers.pages.*;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static List<Student> studentList = new ArrayList<>();

    public static List<Student> getStudentList() {
        return studentList;
    }

    public static void setStudentList(List<Student> students) {
        studentList = students;
    }

    public static void main(String[] args) {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(8083), 1);
            server.createContext("/jquery", new JQueryHandler());
            server.createContext("/index", new IndexJsHandler());
            server.createContext("/styles", new StylesHandler());
            server.createContext("/front_page", new FrontPageHandler());
            server.createContext("/second_page", new SecondPageHandler());
            server.createContext("/convert", new ConvertHandler());
            server.createContext("/table", new TablePageHandler());
            server.createContext("/add_student", new AddStudentHandler());
            server.createContext("/get_students", new GetStudentsHandler());
            server.createContext("/delete_student", new DeleteStudentHandler());
            server.setExecutor(null);
            server.start();
            System.out.println("Server start...");
            setList();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void setList() {
        studentList.add(new Student("1", "Jon", "Smit", "1996"));
        studentList.add(new Student("2", "Jim", "Karter", "1995"));
        studentList.add(new Student("3", "James", "Bond", "1994"));
    }

    public static void writeResponse(HttpExchange t, String str) {
        byte[] resp = str.getBytes();
        try {
            t.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
            t.sendResponseHeaders(200, resp.length);
            OutputStream out = t.getResponseBody();
            out.write(resp);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, String> queryToMap(String query) {
        Map<String, String> params = new HashMap<>();
        if (query != null && query.contains("=")) {
            String[] paramsArray = query.split("&");
            for (String par : paramsArray) {
                String[] p = par.split("=");
                if (p.length == 2) {
                    params.put(p[0], p[1]);
                }
            }
        }
        return params;
    }

    public static void addStudent(Student student) {
        if (studentList.isEmpty()) {
            student.setId("1");
            studentList.add(student);
        } else {
            student.setId(String.valueOf(Integer.parseInt(studentList.get(studentList.size() - 1).getId()) + 1));
            studentList.add(student);
        }
    }

    public static void deleteStudent(String id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId().equals(id)) {
                studentList.remove(i);
            }
        }
    }
}
