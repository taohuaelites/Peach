package com.example.peach.controller;

import com.example.peach.common.ServiceResponse;
import com.example.peach.pojo.Album;
import com.example.peach.service.AlbumService;
import com.example.peach.util.FileUpload;
import com.example.peach.util.RandomStringGenerator;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;


/**
 * Created by Administrator on 2018/11/23.
 */
@RestController
@MapperScan("com.example.peach.mapper")
@RequestMapping("/album")
public class AlbumController {


    @Resource
    private AlbumService albumService;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ServiceResponse<Map> upload(@RequestParam(value = "file", required = false) MultipartFile file, Album album){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sysDate = format.format(new Date());
        String fileName=FileUpload.fileUpload(file);
        album.setAlbumPath(fileName);
        album.setAlbumDate(Timestamp.valueOf(sysDate));
        return  albumService.insertAlbum(album);

}

}
