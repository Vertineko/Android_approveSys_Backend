package com.github.vertineko.android.service;

import com.github.vertineko.android.dao.ApplyDao;
import com.github.vertineko.android.model.Apply;
import com.github.vertineko.android.model.Status;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ApplyService {
    private static ApplyService applyService = new ApplyService();
    private ApplyService(){};
    public static ApplyService getApplyService(){
        return applyService;
    }
    public void addApply(Apply apply) throws IOException {
        InputStream config = Resources.getResourceAsStream("com.github.vertineko.android/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            ApplyDao applyDao = sqlSession.getMapper(ApplyDao.class);
            if(apply != null){
                applyDao.addApply(apply);
            }
        }
    }

    public Apply getApply(int course_id , int user_id) throws IOException {
        InputStream config = Resources.getResourceAsStream("com.github.vertineko.android/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            ApplyDao applyDao = sqlSession.getMapper(ApplyDao.class);
            if(applyDao.getApply(course_id,user_id) != null){
                Apply apply = applyDao.getApply(course_id,user_id);
                return apply;
            }else {
                return null;
            }
        }
    }

    public List<Apply> getSelectedApply(int user_id) throws IOException{
        InputStream config = Resources.getResourceAsStream("com.github.vertineko.android/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            ApplyDao applyDao = sqlSession.getMapper(ApplyDao.class);
            if(applyDao.getSelectedApply(user_id) != null){
                return applyDao.getSelectedApply(user_id);
            }else {
                return null;
            }
        }
    }

    public List<Apply> getApplyofClass_s1() throws IOException{
        InputStream config = Resources.getResourceAsStream("com.github.vertineko.android/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            ApplyDao applyDao = sqlSession.getMapper(ApplyDao.class);
            if(applyDao.getApplyofClass_s1() != null){
                return applyDao.getApplyofClass_s1();
            }
            return null;
        }
    }

    public List<Apply> getApplyofClass_s2() throws IOException{
        InputStream config = Resources.getResourceAsStream("com.github.vertineko.android/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            ApplyDao applyDao = sqlSession.getMapper(ApplyDao.class);
            if(applyDao.getApplyofClass_s2() != null){
                return applyDao.getApplyofClass_s2();
            }
            return null;
        }
    }

    public Apply getApplyById(int id) throws IOException{
        InputStream config = Resources.getResourceAsStream("com.github.vertineko.android/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            ApplyDao applyDao = sqlSession.getMapper(ApplyDao.class);
            if(applyDao.getApplyById(id) != null){
                return applyDao.getApplyById(id);
            }
            return null;
        }
    }

    public void removeApply(int id) throws IOException{
        InputStream config = Resources.getResourceAsStream("com.github.vertineko.android/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            ApplyDao applyDao = sqlSession.getMapper(ApplyDao.class);
            applyDao.removeApply(id);
        }
    }

    public void updateApply(Apply apply) throws IOException{
        InputStream config = Resources.getResourceAsStream("com.github.vertineko.android/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            ApplyDao applyDao = sqlSession.getMapper(ApplyDao.class);
            applyDao.updateApply(apply);
        }
    }

    public List<Apply> getAllApply() throws IOException{
        InputStream config = Resources.getResourceAsStream("com.github.vertineko.android/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            ApplyDao applyDao = sqlSession.getMapper(ApplyDao.class);
            if(applyDao.getAllApply() != null){
                return applyDao.getAllApply();
            }
            return null;
        }
    }

    public List<Apply> getAllSelectedApply(int id,int pageNum,int pageNow) throws IOException{
        InputStream config = Resources.getResourceAsStream("com.github.vertineko.android/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            ApplyDao applyDao = sqlSession.getMapper(ApplyDao.class);
            if(applyDao.getAllSelectedApply(id,pageNum,pageNow) != null){
                return applyDao.getAllSelectedApply(id,pageNum,pageNow);
            }
            return null;
        }

    }

    public int getCountSelectedApply(int user_id) throws IOException{
        InputStream config = Resources.getResourceAsStream("com.github.vertineko.android/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            ApplyDao applyDao = sqlSession.getMapper(ApplyDao.class);
            return applyDao.getCountSelectedApply(user_id);
        }
    }
    public List<Apply> searchApply (String user_id,String apply_id, String course_id, String code, String name, String catalory, String creadit, String status) throws IOException{
        InputStream config = Resources.getResourceAsStream("com.github.vertineko.android/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            ApplyDao applyDao = sqlSession.getMapper(ApplyDao.class);
            if(applyDao.searchApply(user_id,apply_id,course_id,code,name,catalory,creadit,status) != null){
                return applyDao.searchApply(user_id,apply_id,course_id,code,name,catalory,creadit,status);
            }
            return null;
        }
    }

    public List<Apply> getAllApprove(int teacher_id,int pageNum,int pageNow) throws IOException{
        InputStream config = Resources.getResourceAsStream("com.github.vertineko.android/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            ApplyDao applyDao = sqlSession.getMapper(ApplyDao.class);
            if(applyDao.getAllApprove(teacher_id, pageNum, pageNow) != null){
                return applyDao.getAllApprove(teacher_id, pageNum, pageNow);
            }
            return null;
        }
    }

    public List<Apply> searchApply2 (String teacher_id,String apply_id, String course_id, String code, String name, String catalory, String creadit, String status) throws IOException{
        InputStream config = Resources.getResourceAsStream("com.github.vertineko.android/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            ApplyDao applyDao = sqlSession.getMapper(ApplyDao.class);{
                if(applyDao.searchApply2(teacher_id,apply_id,course_id,code,name,catalory,creadit,status) != null){
                    return applyDao.searchApply2(teacher_id,apply_id,course_id,code,name,catalory,creadit,status);
                }
                return null;
            }
        }
    }

    public int getCountSelectedApprove(int teacher_id) throws IOException{
        InputStream config = Resources.getResourceAsStream("com.github.vertineko.android/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            ApplyDao applyDao = sqlSession.getMapper(ApplyDao.class);
            return applyDao.getCountSelectedApprove(teacher_id);
        }
    }
}
