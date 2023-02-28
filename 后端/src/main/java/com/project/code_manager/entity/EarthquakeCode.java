<<<<<<< HEAD
package com.project.code_manager.entity;

import lombok.Data;

@Data
public class EarthquakeCode {
    String rawData;
    GeographicInformationCode geographicInformation;
    TimeCode time;

    public void handle(){
        geographicInformation = new GeographicInformationCode();
        time = new TimeCode();
        getGeographicInformation().setRawData(rawData.substring(0,12));
        getTime().setRawData(rawData.substring(12,26));
    }

=======
package com.project.code_manager.entity;

import lombok.Data;

@Data
public class EarthquakeCode {
    String rawData;
    GeographicInformationCode geographicInformation;
    TimeCode time;

    public void handle(){
        geographicInformation = new GeographicInformationCode();
        time = new TimeCode();
        getGeographicInformation().setRawData(rawData.substring(0,12));
        getTime().setRawData(rawData.substring(12,26));
    }

>>>>>>> ac191af (update)
}