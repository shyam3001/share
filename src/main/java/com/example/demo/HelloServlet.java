package com.example.demo;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // check with database
        if (username.equals("abc") && password.equals("123")) {
            req.getRequestDispatcher("next-page.jsp").forward(req, resp);
        }
        else {
            req.setAttribute("problem", "incorrect-login");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}