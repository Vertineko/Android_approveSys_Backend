package com.github.vertineko.android.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.vertineko.android.model.Teacher;
import com.github.vertineko.android.service.TeacherService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "TchLoginServlet", value = "/TchLoginServlet")
public class TchLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var account = request.getParameter("account");
        var password = request.getParameter("password");
        if(TeacherService.getTeacherService().getTeacher(account) != null){
            if(TeacherService.getTeacherService().getTeacher(account).getPassword().equals(password)){
                Teacher teacher = TeacherService.getTeacherService().getTeacher(account);
                JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(teacher));
                response.getWriter().print("{\"flag\":true,\"teacher\":"+jsonObject+ "}");
            }else {
                response.getWriter().print("{\"flag\":false}");
            }
        }else {
            response.getWriter().print("{\"flag\":false}");
        }
    }
}
