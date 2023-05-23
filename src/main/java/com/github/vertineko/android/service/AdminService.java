package com.github.vertineko.android.service;


import com.github.vertineko.android.dao.AdminDao;
import com.github.vertineko.android.model.Admin;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AdminService {
    private static AdminService adminService = new AdminService();
    private AdminService(){};
    public static AdminService getAdminService(){
        return adminService;
    }
    public boolean adminLogin(String username , String password) throws IOException{
        Admin admin = getAdmin(username);
        if(admin != null){
            if(admin.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
    public Admin getAdmin(String username) throws IOException {
        InputStream config = Resources.getResourceAsStream("com.github.vertineko.android/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
            if(adminDao.getAdmin(username) != null){
                return adminDao.getAdmin(username);
            }else {
                return null;
            }
        }
    }

    public List<Admin> getAllAdmin() throws IOException{
        InputStream config = Resources.getResourceAsStream("com.github.vertineko.android/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
            if(adminDao.getAllAdmin() != null){
                return adminDao.getAllAdmin();
            }
            return null;
        }
    }

    public void addAdmin(Admin admin) throws IOException{
        InputStream config = Resources.getResourceAsStream("com.github.vertineko.android/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
            if(getAdmin(admin.getUsername()) == null){
                adminDao.addAdmin(admin);
            }
        }
    }

    public Admin getAdminById(int id) throws IOException{
        InputStream config = Resources.getResourceAsStream("com.github.vertineko.android/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
            if(adminDao.getAdminById(id) != null){
                return adminDao.getAdminById(id);
            }
            return null;
        }
    }

    public void delete(int id) throws IOException{
        InputStream config = Resources.getResourceAsStream("com.github.vertineko.android/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
            if(adminDao.getAdminById(id) != null){
                adminDao.delete(id);
            }
        }
    }

    public void modify(Admin admin) throws IOException{
        InputStream config = Resources.getResourceAsStream("com.github.vertineko.android/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
            if(adminDao.getAdminById(admin.getId()) != null){
                adminDao.modify(admin);
            }
        }
    }
}
