package com.manajay.cay.service;

import com.manajay.cay.bo.Photo;

import java.util.List;

/**
 * @author manajay
 * @date 2017/12/16$
 */
public interface IPhotoService {

    /**
     * 查询所有的照片
     * @author manajay
     * @date 2017/12/16
     */
    List<Photo> listPhoto();

    List<Photo> mysqlListPhoto();

}
