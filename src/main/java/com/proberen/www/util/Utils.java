package com.proberen.www.util;

import org.apache.commons.codec.binary.Base64;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.UUID;

public class Utils {
    public static String get_UUID(){
        UUID uuid=UUID.randomUUID();
        return uuid.toString().toUpperCase().replaceAll("-","");
    }
    public static String get_MD5(String str){
       try{
           MessageDigest md=MessageDigest.getInstance("MD5");
           byte[] outPut=md.digest(str.getBytes());
           String temp= Base64.encodeBase64URLSafeString(outPut);
           return URLEncoder.encode(temp,"utf-8").toUpperCase();
       }catch(Exception e){
           throw new RuntimeException("Verschlüsselung fehlgeschlagen");
       }
    }
}
