package com.github.vertineko.android.dao;


import com.github.vertineko.android.model.Apply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApplyDao {
    public void addApply(Apply apply);
    public Apply getApply(@Param("course_id")int course_id , @Param("user_id")int user_id);
    public List<Apply> getSelectedApply(int user_id);
    public List<Apply> getApplyofClass_s1();
    //获得第一审批阶段当前老师所管理课程的所有申请
    public List<Apply> getApplyofClass_s2();
    //获得第二审批阶段当前老师所管理课程的所有申请
    public void removeApply(int id);
    public Apply getApplyById(int id);
    public void updateApply(Apply apply);
    public List<Apply> getAllApply();
    public List<Apply> getAllSelectedApply(@Param("user_id")int user_id,@Param("pageNum")int PageNum,@Param("pageNow")int PageNow);
    public int getCountSelectedApply(int user_id);

    public List<Apply> searchApply(@Param("user_id")String user_id,@Param("apply_id")String apply_id, @Param("course_id")String course_id, @Param("code")String code, @Param("name")String name, @Param("catalory")String catalory, @Param("creadit")String creadit, @Param("status")String status);
    public List<Apply> getAllApprove(@Param("teacher_id") int teacher_id,@Param("pageNum") int pageNum,@Param("pageNow") int pageNow);
    public List<Apply> searchApply2(@Param("teacher_id")String teacher_id,@Param("apply_id")String apply_id, @Param("course_id")String course_id, @Param("code")String code, @Param("name")String name, @Param("catalory")String catalory, @Param("creadit")String creadit, @Param("status")String status);
    public int getCountSelectedApprove(int teacher_id);
}
