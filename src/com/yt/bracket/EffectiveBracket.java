package com.yt.bracket;

import java.util.*;

/**
 * @Author : Tong.Yang11@geely.com
 * @Date : 2019/11/05 17:24
 * @Description : no.20
 * https://leetcode-cn.com/problems/valid-parentheses/
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 */
public class EffectiveBracket {

    private static Map<Character, Character> map = new HashMap<>();

    static {
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
    }


    public static boolean isValid(String s) {

        int len = s.length();
        if (len % 2 != 0) return false;
        if (len == 0) return true;

        int index = 0;
        Stack<Character> stack = new Stack<>();
        while (index < len) {
            char bracket = s.charAt(index);
            if (map.get(bracket) != null) {
                if (stack.isEmpty() || !Objects.equals(stack.pop(), map.get(bracket))) {
                    return false;
                }
            } else {
                stack.push(bracket);
            }
            index++;
        }
        return stack.size() == 0;
    }

    public boolean isValid2(String s) {
        if (s.isEmpty()) return true;
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.empty() || c != stack.pop())
                return false;
        }
        return !stack.empty();
    }


    public static void main(String[] args) {
        boolean valid = isValid("(())");
        System.out.println("valid = " + valid);
    }

}
