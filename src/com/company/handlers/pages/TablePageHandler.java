package com.company.handlers.pages;

import com.company.Main;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class TablePageHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange t) {
        if (t.getRequestMethod().equalsIgnoreCase("GET")) {
            String resp =
                    "<table class=\"table information_json\">" +
                            "<tr>" +
                            "<th>Название поля</th>" +
                            "<th>Значение поля</th>" +
                            "<th></th>" +
                            "</tr>" +
                            "<tr class=\"information_json_plus\">" +
                            "<td></td>" +
                            "<td></td>" +
                            "<td><span class=\"btn btn-success plus pull-right\">+</span></td>" +
                            "</tr>" +
                            "</table>" +
                            "<script>" +
                            "// формируем новые поля" +
                            "jQuery('.plus').click(function(){" +
                            "jQuery('.information_json_plus').before(" +
                            "'<tr>' +\n" +
                            "'<td><input type=\"text\" class=\"form-control\" id=\"information_json_name[]\" placeholder=\"Название поля\"></td>' +" +
                            "'<td><input type=\"text\" class=\"form-control\" id=\"information_json_val[]\" placeholder=\"Значение поля\"></td>' +" +
                            "'<td><span class=\"btn btn-danger minus pull-right\">&ndash;</span></td>' +" +
                            "'</tr>'" +
                            ");" +
                            "});" +
                            "jQuery(document).on('click', '.minus', function(){" +
                            "jQuery( this ).closest( 'tr' ).remove();" +
                            "});" +
                            "</script>";
            t.setAttribute("Content-Type", "text/html");
            Main.writeResponse(t, resp);
        }
    }
}
