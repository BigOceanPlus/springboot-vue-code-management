<<<<<<< HEAD
package com.project.code_manager.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class FilePathConfig implements WebMvcConfigurer {
    @Value("/file/**") // http://localhost:9090/file/78b80a91-2d56-43ed-867b-ce84756594fa.doc
    private String path;
    // 文件存放的目录
    @Value("D://IDEA_source//code_manager//src//main//java//com//project//code_manager//file/")
    private String address;

    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler(path).addResourceLocations("file:" + address);
    }
}
=======
package com.project.code_manager.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class FilePathConfig implements WebMvcConfigurer {
    @Value("/file/**") // http://localhost:9090/file/78b80a91-2d56-43ed-867b-ce84756594fa.doc
    private String path;
    // 文件存放的目录
    @Value("D://IDEA_source//code_manager//src//main//java//com//project//code_manager//file/")
    private String address;

    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler(path).addResourceLocations("file:" + address);
    }
}
>>>>>>> ac191af (update)
