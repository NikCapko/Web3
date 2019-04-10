package com.company;

import com.company.handlers.convert.ConvertHandler;
import com.company.handlers.files.IndexJsHandler;
import com.company.handlers.files.JQueryHandler;
import com.company.handlers.files.StylesHandler;
import com.company.handlers.pages.FrontPageHandler;
import com.company.handlers.pages.SecondPageHandler;
import com.company.handlers.pages.TablePageHandler;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

public class Main {
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
            server.setExecutor(null);
            server.start();
            System.out.println("Server start...");
        } catch (IOException e) {
            e.printStackTrace();
        }
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
}
