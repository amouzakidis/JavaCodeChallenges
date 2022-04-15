package com.amouzakidis.challenge;

/*
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    You can return the answer in any order.



    Example 1:

    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

    Example 2:

    Input: nums = [3,2,4], target = 6
    Output: [1,2]

    Example 3:

    Input: nums = [3,3], target = 6
    Output: [0,1]



    Constraints:

        2 <= nums.length <= 104
        -109 <= nums[i] <= 109
        -109 <= target <= 109
        Only one valid answer exists.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) throws Exception {
        int[] ret = TwoSum.twoSum(new int[]{2, 7, 11, 15}, 9);
        if(!Arrays.equals(ret, new int[]{0, 1})){
            throw new Exception( "First test should return 0, 1 and got " + Arrays.toString(ret) );
        }
        ret = TwoSum.twoSum( new int[] {3,2,4}, 6 );
        if(!Arrays.equals(ret, new int[]{1, 2})){
            throw new Exception( "Second test should return 1, 2 and got " + Arrays.toString(ret) );
        }
        ret = TwoSum.twoSum( new int[] {3,3}, 6 );
        if(!Arrays.equals(ret, new int[]{0, 1})){
            throw new Exception( "First test should return 0, 1 and got " + Arrays.toString(ret) );
        }
    }

    public static int[] twoSum(int[] nums, int target) throws Exception {
        Map<Integer, Integer> index = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            index.put(nums[i], i );
        }

        for(int i = 0; i < nums.length - 1; i++){
            int left = target - nums[i];
            Integer pos = index.get(left);
            if( pos != null && pos != i){
                return new int[] { i, pos};
            }
        }
        throw new Exception("There is no solution");
    }

}
