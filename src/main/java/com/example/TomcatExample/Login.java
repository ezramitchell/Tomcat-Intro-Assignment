package com.example.TomcatExample;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Login", value = "/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session;
        String path;
        //if not already authenticated send login page
        if ((
                session = request.getSession(false)) == null ||
                (session.getAttribute("user") != null && !((User) session.getAttribute("user")).isAuthenticated())) {
            path = "login.html";
        } else { //else send back to home
            path = "index.html";
        }

        RequestDispatcher view = request.getRequestDispatcher(path);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //login form, create session and send back to login
        HttpSession session = request.getSession(); //create session if not exists
        User user = (User) session.getAttribute("user");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //user already created
        if(user != null){
            if(!user.isAuthenticated() && password != null){
                user.authenticate(password);
            }
        } else{
            if(username != null){
                if(password != null) user = new User(username, password);
                else user = new User(username);
            }
        }

        session.setAttribute("user", user);
        response.sendRedirect("login");
    }
}
