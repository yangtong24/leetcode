package com.yt.arr;

import java.util.*;

/**
 * @Author : Tong.Yang11@geely.com
 * @Date : 2019/11/08 11:02
 * @Description : no.15
 * <p>
 * https://leetcode-cn.com/problems/3sum
 * <p>
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class ThreeNumsSumZero {

    /**
     * 解题思路:
     * 1.首先排序;
     * 2.固定一个数字nums[i]， 在用左右两个指针，L指针从i后面开始， R指针从nums.length开始遍历;
     * 3.如果nums[i] > 0， 那么直接退出查询;
     * 4.如果nums[i] == nums[i+1], 重复数字，那么退出当前循环， i++;
     * 5.同上，如果nums[L] == nums[L++], nums[R] = nums[R--], 那么L++, R--;
     *
     * @param nums 输入数组
     * [-4,-1,-1,0,1,2]
     * @return 满足条件的
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int k = 0; k < nums.length - 2; k++) {

            if (nums[k] > 0) break;
            if (k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum < 0) {
                    while (i < j && nums[i] == nums[++i]) ;
                } else if (sum > 0) {
                    while (i < j && nums[j] == nums[--j]) ;
                } else {
                    res.add(new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while (i < j && nums[i] == nums[++i]) ;
                    while (i < j && nums[j] == nums[--j]) ;
                }
            }

        }
        return res;
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];
            int[] newNums = remove(nums, i);
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < newNums.length; j++) {
                int temp = newNums[j];
                if (map.get(temp) != null) {
                    List<Integer> element = Arrays.asList(-target, temp, newNums[map.get(temp)]);
                    Collections.sort(element);
                    if (set.add(element)) {
                        result.add(element);
                    }
                    continue;
                }
                map.put(target - temp, j);
            }
        }
        return result;
    }

    private static int[] remove(int[] nums, int i) {
        int[] newNums = new int[nums.length - 1];
        int k = 0;
        for (int j = 0; j < nums.length; j++) {
            if (i == j) {
                continue;
            }
            newNums[k++] = nums[j];
        }
        return newNums;
    }


    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -4};
        long startTime = System.currentTimeMillis();
        List<List<Integer>> lists = threeSum(nums);

        System.out.println(("耗时:" + (System.currentTimeMillis() - startTime) / 1000) + "s");


        for (List<Integer> list : lists) {
            System.out.println("=====");

            for (Integer ele : list) {
                System.out.print(ele + " ");
            }

            System.out.println();
        }
    }


}
