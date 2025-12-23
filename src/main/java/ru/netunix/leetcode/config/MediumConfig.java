package ru.netunix.leetcode.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
@Getter
public class MediumConfig {
    @Value(value = "classpath:code/2_add_two_numbers.txt")
    private Resource addTwoNumbers;
    @Value(value = "classpath:code/3_longest_substring_without_repeating_characters.txt")
    private Resource longestSubstring;
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
    @Value(value = "classpath:code/16_3SumClosest.txt")
    private Resource threeSumClosest;
    @Value(value = "classpath:code/19_remove_nth_node_from_end_of_list.txt")
    private Resource removeNthElement;
    @Value(value = "classpath:code/22_generate_parentheses.txt")
    private Resource generateParentheses;

    @Value(value = "classpath:code/24_swap_nodes_in_pairs.txt")
    private Resource swappedNodesInPairs;


    @Value(value = "classpath:code/36_valid_sudoku.txt")
    private Resource isValidSudoku;


    @Value(value = "classpath:code/35_search_insert_position.txt")
    private Resource searchInsertPosition;
    @Value(value = "classpath:code/29_divide_two_integers.txt")
    private Resource divideTwoIntegers;

    @Value(value = "classpath:code/43_multiply_strings.txt")
    private Resource multiplyStrings;

    @Value(value = "classpath:code/34_find_first_and_last_position_of_element_in_sorted_array.txt")
    private Resource findElementInSortedArray;


    @Value(value = "classpath:code/31_next_permutation.txt")
    private Resource nextPermutation;

    @Value(value = "classpath:code/33_search_in_rotated_sorted_array.txt")
    private Resource searchInRotatedArray;

    @Value(value = "classpath:code/38_count_and_say.txt")
    private Resource countAndSay;

    @Value(value = "classpath:code/3217_delete_nodes_from_linked_list.txt")
    private Resource deleteNodesFromList;

    @Value(value = "classpath:code/56_merge_intervals.txt")
    private Resource mergeIntervals;
    @Value(value = "classpath:code/57_insert_interval.txt")
    private Resource insertIntervals;
    @Value(value = "classpath:code/61_rotate_list.txt")
    private Resource rotateList;
    @Value(value = "classpath:code/81_search_in_rotated_sorted_array_2.txt")
    private Resource searchRotatedSortedArrayTwo;

}
