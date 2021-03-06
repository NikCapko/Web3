package com.company.handlers.pages;

import com.company.Main;
import com.company.Student;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.stream.Collectors;

public class DeleteStudentHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        if (httpExchange.getRequestMethod().equalsIgnoreCase("POST")) {
            String s = new BufferedReader(new InputStreamReader(httpExchange.getRequestBody())).lines().collect(Collectors.joining(""));
            Map<String, String> params = Main.queryToMap(s);
            Main.deleteStudent(params.get("id"));
            Main.writeResponse(httpExchange, String.format("{\"result\":\"success\"}"));
        }
    }
}
