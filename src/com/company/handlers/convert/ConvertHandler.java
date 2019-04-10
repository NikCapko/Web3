package com.company.handlers.convert;

import com.company.Main;
import com.company.convert.Convert;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.util.Map;

public class ConvertHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange t) {
        if (t.getRequestMethod().equalsIgnoreCase("GET")) {
            Map<String, String> params = Main.queryToMap(t.getRequestURI().getQuery());
            Convert c = new Convert(params.get("number"));
            Main.writeResponse(t, String.format("{\"number\":\"%s\"}", c.getResult()));
        }
    }
}
