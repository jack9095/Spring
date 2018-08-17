package com.kuanquan;

import java.io.IOException;
import java.util.List;

/**
 * 创建一个根据id查询用户的接口
 */
public interface QueryUserDaoInvoke {
    List<User> findUserById(String name) throws IOException;
}
