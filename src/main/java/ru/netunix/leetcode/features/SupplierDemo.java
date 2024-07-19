package ru.netunix.leetcode.features;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class SupplierDemo {


    public static void main(String[] args) {
        Supplier<String> supplier = () ->
                "Hello sup";

        System.out.println(supplier.get());
        List<String> list = Arrays.asList("Ab","C",null);
        System.out.println(list.stream().filter((t)->(t!=null)&&t.startsWith("c")).findAny().orElseGet(()->"Helo test"));
        List<String> collect = list.stream().filter((t) -> (t != null) && t.startsWith("A")).collect(Collectors.toList());
        System.out.println(collect);

    }
}
