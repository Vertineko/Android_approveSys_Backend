package com.github.vertineko.android.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.vertineko.android.model.Apply;
import com.github.vertineko.android.model.Role;
import com.github.vertineko.android.model.Teacher;
import com.github.vertineko.android.service.ApplyService;
import com.github.vertineko.android.service.TeacherService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetApproveServlet", value = "/GetApproveServlet")
public class GetApproveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int teacher_id = Integer.parseInt(request.getParameter("teacher_id"));
        Teacher teacher = TeacherService.getTeacherService().getTeacherById(teacher_id);
        if(teacher != null){
            if(teacher.getRole().equals(Role.SPEECHER)){
                List<Apply> applies = ApplyService.getApplyService().getApplyofClass_s1();
                JSONArray jsonArray = JSON.parseArray(JSON.toJSONString(applies));
                response.getWriter().print("{\"flag\":true,\"applies\":" + jsonArray + "}");
            }else {
                List<Apply> applies = ApplyService.getApplyService().getApplyofClass_s2();
                JSONArray jsonArray = JSON.parseArray(JSON.toJSONString(applies));
                response.getWriter().print("{\"flag\":true,\"applies\":" + jsonArray + "}");
            }
        }else {
            response.getWriter().print("{\"flag\":false}");
        }
    }
}
