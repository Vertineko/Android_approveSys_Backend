package com.github.vertineko.android.servlet;

import com.github.vertineko.android.service.ApplyService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "IsApplyExistServlet", value = "/IsApplyExistServlet")
public class IsApplyExistServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int apply_id = Integer.parseInt(request.getParameter("apply_id"));
        if(ApplyService.getApplyService().getApplyById(apply_id) != null){
            response.getWriter().print("{\"flag\":true,\"course_id\":" + ApplyService.getApplyService().getApplyById(apply_id).getCourse_id() + "}");
        }else {
            response.getWriter().print("{\"flag\":true}");
        }
    }
}
