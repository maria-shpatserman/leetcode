package ru.netunix.leetcode.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
@Getter
public class HardConfig {
    @Value(value = "classpath:code/4_median_two_sorted_array.txt")
    private Resource medianTwoSortedArrays;
    @Value(value = "classpath:code/23_merge_k_sorted_lists.txt")
    private Resource mergeKSortedLists;
    @Value(value = "classpath:code/25_reverse_nodes_in_k_group.txt")
    private Resource reversedNodesInGroups;
    @Value(value = "classpath:code/30_substring_with_concatenation_all_words.txt")
    private Resource concatenationAllWords;
    @Value(value = "classpath:code/37_sudoku_solver.txt")
    private Resource sudokuSolver;
    @Value(value = "classpath:code/41_first_missing_positive.txt")
    private Resource missingPositive;
    @Value(value = "classpath:code/32_longest_valid_parentheses.txt")
    private Resource longestValidParentheses;
}
