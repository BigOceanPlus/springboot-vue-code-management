<<<<<<< HEAD
package com.project.code_manager.controller;

import com.project.code_manager.common.Result;
import com.project.code_manager.dao.ChartDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chart")
public class EchartController {
    @Autowired
    ChartDao chartDao;

    @GetMapping("/carrier")
    public Result GetCarrier(){
        return Result.success(chartDao.getCarrier());
    }
}
=======
package com.project.code_manager.controller;

import com.project.code_manager.common.Result;
import com.project.code_manager.dao.ChartDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chart")
public class EchartController {
    @Autowired
    ChartDao chartDao;

    @GetMapping("/carrier")
    public Result GetCarrier(){
        return Result.success(chartDao.getCarrier());
    }
}
>>>>>>> ac191af (update)
