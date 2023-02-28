<<<<<<< HEAD
package com.project.code_manager.dao;

import com.project.code_manager.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CodeDao {
    // 解码
    GeographicInformationCode DecodeGeographicInformationCode(GeographicInformationCode code);
    DisasterCode DecodeDisasterCodeSubclass(DisasterCode disasterCode);
    DisasterCode DecodeDisasterCodeQuota(DisasterCode disasterCode);
    SourceCode DecodeSourceCode(SourceCode sourceCode);
    String DecodeCarrierCode(@Param("code") String CarrierCode);

    // 编码
    GeographicInformationCode EncodeGeographicInformationCode(@Param("province") String province,
                                                              @Param("prefecture") String prefecture,
                                                              @Param("county") String county,
                                                              @Param("street") String street,
                                                              @Param("community") String community);
    SourceCode EncodeSourceCode(@Param("major") String major,
                                @Param("subclass") String subclass);
    String EncodeCarrierCode(@Param("carrier") String carrier);
    DisasterCode EncodeDisasterCodeSubclass(@Param("major") String major,
                                            @Param("subclass") String subclass);
    String EncodeDisasterQuota(@Param("quota") String quota);

    // 项目
    int InsertCode(CodeItem codeItem);
    List<CodeItem> findAll();
    int deleteItem(@Param("id") long id);
    int addUrl(@Param("url") String url, @Param("id") long id);
}
=======
package com.project.code_manager.dao;

import com.project.code_manager.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CodeDao {
    // 解码
    GeographicInformationCode DecodeGeographicInformationCode(GeographicInformationCode code);
    DisasterCode DecodeDisasterCodeSubclass(DisasterCode disasterCode);
    DisasterCode DecodeDisasterCodeQuota(DisasterCode disasterCode);
    SourceCode DecodeSourceCode(SourceCode sourceCode);
    String DecodeCarrierCode(@Param("code") String CarrierCode);

    // 编码
    GeographicInformationCode EncodeGeographicInformationCode(@Param("province") String province,
                                                              @Param("prefecture") String prefecture,
                                                              @Param("county") String county,
                                                              @Param("street") String street,
                                                              @Param("community") String community);
    SourceCode EncodeSourceCode(@Param("major") String major,
                                @Param("subclass") String subclass);
    String EncodeCarrierCode(@Param("carrier") String carrier);
    DisasterCode EncodeDisasterCodeSubclass(@Param("major") String major,
                                            @Param("subclass") String subclass);
    String EncodeDisasterQuota(@Param("quota") String quota);

    // 项目
    int InsertCode(CodeItem codeItem);
    List<CodeItem> findAll();
    int deleteItem(@Param("id") long id);
    int addUrl(@Param("url") String url, @Param("id") long id);
}
>>>>>>> ac191af (update)
