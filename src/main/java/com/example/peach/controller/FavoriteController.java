package com.example.peach.controller;

import com.example.peach.common.ServiceResponse;
import com.example.peach.pojo.Favorite;
import com.example.peach.service.FavoriteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2018/11/18.
 */
@RestController
@RequestMapping(value = "/favorite")
public class FavoriteController {

    @Resource
    private FavoriteService favoriteService;

    //查询自己的心仪对象
    @RequestMapping(value = "/selectByMyId/{myid}")
    public HashMap<String,Object> selectByMyId(@PathVariable("myid") int myid) {

        HashMap<String,Object> map = favoriteService.selectByMyId(myid);

        return map;
    }


    //查询心仪自己的对象
    @RequestMapping(value = "/selectByYouId/{youid}")
    public HashMap<String,Object> selectByYouId(@PathVariable("youid") int youid) {

        HashMap<String,Object> map= favoriteService.selectByYouId(youid);

        return map;
    }


    //查询相互心仪的对象
    @RequestMapping(value = "/selectAll")
    public HashMap<String,Object> selectAll() {

        HashMap<String,Object> map = favoriteService.selectAll();

        return map;
    }


    @RequestMapping(value = "/insertFavorite/{myid}/{youid}")
    public ServiceResponse<String> insertFavorite(@ModelAttribute Favorite favorite) {

        //查询是否已存在
        ServiceResponse<String> response= favoriteService.selectFavorite(favorite);
        if (!response.isSuccess()) {
            return response;
        } else {
            //添加
            response = favoriteService.insertFavorite(favorite);
        }

        return response;
    }


    //删除心仪对象
    @RequestMapping(value = "/deleteFavorite/{myid}/{youid}")
    public ServiceResponse<String> deleteFavorite(@ModelAttribute Favorite favorite) {

            //删除
        ServiceResponse<String> response = favoriteService.deleteFavorite(favorite);

        return response;
    }

}
