package tms.lesson18;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;

public class Solution {
    public static void main(String[] args) throws IOException {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress("localhost", 8080), 0);
        httpServer.createContext("/calc", new MyHandler());
        httpServer.start();

    }

    private static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exchange.getRequestBody()));
            String query = exchange.getRequestURI().getQuery();
            String[] values = query.split("&");

            String result = "result = ";
            int num1 = Integer.parseInt(values[0].substring(5));
            int num2 = Integer.parseInt(values[1].substring(5));
            String operation = values[2].substring(10);

            switch (operation) {
                case "sum":
                    result = result + (num1 + num2);
                    break;
                case "sub":
                    result = result + (num1 - num2);
                    break;
                case "mul":
                    result = result + (num1 * num2);
                    break;
                case "div":
                    result = result + (num1 / num2);
                    break;
            }
            exchange.sendResponseHeaders(200,result.length());
            exchange.getResponseBody().write(result.getBytes());
            exchange.getResponseBody().close();
            bufferedReader.close();
        }
    }
}
