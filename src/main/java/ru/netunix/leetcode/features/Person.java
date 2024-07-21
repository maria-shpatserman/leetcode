package ru.netunix.leetcode.features;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class Person {
    String firstName;
    String lastName;
    List<Book> books;

}
