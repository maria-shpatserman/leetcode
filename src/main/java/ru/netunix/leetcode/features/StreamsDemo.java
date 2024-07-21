package ru.netunix.leetcode.features;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsDemo {
    public static void main(String[] args) {
        Map<String, Book> myMap = new HashMap<>();
        myMap.put("king", new Book("IT", 200));
        myMap.put("king2", new Book("Misery", 100));
        myMap.put("sheldon", new Book("If tomorrow comes", 300));
        myMap.put("heili", new Book("Airport", 50));
        List<Map.Entry<String, Book>> collected = myMap.entrySet().stream().map((e) -> {
            e.getValue().setName(e.getValue().getName().toUpperCase());
            return e;
        }).collect(Collectors.toList());
        System.out.println(collected);
        List<Book> listBooks = Arrays.asList(
                Book.builder().name("mary").price(10).build(),
                Book.builder().name("ozon").price(100).build(),
                Book.builder().name("mark").price(200).build(),
                Book.builder().name("ReAl").price(90).build());
        System.out.println(listBooks);
        List<Book> collected1 = listBooks.stream()
                .map((book) ->
                {
                    book.setPrice(book.getPrice() * 10);
                    return book;
                }).collect(Collectors.toList());
        System.out.println(collected1);

        // return  list of mew type
        List<String> collected2 = listBooks.stream()
                .map((book) ->
                        book.getName()
                ).collect(Collectors.toList());
        System.out.println("get only names " + collected2);

//
        Person p1 = Person.builder()
                .firstName("Larry")
                .lastName("Woll")               .books(Arrays.asList(
                        Book.builder().name("mary").price(10).build(),
                        Book.builder().name("ozon").price(100).build()))
                .build();
        Person p2 = Person.builder()
                .firstName("Kerry")
                .lastName("Bent")
                .books(Arrays.asList(
                        Book.builder().name("c++").price(10).build(),
                        Book.builder().name("java").price(20).build(),
                        Book.builder().name("c#").price(100).build()))
                .build();
        Person p3 = Person.builder()
                .firstName("Martin")
                .lastName("Fawler")
                .books(Arrays.asList(
                        Book.builder().name("refactoring").price(15).build(),
                        Book.builder().name("refactoring JS").price(10).build(),
                        Book.builder().name("patterns").price(20).build(),
                        Book.builder().name("Ci/CD").price(100).build()))
                .build();
        List<Person> personList = Arrays.asList(p1, p2, p3);
        List<List<Book>> collect = personList
                .stream()
                .map(person -> person.getBooks())
                .collect(Collectors.toList());
        System.out.println(collect);

        List<Book> collected3 = personList
                .stream()
                .flatMap(person -> person.getBooks().stream())
                .collect(Collectors.toList());
        System.out.println(collected3);
        List<Book> collected4 = personList
                .stream()
                .flatMap(person -> person.getBooks().stream())
                .map(b -> {
                    b.setName(b.getName() + " SALE 10 %");
                    return b;
                })
                .collect(Collectors.toList());
        System.out.println(collected4);

    }
}
