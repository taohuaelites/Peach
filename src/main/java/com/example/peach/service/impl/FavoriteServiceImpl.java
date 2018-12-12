package com.example.peach.service.impl;

import com.example.peach.common.ServiceResponse;
import com.example.peach.dao.FavoriteMapper;
import com.example.peach.pojo.Favorite;
import com.example.peach.service.FavoriteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2018/11/17.
 */

@Service
public class FavoriteServiceImpl implements FavoriteService {

    @Resource
    private FavoriteMapper favoriteMapper;


    //查询自己的心仪对象
    @Override
    public HashMap<String,Object> selectByMyId(int myid) {

        HashMap<String,Object> map=new HashMap();

        List<Favorite> list = favoriteMapper.selectByMyId(myid);
        if (list!=null && list.size()>0){
            map.put("Favorite",list);
        }else{
            map.put("Favorite",null);
        }
        return  map;
    }

    //查询心仪自己的对象
    @Override
    public HashMap<String,Object> selectByYouId(int youid) {

        HashMap<String,Object> map=new HashMap();

        List<Favorite> list  = favoriteMapper.selectByYouId(youid);
        if (list!=null && list.size()>0){
            map.put("Favorite",list);
        }else{
            map.put("Favorite",null);
        }
        return  map;
    }

    //查询相互心仪的对象
    @Override
    public HashMap<String,Object> selectAll() {

        HashMap<String,Object> map=new HashMap();

        List<Favorite> list  = favoriteMapper.selectAll();
        if (list!=null && list.size()>0){
            map.put("Favorite",list);
        }else{
            map.put("Favorite",null);
        }
        return  map;
    }

    //查询是否重复的对象
    @Override
    public ServiceResponse<String> selectFavorite(Favorite favorite) {

        Favorite favorite1 = favoriteMapper.selectFavorite(favorite);

        if(favorite1!=null){
            return ServiceResponse.createByError("已关注！");
        }else{
            return ServiceResponse.createBySuccess();
        }
    }

    //添加心仪对象
    @Override
    public ServiceResponse<String> insertFavorite(Favorite favorite) {



        int rs = favoriteMapper.insertFavorite(favorite);

        if(rs>0){
            return ServiceResponse.createBySuccess("添加成功！");
        }else{
            return  ServiceResponse.createByError("添加失败！");
        }

    }

    //删除心仪对象
    @Override
    public ServiceResponse<String> deleteFavorite(Favorite favorite) {

        int rs = favoriteMapper.deleteFavorite(favorite);

        if(rs>0){
            return ServiceResponse.createBySuccess("删除成功！");
        }else{
            return  ServiceResponse.createByError("删除失败！");
        }
    }
}
