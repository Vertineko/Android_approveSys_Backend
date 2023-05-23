package com.github.vertineko.android.servlet;

import com.github.vertineko.android.service.ApplyService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "GetApplyCountServlet", value = "/GetApplyCountServlet")
public class GetApplyCountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        int count = ApplyService.getApplyService().getCountSelectedApply(user_id);
        response.getWriter().print("{\"flag\":true,\"count\":" + count + "}");
    }
}
