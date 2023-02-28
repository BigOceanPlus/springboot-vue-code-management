<<<<<<< HEAD
package com.project.code_manager.entity;

import lombok.Data;

@Data
public class CodeItem {
    long id;
    String code;
    String geographic;
    String data_time;
    String source;
    String carrier;
    String disaster;
    String remark;
    String url;

    public CodeItem(String code, String geographic, String data_time, String source, String carrier, String disaster, String remark) {
        this.code = code;
        this.geographic = geographic;
        this.data_time = data_time;
        this.source = source;
        this.carrier = carrier;
        this.disaster = disaster;
        this.remark = remark;
    }
}
=======
package com.project.code_manager.entity;

import lombok.Data;

@Data
public class CodeItem {
    long id;
    String code;
    String geographic;
    String data_time;
    String source;
    String carrier;
    String disaster;
    String remark;
    String url;

    public CodeItem(String code, String geographic, String data_time, String source, String carrier, String disaster, String remark) {
        this.code = code;
        this.geographic = geographic;
        this.data_time = data_time;
        this.source = source;
        this.carrier = carrier;
        this.disaster = disaster;
        this.remark = remark;
    }
}
>>>>>>> ac191af (update)
