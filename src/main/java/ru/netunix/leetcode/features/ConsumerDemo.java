package ru.netunix.leetcode.features;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

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
                Book.builder().name("ReAl").price(-90).build());
        System.out.println(listBooks);
        listBooks.stream().forEach(consumer3);
        System.out.println(listBooks);

    }

}
