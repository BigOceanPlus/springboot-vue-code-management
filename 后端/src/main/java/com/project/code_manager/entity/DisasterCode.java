<<<<<<< HEAD
package com.project.code_manager.entity;

import lombok.Data;

@Data
public class DisasterCode {
    String rawData;
    String major;
    String subclass;
    String quota;
    public void handle(){
        setMajor(rawData.substring(0,1));
        setSubclass(rawData.substring(1,3));
        setQuota(rawData.substring(3,6));
    }
    @Override
    public String toString(){
        return major + "-" + subclass + "-" + quota;
    }

    public String classEncode(){
        return major + subclass;
    }
=======
package com.project.code_manager.entity;

import lombok.Data;

@Data
public class DisasterCode {
    String rawData;
    String major;
    String subclass;
    String quota;
    public void handle(){
        setMajor(rawData.substring(0,1));
        setSubclass(rawData.substring(1,3));
        setQuota(rawData.substring(3,6));
    }
    @Override
    public String toString(){
        return major + "-" + subclass + "-" + quota;
    }

    public String classEncode(){
        return major + subclass;
    }
>>>>>>> ac191af (update)
}