package com.example.peach.util;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 随机字符串生成
 * @author zuoliangzhu
 *
 */
public class RandomStringGenerator {
    /**
     * 获取一定长度的随机字符串
     * @param length 指定字符串长度
     * @return 一定长度的字符串
     */
    public static String getRandomStringByLength(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    public static String getRandomStringtime(int length) {
<<<<<<< HEAD
        String base = "0123456789abcdefghijklmnopqrstuvwxyz";
=======
        String base = "0123456789";
>>>>>>> ead560b8456e748583ec8e8b4b62cdfbe8875259
        SimpleDateFormat myFmt = new SimpleDateFormat("yyMMddHHmmss");
        String charseed = myFmt.format(new Date());
        StringBuffer sb = new StringBuffer();// 装载生成的随机数
        Random random = new Random();// 调用种子生成随机数
<<<<<<< HEAD
=======
        sb.append(charseed);
>>>>>>> ead560b8456e748583ec8e8b4b62cdfbe8875259
        for (int i = 0; i <length-charseed.length(); i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
<<<<<<< HEAD
        sb.append(charseed);
=======
>>>>>>> ead560b8456e748583ec8e8b4b62cdfbe8875259
        return sb.toString();
    }
}
