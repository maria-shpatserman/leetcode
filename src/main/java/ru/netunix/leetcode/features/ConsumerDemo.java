package ru.netunix.leetcode.features;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ConsumerDemo {
//    @Override
//    public void accept(Integer integer) {
//        integer = integer*10;
//        System.out.println("i*10 = "+(integer));
//    }

    public static void main(String[] args) {
        Consumer<Integer> consumer = (i) -> {
            i = i * 10;

            System.out.println("i*10 = " + (i));
        };
        Consumer<Integer> consumer2 = i ->
                System.out.println("i = " + (i));
        Integer a = Integer.valueOf(10);
        consumer.accept(a);
        System.out.println("a = " + a);
        consumer.accept(10);
        consumer2.accept(10);
        Consumer<Book> consumer3 = (b) -> {
            b.setName(b.getName().toUpperCase());
            if (b.getPrice() == null || b.getPrice() < 0) {
                b.setPrice(0);
            }
        };
        Book b = Book.builder().name("Kate").build();
        Book b2 = Book.builder().name("mary").price(20).build();
//        System.out.println("b = " + b.toString());
//        System.out.println("b2 = " + b2.toString());
        consumer3.accept(b);
        consumer3.accept(b2);
//        System.out.println("b = " + b.toString());
//        System.out.println("b2 = " + b2.toString());
        List<Integer> list = Arrays.asList(Integer.valueOf(1), Integer.valueOf(2),
                Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5));
        System.out.println(list);
        list.stream().forEach(consumer);
        System.out.println(list);
        list.stream().forEach(t -> t = t + 1);
        System.out.println(list);
        List<Book> listBooks = Arrays.asList(
                Book.builder().name("mary").build(),
                Book.builder().name("ozon").price(100).build(),
                Book.builder().name("mark").price(200).build(),
                Book.builder().name("ReAl").price(-90).build());
        System.out.println(listBooks);
        List<Book> collected = listBooks.stream()
                .filter((r) -> {
                    return r.name.startsWith("m");
                })
                .map((f) -> {
                    f.setPrice(550);
                    return f;
                })
                .collect(Collectors.toList());
        ;
        System.out.println(collected);
        System.out.println(listBooks);
        List<Book> bookList = listBooks.stream().sorted((o1, o2) -> {
            return o2.getPrice() - o1.getPrice();
        }).collect(Collectors.toList());
        System.out.println(bookList);
//      ---
        Map<String, Book> myMap = new HashMap<>();
        myMap.put("king", new Book("IT", 200));
        myMap.put("king2", new Book("Misery", 100));
        myMap.put("sheldon", new Book("If tomorrow comes", 300));
        myMap.put("heili", new Book("Airport", 50));
        List<Map.Entry<String, Book>> collected1 = myMap.entrySet().stream().sorted((o1, o2) -> {
            return o2.getValue().getPrice() - o1.getValue().getPrice();
        }).collect(Collectors.toList());
        System.out.println(collected1);
        List<Map.Entry<String, Book>> collected2 = myMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(Book::getPrice).reversed()))
        .collect(Collectors.toList());
        System.out.println(collected2);

    }

}
