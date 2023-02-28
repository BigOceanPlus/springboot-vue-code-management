<<<<<<< HEAD
package com.project.code_manager.controller;

import com.project.code_manager.common.Result;
import com.project.code_manager.dao.CodeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/file")
public class FileController {
    private final String address = "D://IDEA_source//code_manager//src//main//java//com//project//code_manager//file";
    private final String path = "/file";

    @Autowired
    CodeController codeController;

    @PostMapping("/upload/{id}")
    public Result fileUpload(MultipartFile file,HttpServletRequest req,@PathVariable long id){
        String filename = file.getOriginalFilename();
        String[] msg = filename.split("\\.");

        System.out.println(filename);
        System.out.println(msg);

        File folder = new File(address);
        if(!folder.exists()) folder.mkdirs();
        String newName = UUID.randomUUID().toString() + "." + msg[1];

        try{
            file.transferTo(new File(folder, newName));
            String url = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + path + "/" + newName;
            codeController.AddUrl(url,id);
            return Result.success(url);
        }
        catch (IOException e){
            e.printStackTrace();
            return Result.error();
        }
    }
    @PostMapping("/code/upload")
    public Result fileCodeUpload(MultipartFile file,HttpServletRequest req){
        String filename = file.getOriginalFilename();
        String[] msg = filename.split("\\.");
        System.out.println(filename);
        if(msg[0].length() != 36) return Result.error("文件名称不对");

        long id = (long)codeController.decodeInsert(msg[0]).getData();
        System.out.println(id);
        File folder = new File(address);
        if(!folder.exists()) folder.mkdirs();
        String newName = UUID.randomUUID().toString() + "." + msg[1];

        try{
            file.transferTo(new File(folder, newName));
            String url = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + path + "/" + newName;
            codeController.AddUrl(url,id);
            return Result.success(url);
        }
        catch (IOException e){
            e.printStackTrace();
            return Result.error();
        }
    }
}
=======
package com.project.code_manager.controller;

import com.project.code_manager.common.Result;
import com.project.code_manager.dao.CodeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/file")
public class FileController {
    private final String address = "D://IDEA_source//code_manager//src//main//java//com//project//code_manager//file";
    private final String path = "/file";

    @Autowired
    CodeController codeController;

    @PostMapping("/upload/{id}")
    public Result fileUpload(MultipartFile file,HttpServletRequest req,@PathVariable long id){
        String filename = file.getOriginalFilename();
        String[] msg = filename.split("\\.");

        System.out.println(filename);
        System.out.println(msg);

        File folder = new File(address);
        if(!folder.exists()) folder.mkdirs();
        String newName = UUID.randomUUID().toString() + "." + msg[1];

        try{
            file.transferTo(new File(folder, newName));
            String url = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + path + "/" + newName;
            codeController.AddUrl(url,id);
            return Result.success(url);
        }
        catch (IOException e){
            e.printStackTrace();
            return Result.error();
        }
    }
    @PostMapping("/code/upload")
    public Result fileCodeUpload(MultipartFile file,HttpServletRequest req){
        String filename = file.getOriginalFilename();
        String[] msg = filename.split("\\.");
        System.out.println(filename);
        if(msg[0].length() != 36) return Result.error("文件名称不对");

        long id = (long)codeController.decodeInsert(msg[0]).getData();
        System.out.println(id);
        File folder = new File(address);
        if(!folder.exists()) folder.mkdirs();
        String newName = UUID.randomUUID().toString() + "." + msg[1];

        try{
            file.transferTo(new File(folder, newName));
            String url = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + path + "/" + newName;
            codeController.AddUrl(url,id);
            return Result.success(url);
        }
        catch (IOException e){
            e.printStackTrace();
            return Result.error();
        }
    }
}
>>>>>>> ac191af (update)
