package com.example.TomcatExample;

import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GetUserData", value = "/GetUserData")
public class GetUserData extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session;
        User user;
        if((session = request.getSession(false)) != null && (user = (User)session.getAttribute("user")) != null && user.isAuthenticated()){
            UserData userData = user.getUserData();
            String dataJSON = new Gson().toJson(userData);
            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.println(dataJSON);
            out.flush();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
