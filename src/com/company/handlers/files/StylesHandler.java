package com.company.handlers.files;

import com.company.Main;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class StylesHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange httpExchange) {
        if (httpExchange.getRequestMethod().equalsIgnoreCase("GET")) {
            String fileName = "styles.css";

            StringBuilder sb = new StringBuilder();
            File file = new File(fileName);
            try {
                try (BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()))) {
                    String s;
                    while ((s = in.readLine()) != null) {
                        sb.append(s);
                        sb.append("\n");
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            httpExchange.setAttribute("Content-Type", "text/plain");
            Main.writeResponse(httpExchange, String.format("%s", sb.toString()));
        }
    }
}
