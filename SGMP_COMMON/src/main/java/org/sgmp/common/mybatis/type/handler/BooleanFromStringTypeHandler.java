package org.sgmp.common.mybatis.type.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

/**
 * 
 * @author Nick
 *
 */
public class BooleanFromStringTypeHandler implements TypeHandler<Boolean> {

    private static final String TRUE = "TRUE";
    private static final String FALSE = "FALSE";

    @Override
    public void setParameter(PreparedStatement ps, int i, Boolean parameter, JdbcType jdbcType) throws SQLException {
        String value = parameter ? TRUE : FALSE;
        ps.setString(i, value); 
    }

    @Override
    public Boolean getResult(ResultSet rs, String columnName) throws SQLException {
        String value = rs.getString(columnName);
        if(StringUtils.equalsIgnoreCase(value, TRUE)) {
            return Boolean.TRUE;
        }
        else if(StringUtils.equalsIgnoreCase(value, FALSE)) {
            return Boolean.FALSE;
        }
        return null;
    }

    @Override
    public Boolean getResult(ResultSet rs, int columnIndex) throws SQLException {
        String value = rs.getString(columnIndex);
        if(StringUtils.equalsIgnoreCase(value, TRUE)) {
            return Boolean.TRUE;
        }
        else if(StringUtils.equalsIgnoreCase(value, FALSE)) {
            return Boolean.FALSE;
        }
        return null;
    }

    @Override
    public Boolean getResult(CallableStatement cs, int columnIndex) throws SQLException {
        String value = cs.getString(columnIndex);
        if(StringUtils.equalsIgnoreCase(value, TRUE)) {
            return Boolean.TRUE;
        }
        else if(StringUtils.equalsIgnoreCase(value, FALSE)) {
            return Boolean.FALSE;
        }
        return null;
    }

}
