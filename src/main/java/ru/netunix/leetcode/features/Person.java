package ru.netunix.leetcode.features;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Optional;

@Builder
@Data
public class Person {
    String firstName;

    public Optional<String> getLastName() {
        return Optional.ofNullable(lastName);
    }

    String lastName;
    List<Book> books;

}
