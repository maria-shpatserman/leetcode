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
    @Value(value = "classpath:code/2_add_two_numbers.txt")
    private Resource addTwoNumbers;
    @Value(value = "classpath:code/2_longest_substring_without_repeating_characters.txt")
    private Resource longestSubstring;
    @Value(value = "classpath:code/4_median_two_sorted_array.txt")
    private Resource medianTwoSortedArrays;
    @Value(value = "classpath:code/5_longest_palindromic_substring.txt")
    private Resource longestPalindromicSubstring;
    @Value(value = "classpath:code/11_container_with_most_water.txt")
    private Resource mostWaterContainer;
    @Value(value = "classpath:code/6_zigzag_conversion.txt")
    private Resource zigzagConversion;
    @Value(value = "classpath:code/7_reverse_integer.txt")
    private Resource reverseInteger;
    @Value(value = "classpath:code/8_string_to_integer_atoi.txt")
    private Resource stringToIntegerAtoi;
    @Value(value = "classpath:code/17_letter_combintaions_of_phone_number.txt")
    private Resource letterCombinations;
    @Value(value = "classpath:code/15_3_sum.txt")
    private Resource threeSum;

    @Value(value = "classpath:code/18_4Sum.txt")
    private Resource fourSum;


}
