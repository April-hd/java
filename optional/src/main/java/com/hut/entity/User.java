package com.hut.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class User {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

}
