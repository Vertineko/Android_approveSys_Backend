package com.github.vertineko.android.servlet;

import com.github.vertineko.android.model.Apply;
import com.github.vertineko.android.model.Status;
import com.github.vertineko.android.service.ApplyService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ConfigureServlet", value = "/ConfigureServlet")
public class ConfigureServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int apply_id = Integer.parseInt(request.getParameter("apply_id"));
        if(ApplyService.getApplyService().getApplyById(apply_id) != null){
            Apply apply = ApplyService.getApplyService().getApplyById(apply_id);
            apply.setStatus(Status.SUCCESS);
            ApplyService.getApplyService().updateApply(apply);
            response.getWriter().print("{\"flag\":true}");
        }else {
            response.getWriter().print("{\"flag\":false}");
        }
    }
}
