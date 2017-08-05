package com.lj.spring.typeHandler;

/**
 * @Author 段连洁 [ manajay.dlj@gmail.com ]
 * @Date 05/08/2017 5:14 PM
 */

import com.lj.spring.bean.Sex;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 段连洁 [manajay.dlj@gmail.com]
 * @class SexTypeHandler
 * @description user sex type handler
 * @date 05/08/2017 5:14 PM
 */
public class SexTypeHandler implements TypeHandler<Sex> {

    @Override
    public void setParameter(PreparedStatement ps, int i, Sex sex, JdbcType jdbcType) throws SQLException {
        ps.setInt(i,sex.getI());
    }

    @Override
    public Sex getResult(ResultSet rs, int columnIndex) throws SQLException {
        int id = rs.getInt(columnIndex);
        return Sex.getSex(id);
    }

    @Override
    public Sex getResult(ResultSet rs, String columnName) throws SQLException {
        int id = rs.getInt(columnName);
        return Sex.getSex(id);
    }

    @Override
    public Sex getResult(CallableStatement cs, int columnIndex) throws SQLException {
        int id = cs.getInt(columnIndex);
        return Sex.getSex(id);
    }
}
