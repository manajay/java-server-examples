package com.manajay.cay.service.impl;

import com.manajay.cay.bo.Photo;
import com.manajay.cay.mapper.mybatis.MybatisPhotoMapper;
import com.manajay.cay.mapper.mysql.MysqlPhotoMapper;

import com.manajay.cay.service.IPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author manajay
 * @date 2017/12/16$
 */
@Service("photoServiceImpl")
public class PhotoServiceImpl implements IPhotoService {

    @Autowired
    private MysqlPhotoMapper mysqlPhotoMapper;

    @Autowired
    private MybatisPhotoMapper mybatisPhotoMapper;

    @Override
    public List<Photo> listPhoto() {
        return mybatisPhotoMapper.selectAll();
    }

    @Override
    public List<Photo> mysqlListPhoto() {
        return mysqlPhotoMapper.selectAll();
    }
}
