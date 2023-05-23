package com.github.vertineko.android.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.vertineko.android.service.CourseService;
import com.github.vertineko.android.service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.descriptor.JspConfigDescriptor;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ApplyInfoServlet", value = "/ApplyInfoServlet")
public class ApplyInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int course_id = Integer.parseInt(request.getParameter("course_id"));
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        if(CourseService.getCourseService().getCourseById(course_id) != null && UserService.getUserService().findUserById(user_id) != null){
            JSONObject jsonCourse = JSON.parseObject(JSON.toJSONString(CourseService.getCourseService().getCourseById(course_id)));
            JSONObject jsonUser = JSON.parseObject(JSON.toJSONString(UserService.getUserService().findUserById(user_id)));
            response.getWriter().print("{\"flag\":true" +",\"course\":" + jsonCourse + ",\"user\":" + jsonUser + "}");
        }else {
            response.getWriter().print("{\"flag\":false}");
        }
    }
}
