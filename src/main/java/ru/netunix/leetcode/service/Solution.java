package ru.netunix.leetcode.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.netunix.leetcode.util.ListNode;

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
            if(points.containsKey(lastPoint)){
               points.put(lastPoint, points.get(lastPoint)+1);
            }
           else{ points.put(lastPoint,  1);}

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
