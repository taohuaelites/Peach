package com.example.peach.dao;

import com.example.peach.pojo.Album;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/12/8.
 */
@Component
@Mapper
public interface AlbumMapper {
    int insertAlbum(Album album);
}
