package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import com.example.model.Message;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

    @Override
    public void init() {
        System.out.println("Servlet initialized");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h1>Hello from a Java Servlet!</h1>");
    }

    @Override
    public void destroy() {
        System.out.println("Servlet destroyed");
    }

        @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        Message message = new Message("Hello from MVC!");

        request.setAttribute("msg", message);

        RequestDispatcher dispatcher =
                request.getRequestDispatcher("hello.jsp");

        dispatcher.forward(request, response);
    }
}
