package ru.netunix.leetcode.features;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateDemo {

//    @Override
//    public boolean test(Integer integer) {
//        if(integer==null || integer<0) {
//            return false;
//        }
//        return true;
//    }

    public static void main(String[] args) {
        Predicate<Integer> predicate = (integer) -> {
            if (integer == null || integer < 0) {
                return false;
            }
            return true;
        };
        System.out.println("result = " + predicate.test(12));
        System.out.println("result = " + predicate.test(null));
        System.out.println("result = " + predicate.test(-10));

        List<Integer> list = Arrays.asList(1, 0, 3, -10, 5, null);
        list.stream()
                .filter(t -> {
                    if (t == null || t < 0) {
                        return false;
                    }
                    return true;
                })
                .forEach(t -> System.out.println(t));
        Map<String, Book> myMap = new HashMap<>();
        myMap.put("king", new Book("IT", 200));
        myMap.put("king2", new Book("Misery", 100));
        myMap.put("sheldon", new Book("If tomorrow comes", 300));
        myMap.put("heili", new Book("Airport", 50));
        List<Map.Entry<String, Book>> collect = myMap.entrySet().stream().filter((e) -> {
            return e.getValue().getPrice() > 100;
        }).collect(Collectors.toList());
        System.out.println(collect);


    }
}
