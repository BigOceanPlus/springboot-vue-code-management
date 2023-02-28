<<<<<<< HEAD
package com.project.code_manager.entity;

import lombok.Data;

@Data
public class SourceCode {
    String rawData;
    String major;
    String subclass;
    public void handle(){
        major = rawData.substring(0,1);
        subclass = rawData.substring(1,3);
    }
    @Override
    public String toString(){
        return major + "-" + subclass;
    }
    public String encode(){
        return major + subclass;
    }
}
=======
package com.project.code_manager.entity;

import lombok.Data;

@Data
public class SourceCode {
    String rawData;
    String major;
    String subclass;
    public void handle(){
        major = rawData.substring(0,1);
        subclass = rawData.substring(1,3);
    }
    @Override
    public String toString(){
        return major + "-" + subclass;
    }
    public String encode(){
        return major + subclass;
    }
}
>>>>>>> ac191af (update)
