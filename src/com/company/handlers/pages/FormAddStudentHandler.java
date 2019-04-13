package com.company.handlers.pages;

import com.company.Main;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class FormAddStudentHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange httpExchange) {
        if (httpExchange.getRequestMethod().equalsIgnoreCase("GET")) {
            String resp =
                    "<p><label for=\"firstName\">Имя</label><input type=\"text\" id=\"firstName\" name=\"form-text\" value=\"XX\"/></p>" +
                            "<p><label for=\"lastName\">Фамилия</label><input type=\"text\" id=\"lastName\" name=\"form-text\"/></p>" +
                            "<p><label for=\"yearBirth\">Год рождения</label><input type=\"text\" id=\"yearBirth\" name=\"form-text\"/></p>";
            httpExchange.setAttribute("Content-Type", "text/html");
            Main.writeResponse(httpExchange, resp);
        }
    }
}
