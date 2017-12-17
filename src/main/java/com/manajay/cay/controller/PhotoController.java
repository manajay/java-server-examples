package com.manajay.cay.controller;

import com.manajay.cay.bo.Photo;
import com.manajay.cay.service.IPhotoService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 图片
 * @author manajay
 * @date 2017/12/16$
 */
@RestController
public class PhotoController {

    @Resource(name = "photoServiceImpl")
    private IPhotoService photoService;

    /**
     * 获取图片列表
     * @author manajay
     * @date 2017/12/16
     */
    @GetMapping("/photos")
    public List<Photo> listPhoto(@RequestParam("source") String source){

        if (StringUtils.isEmpty(source)){
            return photoService.listPhoto();
        }

        if ("mysql".equals(source)){
            return photoService.mysqlListPhoto();
        }

        return photoService.listPhoto();
    }

}
