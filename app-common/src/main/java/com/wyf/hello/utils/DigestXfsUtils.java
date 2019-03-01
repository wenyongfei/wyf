package com.wyf.hello.utils;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * 编码方法工具包。例如DES、SHA1、MD5、Base64，URL，Soundx等等的编码、解码
 */
public class DigestXfsUtils {
    public static String encodeStr(String data) {
        String encodeS = DigestUtils.md5Hex(data);
        return encodeS;
    }

}
