package com.example.peach.service.impl;

import com.example.peach.common.ServiceResponse;
import com.example.peach.dao.AlbumMapper;
import com.example.peach.pojo.Album;
import com.example.peach.service.AlbumService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Administrator on 2018/12/8.
 */
@Service
public class AlbumServiceImpl implements AlbumService {
    @Resource
    private AlbumMapper albumMapper;

    @Override
    public ServiceResponse<Map> insertAlbum(Album album) {
        int insert = albumMapper.insertAlbum(album);
        if (insert > 0) {
            return ServiceResponse.createBySuccess("添加成功");
        }
        return ServiceResponse.createByError("添加失败");
    }
}
