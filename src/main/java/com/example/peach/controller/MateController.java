package com.example.peach.controller;

import com.example.peach.common.ServiceResponse;
import com.example.peach.pojo.Mate;
import com.example.peach.service.MateService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/11/22.
 */
@RestController
@RequestMapping("/mate")
public class MateController {
    @Resource
    private MateService mateService;

    /**
     * 根据userId查询
     */
    @RequestMapping(value = "/selectByuserId", method = RequestMethod.GET)
    public Map<String, Object> selectByuserId(Integer userId) {
        Mate mate = mateService.selectByuserId(userId);
        Map<String, Object> map = new HashMap<>();
        map.put("mate",mate);
        return  map;
    }
    /**
     * 添加Mate
     */
    @RequestMapping(value = "/insertMate",method = RequestMethod.POST)
    public ServiceResponse<String> insertMate(@ModelAttribute Mate mate){
        return mateService.insertMate(mate);
    }
    /**
     * 根据userId修改
     */
    @RequestMapping(value = "/updateMate",method = RequestMethod.POST)
    public ServiceResponse<String> updateMate(@ModelAttribute Mate mate){
        return mateService.updateMate(mate);
    }
}
