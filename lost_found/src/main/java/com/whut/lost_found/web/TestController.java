package com.whut.lost_found.web;

import com.whut.lost_found.pojo.User;
import com.whut.lost_found.service.TestService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/7/21 0021.
 */
@Controller
@RequestMapping("/Test")
public class TestController {
    @RequestMapping("/getTest")
    public String getTest(){
        return "test";
    }
    @RequestMapping("/testJson")
    @ResponseBody
    public Object getTestJson(){
        User user=new User(2,"jia","测试");
        return user;
    }
    @RequestMapping("/testJSONObject")
    @ResponseBody
    public Object getJSONObject(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("resulet","success");
        JSONArray jsonArray=new JSONArray();
        String []name={"jia","jun","long"};
        for(int i=0;i<3;i++){
            JSONObject jj=new JSONObject();
            jj.put("id",i);
            jj.put("name",name[i]);
            jj.put("zheshi","神坑");
            jsonArray.add(jj);
        }
        jsonObject.put("detil",jsonArray);
        return jsonObject;
    }

    @Autowired
    TestService testService;

    @RequestMapping(value = "/getAllUser")
    @ResponseBody
    public Object getAllUser(){
        return testService.getAllUser();
    }
}
