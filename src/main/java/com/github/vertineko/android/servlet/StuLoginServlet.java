package com.github.vertineko.android.servlet;

import com.github.vertineko.android.service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "StuLoginServlet", value = "/StuLoginServlet")
public class StuLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var account = request.getParameter("account");
        var password = request.getParameter("password");
        if(UserService.getUserService().findUserByAccount(account) != null){
            if(password.equals(UserService.getUserService().findUserByAccount(account).getPassword())){
                response.getWriter().print("{\"flag\":true,\"id\":" + UserService.getUserService().findUserByAccount(account).getId() +"}");
            }else {
                response.getWriter().print("{\"flag\":false}");
            }
        }else {
            response.getWriter().print("{\"flag\":false}");
        }
    }
}
