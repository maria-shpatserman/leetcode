package ru.netunix.leetcode.features;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalDemo {
    List<Person> getPersonList() {
        Person p1 = Person.builder().firstName("Larry").lastName("Breh").books(Arrays.asList(Book.builder().name("mary").price(10).build(), Book.builder().name("ozon").price(100).build())).build();
        Person p2 = Person.builder().firstName("Kerry").lastName("Bent").books(Arrays.asList(Book.builder().name("c++").price(10).build(), Book.builder().name("java").price(20).build(), Book.builder().name("c#").price(100).build())).build();
        Person p3 = Person.builder().firstName("Martin").lastName("Swartz").books(Arrays.asList(Book.builder().name("refactoring").price(15).build(), Book.builder().name("refactoring JS").price(10).build(), Book.builder().name("patterns").price(20).build(), Book.builder().name("Ci/CD").price(100).build())).build();
        List<Person> personList = Arrays.asList(p1, p2, p3);
        return personList;
    }

    public Person getPersonByLastNane(String lastName) throws Exception {
        List<Person> list = getPersonList();
       return list.stream()
                .filter(p -> p.getLastName().get().equals(lastName))
                .findFirst().orElseThrow(()->new Exception("No customer with this email"));
    }

    public static void main(String[] args) throws Exception {
        Person person = Person.builder().firstName("Larry").lastName("Woll").books(Arrays.asList(Book.builder().name("mary").price(10).build(), Book.builder().name("ozon").price(100).build())).build();
        Optional<Object> emptyOptional = Optional.empty();
        System.out.println(emptyOptional);
        Optional<String> lastName = person.getLastName();
        System.out.println(lastName);
        String s = lastName.map(e -> e.toUpperCase()).orElseGet(() -> "default last name");
        System.out.println(s);
        OptionalDemo demo = new OptionalDemo();
        System.out.println("lastname = Leo, Person = "+demo.getPersonByLastNane("Leo"));
    }
}
