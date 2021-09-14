package com.hut;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {
        log.info("hello");

        try {
            throw new NullPointerException("用户名不能为空");
        } catch (NullPointerException e) {
            log.error(e.getMessage(), e);
        }
    }

}
