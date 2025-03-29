package ru.netunix.leetcode.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionForth {
    public static void main(String[] args) {
        SolutionForth s = new SolutionForth();
        int[] nums1 = new int[]{1};
//        s.nextPermutation(nums1);
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int index = s.search(nums, target);
        System.out.println("index = " + index);

        String result = s.countAndSay(4);
        System.out.println("---->>>  CountAndSay = >>>" + result);

        String a = "01110111111111101000000101111001110001111100001101";
        String b = "000011011011001011101111001100000011011110011";
        String resultAddBinary = s.addBinary(a, b);
        System.out.println("---->>>> Add Binary --->>>" + resultAddBinary);

        List<List<Integer>> generateList = s.generate(25);
        System.out.println(" generated list = " + generateList.toString());
        List<Integer> row = s.getRow(3);
        System.out.println(" generated pascals row  = " + row.toString());

    }

    public int search(int[] nums, int target) {
        if (isRotated(nums)) {
            if (target == nums[0]) return 0;
            if (target == nums[nums.length - 1]) return nums.length - 1;
            if (target > nums[0]) {
                return getIndexAscending(nums, target);
            } else {
                return getIndexDescending(nums, target);
            }

        } else if (isPossibleContain(nums, target)) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) return i;
            }
        }
        return -1;
    }

    public int getIndexAscending(int[] nums, int target) {
        int i = 0;
        while (nums[i] < nums[i + 1] && nums[i] < target) {
            i = i + 1;
        }
        if (target == nums[i]) return i;
        return -1;


    }

    public int getIndexDescending(int[] nums, int target) {
        int i = nums.length - 1;
        while (nums[i] > nums[i - 1] && nums[i] > target) {
            i = i - 1;
        }
        if (target == nums[i]) return i;
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

    public String countAndSay(int n) {

        if (n == 1) return "1";
        String previous = countAndSay(n - 1);
        int count = 1;
        char[] chars = previous.toCharArray();
        char previousChar = chars[0];
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < chars.length; i++) {
            char current = chars[i];
            if (current == previousChar) {
                count = count + 1;
            } else {
                result.append(count).append(previousChar);
                count = 1;
                previousChar = current;
            }


        }
        result.append(count).append(previousChar);
        return result.toString();

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

    public String addBinary(String a, String b) {
        long aInt = Long.parseLong(a, 2);
        long bInt = Long.parseLong(b, 2);
        long result = aInt + bInt;
        return Long.toBinaryString(result);
    }

    public int addDigits(int num) {
        int result = getSumOfChars(num);


        while (result > 9) {
            result = getSumOfChars(result);
        }

        return result;

    }

    public int getSumOfChars(int num) {
        String s = String.valueOf(num);
        int tmp = 0;

        for (char c : s.toCharArray()) {

            tmp = tmp + Character.getNumericValue(c);
        }
        return tmp;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> valuesOne = new ArrayList<>();
        valuesOne.add(1);
        result.add(valuesOne);

        for (int i = 1; i < numRows; i++) {
            List<Integer> values = new ArrayList<>();
            int columnCount = i+1;
            for (int j = 0; j < columnCount; j++) {
                if (j == 0) values.add(1);
                if (j == (columnCount - 1)) values.add(1);
                if (j != 0 && j < (columnCount - 1)) {
                    Integer sum = result.get(i-1).get(j-1)+ result.get(i-1).get(j);
                    values.add(sum);
                }
            }
            result.add(values);
        }
        return result;

    }

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> valuesOne = new ArrayList<>();
        valuesOne.add(1);
        result.add(valuesOne);

        for (int i = 1; i < rowIndex+1; i++) {
            List<Integer> values = new ArrayList<>();
            int columnCount = i+1;
            for (int j = 0; j < columnCount; j++) {
                if (j == 0) values.add(1);
                if (j == (columnCount - 1)) values.add(1);
                if (j != 0 && j < (columnCount - 1)) {
                    Integer sum = result.get(i-1).get(j-1)+ result.get(i-1).get(j);
                    values.add(sum);
                }
            }
            result.add(values);
        }
        return result.get(rowIndex);
    }

}
