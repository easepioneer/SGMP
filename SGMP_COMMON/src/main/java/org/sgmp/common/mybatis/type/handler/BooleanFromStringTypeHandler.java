package org.sgmp.common.mybatis.type.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.BooleanTypeHandler;
import org.apache.ibatis.type.JdbcType;

/**
 * 
 * @author Nick
 *
 */
public class BooleanFromStringTypeHandler extends BooleanTypeHandler {

    private static final String TRUE = "true";
    private static final String FALSE = "false";

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Boolean parameter, JdbcType jdbcType) throws SQLException {
        String value = null;
        if(parameter != null) {
            if(((Boolean) parameter).booleanValue()) {
                value = TRUE;
            }
            else {
                value = FALSE;
            }
        }
        ps.setString(i, value);
    }

    @Override
    public Boolean getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String value = rs.getString(columnName);
        if(StringUtils.equals(value, TRUE)) {
            return Boolean.TRUE;
        }
        else if(StringUtils.equals(value, FALSE)) {
            return Boolean.FALSE;
        }
        return null;
    }

    @Override
    public Boolean getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String value = rs.getString(columnIndex);
        if(StringUtils.equals(value, TRUE)) {
            return Boolean.TRUE;
        }
        else if(StringUtils.equals(value, FALSE)) {
            return Boolean.FALSE;
        }
        return null;
    }

    @Override
    public Boolean getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String value = cs.getString(columnIndex);
        if(StringUtils.equals(value, TRUE)) {
            return Boolean.TRUE;
        }
        else if(StringUtils.equals(value, FALSE)) {
            return Boolean.FALSE;
        }
        return null;
    }

}
