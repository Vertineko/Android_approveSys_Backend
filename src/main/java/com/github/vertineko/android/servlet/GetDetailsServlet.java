package com.github.vertineko.android.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.vertineko.android.service.ApplyService;
import com.github.vertineko.android.service.CourseService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "GetDetailsServlet", value = "/GetDetailsServlet")
public class GetDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int apply_id = Integer.parseInt(request.getParameter("apply_id"));
        int course_id = Integer.parseInt(request.getParameter("course_id"));
        if(ApplyService.getApplyService().getApplyById(apply_id) != null && CourseService.getCourseService().getCourseById(course_id) != null){
            JSONObject jsonApply = JSON.parseObject(JSON.toJSONString(ApplyService.getApplyService().getApplyById(apply_id)));
            JSONObject jsonCourse = JSON.parseObject(JSON.toJSONString(CourseService.getCourseService().getCourseById(course_id)));
            response.getWriter().print("{\"flag\":true,\"course\":" + jsonCourse + ",\"apply\":"+ jsonApply + "}");
        }else {
            response.getWriter().print("{\"flag\":false}");
        }
    }
}
