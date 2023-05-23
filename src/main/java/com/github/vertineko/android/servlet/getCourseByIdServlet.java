package com.github.vertineko.android.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.vertineko.android.service.CourseService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "getCourseByIdServlet", value = "/getCourseByIdServlet")
public class getCourseByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int course_id = Integer.parseInt(request.getParameter("course_id"));
        if(CourseService.getCourseService().getCourseById(course_id) != null){
            response.getWriter().print("{\"flag\":true,\"course\":" + JSON.toJSONString(CourseService.getCourseService().getCourseById(course_id)) + "}");
        }else {
            response.getWriter().print("{\"flag\":false}");
        }
    }
}
