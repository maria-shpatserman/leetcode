package ru.netunix.leetcode.features;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {

//    @Override
//    public boolean test(Integer integer) {
//        if(integer==null || integer<0) {
//            return false;
//        }
//        return true;
//    }

    public static void main(String[] args) {
    Predicate<Integer> predicate = (integer)-> {
            if(integer==null || integer<0) {
                return false;
            }
            return true;
        };
        System.out.println("result = "+ predicate.test(12));
        System.out.println("result = "+ predicate.test(null));
        System.out.println("result = "+ predicate.test(-10));

        List<Integer> list = Arrays.asList(1,0,3,-10,5,null);
        list.stream()
                .filter(t->{
            if(t==null || t<0) {
                return false;
            }
            return true;
        })
                .forEach(t-> System.out.println(t));

    }
}
