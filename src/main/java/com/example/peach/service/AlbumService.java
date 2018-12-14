package com.example.peach.service;

import com.example.peach.common.ServiceResponse;
import com.example.peach.pojo.Album;

import java.util.Map;

/**
 * Created by Administrator on 2018/12/8.
 */
public interface AlbumService {
    ServiceResponse<Map> insertAlbum(Album album);
}
