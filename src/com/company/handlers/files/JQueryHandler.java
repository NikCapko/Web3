package com.company.handlers.files;

import com.company.Main;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;

public class JQueryHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange t) {
        if (t.getRequestMethod().equalsIgnoreCase("GET")) {
            String fileName = "jquery-3.3.1.js";

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
            Main.writeResponse(t, String.format("%s", sb.toString()));
        }
    }
}
