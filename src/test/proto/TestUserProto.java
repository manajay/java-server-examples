package proto;
/**
 * @Author 段连洁 [ manajay.dlj@gmail.com ]
 * @Date 04/08/2017 10:32 AM
 */

import com.googlecode.protobuf.format.JsonFormat;
import com.lj.spring.util.HttpSenderTest;
import com.lj.spring.util.ByteUtil;
import org.junit.Assert;
import org.junit.Test;
import com.lj.spring.bean.UserProto;
import com.lj.spring.bean.OTIpcDef;

/**
 * @author 段连洁 [manajay.dlj@gmail.com]
 * @class TestUserProto
 * @description test
 * @date 04/08/2017 10:32 AM
 */
public class TestUserProto {

    @Test
    public void testUserProto() {
        UserProto.User user = UserProto.User.newBuilder()
                .setId(100).setName("lianjie").setPassword("123456").setAge(26).setDetail("我是一个小画家!").build();
        System.out.println(user);
        Assert.assertEquals(100, user.getId());

        byte [] userByte = user.toByteArray();

    }

    @Test
    public void testTCPProto() {

        String baseUrl = "";

        OTIpcDef.OTIpcList.Builder builder = OTIpcDef.OTIpcList.newBuilder();
        String jsonString = "{}";
        try {
            JsonFormat.merge(jsonString,builder);
        } catch (JsonFormat.ParseException e) {
            e.printStackTrace();
        }
        OTIpcDef.OTIpcList otipcList = builder.build();

        HttpSenderTest.executePost(baseUrl, ByteUtil.compress(otipcList.toByteArray()),true,false);

    }

}
