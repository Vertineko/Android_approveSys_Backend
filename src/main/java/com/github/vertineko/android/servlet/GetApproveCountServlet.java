package com.github.vertineko.android.servlet;

import com.github.vertineko.android.service.ApplyService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "GetApproveCountServlet", value = "/GetApproveCountServlet")
public class GetApproveCountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int teacher_id = Integer.parseInt(request.getParameter("teacher_id"));
        int count = ApplyService.getApplyService().getCountSelectedApprove(teacher_id);
        response.getWriter().print("{\"flag\":true,\"count\":" + count + "}");
    }
}
