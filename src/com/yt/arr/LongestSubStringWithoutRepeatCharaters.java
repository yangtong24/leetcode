package com.yt.arr;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : Tong.Yang11@geely.com
 * @Date : 2019/11/04 13:46
 * @Description : no.3
 * 无重复字符最长子串:给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LongestSubStringWithoutRepeatCharaters {

    /**
     * 非常偷懒的一种做法，用Map保存索引位置，方便回溯
     *
     * @param s
     *
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        char[] array = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>(s.length());
        int count = 0;
        int max = count;
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i]) != null) {
                i = map.get(array[i]) + 1;
                map.clear();
                count = 1;
            } else {
                count++;
            }
            max = Math.max(count, max);
            map.put(array[i], i);
        }
        return max;
    }

    /**
     * 官方给出的最优解
     *
     * 不用回溯(map只负责记录索引位置，以及是否重复)
     * 使用hi, lo两个指针来计算最大长度，并且有重复的时候更新hi
     *
     *
     * @param s
     *
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length(), count = 0;
        Map<Character, Integer> map = new HashMap<>();
        // try to extend the range [i, j]
        for (int hi = 0, lo = 0; hi < n; hi++) {
            if (map.containsKey(s.charAt(hi))) {
                lo = Math.max(map.get(s.charAt(hi)), lo);
            }
            count = Math.max(count, hi - lo + 1);
            map.put(s.charAt(hi), hi + 1);
        }
        return count;
    }


    public static void main(String[] args) {
        int test = lengthOfLongestSubstring2("pwwkewnc");
        System.out.println("test = " + test);
    }
}
