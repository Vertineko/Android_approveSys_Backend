package com.github.vertineko.android.dao;

import com.github.vertineko.android.model.Course;

import java.util.List;

public interface CourseDao {
    public void addCourse(Course course);
    public List<Course> getAllCourse();
    public Course getCourseById(int id);
    public void modify(Course course);
    public void delete(int id);
}
