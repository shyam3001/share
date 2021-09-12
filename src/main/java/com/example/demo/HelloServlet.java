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
            // update database here
            System.out.println("Updating Database");

            new Thread(() -> {
                try {
                    // send the email here
                    System.out.println("Trying to Send Email");
                    // assume it takes 10 seconds to send the email
                    Thread.sleep(10000);
                    System.out.println("Email sent");
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            }).start();

            System.out.println("Request Dispatching...");
            req.getRequestDispatcher("next-page.jsp").forward(req, resp);
        }
        else {
            req.setAttribute("problem", "incorrect-login");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}