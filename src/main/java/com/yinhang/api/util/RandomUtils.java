package com.yinhang.api.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.UUID;


public class RandomUtils {

    private static final Logger logger = LoggerFactory.getLogger(RandomUtils.class);

    public static String randomUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String string(String type, String value) {
        return md5(type + value + System.currentTimeMillis() + randomUUID());
    }

    public static String usernameString(String type,String value) {
        return usernameMd5(type + value + System.currentTimeMillis() + randomUUID());
    }

    public static String usernameMd5(String str){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            return new BigInteger(1, md.digest()).toString(5);
        } catch (Exception e) {
            logger.error("MD5加密出现错误，%s", e.toString());
            return randomUUID();
        }
    }


    public static String md5(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            logger.error("MD5加密出现错误，%s", e.toString());
            return randomUUID();
        }
    }

    public static String orderId(){
        return (System.currentTimeMillis() + "").substring(1) +
                (System.nanoTime() + "").substring(7, 10);
    }
}
