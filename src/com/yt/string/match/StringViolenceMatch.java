package com.yt.string.match;


/**
 * @Author : Tong.Yang11@geely.com
 * @Date : 2019/11/05 17:24
 * @Description : 字符串暴力匹配
 **/
public class StringViolenceMatch {

    private static int strStr(String haystack, String needle) {
        int i = 0, j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                // 回溯
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == needle.length()) {
            return i - j;
        }
        return -1;
    }


    public static void main(String[] args) {
        int i = strStr("", "");
        System.out.println("i = " + i);
    }

}    
