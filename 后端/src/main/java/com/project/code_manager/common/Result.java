<<<<<<< HEAD
package com.project.code_manager.common;

import lombok.Data;

@Data
public class Result {
    private boolean code;
    private String msg;
    private Object data;

    private static final boolean SUCCESS_CODE = true;
    private static final boolean ERROR_CODE = false;
    private static final String SUCCESS_MSG = "请求成功";
    private static final String ERROR_MSG = "请求失败";

    public static Result success(){
        Result result = new Result();
        result.setCode(SUCCESS_CODE);
        result.setMsg(SUCCESS_MSG);
        return result;
    }

    public static Result success(Object data){
        Result result = success();
        result.setData(data);
        return result;
    }

    public static Result error(){
        Result result = new Result();
        result.setCode(ERROR_CODE);
        result.setMsg(ERROR_MSG);
        return result;
    }

    public static Result error(String msg){
        Result result = error();
        result.setMsg(msg);
        return result;
    }
}
=======
package com.project.code_manager.common;

import lombok.Data;

@Data
public class Result {
    private boolean code;
    private String msg;
    private Object data;

    private static final boolean SUCCESS_CODE = true;
    private static final boolean ERROR_CODE = false;
    private static final String SUCCESS_MSG = "请求成功";
    private static final String ERROR_MSG = "请求失败";

    public static Result success(){
        Result result = new Result();
        result.setCode(SUCCESS_CODE);
        result.setMsg(SUCCESS_MSG);
        return result;
    }

    public static Result success(Object data){
        Result result = success();
        result.setData(data);
        return result;
    }

    public static Result error(){
        Result result = new Result();
        result.setCode(ERROR_CODE);
        result.setMsg(ERROR_MSG);
        return result;
    }

    public static Result error(String msg){
        Result result = error();
        result.setMsg(msg);
        return result;
    }
}
>>>>>>> ac191af (update)
