package com.company.handlers.pages;

import com.company.Main;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class FrontPageHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange t) {
        if (t.getRequestMethod().equalsIgnoreCase("GET")) {
            String resp = "<html>" +
                    "<head>" +
                    "<meta http-equiv=\"Content-Type\" content=\"text/html;charset=utf-8\">" +
                    "<script type=\"text/javascript\" src=\"jquery\"></script>" +
                    "<script type=\"text/javascript\" src=\"index\"></script>" +
                    "<link rel=\"stylesheet\" type=\"text/css\" href=\"styles\">" +
                    "<title>Example</title>" +
                    "</head>" +
                    "<body>" +
                    "<h1>Выполнил Цапко Николай</h1>" +
                    "<h2>группа ПИ-41</h2>" +
                    "<input type=\"button\" value=\"Перейти к заданию\" onclick=\"openTable()\" />" +
                    "</body>" +
                    "</html>";
            t.setAttribute("Content-Type", "text/html");
            Main.writeResponse(t, resp);
        }
    }
}
