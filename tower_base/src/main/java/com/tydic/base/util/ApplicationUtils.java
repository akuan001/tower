package com.tydic.base.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.UUID;

import javax.imageio.stream.FileImageInputStream;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tydic.base.constant.ConstantCodeDefine;

public class ApplicationUtils {
    /**
     * 产生一个36个字符的UUID
     * 
     * @return UUID
     */
    public static String randomUUID() {
        return UUID.randomUUID().toString();
    }

    public static String getFileByFileGroup(String fileGroup) {
        String picDir = "";
        switch (fileGroup) {
        case ConstantCodeDefine.CAROUSEL_PIC_GROUP:
            picDir = ConstantCodeDefine.CAROUSEL_PIC_DIR;
            break;
        case ConstantCodeDefine.NEWS_KINDEDITOR_PIC_GROUP:
            picDir = ConstantCodeDefine.NEWS_KINDEDITOR_PIC_DIR;
            break;
        case ConstantCodeDefine.NEWS_PIC_GROUP:
            picDir = ConstantCodeDefine.NEWS_PIC_DIR;
            break;
        case ConstantCodeDefine.BUSINESS_DES_TYPE_KINDEDITOR_GROUP:
            picDir = ConstantCodeDefine.BUSINESS_DES_TYPE_KINDEDITOR_DIR;
            break;
        case ConstantCodeDefine.BUSINESS_DES_PIC_GROUP:
            picDir = ConstantCodeDefine.BUSINESS_DES_PIC_DIR;
            break;
        case ConstantCodeDefine.SOLUTION_TYPE_GROUP:
            picDir = ConstantCodeDefine.SOLUTION_TYPE_DIR;
            break;
        case ConstantCodeDefine.PRODUCT_TYPE_GROUP:
            picDir = ConstantCodeDefine.PRODUCT_TYPE_DIR;
            break;
        case ConstantCodeDefine.PRODUCT_GROUP:
            picDir = ConstantCodeDefine.PRODUCT_DIR;
            break;
        case ConstantCodeDefine.PROGRAMME_PIC_GROUP:
            picDir = ConstantCodeDefine.PROGRAMME_PIC_DIR;
            break;
        case ConstantCodeDefine.PROGRAMME_FILE_GROUP:
            picDir = ConstantCodeDefine.PROGRAMME_FILE_DIR;
            break;
        default:
            break;
        }
        return picDir;
    }

    /**
     * sha256加密
     * 
     * @param value
     *            要加密的值
     * @return sha256加密后的值
     */
    public static String sha256Hex(String value) {
        return DigestUtils.sha256Hex(value);
    }

    /**
     * MD5加密
     * 
     * @param value
     *            要加密的值
     * @return MD5加密后的值
     */
    public static String MD5Hex(String value) {
        String md5 = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5"); // 创建一个md5算法对象
            byte[] messageByte = value.getBytes("UTF-8");
            byte[] md5Byte = md.digest(messageByte); // 获得MD5字节数组,16*8=128位
            md5 = bytesToHex(md5Byte); // 转换为16进制字符串
        } catch (Exception e) {
            e.printStackTrace();
        }
        return md5.toLowerCase();
    }

    // 二进制转十六进制
    public static String bytesToHex(byte[] bytes) {
        StringBuffer hexStr = new StringBuffer();
        int num;
        for (int i = 0; i < bytes.length; i++) {
            num = bytes[i];
            if (num < 0) {
                num += 256;
            }
            if (num < 16) {
                hexStr.append("0");
            }
            hexStr.append(Integer.toHexString(num));
        }
        return hexStr.toString().toUpperCase();
    }

    /**
     * 图片转换成byte流
     */
    @RequestMapping("/imageToByte")
    public static byte[] byteToImage(String path) {
        byte[] data = null;
        FileImageInputStream input = null;
        try {
            input = new FileImageInputStream(new File(path));
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int numBytesRead = 0;
            while ((numBytesRead = input.read(buf)) != -1) {
                output.write(buf, 0, numBytesRead);
            }
            data = output.toByteArray();
            output.close();
            input.close();
        } catch (FileNotFoundException ex1) {
            ex1.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        return data;
    }

    public static void main(String[] args) {
        String temp = MD5Hex("test");
        System.out.println(temp.toLowerCase());
    }

}
