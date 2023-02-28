<<<<<<< HEAD
package com.project.code_manager.controller;

import com.project.code_manager.common.Result;
import com.project.code_manager.dao.UserDao;
import com.project.code_manager.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserDao userDao;

    @PostMapping("/login")
    public Result Login(@RequestBody User user){
        //System.out.println(user);
        if(userDao.findUser(user.getUsername(),user.getPassword()) != null)
            return Result.success();
        else
            return Result.error();
    }
    @GetMapping
    public Result findAll(){
        return Result.success(userDao.findAll());
    }
    @GetMapping("/{username}")
    public Result DeleteByUsername(@PathVariable String username){
        return Result.success(userDao.deleteByUsername(username));
    }
    @PostMapping("/insert")
    public Result InsertUser(@RequestBody User user){
        return Result.success(userDao.insertUser(user));
    }
    @PostMapping("/update")
    public Result UpdateUser(@RequestBody User user){
        return Result.success(userDao.updateUser(user));
    }
}
=======
package com.project.code_manager.controller;

import com.project.code_manager.common.Result;
import com.project.code_manager.dao.UserDao;
import com.project.code_manager.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserDao userDao;

    @PostMapping("/login")
    public Result Login(@RequestBody User user){
        //System.out.println(user);
        if(userDao.findUser(user.getUsername(),user.getPassword()) != null)
            return Result.success();
        else
            return Result.error();
    }
    @GetMapping
    public Result findAll(){
        return Result.success(userDao.findAll());
    }
    @GetMapping("/{username}")
    public Result DeleteByUsername(@PathVariable String username){
        return Result.success(userDao.deleteByUsername(username));
    }
    @PostMapping("/insert")
    public Result InsertUser(@RequestBody User user){
        return Result.success(userDao.insertUser(user));
    }
    @PostMapping("/update")
    public Result UpdateUser(@RequestBody User user){
        return Result.success(userDao.updateUser(user));
    }
}
>>>>>>> ac191af (update)
