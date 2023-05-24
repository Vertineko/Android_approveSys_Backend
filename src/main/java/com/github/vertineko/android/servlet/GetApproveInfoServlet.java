package com.github.vertineko.android.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.vertineko.android.model.Apply;
import com.github.vertineko.android.model.Course;
import com.github.vertineko.android.model.Exfile;
import com.github.vertineko.android.model.User;
import com.github.vertineko.android.service.ApplyService;
import com.github.vertineko.android.service.CourseService;
import com.github.vertineko.android.service.FileService;
import com.github.vertineko.android.service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "GetApproveInfoServlet", value = "/GetApproveInfoServlet")
public class GetApproveInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int apply_id = Integer.parseInt(request.getParameter("apply_id"));
        Apply apply = ApplyService.getApplyService().getApplyById(apply_id);
        if(apply != null){
            User user = UserService.getUserService().findUserById(apply.getUser_id());
            Course course = CourseService.getCourseService().getCourseById(apply.getCourse_id());
            byte[] image = FileService.getFileService().getFile(apply_id).getFile();
            JSONObject jsonUser = JSON.parseObject(JSON.toJSONString(user));
            JSONObject jsonCourse = JSON.parseObject(JSON.toJSONString(course));
            String jsonApply = JSON.toJSONString(apply);
            String jsonImage = JSON.toJSONString(image);
            System.out.println("{\"flag\":true,\"course\":" +jsonCourse +",\"user\":"+jsonUser+",\"image\":"+jsonImage+ ",\"apply\":"+jsonApply+"}");
            response.getWriter().print("{\"flag\":true,\"course\":" +jsonCourse +",\"user\":"+jsonUser+",\"image\":"+jsonImage+ ",\"apply\":"+jsonApply+"}");
        }else {
            response.getWriter().print("{\"flag\":false}");
        }
    }
}
