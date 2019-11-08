package com.yt.arr;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Tong.Yang11@geely.com
 * @Date : 2019/11/07 16:47
 * @Description : no.46
 * <p>
 * https://leetcode-cn.com/problems/permutations
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,4]
 * 输出:
 * [
 * [1,2,3,4],
 * [1,2,4,3],
 * [1,3,2,4],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            nums = moveToHead(nums, i);
            result.add(toList(nums));
            for (int j = 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    swap(nums, j, k);
                    result.add(toList(nums));
                    swap(nums, j, k);
                }
            }
        }
        return result;
    }

    // 其实我需要的是一个方法: 把一个元素移动到指定位置，其他元素保持相对位置


    private int[] moveToHead(int[] nums, int i) {
        int[] newArr = new int[nums.length];

        newArr[0] = nums[i];

        for (int m = 1, j = 0; j < nums.length; j++) {
            if (i == j) {
                continue;
            }
            newArr[m++] = nums[j];
        }
        return newArr;
    }

    private List<Integer> toList(int[] nums) {
        List<Integer> list = new ArrayList<>(nums.length);
        for (int num : nums) {
            list.add(num);
        }
        return list;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        int[] arr = {1, 2, 3, 4};
        List<List<Integer>> res = permutations.permute(arr);
        System.out.println("res.size() = " + res.size());
        for (List<Integer> list : res) {
            System.out.println("=======");

            for (Integer e : list) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }


}
