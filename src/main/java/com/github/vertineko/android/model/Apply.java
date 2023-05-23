package com.github.vertineko.android.model;

public class Apply {
    private int course_id;
    private Status status;
    private int teacher1_id;
    private int teacher2_id;
    private int user_id;
    private String reason;
    private String note;
    private int id;

    public Apply(int course_id, Status status, int teacher1_id, int teacher2_id, int user_id, String reason,String note) {
        this.course_id = course_id;
        this.status = status;
        this.teacher1_id = teacher1_id;
        this.teacher2_id = teacher2_id;
        this.user_id = user_id;
        this.reason = reason;
        this.note = note;
    }

    public int getCourse_id() {
        return course_id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getTeacher1_id() {
        return teacher1_id;
    }

    public void setTeacher1_id(int teacher1_id) {
        this.teacher1_id = teacher1_id;
    }

    public int getTeacher2_id() {
        return teacher2_id;
    }

    public void setTeacher2_id(int teacher2_id) {
        this.teacher2_id = teacher2_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}
