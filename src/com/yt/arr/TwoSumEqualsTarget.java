package com.yt.arr;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author : Tong.Yang11@geely.com
 * @Date : 2019/11/01 16:39
 * @Description : 两数之和(no.1)
 * <p>
 * https://leetcode-cn.com/problems/two-sum/ * <p>
 * <p>
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSumEqualsTarget {


    /**
     * @param nums   数组
     * @param target 目标值
     *
     * @return 索引
     * <p>
     * 这道题目的关键就是利用map的高效查找能力，保存 i 和 target-nums[i] 的映射关系
     * 如果map.get(nums[i])不为空，说明我们已经找到了和为target的两个索引
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (map.get(temp) != null) {
                return new int[]{map.get(temp), i};
            }
            map.put(target - temp, i);
        }
        throw new RuntimeException("target arr is not exists");
    }

    public static int[] twoSum2(int[] nums, int target) {
        // 先排序
        Arrays.sort(nums);

        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                return new int[]{nums[i], nums[j]};
            } else if (sum < 0) {
                while (i < j && nums[i] == nums[++i]) ;
            } else {
                while (i < j && nums[j] == nums[--j]) ;
            }

        }
        throw new RuntimeException("target arr is not exists");
    }

    public static void main(String[] args) {
        int nums[] = {2, 13, 42, 5, 7, 121, 15};
        int[] res = twoSum2(nums, 9);
        for (int ele : res) {
            System.out.print(ele + " ");
        }
    }


}
