package com.company.handlers.pages;

import com.company.Main;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class SecondPageHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange t) {
        if (t.getRequestMethod().equalsIgnoreCase("GET")) {
            String resp =
                    "<p>" +
                    "<label for=\"rim\">Римское число:</label>" +
                    "<input type=\"text\" id=\"rim\" name=\"form-text\" value=\"XX\" />" +
                    "</p>" +
                    "<input type=\"submit\" value=\"Отправить\" onclick=\"sendNumber()\">" +
                    "<p>" +
                    "<label for=\"arabic\">Арабское число: </label>" +
                    "<input type=\"text\" id=\"arabic\" readonly />" +
                    "</p>";
            t.setAttribute("Content-Type", "text/html");
            Main.writeResponse(t, resp);
        }
    }
}
