<<<<<<< HEAD
package com.project.code_manager.entity;

import lombok.Data;

import java.io.Serializable;

// 110101001001202105220204003000101002
@Data
public class Code implements Serializable {
    String rawData;
    EarthquakeCode earthquake;
    SourceCode source;
    String carrier;
    DisasterCode disaster;

    public Code(String rawData){
        setRawData(rawData);

        earthquake = new EarthquakeCode();
        disaster = new DisasterCode();
        source = new SourceCode();

        getEarthquake().setRawData(rawData.substring(0,26)); // 震情码
        getSource().setRawData(rawData.substring(26,29)); // 来源码
        carrier = rawData.substring(29,30);  // 载体码
        getDisaster().setRawData(rawData.substring(30,36));  // 灾情码

        getEarthquake().handle();
        getEarthquake().getGeographicInformation().handle();
        getEarthquake().getTime().handle();
        getDisaster().handle();
        getSource().handle();
    }

}
=======
package com.project.code_manager.entity;

import lombok.Data;

import java.io.Serializable;

// 110101001001202105220204003000101002
@Data
public class Code implements Serializable {
    String rawData;
    EarthquakeCode earthquake;
    SourceCode source;
    String carrier;
    DisasterCode disaster;

    public Code(String rawData){
        setRawData(rawData);

        earthquake = new EarthquakeCode();
        disaster = new DisasterCode();
        source = new SourceCode();

        getEarthquake().setRawData(rawData.substring(0,26)); // 震情码
        getSource().setRawData(rawData.substring(26,29)); // 来源码
        carrier = rawData.substring(29,30);  // 载体码
        getDisaster().setRawData(rawData.substring(30,36));  // 灾情码

        getEarthquake().handle();
        getEarthquake().getGeographicInformation().handle();
        getEarthquake().getTime().handle();
        getDisaster().handle();
        getSource().handle();
    }

}
>>>>>>> ac191af (update)
