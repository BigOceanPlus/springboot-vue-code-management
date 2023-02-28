<<<<<<< HEAD
package com.project.code_manager.entity;

import lombok.Data;

@Data
public class GeographicInformationCode{
    String rawData;
    String province;
    String prefecture;
    String county;
    String street;
    String community;

    public void handle(){
        setProvince(rawData.substring(0,2));
        setPrefecture(rawData.substring(2,4));
        setCounty(rawData.substring(4,6));
        setStreet(rawData.substring(6,9));
        setCommunity(rawData.substring(9,12));
    }

    @Override
    public String toString(){
        return province + prefecture + county + street + community;
    }

    public String encode(){
        return province + prefecture + county + street + community;
    }
=======
package com.project.code_manager.entity;

import lombok.Data;

@Data
public class GeographicInformationCode{
    String rawData;
    String province;
    String prefecture;
    String county;
    String street;
    String community;

    public void handle(){
        setProvince(rawData.substring(0,2));
        setPrefecture(rawData.substring(2,4));
        setCounty(rawData.substring(4,6));
        setStreet(rawData.substring(6,9));
        setCommunity(rawData.substring(9,12));
    }

    @Override
    public String toString(){
        return province + prefecture + county + street + community;
    }

    public String encode(){
        return province + prefecture + county + street + community;
    }
>>>>>>> ac191af (update)
}