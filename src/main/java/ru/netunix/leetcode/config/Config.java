package ru.netunix.leetcode.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;

@Configuration
@Getter
public class Config {
    @Value(value = "classpath:code/242_valid_anagram.txt")
    private Resource validAnagram;
    @Value(value = "classpath:code/88_merge_sorted_arrays.txt")
    private Resource mergeSortedArrays;
    @Value(value = "classpath:code/66_plus_one.txt")
    private Resource plusOne;
    @Value(value = "classpath:code/69_sqrt.txt")
    private Resource sqrtX;
    @Value(value = "classpath:code/83_remove_duplicates_from_sorted_list.txt")
    private Resource rmvDuplicates;
    @Value(value = "classpath:code/169_majority_element.txt")
    private Resource mjrElement;
    @Value(value = "classpath:code/219_contain_duplicates_ii.txt")
    private Resource containsDuplicates2;
    @Value(value = "classpath:code/2469_convert_the_temperature.txt")
    private Resource convertTemperature;
    @Value(value = "classpath:code/1_two_sum.txt")
    private Resource twoSum;
    @Value(value = "classpath:code/258_Add_digits.txt")
    private Resource addDigits;
    @Value(value = "classpath:code/118_pascals_triangle.txt")
    private Resource pascalTriangle;
    @Value(value = "classpath:code/119_pascals_triangle_2.txt")
    private Resource pascalTriangleTwo;
    @Value(value = "classpath:code/136_single_number.txt")
    private Resource singleNumber;
    @Value(value = "classpath:code/141_linked_list_cycle.txt")
    private Resource linkedListCycle;
    @Value(value = "classpath:code/67_add_binary.txt")
    private Resource addBinary;
    @Value(value = "classpath:code/1496_path_crossing.txt")
    private Resource pathCrossing;
    @Value(value = "classpath:code/222_count_complete_tree_nodes.txt")
    private Resource countBinaryTreeNodes;
    @Value(value = "classpath:code/228_summary_ranges.txt")
    private Resource summaryRanges;

    @Value(value = "classpath:code/121_best_time_to_buy_sell.txt")
    private Resource buyAndSell;












}
