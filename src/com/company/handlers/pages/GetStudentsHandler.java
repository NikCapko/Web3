package com.company.handlers.pages;

import com.company.Main;
import com.company.Student;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class GetStudentsHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange t) {
        if (t.getRequestMethod().equalsIgnoreCase("GET")) {
            List<Student> list = Main.getStudentList();
            String resp = getJsonArray(list);
            Main.writeResponse(t, resp);
        } else {
            StringBuilder resp = new StringBuilder();
            writeResponse(t, resp.toString());
        }
    }

    public static void writeResponse(HttpExchange t, String str) {
        str = String.format("{\"data\":%s}", str);
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

    public static <T> String getJsonArray(List<T> list) {
        StringBuilder result = new StringBuilder();
        for (Object o : list) {
            result.append(o.toString()).append(",");
        }
        return String.format("[%s]", result.toString().substring(0, result.length() - 1));
    }
}
