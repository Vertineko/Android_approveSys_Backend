package com.github.vertineko.android.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.vertineko.android.service.ApplyService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "GetApprovePageServlet", value = "/GetApprovePageServlet")
public class GetApprovePageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int teacher_id = Integer.parseInt(request.getParameter("teacher_id"));
        int pageNum = Integer.parseInt(request.getParameter("pageNum"));
        int pageNow = Integer.parseInt(request.getParameter("pageNow"));
        if(ApplyService.getApplyService().getAllSelectedApply(teacher_id,pageNum,pageNow) != null){
            JSONArray jsonArray = JSON.parseArray(JSON.toJSONString(ApplyService.getApplyService().getAllApprove(teacher_id,(pageNow-1)*pageNum,pageNum)));
            response.getWriter().print("{\"flag\":true,\"applies\":" + jsonArray + "}");
        }else {
            response.getWriter().print("{\"flag\":false}");
        }
    }
}

