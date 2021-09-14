package com.hut;

import com.hut.entity.User;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.util.Optional;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        User user = null;
        // 如果对象为空，会抛出空指针异常，调用有参构造
        try {
            Optional.of(user);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        // 如果对象为空，返回Optional对象，调用无参构造
        System.out.println(Optional.ofNullable(user));
        // 对象是否存在
        System.out.println(Optional.ofNullable(user).isPresent());
    }

    public static void test2() {
        User user = new User();
        // 对象如果存在，则打印对象
        if (Optional.ofNullable(user).isPresent()) {
            System.out.println(user);
        }
        Optional.ofNullable(user).ifPresent(u -> System.out.println(u));

        try {
            // 获取对象值，如果存在返回对象，如果不存在，抛出NoSuchElementException
            System.out.println(Optional.ofNullable(user).get());
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

        // 判断对象里的属性值是否存在
        System.out.println(Optional.ofNullable(user).map(User::getUsername));
        // 如果属性值不存在，则赋予默认值，但不改变原对象值
        System.out.println(Optional.ofNullable(user).map(User::getUsername).orElse("daihui"));
        System.out.println(Optional.ofNullable(user).map(User::getUsername).orElseGet(() -> "daihui"));
        try {
            // 如果属性值不存在，也可以抛出异常
            Optional.ofNullable(user).map(User::getUsername).orElseThrow(() -> new RuntimeException("用户名不能为空"));
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

        user.setUsername("daihui");
        // 如果对象属性值存在，则打印对象值
        System.out.println(Optional.ofNullable(user).map(User::getUsername));
        try {
            // 如果密码不存在，会报空指针异常
            System.out.println(Optional.ofNullable(user).flatMap(u -> Optional.of(u.getPassword())));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Optional.ofNullable(user).flatMap(u -> Optional.ofNullable(u.getPassword())));


//        System.out.println(Optional.ofNullable(user).filter(u -> "daihui".equals(user.getUsername())));
    }

}
