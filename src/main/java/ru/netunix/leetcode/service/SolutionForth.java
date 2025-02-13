package ru.netunix.leetcode.service;

import java.util.Arrays;

public class SolutionForth {
    public static void main(String[] args) {
        SolutionForth s = new SolutionForth();
        int[] nums1 = new int[]{1};
//        s.nextPermutation(nums1);
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int index = s.search(nums, target);
        System.out.println("index = "+index);
    }

    public int search(int[] nums, int target) {
        if (isRotated(nums)) {
            if(target == nums[0]) return 0;
            if(target == nums[nums.length-1]) return nums.length-1;
            if(target>nums[0]){
                return getIndexAscending(nums,target);
            }
            else {
                return getIndexDescending(nums,target);
            }

        }
        else if (isPossibleContain(nums,target)){
            for(int i=0;i<nums.length;i++){
                if(nums[i]==target) return i;
            }
        }
        return -1;
    }
    public int getIndexAscending(int[]nums, int target){
        int i=0;
        while (nums[i]<nums[i+1]&&nums[i]<target){
            i=i+1;
        }
        if(target == nums[i]) return i;
        return -1;


    }
    public int getIndexDescending(int[]nums, int target){
        int i=nums.length-1;
        while (nums[i]>nums[i-1]&&nums[i]>target){
            i=i-1;
        }
        if(target == nums[i]) return i;
        return -1;

    }

    public boolean isRotated(int[] nums) {
        if (nums[0] > nums[nums.length - 1]) return true;
        return false;
    }

    public boolean isPossibleContain(int[] nums, int target) {
        if (target < nums[0] || target > nums[nums.length - 1]) return false;
        return true;

    }

    public void nextPermutation(int[] nums) {
        int permutationIndex = getPermutationIndex(nums);
        if (permutationIndex == -1) {
            //reorder full  array and return it
            int i = 0;
            int j = nums.length - 1;
            while (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i = i + 1;
                j = j - 1;
            }
        } else {
            //switch values
            int rightIndex = getIndexToChangeWith(nums, permutationIndex);
            int temp = nums[permutationIndex];
            nums[permutationIndex] = nums[rightIndex];
            nums[rightIndex] = temp;
            //reorder
            int i = permutationIndex + 1;
            int j = nums.length - 1;
            while (i < j) {
                int temp2 = nums[i];
                nums[i] = nums[j];
                nums[j] = temp2;
                i = i + 1;
                j = j - 1;
            }


        }


        System.out.println(Arrays.toString(nums));


    }

    public int getIndexToChangeWith(int[] nums, int indexLeft) {
        if ((indexLeft + 1) == (nums.length - 1)) return nums.length - 1;
        int changedValue = nums[indexLeft];
        for (int i = nums.length - 1; i > indexLeft; i--) {
            if (nums[i] > changedValue) return i;
        }
        return indexLeft;
    }

    public int getPermutationIndex(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                return i - 1;
            }

        }
        return -1;
    }
}
