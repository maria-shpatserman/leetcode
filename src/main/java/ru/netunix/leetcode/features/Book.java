package ru.netunix.leetcode.features;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@Data
public class Book{
    String name;
    Integer price;

}