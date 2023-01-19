package org.zzzzzz.dto;

import lombok.Data;

// 登录后 返回的结果集
@Data
public class AccountDto<T> {

    /*
     -2 : 密码错误
     -1 : 用户名不存在
      0 : 登录成功
     */
    private Integer code; // 此次登录的状态码
    private T admin; // 此次登录的管理员的类型

}
