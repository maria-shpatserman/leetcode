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
    @Value(value = "classpath:code/16_3SumClosest.txt")
    private Resource threeSumClosest;
    @Value(value = "classpath:code/19_remove_nth_node_from_end_of_list.txt")
    private Resource removeNthElement;
    @Value(value = "classpath:code/22_generate_parentheses.txt")
    private Resource generateParentheses;
    @Value(value = "classpath:code/23_merge_k_sorted_lists.txt")
    private Resource mergeKSortedLists;
    @Value(value = "classpath:code/24_swap_nodes_in_pairs.txt")
    private Resource swappedNodesInPairs;
    @Value(value = "classpath:code/25_reverse_nodes_in_k_group.txt")
    private Resource reversedNodesInGroups;
    @Value(value = "classpath:code/30_substring_with_concatenation_all_words.txt")
    private Resource concatenationAllWords;
    @Value(value = "classpath:code/36_valid_sudoku.txt")
    private Resource isValidSudoku;
    @Value(value = "classpath:code/37_sudoku_solver.txt")
    private Resource sudokuSolver;
    @Value(value = "classpath:code/41_first_missing_positive.txt")
    private Resource missingPositive;
    @Value(value = "classpath:code/35_search_insert_position.txt")
    private Resource searchInsertPosition;
    @Value(value = "classpath:code/29_divide_two_integers.txt")
    private Resource divideTwoIntegers;

    @Value(value = "classpath:code/43_multiply_strings.txt")
    private Resource multiplyStrings;

    @Value(value = "classpath:code/34_find_first_and_last_position_of_element_in_sorted_array.txt")
    private Resource findElementInSortedArray;

    @Value(value = "classpath:code/32_longest_valid_parentheses.txt")
    private Resource longestValidParentheses;
    @Value(value = "classpath:code/31_next_permutation.txt")
    private Resource nextPermutation;

    @Value(value = "classpath:code/33_search_in_rotated_sorted_array.txt")
    private Resource searchInRotatedArray;

    @Value(value = "classpath:code/38_count_and_say.txt")
    private Resource countAndSay;

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

}
