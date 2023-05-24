package com.github.vertineko.android.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.vertineko.android.model.Apply;
import com.github.vertineko.android.model.Role;
import com.github.vertineko.android.model.Status;
import com.github.vertineko.android.service.ApplyService;
import com.github.vertineko.android.service.TeacherService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ApproveServlet", value = "/ApproveServlet")
public class ApproveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int ispass = Integer.parseInt(request.getParameter("ispass"));
        int apply_id = Integer.parseInt(request.getParameter("apply_id"));
        int teacher_id = Integer.parseInt(request.getParameter("teacher_id"));
        Apply apply = ApplyService.getApplyService().getApplyById(apply_id);

        JSONObject jsonObject = new JSONObject();
        if(apply != null){
            if(ispass == 1){
                if(TeacherService.getTeacherService().getTeacherById(teacher_id).getRole().equals(Role.SPEECHER)){
                    apply.setStatus(Status.PROCESSING_STAGE1);
                    apply.setTeacher1_id(teacher_id);
                    ApplyService.getApplyService().updateApply(apply);
                    jsonObject.put("flag","true");
                    response.getWriter().print(jsonObject);
                }else {
                    apply.setStatus(Status.PROCESSING_STAGE2);
                    apply.setTeacher2_id(teacher_id);
                    ApplyService.getApplyService().updateApply(apply);
                    jsonObject.put("flag","true");
                    response.getWriter().print(jsonObject);
                }
            }else {
                if(TeacherService.getTeacherService().getTeacherById(teacher_id).getRole().equals(Role.SPEECHER)){
                    apply.setStatus(Status.FAILED);
                    apply.setTeacher1_id(teacher_id);
                    ApplyService.getApplyService().updateApply(apply);
                    jsonObject.put("flag","true");
                    response.getWriter().print(jsonObject);
                }else {
                    apply.setStatus(Status.FAILED);
                    apply.setTeacher2_id(teacher_id);
                    ApplyService.getApplyService().updateApply(apply);
                    jsonObject.put("flag","true");
                    response.getWriter().print(jsonObject);
                }
            }
        }else {
            jsonObject.put("flag","false");
            response.getWriter().print(jsonObject);
        }
    }
}
