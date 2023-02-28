<<<<<<< HEAD
package com.project.code_manager.controller;

import com.project.code_manager.common.Result;
import com.project.code_manager.dao.CodeDao;
import com.project.code_manager.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController  // 110101001001202105220204003000101002
@RequestMapping("/code")
public class CodeController {
    @Autowired
    private CodeDao codeDao;

    @GetMapping("/decode/{input}")
    public Result decode(@PathVariable String input){
        Code code = new Code(input);
        // boolean flag = true;

        DataTimeHandler1(code.getEarthquake().getTime());
        code.getEarthquake().setGeographicInformation(codeDao.DecodeGeographicInformationCode(code.getEarthquake().getGeographicInformation()));
        DisasterCode disasterCodeCopy = code.getDisaster();
        code.setDisaster(codeDao.DecodeDisasterCodeSubclass(disasterCodeCopy));
        code.getDisaster().setQuota(codeDao.DecodeDisasterCodeQuota(disasterCodeCopy).getQuota());
        code.setSource(codeDao.DecodeSourceCode(code.getSource()));
        code.setCarrier(codeDao.DecodeCarrierCode(code.getCarrier()));

        return Result.success(code);
    }

    @PostMapping("/encode")
    public Result encode(@RequestBody CodeRequest codeRequest){
        System.out.println(codeRequest);
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(codeDao.EncodeGeographicInformationCode(codeRequest.getProvince(),codeRequest.getPrefecture(), codeRequest.getCounty(), codeRequest.getStreet(), codeRequest.getCommunity()).encode());
        stringBuilder.append(DataTimeHandler2(codeRequest.getData(),codeRequest.getTime()));
        stringBuilder.append(codeDao.EncodeSourceCode(codeRequest.getSourceMajor(),codeRequest.getSourceSubclass()).encode());
        stringBuilder.append(codeDao.EncodeCarrierCode(codeRequest.getCarrier()));

        stringBuilder.append(codeDao.EncodeDisasterCodeSubclass(codeRequest.getDisasterMajor(),codeRequest.getDisasterSubclass()).classEncode());
        stringBuilder.append(codeDao.EncodeDisasterQuota(codeRequest.getDisasterQuota()));

        System.out.println(stringBuilder);

        return Result.success(stringBuilder.toString());
    }

    @GetMapping("/decode/insert/{input}")
    public Result decodeInsert(@PathVariable String input){
        Code code = (Code)decode(input).getData();
        CodeItem codeItem = new CodeItem(input,code.getEarthquake().getGeographicInformation().toString(),
                code.getEarthquake().getTime().toString(),
                code.getSource().toString(),
                code.getCarrier(),
                code.getDisaster().toString(),
                "");
        codeDao.InsertCode(codeItem);
        System.out.println(codeItem.getId());
        return Result.success(codeItem.getId());
    }

    @GetMapping("/decode/insert/json/{input}")
    public Result decodeJsonInsert(@PathVariable String input){
        Code code = (Code)decode(input).getData();
        CodeItem codeItem = new CodeItem(input,code.getEarthquake().getGeographicInformation().toString(),
                code.getEarthquake().getTime().toString(),
                code.getSource().toString(),
                code.getCarrier(),
                code.getDisaster().toString(),
                "");
        codeDao.InsertCode(codeItem);

        return Result.success(code);
    }

    @PostMapping("/encode/insert")
    public Result encodeInsert(@RequestBody CodeRequest codeRequest){
        String code = (String)encode(codeRequest).getData();
        CodeItem codeItem = new CodeItem(code,codeRequest.getProvince() + codeRequest.getPrefecture() + codeRequest.getCounty() + codeRequest.getStreet() + codeRequest.getCommunity(),
                DataTimeHandler3(codeRequest.getData(),codeRequest.getTime()),
                codeRequest.getSourceMajor() + "-" + codeRequest.getSourceSubclass(),
                codeRequest.getCarrier(),
                codeRequest.getDisasterMajor() + "-" + codeRequest.getDisasterSubclass() + "-" + codeRequest.getDisasterQuota(),
                codeRequest.getRemark());
        codeDao.InsertCode(codeItem);
        System.out.println(codeItem.getId());
        return Result.success(codeItem.getId());
    }

    @GetMapping("/item")
    public Result findAll(){
        return Result.success(codeDao.findAll());
    }
    @GetMapping("/item/{id}")
    public Result DeleteItem(@PathVariable long id){
        return Result.success(codeDao.deleteItem(id));
    }

    public int AddUrl(String url,long id){
        return codeDao.addUrl(url,id);
    }

    private void DataTimeHandler1(TimeCode timeCode){
        timeCode.setYear(timeCode.getYear() + "年");
        timeCode.setMonthAndDay(timeCode.getMonthAndDay().substring(0,2) + "月" + timeCode.getMonthAndDay().substring(2,4) + "日");
        timeCode.setHour(timeCode.getHour() + "时");
        timeCode.setMinute(timeCode.getMinute() + "分");
        timeCode.setSecond(timeCode.getSecond() + "秒");
    }

    private String DataTimeHandler2(String date, String time){
        String[] s1 = date.split("-");
        String[] s2 = time.split("-");
        return s1[0] + s1[1] + s1[2] + s2[0] + s2[1] + s2[2];
    }

    private String DataTimeHandler3(String date, String time){
        String[] s1 = date.split("-");
        String[] s2 = time.split("-");
        return s1[0] + "年" + s1[1] + "月" + s1[2] + "日-" + s2[0] + "时" + s2[1] + "分" + s2[2] + "秒";
    }
}
=======
package com.project.code_manager.controller;

import com.project.code_manager.common.Result;
import com.project.code_manager.dao.CodeDao;
import com.project.code_manager.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController  // 110101001001202105220204003000101002
@RequestMapping("/code")
public class CodeController {
    @Autowired
    private CodeDao codeDao;

    @GetMapping("/decode/{input}")
    public Result decode(@PathVariable String input){
        Code code = new Code(input);
        // boolean flag = true;

        DataTimeHandler1(code.getEarthquake().getTime());
        code.getEarthquake().setGeographicInformation(codeDao.DecodeGeographicInformationCode(code.getEarthquake().getGeographicInformation()));
        DisasterCode disasterCodeCopy = code.getDisaster();
        code.setDisaster(codeDao.DecodeDisasterCodeSubclass(disasterCodeCopy));
        code.getDisaster().setQuota(codeDao.DecodeDisasterCodeQuota(disasterCodeCopy).getQuota());
        code.setSource(codeDao.DecodeSourceCode(code.getSource()));
        code.setCarrier(codeDao.DecodeCarrierCode(code.getCarrier()));

        return Result.success(code);
    }

    @PostMapping("/encode")
    public Result encode(@RequestBody CodeRequest codeRequest){
        System.out.println(codeRequest);
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(codeDao.EncodeGeographicInformationCode(codeRequest.getProvince(),codeRequest.getPrefecture(), codeRequest.getCounty(), codeRequest.getStreet(), codeRequest.getCommunity()).encode());
        stringBuilder.append(DataTimeHandler2(codeRequest.getData(),codeRequest.getTime()));
        stringBuilder.append(codeDao.EncodeSourceCode(codeRequest.getSourceMajor(),codeRequest.getSourceSubclass()).encode());
        stringBuilder.append(codeDao.EncodeCarrierCode(codeRequest.getCarrier()));

        stringBuilder.append(codeDao.EncodeDisasterCodeSubclass(codeRequest.getDisasterMajor(),codeRequest.getDisasterSubclass()).classEncode());
        stringBuilder.append(codeDao.EncodeDisasterQuota(codeRequest.getDisasterQuota()));

        System.out.println(stringBuilder);

        return Result.success(stringBuilder.toString());
    }

    @GetMapping("/decode/insert/{input}")
    public Result decodeInsert(@PathVariable String input){
        Code code = (Code)decode(input).getData();
        CodeItem codeItem = new CodeItem(input,code.getEarthquake().getGeographicInformation().toString(),
                code.getEarthquake().getTime().toString(),
                code.getSource().toString(),
                code.getCarrier(),
                code.getDisaster().toString(),
                "");
        codeDao.InsertCode(codeItem);
        System.out.println(codeItem.getId());
        return Result.success(codeItem.getId());
    }

    @GetMapping("/decode/insert/json/{input}")
    public Result decodeJsonInsert(@PathVariable String input){
        Code code = (Code)decode(input).getData();
        CodeItem codeItem = new CodeItem(input,code.getEarthquake().getGeographicInformation().toString(),
                code.getEarthquake().getTime().toString(),
                code.getSource().toString(),
                code.getCarrier(),
                code.getDisaster().toString(),
                "");
        codeDao.InsertCode(codeItem);

        return Result.success(code);
    }

    @PostMapping("/encode/insert")
    public Result encodeInsert(@RequestBody CodeRequest codeRequest){
        String code = (String)encode(codeRequest).getData();
        CodeItem codeItem = new CodeItem(code,codeRequest.getProvince() + codeRequest.getPrefecture() + codeRequest.getCounty() + codeRequest.getStreet() + codeRequest.getCommunity(),
                DataTimeHandler3(codeRequest.getData(),codeRequest.getTime()),
                codeRequest.getSourceMajor() + "-" + codeRequest.getSourceSubclass(),
                codeRequest.getCarrier(),
                codeRequest.getDisasterMajor() + "-" + codeRequest.getDisasterSubclass() + "-" + codeRequest.getDisasterQuota(),
                codeRequest.getRemark());
        codeDao.InsertCode(codeItem);
        System.out.println(codeItem.getId());
        return Result.success(codeItem.getId());
    }

    @GetMapping("/item")
    public Result findAll(){
        return Result.success(codeDao.findAll());
    }
    @GetMapping("/item/{id}")
    public Result DeleteItem(@PathVariable long id){
        return Result.success(codeDao.deleteItem(id));
    }

    public int AddUrl(String url,long id){
        return codeDao.addUrl(url,id);
    }

    private void DataTimeHandler1(TimeCode timeCode){
        timeCode.setYear(timeCode.getYear() + "年");
        timeCode.setMonthAndDay(timeCode.getMonthAndDay().substring(0,2) + "月" + timeCode.getMonthAndDay().substring(2,4) + "日");
        timeCode.setHour(timeCode.getHour() + "时");
        timeCode.setMinute(timeCode.getMinute() + "分");
        timeCode.setSecond(timeCode.getSecond() + "秒");
    }

    private String DataTimeHandler2(String date, String time){
        String[] s1 = date.split("-");
        String[] s2 = time.split("-");
        return s1[0] + s1[1] + s1[2] + s2[0] + s2[1] + s2[2];
    }

    private String DataTimeHandler3(String date, String time){
        String[] s1 = date.split("-");
        String[] s2 = time.split("-");
        return s1[0] + "年" + s1[1] + "月" + s1[2] + "日-" + s2[0] + "时" + s2[1] + "分" + s2[2] + "秒";
    }
}
>>>>>>> ac191af (update)
