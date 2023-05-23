package com.github.vertineko.android.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.vertineko.android.service.ApplyService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ShowProcessingApplyServlet", value = "/ShowProcessingApplyServlet")
public class ShowProcessingApplyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        if(ApplyService.getApplyService().getSelectedApply(user_id) != null){
            JSONArray jsonArray = JSON.parseArray(JSON.toJSONString(ApplyService.getApplyService().getSelectedApply(user_id)));
            response.getWriter().print("{\"flag\":true,\"courses\":" + jsonArray + "}");
        }else {
            response.getWriter().print("{\"flag\":false}");
        }
    }
}
