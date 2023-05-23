package com.github.vertineko.android.servlet;

import com.github.vertineko.android.model.Apply;
import com.github.vertineko.android.service.ApplyService;
import com.github.vertineko.android.service.CourseService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "isApplyExisitServlet", value = "/isApplyExisitServlet")
public class isApplyExisitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        int course_id = Integer.parseInt(request.getParameter("course_id"));
        if(ApplyService.getApplyService().getApply(course_id,user_id) == null){
            response.getWriter().print("{\"flag\":true}");
        }else {
            response.getWriter().print("{\"flag\":false}");
        }
    }
}
