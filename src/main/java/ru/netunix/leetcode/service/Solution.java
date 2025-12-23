package ru.netunix.leetcode.service;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;
import ru.netunix.leetcode.util.ListNode;
import ru.netunix.leetcode.util.TreeNode;

import javax.print.DocFlavor;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import static ru.netunix.leetcode.service.Solution.Path.N;

@Slf4j
public class Solution {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Solution solution = new Solution();


        boolean crossing = solution.isPathCrossing("NESWW");
        System.out.println("answer = " + crossing);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(1);
        TreeNode node4 = new TreeNode(11, node7, node8);
        TreeNode node5 = new TreeNode(13);
        TreeNode node6 = new TreeNode(4, null, node9);
        TreeNode node2 = new TreeNode(4, node4, null);
        TreeNode node3 = new TreeNode(8, node5, node6);
        TreeNode nodeRoot = new TreeNode(5, node2, node3);
//        int result = solution.countNodes(nodeRoot);
//        System.out.println("result = " + result);
//        int[] nums = {7, 1, 5, 4, 6, 2};
//        List<String> summaryRanges = solution.summaryRanges(nums);
//        System.out.println(summaryRanges);
//        int maxProfit = solution.maxProfit(nums);
//        System.out.println("naxProfit = " + maxProfit);
//        boolean hasPathSum = solution.hasPathSum(nodeRoot, 18);
//        System.out.println("hasPathSum = " + hasPathSum);
        int[][] intervals = {{1, 3}, {1, 5}, {1, 2}, {1, 3}, {2, 8}, {2, 11}, {2, 8}, {14, 16}, {18, 35}};
//        Map<Integer, List<int[]>> mapIntervals = solution.getMapIntervals(intervals);
//        System.out.println(mapIntervals);
        int[][] merged = solution.merge(intervals);
        for (int i = 0; i < merged.length; i++) {
            System.out.println("merged [" + i + "]=" + Arrays.toString(merged[i]));
        }
        int[] newInterval = {20, 40};
        int[][] insertedAndMerged = solution.insert(intervals, newInterval);
        for (int i = 0; i < insertedAndMerged.length; i++) {
            System.out.println("insertedAndMerged [" + i + "]=" + Arrays.toString(insertedAndMerged[i]));
        }

        int[] nums = {6,7,8,9,0,1,2,3,4,5};
        int target =5;
        System.out.println("Result search = "+solution.search(nums,target));

    }

    public boolean search(int[] nums, int target) {
        if (nums[0] == target) return true;
        if (nums[0] < target) return findTargetNoRotation(0, nums, target);
        return findTargetWithRotation(nums, target);

    }

    public boolean findTargetNoRotation(int headIndex, int[] nums, int target) {
        int min = nums[headIndex];
        for (int i = headIndex; i < nums.length; i++) {
            if (nums[i] == target) return true;
            if (nums[i] > target) return false;
            if (nums[i] < min) return false;
            min = nums[i];
        }
        return false;
    }

    public boolean findTargetWithRotation(int[] nums, int target) {
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) return true;
            if (nums[i] < target) return findTargetNoRotation(i, nums, target);
            if ((nums[i] < min) && (nums[i] > target)) return false;
            min = nums[i];

        }
        return false;
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] copied = Arrays.copyOf(intervals, intervals.length + 1);
        copied[intervals.length] = newInterval;
        return merge(copied);
    }

    public Map<Integer, List<int[]>> getMapIntervals(int[][] intervals) {
        Map<Integer, List<int[]>> result = new HashMap<>();
        Set<String> mySetKeys = new HashSet<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] current = intervals[i];
            String key = Arrays.toString(current);
            boolean added = mySetKeys.add(key);
            if (added) {
                int leftKey = current[0];
                if (result.containsKey(leftKey)) {
                    result.get(leftKey).add(current);
                } else {
                    List<int[]> newList = new ArrayList<>();
                    newList.add(current);
                    result.put(leftKey, newList);
                }

            }

        }
        return result;

    }

    public TreeMap<Integer, int[]> getMapCombinedIntervals(Map<Integer, List<int[]>> orderedMap) {
        TreeMap<Integer, int[]> result = new TreeMap<>();
        for (Integer key : orderedMap.keySet()) {
            int leftKey = key;
            List<int[]> list = orderedMap.get(leftKey);
            int rightKey = list.get(0)[1];
            for (int i = 0; i < list.size(); i++) {
                int temp = list.get(i)[1];
                if (temp > rightKey) {
                    rightKey = temp;
                }
            }
            int[] combined = {leftKey, rightKey};
            result.put(leftKey, combined);


        }

        return result;
    }

    public List<int[]> getNotOverlappedIntervals(List<int[]> overlappedList) {
        List<int[]> result = new ArrayList<>();
        if (overlappedList.size() == 1) {
            return overlappedList;
        }
        int[] previous = overlappedList.get(0);
        for (int i = 0; i < overlappedList.size() - 1; i++) {
            int[] current = overlappedList.get(i + 1);
            if (isOverlapped(previous, current)) {
                //combine new previous
                int maxRightSide = previous[1] > current[1] ? previous[1] : current[1];
                previous = new int[]{previous[0], maxRightSide};


            } else {
                //save previous into result list
                result.add(previous);
                previous = current;
            }

        }
        result.add(previous);


        return result;
    }

    public boolean isOverlapped(int[] previous, int[] current) {
        if (current[0] > previous[1]) return false;
        else return true;
    }

    public int[][] merge(int[][] intervals) {
        Map<Integer, List<int[]>> mapIntervals = getMapIntervals(intervals);
        TreeMap<Integer, int[]> combinedIntervals = getMapCombinedIntervals(mapIntervals);
        List<int[]> overlappedList = new ArrayList<>();
        for (Integer key : combinedIntervals.keySet()) {
            System.out.println("key " + key + " value " + Arrays.toString(combinedIntervals.get(key)));
            overlappedList.add(combinedIntervals.get(key));
        }
        List<int[]> notOverlappedIntervals = getNotOverlappedIntervals(overlappedList);
        int[][] result = new int[notOverlappedIntervals.size()][];
        for (int i = 0; i < notOverlappedIntervals.size(); i++) {
            result[i] = notOverlappedIntervals.get(i);
        }
        return result;

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return checkNode(0, targetSum, root);
    }

    public boolean checkNode(int parentSum, int targetSum, TreeNode current) {
        int currentSum = current.val + parentSum;
        if ((currentSum == targetSum) && (current.left == null && current.right == null)) return true;
        if (current.left != null && checkNode(currentSum, targetSum, current.left)) return true;
        if (current.right != null && checkNode(currentSum, targetSum, current.right)) return true;
        return false;

    }

    public int maxProfit(int[] prices) {
        int min = prices[0];
        int maxDiff = 0;
        if (prices.length == 1) return maxDiff;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                maxDiff = Math.max((prices[i] - min), maxDiff);
            }
        }

        return maxDiff;
    }

    int isLast(TreeNode node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) {
            return 1;
        } else
            return isLast(node.left) + isLast(node.right) + 1;
    }

    public int countNodes(TreeNode root) {

        return isLast(root);
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int indexLeft = 0;
        while (indexLeft < nums.length) {
            int lastIndex = getLastIndex(indexLeft, nums);
            String makeRange = makeRange(nums[indexLeft], nums[lastIndex]);
            result.add(makeRange);
            indexLeft = lastIndex + 1;
        }


        return result;
    }

    int getLastIndex(int startIndex, int[] nums) {

        if ((startIndex + 1) == nums.length) return startIndex;
        int start = nums[startIndex];
        int nextIndex = startIndex;
        for (int i = startIndex + 1; i < nums.length; i++) {
            int temp = nums[i];
            if ((start + 1) == temp) {
                start = temp;
                nextIndex = i;
            } else
                break;
        }
        return nextIndex;
    }

    String makeRange(int left, int right) {
        if (left == right) return String.valueOf(left);
        return left + "->" + right;
    }


    public String addBinary(String a, String b) {
        String max = a.length() > b.length() ? a : b;
        String min = a.length() <= b.length() ? a : b;
        StringBuilder result = new StringBuilder();
        char[] maxArray = max.toCharArray();
        char[] minArray = min.toCharArray();
        int i = maxArray.length - 1;
        int j = minArray.length - 1;
        int previous = 0;
        while (i >= 0) {
            if (j >= 0) {
                int valueOne = Character.getNumericValue(maxArray[i]);
                int valueSecond = Character.getNumericValue(minArray[j]);
                int sum = valueOne + valueSecond + previous;
                if (sum == 3) {
                    result.append("1");
                    previous = 1;
                } else if (sum == 2) {
                    result.append("0");
                    previous = 1;

                } else if (sum == 1) {
                    result.append("1");
                    previous = 0;

                } else {
                    result.append("0");
                    previous = 0;
                }
                i--;
                j--;

            } else {
                int valueOne = Character.getNumericValue(maxArray[i]);
                int sum = valueOne + previous;
                if (sum == 2) {
                    result.append("0");
                    previous = 1;

                } else if (sum == 1) {
                    result.append("1");
                    previous = 0;

                } else {
                    result.append("0");
                    previous = 0;
                }
                i--;
            }


        }
        if (previous == 1) {
            result.append("1");
        }
        return result.reverse().toString();

    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }


        @Override
        public boolean equals(Object obj) {
            Point that = (Point) obj;
            if ((this.x == that.x) && (this.y == that.y)) return true;
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }


    public boolean isPathCrossing(String path) {
        Map<Point, Integer> points = new HashMap<>();
        Point lastPoint = new Point(0, 0);
        points.put(lastPoint, 1);

        for (String s : path.split("")) {
            Path step = Path.valueOf(s);
            lastPoint = getPoint(lastPoint, step);
            if (points.containsKey(lastPoint)) {
                points.put(lastPoint, points.get(lastPoint) + 1);
            } else {
                points.put(lastPoint, 1);
            }

        }
        if (!points.entrySet().stream().filter(a -> a.getValue() > 1).collect(Collectors.toList()).isEmpty())
            return true;
        return false;
    }

    Point getPoint(Point lastPoint, Path p) {
        int x = lastPoint.x;
        int y = lastPoint.y;
        return switch (p) {
            case N -> new Point(x, y + 1);
            case E -> new Point(x + 1, y);
            case S -> new Point(x, y - 1);
            case W -> new Point(x - 1, y);

        };

    }

    enum Path {
        N,
        W,
        E,
        S;
    }


}
