package com.github.vertineko.android.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.vertineko.android.model.Course;
import com.github.vertineko.android.service.CourseService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetCoursesServlet", value = "/GetCoursesServlet")
public class GetCoursesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Course> courses = CourseService.getCourseService().getAllCourse();
        if(courses != null){
            JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(courses));
            response.getWriter().print("{\"flag\":true,\"courses\":" + jsonArray + "}");

        }else {
            response.getWriter().print("{\"flag\":false}");
        }
    }
}
