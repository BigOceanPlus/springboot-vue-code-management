<<<<<<< HEAD
package com.project.code_manager.dao;

import com.project.code_manager.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {
    User findUser(@Param("username") String username, @Param("password") String password);
    List<User> findAll();
    int deleteByUsername(@Param("username") String username);
    int insertUser(User user);
    int updateUser(User user);
}
=======
package com.project.code_manager.dao;

import com.project.code_manager.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {
    User findUser(@Param("username") String username, @Param("password") String password);
    List<User> findAll();
    int deleteByUsername(@Param("username") String username);
    int insertUser(User user);
    int updateUser(User user);
}
>>>>>>> ac191af (update)
