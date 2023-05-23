package com.github.vertineko.android.service;

import com.github.vertineko.android.dao.FileDao;
import com.github.vertineko.android.model.Exfile;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class FileService {
    private static FileService fileService = new FileService();
    private FileService(){};
    public static FileService getFileService(){
        return fileService;
    }
    public void addFile(Exfile file) throws IOException {
        InputStream config = Resources.getResourceAsStream("com.github.vertineko.android/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            FileDao fileDao = sqlSession.getMapper(FileDao.class);
            if(file != null){
                fileDao.addFile(file);
            }
        }
    }
    public Exfile getFile(int id) throws IOException {
        InputStream config = Resources.getResourceAsStream("com.github.vertineko.android/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            FileDao fileDao = sqlSession.getMapper(FileDao.class);
            if(fileDao.getfile(id) != null){
                return fileDao.getfile(id);
            }else {
                return null;
            }
        }
    }


}
