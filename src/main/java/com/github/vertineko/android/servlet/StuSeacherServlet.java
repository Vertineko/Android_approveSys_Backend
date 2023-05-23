package com.github.vertineko.android.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.vertineko.android.service.ApplyService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "StuSeacherServlet", value = "/StuSeacherServlet")
public class StuSeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_id = request.getParameter("user_id");
        String name = request.getParameter("name");
        String status = request.getParameter("status");
        if(ApplyService.getApplyService().searchApply(user_id,null,null,null,name,null,null,status) != null){
            JSONArray jsonArray = JSON.parseArray(JSON.toJSONString(ApplyService.getApplyService().searchApply(user_id,null,null,null,name,null,null,status)));
            response.getWriter().print("{\"flag\":true,\"applies\":" + jsonArray + "}");
        }else {
            response.getWriter().print("{\"flag\":false}");
        }
    }
}
