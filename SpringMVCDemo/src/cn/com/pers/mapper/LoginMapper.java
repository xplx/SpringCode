package cn.com.pers.mapper;

import org.apache.ibatis.annotations.Param;

import cn.com.pers.model.Login;

/**
 * Created by wxp on 2017-12-8.
 */
public interface LoginMapper {
	Login selectUser(@Param(value = "username") String username);
}
