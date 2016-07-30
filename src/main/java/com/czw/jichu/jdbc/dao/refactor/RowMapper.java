package com.czw.jichu.jdbc.dao.refactor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author Zevi Chan
 * @Date 2016年7月5日
 */
public interface RowMapper {
	public Object mapRow(ResultSet rs) throws SQLException;
}
