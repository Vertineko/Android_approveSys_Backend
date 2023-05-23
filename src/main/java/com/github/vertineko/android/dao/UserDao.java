package com.github.vertineko.android.dao;

import com.github.vertineko.android.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    public void addUser(User user);
    public void deleteUser(int id);
    public User findUserById(int id);
    public User findUserByAccount(String account);
    public void modifyUser(User user);
    public List<User> getAllUser();
}
