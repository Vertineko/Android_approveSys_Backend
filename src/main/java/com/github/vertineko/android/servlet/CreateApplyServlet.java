package com.github.vertineko.android.servlet;

import com.github.vertineko.android.model.Apply;
import com.github.vertineko.android.model.Exfile;
import com.github.vertineko.android.model.Status;
import com.github.vertineko.android.service.ApplyService;
import com.github.vertineko.android.service.FileService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.File;
import java.io.IOException;

@WebServlet(name = "CreateApplyServlet", value = "/CreateApplyServlet")
@MultipartConfig(maxFileSize = 41194304)
public class CreateApplyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part user_idPart = request.getPart("user_id");
        Part course_idPart = request.getPart("course_id");
        Part filePart = request.getPart("image");
        Part reasonPart = request.getPart("reason");
        int user_id = Integer.parseInt(new String(user_idPart.getInputStream().readAllBytes()));
        int course_id = Integer.parseInt(new String(course_idPart.getInputStream().readAllBytes()));
        String reason = new String(reasonPart.getInputStream().readAllBytes());
        Apply apply = new Apply(course_id, Status.SUBMITTED,-1,-1,user_id,reason,"");
        ApplyService.getApplyService().addApply(apply);
        int apply_id = ApplyService.getApplyService().getApply(course_id,user_id).getId();
        if(filePart.getInputStream().readAllBytes() != null){
            Exfile exfile = new Exfile(apply_id,"image/jpeg",filePart.getInputStream().readAllBytes());
            FileService.getFileService().addFile(exfile);
            response.getWriter().print("{\"flag\":true}");
        }else {
            response.getWriter().print("{\"flag\":false}");
        }

     }
}
