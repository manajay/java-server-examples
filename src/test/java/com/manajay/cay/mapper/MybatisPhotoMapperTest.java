package com.manajay.cay.mapper;

import com.manajay.cay.bo.Photo;
import com.manajay.cay.mapper.mysql.MysqlPhotoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author manajay
 * @date 2017/12/16$
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPhotoMapperTest {

    @Autowired
    private MysqlPhotoMapper photoMapper;

    @Test
    public void selectAllTest(){
        List<Photo> photos = photoMapper.selectAll();
        System.out.println(photos);
    }

    @Test
    public void getPhotoByIdTest(){
        Photo photo = photoMapper.selectByPrimaryKey(1);
        System.out.println(photo);
    }
}
